package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class Crystal extends TextureObject {

    // @formatter:off
    private final float[][] matrixTransform = {
            { 0.75000f,  0.75240f,  0.00000f,  0.00000f,  7.50000f,  0.00000f},
            { 0.76955f,  0.77175f,  0.00000f,  0.00000f,  8.67500f,  0.00000f},
            { 0.78910f,  0.79110f,  0.00000f,  0.00000f,  9.85000f,  0.00000f},
            { 0.81645f,  0.81815f,  0.00000f,  0.00000f, 11.50000f,  0.00000f},
            { 0.84380f,  0.84520f,  0.00000f,  0.00000f, 13.15000f,  0.00000f},
            { 0.87895f,  0.88005f,  0.00000f,  0.00000f, 15.25000f,  0.00000f},
            { 0.91410f,  0.91490f,  0.00000f,  0.00000f, 17.35000f,  0.00000f},
            { 0.95705f,  0.95745f,  0.00000f,  0.00000f, 19.92500f,  0.00000f},
            { 1.00000f,  1.00000f,  0.00000f,  0.00000f, 22.50000f,  0.00000f},
            { 0.96780f,  0.96780f,  0.00000f,  0.00000f, 25.72500f,  0.00000f},
            { 0.93560f,  0.93560f,  0.00000f,  0.00000f, 28.95000f,  0.00000f},
            { 0.90560f,  0.90560f,  0.00000f,  0.00000f, 31.95000f,  0.00000f},
            { 0.87560f,  0.87560f,  0.00000f,  0.00000f, 34.95000f,  0.00000f},
            { 0.84780f,  0.84780f,  0.00000f,  0.00000f, 37.72500f,  0.00000f},
            { 0.82000f,  0.82000f,  0.00000f,  0.00000f, 40.50000f,  0.00000f},
            { 0.79445f,  0.79445f,  0.00000f,  0.00000f, 43.05000f,  0.00000f},
            { 0.76890f,  0.76890f,  0.00000f,  0.00000f, 45.60000f,  0.00000f},
            { 0.74555f,  0.74555f,  0.00000f,  0.00000f, 47.95000f,  0.00000f},
            { 0.72220f,  0.72220f,  0.00000f,  0.00000f, 50.30000f,  0.00000f},
            { 0.70110f,  0.70110f,  0.00000f,  0.00000f, 52.40000f,  0.00000f},
            { 0.68000f,  0.68000f,  0.00000f,  0.00000f, 54.50000f,  0.00000f},
            { 0.66110f,  0.66110f,  0.00000f,  0.00000f, 56.40000f,  0.00000f},
            { 0.64220f,  0.64220f,  0.00000f,  0.00000f, 58.30000f,  0.00000f},
            { 0.62555f,  0.62555f,  0.00000f,  0.00000f, 59.95000f,  0.00000f},
            { 0.60890f,  0.60890f,  0.00000f,  0.00000f, 61.60000f,  0.00000f},
            { 0.59445f,  0.59445f,  0.00000f,  0.00000f, 63.05000f,  0.00000f},
            { 0.58000f,  0.58000f,  0.00000f,  0.00000f, 64.50000f,  0.00000f},
            { 0.56780f,  0.56780f,  0.00000f,  0.00000f, 65.72500f,  0.00000f},
            { 0.55560f,  0.55560f,  0.00000f,  0.00000f, 66.95000f,  0.00000f},
            { 0.54560f,  0.54560f,  0.00000f,  0.00000f, 67.95000f,  0.00000f},
            { 0.53560f,  0.53560f,  0.00000f,  0.00000f, 68.95000f,  0.00000f},
            { 0.52780f,  0.52780f,  0.00000f,  0.00000f, 69.72500f,  0.00000f},
            { 0.52000f,  0.52000f,  0.00000f,  0.00000f, 70.50000f,  0.00000f},
            { 0.51445f,  0.51445f,  0.00000f,  0.00000f, 71.05000f,  0.00000f},
            { 0.50890f,  0.50890f,  0.00000f,  0.00000f, 71.60000f,  0.00000f},
            { 0.50555f,  0.50555f,  0.00000f,  0.00000f, 71.95000f,  0.00000f},
            { 0.50220f,  0.50220f,  0.00000f,  0.00000f, 72.30000f,  0.00000f},
            { 0.50110f,  0.50110f,  0.00000f,  0.00000f, 72.40000f,  0.00000f},
            { 0.50000f,  0.50000f,  0.00000f,  0.00000f, 72.50000f,  0.00000f},
    };

    private final float[][][] colorTransform = {
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 240}, {0, 0, 0, 0}},
            {{256, 256, 256, 223}, {0, 0, 0, 0}}, {{256, 256, 256, 208}, {0, 0, 0, 0}},
            {{256, 256, 256, 192}, {0, 0, 0, 0}}, {{256, 256, 256, 178}, {0, 0, 0, 0}},
            {{256, 256, 256, 164}, {0, 0, 0, 0}}, {{256, 256, 256, 151}, {0, 0, 0, 0}},
            {{256, 256, 256, 138}, {0, 0, 0, 0}}, {{256, 256, 256, 126}, {0, 0, 0, 0}},
            {{256, 256, 256, 114}, {0, 0, 0, 0}}, {{256, 256, 256, 103}, {0, 0, 0, 0}},
            {{256, 256, 256,  92}, {0, 0, 0, 0}}, {{256, 256, 256,  82}, {0, 0, 0, 0}},
            {{256, 256, 256,  73}, {0, 0, 0, 0}}, {{256, 256, 256,  64}, {0, 0, 0, 0}},
            {{256, 256, 256,  56}, {0, 0, 0, 0}}, {{256, 256, 256,  48}, {0, 0, 0, 0}},
            {{256, 256, 256,  41}, {0, 0, 0, 0}}, {{256, 256, 256,  34}, {0, 0, 0, 0}},
            {{256, 256, 256,  28}, {0, 0, 0, 0}}, {{256, 256, 256,  23}, {0, 0, 0, 0}},
            {{256, 256, 256,  18}, {0, 0, 0, 0}}, {{256, 256, 256,  14}, {0, 0, 0, 0}},
            {{256, 256, 256,  10}, {0, 0, 0, 0}}, {{256, 256, 256,   8}, {0, 0, 0, 0}},
            {{256, 256, 256,   5}, {0, 0, 0, 0}}, {{256, 256, 256,   3}, {0, 0, 0, 0}},
            {{256, 256, 256,   1}, {0, 0, 0, 0}}, {{256, 256, 256,   0}, {0, 0, 0, 0}},
            {{256, 256, 256,   0}, {0, 0, 0, 0}},
    };

    // @formatter:on

    private final float[][] sizeTexture = {
            {30.0f, 31.5f},
            {20.0f, 21.0f}
    };

    private final float[][] endPosition = {
            {-7.3f, 19.9f},
            {0.3f, 12.4f},
            {7.8f, 19.9f},
            {1.3f, 27.4f}
    };

    private static final String[][] textureList = {{"image_13", "image_15"}};

    private static final int MAX_FRAMES = 4;

    private int frameCounter = 0;

    Crystal(final Context context) {
        super(context, textureList, null);
    }

    void createEndsObject(final float[] transform, final float[] translate) {
        for (int n = 0; n < 4; n++) {
            final int i = random.nextInt(2);
            final TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][i]));
            texture.width = sizeTexture[i][0];
            texture.height = sizeTexture[i][1];

            final Object crystalsEnd = objects.obtain(texture, 1.0f);
            crystalsEnd.setObjectScale(1.0f);

            final float _x = endPosition[n][0];
            final float _y = endPosition[n][1];
            final int _rotation = n * 90;

            crystalsEnd.frameCounter = 0;
            crystalsEnd.animCounter = 0;
            crystalsEnd.animCounterSkip = false;
            crystalsEnd.resetViewMatrix();
            crystalsEnd.setViewTransform(transform);
            crystalsEnd.setViewRotate(_rotation);
            crystalsEnd.setViewTranslate(translate[0] + _x, translate[1] + _y);
        }
    }

    void createObject() {
        int i = random.nextInt(2);
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][i]));
        final Object object = objects.obtain(texture, 1.0f);
        object.setObjectScale(2.0f);
        float _x = random.nextInt(width);
        float _y = random.nextInt(height);
        int _alpha = random.nextInt(100);
        int _rotation = random.nextInt(4) * 90;
        int _scale = random.nextInt(80);
        object.frameCounter = 0;
        object.resetViewMatrix();
        object.setViewScale(_scale, _scale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x, _y);
        object.setAplpha(_alpha);
    }

    public void createObject(float[] transform, float[] translate) {
        if (frameCounter % 2 == 0) return;
        int i = random.nextInt(2);
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][i]));
        texture.width = sizeTexture[i][0];
        texture.height = sizeTexture[i][1];
        final Object crystal = objects.obtain(texture, 1.0f);
        crystal.setObjectScale(1.0f);
        crystal.resetViewMatrix();
        float _x = random.nextInt(20) - 10;
        float _y = random.nextInt(20) - 10;
        int _rotation = random.nextInt(4) * 90;
        int _scale = random.nextInt(120);
        crystal.frameCounter = 0;
        crystal.setViewTransform(transform);
        crystal.setViewScale(_scale, _scale);
        crystal.setViewRotate(_rotation);
        crystal.setViewTranslate(translate[0] + _x, translate[1] + _y);
    }

    public void update(boolean createObject) {
        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (createObject && (frameCounter == 1)) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < matrixTransform.length) {
                object.resetMatrix();
                object.setColorTransform(colorTransform[object.frameCounter]);
                object.setTransform(matrixTransform[object.frameCounter]);
                object.frameCounter++;
            } else {
                iterator.remove();
            }
        }

        iterator.release();
    }
}
