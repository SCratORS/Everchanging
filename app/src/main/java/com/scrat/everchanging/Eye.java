package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

import java.util.Calendar;

final class Eye extends TextureObject {

    private final int[][] Frames = {
            {0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 27}, {6, 1}, //-1
            {0, 1}, {7, 1}, {5, 10}, {6, 1},                         //6
            {0, 1}, {7, 1}, {5, 20}, {6, 1},                         //10
            {0, 30}, {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 27}, {6, 1},//14
            {0, 1}, {7, 1}, {5, 52}, {8, 1}, {9, 1}, {10, 1},        //21
            {11, 1}
    };

    private static final int MAX_FRAMES = 45;

    private int numClips;
    private int frameCounter = 0;

    private final float scale = 0.25f;
    private boolean init = false;

    private static final String[][] textureList = {
            {
                    "image_1", "image_2", "image_3", "image_4", "image_5", "image_6",
                    "image_7", "image_8", "image_9", "image_10", "image_11", "image_12"
            }
    };

    private final Calendar calendar;

    private final boolean[] positions = {false, false, false, false, false};

    Eye(final Context context, final Calendar calendar) {
        super(context, textureList, null);
        this.calendar = calendar;
    }

    private boolean get0601() {
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        return (currentMonth == 1) && (currentDay == 6);
    }

    void createObject() {
        if (objects.objectsInUseCount() > numClips) return;

        int _x, _y, _r;
        _r = random.nextInt(5);

        if (positions[_r]) return;

        final int textureIndex = textureManager.getTextureIndex(textureList[0][0]);
        final Object object = objects.obtain(textureManager.getTexture(textureIndex), scale);

        switch (random.nextInt(5)) {
            default:
                object.frameCounter = -1;
                break;

            case 1:
                object.frameCounter = 6;
                break;

            case 2:
                object.frameCounter = 10;
                break;

            case 3:
                object.frameCounter = 14;
                break;

            case 4:
                object.frameCounter = 21;
                break;
        }
        object.animCounter = 0;

        final int _yscale = random.nextInt(75) + 50;
        int _xscale = _yscale;
        if (random.nextInt(2) == 0) _xscale *= -1;

        object.index = _r;
        positions[object.index] = true;
        switch (object.index) {
            default:
                _x = 229;
                _y = 179;
                break;

            case 1:
                _x = 47;
                _y = 65;
                break;

            case 2:
                _x = 14;
                _y = 138;
                break;

            case 3:
                _x = 139;
                _y = 158;
                break;

            case 4:
                _x = 165;
                _y = 177;
                break;
        }
        object.resetViewMatrix();
        object.setViewScale(_xscale, _yscale);
        object.setViewPosition(_x, height - 320 + _y);
    }

    void update(final boolean createObject) {
        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (!init && createObject) numClips = get0601() ? 10 : (random.nextInt(5) + 5);
        init = createObject;
        if (frameCounter == 2) if (createObject) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.animCounter == 0) {
                object.frameCounter++;
                if (object.frameCounter < Frames.length) {
                    object.animCounter = Frames[object.frameCounter][1];
                    object.resetMatrix();
                    object.setTexture(textureManager.getTexture(textureManager.getTextureIndex(textureList[0][Frames[object.frameCounter][0]])), scale);
                } else {
                    iterator.remove();
                    positions[object.index] = false;
                }
            }
            object.animCounter--;
        }

        iterator.release();
    }
}
