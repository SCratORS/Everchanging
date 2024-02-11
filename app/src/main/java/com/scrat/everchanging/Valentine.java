package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class Valentine extends TextureObject {

    private static final String[][] textureList = {{"image_13", "image_15", "shape_278", "shape_279"}};

    // @formatter:off
    private final float[][] matrixTransform = {
            {  0.8500f,   0.8500f,   0.0000f,   0.0000f,   0.0000f,   0.0000f},
            {  0.8687f,   0.8687f,   0.0000f,   0.0000f,   0.0000f,  -1.2500f},
            {  0.8875f,   0.8875f,   0.0000f,   0.0000f,   0.0000f,  -2.5000f},
            {  0.9062f,   0.9062f,   0.0000f,   0.0000f,   0.0000f,  -3.7500f},
            {  0.9250f,   0.9250f,   0.0000f,   0.0000f,   0.0000f,  -5.0000f},
            {  0.9438f,   0.9438f,   0.0000f,   0.0000f,   0.0000f,  -6.2500f},
            {  0.9625f,   0.9625f,   0.0000f,   0.0000f,   0.0000f,  -7.5000f},
            {  0.9812f,   0.9812f,   0.0000f,   0.0000f,   0.0000f,  -8.7500f},
            {  1.0000f,   1.0000f,   0.0000f,   0.0000f,   0.0000f, -10.0000f},
            {  0.9805f,   0.9805f,   0.0000f,   0.0000f,   0.0000f, -10.9750f},
            {  0.9609f,   0.9609f,   0.0000f,   0.0000f,   0.0000f, -11.9500f},
            {  0.9423f,   0.9423f,   0.0000f,   0.0000f,   0.0000f, -12.8750f},
            {  0.9236f,   0.9236f,   0.0000f,   0.0000f,   0.0000f, -13.8000f},
            {  0.9058f,   0.9058f,   0.0000f,   0.0000f,   0.0000f, -14.7000f},
            {  0.8880f,   0.8880f,   0.0000f,   0.0000f,   0.0000f, -15.6000f},
            {  0.8711f,   0.8711f,   0.0000f,   0.0000f,   0.0000f, -16.4500f},
            {  0.8542f,   0.8542f,   0.0000f,   0.0000f,   0.0000f, -17.3000f},
            {  0.8382f,   0.8382f,   0.0000f,   0.0000f,   0.0000f, -18.1000f},
            {  0.8222f,   0.8222f,   0.0000f,   0.0000f,   0.0000f, -18.9000f},
            {  0.8071f,   0.8071f,   0.0000f,   0.0000f,   0.0000f, -19.6500f},
            {  0.7920f,   0.7920f,   0.0000f,   0.0000f,   0.0000f, -20.4000f},
            {  0.7778f,   0.7778f,   0.0000f,   0.0000f,   0.0000f, -21.1000f},
            {  0.7635f,   0.7635f,   0.0000f,   0.0000f,   0.0000f, -21.8000f},
            {  0.7502f,   0.7502f,   0.0000f,   0.0000f,   0.0000f, -22.4750f},
            {  0.7369f,   0.7369f,   0.0000f,   0.0000f,   0.0000f, -23.1500f},
            {  0.7244f,   0.7244f,   0.0000f,   0.0000f,   0.0000f, -23.7750f},
            {  0.7120f,   0.7120f,   0.0000f,   0.0000f,   0.0000f, -24.4000f},
            {  0.7005f,   0.7005f,   0.0000f,   0.0000f,   0.0000f, -24.9750f},
            {  0.6889f,   0.6889f,   0.0000f,   0.0000f,   0.0000f, -25.5500f},
            {  0.6782f,   0.6782f,   0.0000f,   0.0000f,   0.0000f, -26.0750f},
            {  0.6675f,   0.6675f,   0.0000f,   0.0000f,   0.0000f, -26.6000f},
            {  0.6578f,   0.6578f,   0.0000f,   0.0000f,   0.0000f, -27.1000f},
            {  0.6480f,   0.6480f,   0.0000f,   0.0000f,   0.0000f, -27.6000f},
            {  0.6391f,   0.6391f,   0.0000f,   0.0000f,   0.0000f, -28.0500f},
            {  0.6302f,   0.6302f,   0.0000f,   0.0000f,   0.0000f, -28.5000f},
            {  0.6222f,   0.6222f,   0.0000f,   0.0000f,   0.0000f, -28.9000f},
            {  0.6142f,   0.6142f,   0.0000f,   0.0000f,   0.0000f, -29.3000f},
            {  0.6071f,   0.6071f,   0.0000f,   0.0000f,   0.0000f, -29.6500f},
            {  0.6000f,   0.6000f,   0.0000f,   0.0000f,   0.0000f, -30.0000f},
    };

    private final float[][][] colorTransform = {
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 240}, {0, 0, 0, 0}},
            {{256, 256, 256, 223}, {0, 0, 0, 0}}, {{256, 256, 256, 215}, {0, 0, 0, 0}},
            {{256, 256, 256, 207}, {0, 0, 0, 0}}, {{256, 256, 256, 196}, {0, 0, 0, 0}},
            {{256, 256, 256, 184}, {0, 0, 0, 0}}, {{256, 256, 256, 174}, {0, 0, 0, 0}},
            {{256, 256, 256, 163}, {0, 0, 0, 0}}, {{256, 256, 256, 152}, {0, 0, 0, 0}},
            {{256, 256, 256, 142}, {0, 0, 0, 0}}, {{256, 256, 256, 132}, {0, 0, 0, 0}},
            {{256, 256, 256, 123}, {0, 0, 0, 0}}, {{256, 256, 256, 114}, {0, 0, 0, 0}},
            {{256, 256, 256, 105}, {0, 0, 0, 0}}, {{256, 256, 256,  96}, {0, 0, 0, 0}},
            {{256, 256, 256,  88}, {0, 0, 0, 0}}, {{256, 256, 256,  80}, {0, 0, 0, 0}},
            {{256, 256, 256,  72}, {0, 0, 0, 0}}, {{256, 256, 256,  64}, {0, 0, 0, 0}},
            {{256, 256, 256,  57}, {0, 0, 0, 0}}, {{256, 256, 256,  50}, {0, 0, 0, 0}},
            {{256, 256, 256,  43}, {0, 0, 0, 0}}, {{256, 256, 256,  37}, {0, 0, 0, 0}},
            {{256, 256, 256,  31}, {0, 0, 0, 0}}, {{256, 256, 256,  25}, {0, 0, 0, 0}},
            {{256, 256, 256,  19}, {0, 0, 0, 0}}, {{256, 256, 256,  14}, {0, 0, 0, 0}},
            {{256, 256, 256,   9}, {0, 0, 0, 0}}, {{256, 256, 256,   4}, {0, 0, 0, 0}},
            {{256, 256, 256,   0}, {0, 0, 0, 0}},
    };

    // @formatter:on

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
