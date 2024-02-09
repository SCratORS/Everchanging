package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

public class TouchBlick extends TextureObject {
    static final String[][] textureList = {{"image_13","image_15","shape_278"}};
    private final float[][] matrixAnimationTransform = {
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

    private final float[][] matrixTransform = {
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

    private final float[][][] colorTransform = {
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
    private final byte[] selectList = {0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    private final float[][] sizeTexture = {
            {30.0f, 31.5f},
            {20.0f, 21.0f}
    };
    float svgScale = 1.0f;

    int numClips = 20;

    public TouchBlick(Context context) {
        super(context, textureList, null);
    }

    void resetObject(Object object, float posX, float posY) {
        int index = random.nextInt(selectList.length);
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][selectList[index]]));
        if (index<2) {
            texture.width = sizeTexture[index][0];
            texture.height = sizeTexture[index][1];
            svgScale = 1.0f;
        } else {
            svgScale = 1.0f / textureManager.dipToPixels(1);
        }

        object.setTexture(texture, svgScale);

        float _x = (posX*ratio) + random.nextInt(30) - 15;
        float _y = (posY*ratio) + random.nextInt(30) - 15;
        int _rotation = (random.nextInt(4) + 1) * 90;
        int _scale = random.nextInt(150);

        object.resetViewMatrix();
        object.setViewScale(_scale, _scale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x,  _y);
        object.frameCounter = 0;
    }

    void createObject(float posX, float posY) {
        if (objects.objectsInUseCount() >= numClips) return;
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][selectList[0]]));
        Object object = objects.obtain(texture, 1.0f);
        resetObject(object, posX, posY);
    }

    public void update(boolean createObject, float posX, float posY) {

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
