package com.scrat.everchanging.util;

import java.util.Iterator;

/**
 * Unlike a normal Iterator, this one is reusable.<br/><br/>
 * <p>
 * Because this will be used heavily on each frame render, we need to avoid creating and
 * releasing objects. This iterator fulfills this goal.<br/><br/>
 * <p>
 * - MUST call {@link #acquire()} before using;<br/>
 * - MUST call {@link #release()} after done using.<br/><br/>
 * <p>
 * Call {@link #reset()} to start over.<br/><br/>
 */
public abstract class ReusableIterator<E> implements Iterator<E> {

    private volatile boolean acquired;

    public abstract void reset();

    public final void acquire() {
        throwIfLocked();
        acquired = true;
    }

    public final void release() {
        acquired = false;
    }

    protected final void throwIfNotLocked() {
        if (!acquired) {
            throw new IllegalStateException("Call acquire() before using");
        }
    }

    protected final void throwIfLocked() {
        if (acquired) {
            throw new IllegalStateException("Already acquired");
        }
    }
}
