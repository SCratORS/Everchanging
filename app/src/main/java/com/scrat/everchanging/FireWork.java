package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

import java.util.Calendar;

final class FireWork extends TextureObject {

    private static final int[][] textureList = {{
            R.drawable.shape_180, R.drawable.shape_181, R.drawable.shape_182, R.drawable.shape_183,
            R.drawable.shape_184, R.drawable.shape_185, R.drawable.shape_186, R.drawable.shape_187,
            R.drawable.shape_188, R.drawable.shape_189, R.drawable.shape_190, R.drawable.shape_191,
            R.drawable.shape_192, R.drawable.shape_193, R.drawable.shape_194, R.drawable.shape_195,
            R.drawable.shape_196, R.drawable.shape_197, R.drawable.shape_198, R.drawable.shape_199,
            R.drawable.shape_200, R.drawable.shape_201, R.drawable.shape_202, R.drawable.shape_203,
            R.drawable.shape_204, R.drawable.shape_205, R.drawable.shape_206, R.drawable.shape_207,
            R.drawable.shape_208, R.drawable.shape_209, R.drawable.shape_210, R.drawable.shape_211,
            R.drawable.shape_212, R.drawable.shape_213, R.drawable.shape_214, R.drawable.shape_215,
            R.drawable.shape_216, R.drawable.shape_217
    }};

    private final byte[] spriteTable = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8,
            9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
            19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
            29, 30, 31, 32, 33, 34, 35, 36, 37, 8
    };
    private final float[] transformMatrix = {1.0f, 1.0f, 0.0f, 0.0f, 19.7f, -88.5f};
    private final float[][][] colorTransform = {
            {{0, 0, 0, 256}, {0, 213, 213, 0}},
            {{0, 0, 0, 256}, {213, 0, 170, 0}},
            {{0, 0, 0, 256}, {235, 114, 29, 0}},
            {{0, 0, 0, 256}, {189, 236, 2, 0}},
            {{0, 0, 0, 256}, {221, 66, 0, 0}}
    };

    private static final int MAX_FRAMES = 5;

    private int numClips = minObjects;
    private float svgScale = 1.0f;
    private int frameCounter;
    private int internalCounter;
    private boolean init;

    private final Calendar calendar;

    private boolean get010104() {
        svgScale = textureManager.dipToPixels(1);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentYear = calendar.get(Calendar.YEAR);
        return (currentMonth == 1) && (currentDay == 1) && (currentYear % 4 == 0);
    }

    FireWork(final Context context, final Calendar calendar) {
        super(context, textureList, null);
        this.calendar = calendar;
    }

    void resetObject(Object object) {
        int _x = random.nextInt(240);
        int _y = random.nextInt(240);
        int _yscale = random.nextInt(150);
        object.resetMatrix();
        object.resetViewMatrix();
        object.setViewTransform(transformMatrix);
        object.setViewScale(_yscale, _yscale);
        object.setViewPosition(_x, height - 220 + _y);
        object.setViewRotate(object.getRotation());
        object.frameCounter = random.nextInt(5);
        object.index--;
    }

    void createObject() {
        if (objects.objectsInUseCount() >= numClips) return;
        int textureIndex = textureManager.getTextureIndex(textureList[0][0]);
        final Object object = objects.obtain(textureManager.getTexture(textureIndex), 1.0f);

        object.setObjectScale(1.0f / svgScale);
        int _x = random.nextInt(240);
        int _y = random.nextInt(220);
        int _rotation = random.nextInt(20) - 10;
        int _yscale = random.nextInt(85) + 25;
        int _xscale = _yscale;
        if (random.nextInt(2) == 0) _xscale *= -1;
        object.resetViewMatrix();
        object.resetMatrix();

        object.setViewTransform(transformMatrix);
        object.setViewScale(_xscale, _yscale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x, height - 220 + _y);
        object.setColorTransform(colorTransform[random.nextInt(5)]);
        object.frameCounter = 0;
        object.index = random.nextInt(5);
    }

    public void update(final boolean createObject, final boolean skipEverySecondFrame) {
        internalCounter++;
        if (skipEverySecondFrame && internalCounter % 2 == 0) {
            return;
        }

        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (!init && createObject)
            numClips = (get010104() ? maxObjects : (minObjects + random.nextInt(maxObjects - 4)));
        init = createObject;

        if ((createObject) && (frameCounter == 2) && (random.nextInt(3) == 0)) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < spriteTable.length) {
                object.resetMatrix();
                object.setTexture(textureManager.getTexture(textureManager.getTextureIndex(textureList[0][spriteTable[object.frameCounter]])), 1.0f);
                object.frameCounter++;
            } else {
                if ((createObject) && (object.index > 0)) resetObject(object);
                else iterator.remove();
            }
        }

        iterator.release();
    }
}
