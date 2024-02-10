package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class Valentine extends TextureObject {

    private static final String[][] textureList = {{"image_13", "image_15", "shape_278", "shape_279"}};

    private final float[][] matrixTransform = {
            {0.85f, 0.85f, 0.0000f, 0.0000f, 0f, 0f},
            {0.8875f, 0.8875f, 0.0000f, 0.0000f, 0f, -2.5f},
            {0.925f, 0.925f, 0.0000f, 0.0000f, 0f, -5f},
            {0.9625f, 0.9625f, 0.0000f, 0.0000f, 0f, -7.5f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, -10f},
            {0.9609f, 0.9609f, 0.0000f, 0.0000f, 0f, -11.95f},
            {0.9236f, 0.9236f, 0.0000f, 0.0000f, 0f, -13.8f},
            {0.888f, 0.888f, 0.0000f, 0.0000f, 0f, -15.6f},
            {0.8542f, 0.8542f, 0.0000f, 0.0000f, 0f, -17.3f},
            {0.8222f, 0.8222f, 0.0000f, 0.0000f, 0f, -18.9f},
            {0.792f, 0.792f, 0.0000f, 0.0000f, 0f, -20.4f},
            {0.7635f, 0.7635f, 0.0000f, 0.0000f, 0f, -21.8f},
            {0.7369f, 0.7369f, 0.0000f, 0.0000f, 0f, -23.15f},
            {0.712f, 0.712f, 0.0000f, 0.0000f, 0f, -24.4f},
            {0.6889f, 0.6889f, 0.0000f, 0.0000f, 0f, -25.55f},
            {0.6675f, 0.6675f, 0.0000f, 0.0000f, 0f, -26.6f},
            {0.648f, 0.648f, 0.0000f, 0.0000f, 0f, -27.6f},
            {0.6302f, 0.6302f, 0.0000f, 0.0000f, 0f, -28.5f},
            {0.6142f, 0.6142f, 0.0000f, 0.0000f, 0f, -29.3f},
            {0.6f, 0.6f, 0.0000f, 0.0000f, 0f, -30f}
    };

    private final float[][][] colorTransform = {
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 223}, {0, 0, 0, 0}},
            {{256, 256, 256, 207}, {0, 0, 0, 0}}, {{256, 256, 256, 184}, {0, 0, 0, 0}},
            {{256, 256, 256, 163}, {0, 0, 0, 0}}, {{256, 256, 256, 142}, {0, 0, 0, 0}},
            {{256, 256, 256, 123}, {0, 0, 0, 0}}, {{256, 256, 256, 105}, {0, 0, 0, 0}},
            {{256, 256, 256, 88}, {0, 0, 0, 0}}, {{256, 256, 256, 72}, {0, 0, 0, 0}},
            {{256, 256, 256, 57}, {0, 0, 0, 0}}, {{256, 256, 256, 43}, {0, 0, 0, 0}},
            {{256, 256, 256, 31}, {0, 0, 0, 0}}, {{256, 256, 256, 19}, {0, 0, 0, 0}},
            {{256, 256, 256, 9}, {0, 0, 0, 0}}, {{256, 256, 256, 0}, {0, 0, 0, 0}}
    };

    private final byte[] selectList = {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};

    private final float[][] sizeTexture = {
            {30.0f, 31.5f},
            {20.0f, 21.0f}
    };

    Valentine(final Context context) {
        super(context, textureList, null);
    }

    void createObject() {
        int index = random.nextInt(selectList.length);
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][selectList[index]]));
        Object object;

        float svgScale;
        if (index < 2) {
            texture.width = sizeTexture[index][0];
            texture.height = sizeTexture[index][1];
            svgScale = 1.0f;
            object = objects.obtain(texture, svgScale);
        } else {
            svgScale = 1.0f / textureManager.dipToPixels(1);
            object = objects.obtain(texture, 1.0f);
            object.setObjectScale(svgScale);
        }
        float _x = random.nextInt(width);
        float _y = random.nextInt(height);
        int _rotation = 0;
        int _scale = random.nextInt(120);
        object.resetViewMatrix();
        object.setViewScale(_scale, _scale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x, _y);
        object.frameCounter = 0;
    }

    void update(final boolean createObject) {

        if (createObject) createObject();

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
