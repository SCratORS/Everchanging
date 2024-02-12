package com.scrat.everchanging;

import com.scrat.everchanging.util.ReusableIterator;

import java.util.ArrayList;
import java.util.List;

final class ObjectPool {

    private final UsedObjectsIterator usedObjectsIterator = new UsedObjectsIterator();

    private final List<Object> all = new ArrayList<>();
    private int usedObjectCount;

    int objectsInUseCount() {
        return usedObjectCount;
    }

    void markAllAsUnused() {
        final int size = all.size();
        for (int i = 0; i < size; i++) {
            final Object object = all.get(i);
            if (object.used) {
                object.used = false;
                usedObjectCount--;
            }
        }
    }

    ReusableIterator<Object> iterator() {
        usedObjectsIterator.acquire();
        usedObjectsIterator.reset();
        usedObjectsIterator.release();

        return usedObjectsIterator;
    }

    /**
     * Retrieves unused object from pool or creates a new one and adds it to the pool.
     */
    Object obtain() {
        Object toReturn = nextUnusedOrNull();
        if (toReturn == null) {
            toReturn = new Object();
            all.add(toReturn);
        }

        if (!toReturn.used) {
            toReturn.used = true;
            usedObjectCount++;
        }
        return toReturn;
    }

    /**
     * Retrieves unused object from pool or creates a new one and adds to the pool, then applies
     * texture.
     */
    Object obtain(final TextureManager.Texture texture, final float scale) {
        final Object toReturn = obtain();
        toReturn.setTexture(texture, scale);
        return toReturn;
    }

    private Object nextUnusedOrNull() {
        final int allSize = all.size();
        for (int i = 0; i < allSize; i++) {
            final Object object = all.get(i);
            if (!object.used) {
                return object;
            }
        }

        return null;
    }

    /**
     * Unlike a normal Iterator, this one is reusable.<br/><br/>
     * <p>
     * Because this will be used heavily on each frame render, we need to avoid creating and
     * releasing objects. This iterator fulfills this goal.<br/><br/>
     * <p>
     * Call {@link #reset} to prepare for using with next client.<br/><br/>
     * <p>
     * Calling {@link #remove()} will mark object as unused and keep in the pool.
     */
    private final class UsedObjectsIterator extends ReusableIterator<Object> {

        private int i;
        private int limit;
        private int usedObjectsReturnedSoFar;

        @Override
        public void reset() {
            throwIfNotLocked();
            i = 0;
            limit = usedObjectCount;
            usedObjectsReturnedSoFar = 0;
        }

        @Override
        public boolean hasNext() {
            throwIfNotLocked();
            return usedObjectsReturnedSoFar < limit;
        }

        @Override
        public Object next() {
            throwIfNotLocked();
            while (!all.get(i).used) {
                i++;
            }

            final Object object = all.get(i++);
            if (!object.used) {
                throw new IllegalStateException("Obtained unused object. This should not happen.");
            }
            usedObjectsReturnedSoFar++;
            return object;
        }

        /**
         * Marks as unused instead of actually removing
         */
        @Override
        public void remove() {
            throwIfNotLocked();
            all.get(i - 1).used = false;
            usedObjectsReturnedSoFar--;
            usedObjectCount--;
            limit--;
        }
    }
}
