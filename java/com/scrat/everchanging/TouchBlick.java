package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class TouchBlick extends TextureObject {

    private static final String[][] textureList = {{"image_13", "image_15", "shape_278"}};

    // @formatter:off
    private static final float[][] matrixAnimationTransform = {
            {  1.00f,   1.00f,   0.00f,   0.00f, -10.00f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -9.15f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -8.30f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -7.50f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -6.70f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -5.85f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -5.00f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -4.20f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -3.40f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -2.50f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -1.60f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  -0.80f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   0.00f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   0.80f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   1.60f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   2.50f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   3.40f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   4.20f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   5.00f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   5.85f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   6.70f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   7.50f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   8.30f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,   9.15f,   0.00f},
            {  1.00f,   1.00f,   0.00f,   0.00f,  10.00f,   0.00f},

    };

    private static final float[][] matrixTransform = {
            { 0.7500f,  0.7524f,  0.0000f,  0.0000f, -2.0000f,  0.0000f},
            { 0.7916f,  0.7937f,  0.0000f,  0.0000f, -1.5500f,  0.0000f},
            { 0.8333f,  0.8349f,  0.0000f,  0.0000f, -1.1000f,  0.0000f},
            { 0.8750f,  0.8762f,  0.0000f,  0.0000f, -0.6500f,  0.0000f},
            { 0.9167f,  0.9175f,  0.0000f,  0.0000f, -0.2000f,  0.0000f},
            { 0.9584f,  0.9588f,  0.0000f,  0.0000f,  0.1250f,  0.0000f},
            { 1.0000f,  1.0000f,  0.0000f,  0.0000f,  0.4500f,  0.0000f},
            { 0.9969f,  0.9969f,  0.0000f,  0.0000f,  0.4250f,  0.0000f},
            { 0.9938f,  0.9938f,  0.0000f,  0.0000f,  0.4000f,  0.0000f},
            { 0.9845f,  0.9845f,  0.0000f,  0.0000f,  0.3000f,  0.0000f},
            { 0.9753f,  0.9753f,  0.0000f,  0.0000f,  0.2000f,  0.0000f},
            { 0.9599f,  0.9599f,  0.0000f,  0.0000f,  0.0250f,  0.0000f},
            { 0.9444f,  0.9444f,  0.0000f,  0.0000f, -0.1500f,  0.0000f},
            { 0.9228f,  0.9228f,  0.0000f,  0.0000f, -0.3750f,  0.0000f},
            { 0.9012f,  0.9012f,  0.0000f,  0.0000f, -0.6000f,  0.0000f},
            { 0.8735f,  0.8735f,  0.0000f,  0.0000f, -0.8750f,  0.0000f},
            { 0.8457f,  0.8457f,  0.0000f,  0.0000f, -1.1500f,  0.0000f},
            { 0.8118f,  0.8118f,  0.0000f,  0.0000f, -1.5000f,  0.0000f},
            { 0.7778f,  0.7778f,  0.0000f,  0.0000f, -1.8500f,  0.0000f},
            { 0.7377f,  0.7377f,  0.0000f,  0.0000f, -2.2750f,  0.0000f},
            { 0.6975f,  0.6975f,  0.0000f,  0.0000f, -2.7000f,  0.0000f},
            { 0.6512f,  0.6512f,  0.0000f,  0.0000f, -3.2000f,  0.0000f},
            { 0.6049f,  0.6049f,  0.0000f,  0.0000f, -3.7000f,  0.0000f},
            { 0.5525f,  0.5525f,  0.0000f,  0.0000f, -4.2250f,  0.0000f},
            { 0.5000f,  0.5000f,  0.0000f,  0.0000f, -4.7500f,  0.0000f},
    };

    private static final float[][][] colorTransform = {
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 254}, {0, 0, 0, 0}},
            {{256, 256, 256, 253}, {0, 0, 0, 0}}, {{256, 256, 256, 248}, {0, 0, 0, 0}},
            {{256, 256, 256, 243}, {0, 0, 0, 0}}, {{256, 256, 256, 236}, {0, 0, 0, 0}},
            {{256, 256, 256, 228}, {0, 0, 0, 0}}, {{256, 256, 256, 216}, {0, 0, 0, 0}},
            {{256, 256, 256, 205}, {0, 0, 0, 0}}, {{256, 256, 256, 191}, {0, 0, 0, 0}},
            {{256, 256, 256, 177}, {0, 0, 0, 0}}, {{256, 256, 256, 160}, {0, 0, 0, 0}},
            {{256, 256, 256, 142}, {0, 0, 0, 0}}, {{256, 256, 256, 122}, {0, 0, 0, 0}},
            {{256, 256, 256, 101}, {0, 0, 0, 0}}, {{256, 256, 256,  78}, {0, 0, 0, 0}},
            {{256, 256, 256,  54}, {0, 0, 0, 0}}, {{256, 256, 256,  27}, {0, 0, 0, 0}},
            {{256, 256, 256,   0}, {0, 0, 0, 0}},
    };
    // @formatter:on

    private static final byte[] selectList = {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    private static final float[][] sizeTexture = {
            {30.0f, 31.5f},
            {20.0f, 21.0f}
    };

    private static final int NUM_CLIPS = 20;

    private float svgScale = 1.0f;

    TouchBlick(final Context context) {
        super(context, textureList, null);
    }

    void resetObject(final Object object, final float posX, final float posY) {
        final int index = random.nextInt(selectList.length);
        final TextureManager.Texture texture = textureManager.getTexture(
                textureManager.getTextureIndex(textureList[0][selectList[index]]));

        if (index < 2) {
            texture.width = sizeTexture[index][0];
            texture.height = sizeTexture[index][1];
            svgScale = 1.0f;
        } else {
            svgScale = 1.0f / textureManager.dipToPixels(1);
        }

        object.setTexture(texture, svgScale);

        final float _x = (posX * ratio) + random.nextInt(30) - 15;
        final float _y = (posY * ratio) + random.nextInt(30) - 15;
        final int _rotation = (random.nextInt(4) + 1) * 90;
        final int _scale = random.nextInt(150);

        object.resetViewMatrix();
        object.setViewScale(_scale, _scale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x, _y);
        object.frameCounter = 0;
    }

    void createObject(final float posX, final float posY) {
        if (objects.objectsInUseCount() >= NUM_CLIPS) return;
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][selectList[0]]));
        resetObject(objects.obtain(texture, 1.0f), posX, posY);
    }

    void update(final boolean createObject, final float posX, final float posY) {

        if (createObject) createObject(posX, posY);

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < matrixTransform.length) {
                object.resetMatrix();
                object.setColorTransform(colorTransform[object.frameCounter]);
                object.setTransform(matrixTransform[object.frameCounter]);
                object.setTransform(matrixAnimationTransform[object.frameCounter]);
                object.frameCounter++;
            } else {
                if (createObject) resetObject(object, posX, posY);
                else iterator.remove();
            }
        }
        iterator.release();
    }
}
