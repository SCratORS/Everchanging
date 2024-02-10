package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class TouchBlick extends TextureObject {

    private static final String[][] textureList = {{"image_13", "image_15", "shape_278"}};

    private static final float[][] matrixAnimationTransform = {
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -10.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -8.3f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -6.7f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -5.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -3.4f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -1.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 1.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 3.4f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 5.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 6.7f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 8.3f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 10.0f, 0f}
    };

    private static final float[][] matrixTransform = {
            {0.75f, 0.7524f, 0.0000f, 0.0000f, -2f, 0f},
            {0.8333f, 0.8349f, 0.0000f, 0.0000f, -1.1f, 0f},
            {0.9167f, 0.9175f, 0.0000f, 0.0000f, -0.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0.45f, 0f},
            {0.9938f, 0.9938f, 0.0000f, 0.0000f, 0.4f, 0f},
            {0.9753f, 0.9753f, 0.0000f, 0.0000f, 0.2f, 0f},
            {0.9444f, 0.9444f, 0.0000f, 0.0000f, -0.15f, 0f},
            {0.9012f, 0.9012f, 0.0000f, 0.0000f, -0.6f, 0f},
            {0.8457f, 0.8457f, 0.0000f, 0.0000f, -1.15f, 0f},
            {0.7778f, 0.7778f, 0.0000f, 0.0000f, -1.85f, 0f},
            {0.6975f, 0.6975f, 0.0000f, 0.0000f, -2.7f, 0f},
            {0.6049f, 0.6049f, 0.0000f, 0.0000f, -3.7f, 0f},
            {0.5f, 0.5f, 0.0000f, 0.0000f, -4.75f, 0f}
    };

    private static final float[][][] colorTransform = {
            {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 253}, {0, 0, 0, 0}},
            {{256, 256, 256, 243}, {0, 0, 0, 0}},
            {{256, 256, 256, 228}, {0, 0, 0, 0}},
            {{256, 256, 256, 205}, {0, 0, 0, 0}},
            {{256, 256, 256, 177}, {0, 0, 0, 0}},
            {{256, 256, 256, 142}, {0, 0, 0, 0}},
            {{256, 256, 256, 101}, {0, 0, 0, 0}},
            {{256, 256, 256, 54}, {0, 0, 0, 0}},
            {{256, 256, 256, 0}, {0, 0, 0, 0}}
    };

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
