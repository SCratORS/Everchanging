package com.scrat.everchanging;

import android.content.Context;

import java.util.ArrayList;

public class Crystal extends TextureObject {
    private final float[][] matrixTransform = {
            {0.75f, 0.7524f, 0.0000f, 0.0000f, 7.5f, 0f},
            {0.7891f, 0.7911f, 0.0000f, 0.0000f, 9.85f, 0f},
            {0.8438f, 0.8452f, 0.0000f, 0.0000f, 13.15f, 0f},
            {0.9141f, 0.9149f, 0.0000f, 0.0000f, 17.35f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 22.5f, 0f},
            {0.9356f, 0.9356f, 0.0000f, 0.0000f, 28.95f, 0f},
            {0.8756f, 0.8756f, 0.0000f, 0.0000f, 34.95f, 0f},
            {0.82f, 0.82f, 0.0000f, 0.0000f, 40.5f, 0f},
            {0.7689f, 0.7689f, 0.0000f, 0.0000f, 45.6f, 0f},
            {0.7222f, 0.7222f, 0.0000f, 0.0000f, 50.3f, 0f},
            {0.68f, 0.68f, 0.0000f, 0.0000f, 54.5f, 0f},
            {0.6422f, 0.6422f, 0.0000f, 0.0000f, 58.3f, 0f},
            {0.6089f, 0.6089f, 0.0000f, 0.0000f, 61.6f, 0f},
            {0.58f, 0.58f, 0.0000f, 0.0000f, 64.5f, 0f},
            {0.5556f, 0.5556f, 0.0000f, 0.0000f, 66.95f, 0f},
            {0.5356f, 0.5356f, 0.0000f, 0.0000f, 68.95f, 0f},
            {0.52f, 0.52f, 0.0000f, 0.0000f, 70.5f, 0f},
            {0.5089f, 0.5089f, 0.0000f, 0.0000f, 71.6f, 0f},
            {0.5022f, 0.5022f, 0.0000f, 0.0000f, 72.3f, 0f},
            {0.5f, 0.5f, 0.0000f, 0.0000f, 72.5f, 0f}
    };
    private final float[][][] colorTransform = {
            {{256,256,256,256},{0,0,0,0}},{{256,256,256,256},{0,0,0,0}},
            {{256,256,256,256},{0,0,0,0}},{{256,256,256,256},{0,0,0,0}},
            {{256,256,256,256},{0,0,0,0}},{{256,256,256,223},{0,0,0,0}},
            {{256,256,256,192},{0,0,0,0}},{{256,256,256,164},{0,0,0,0}},
            {{256,256,256,138},{0,0,0,0}},{{256,256,256,114},{0,0,0,0}},
            {{256,256,256,92},{0,0,0,0}},{{256,256,256,73},{0,0,0,0}},
            {{256,256,256,56},{0,0,0,0}},{{256,256,256,41},{0,0,0,0}},
            {{256,256,256,28},{0,0,0,0}},{{256,256,256,18},{0,0,0,0}},
            {{256,256,256,10},{0,0,0,0}},{{256,256,256,5},{0,0,0,0}},
            {{256,256,256,1},{0,0,0,0}},{{256,256,256,0},{0,0,0,0}},
    };
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
    static final String[][] textureList = {{"image_13","image_15"}};
    int frameCounter = 0;
    int maxFrames = 2;
    ArrayList<Object> removeObjects = new ArrayList<>();
    public Crystal(Context context) {
        super(context, textureList, null);
    }
    public void createEndsObject(float[] transform, float[] translate) {
        for (int n = 0; n < 4; n++) {
            int i = random.nextInt(2);
            TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][i]));
            texture.width = sizeTexture[i][0];
            texture.height = sizeTexture[i][1];
            Object crystalsEnd = new Object(null, 1.0f);
            crystalsEnd.setTexture(texture, 1.0f);
            crystalsEnd.setObjectScale(1.0f);
            float _x = endPosition[n][0];
            float _y = endPosition[n][1];
            int _rotation = n * 90;
            crystalsEnd.frameCounter = 0;
            crystalsEnd.animCounter = 0;
            crystalsEnd.resetViewMatrix();
            crystalsEnd.setViewTransform(transform);
            crystalsEnd.setViewRotate(_rotation);
            crystalsEnd.setViewTranslate(translate[0]+_x,  translate[1]+_y);
            objects.add(crystalsEnd);
        }
    }
    void createObject() {
        int i = random.nextInt(2);
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][i]));
        Object object = new Object(texture, 1.0f);
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
        object.setViewPosition(_x,  _y);
        object.setAplpha(_alpha);
        objects.add(object);
    }

    public void createObject(float[] transform, float[] translate) {
        if (frameCounter%2 == 0) return;
        int i = random.nextInt(2);
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][i]));
        texture.width = sizeTexture[i][0];
        texture.height = sizeTexture[i][1];
        Object crystal = new Object(texture, 1.0f);
        crystal.setTexture(texture, 1.0f);
        crystal.setObjectScale(1.0f);
        crystal.resetViewMatrix();
        float _x = random.nextInt(20)-10;
        float _y = random.nextInt(20)-10;
        int _rotation = random.nextInt(4) * 90;
        int _scale = random.nextInt(120);
        crystal.frameCounter = 0;
        crystal.setViewTransform(transform);
        crystal.setViewScale(_scale, _scale);
        crystal.setViewRotate(_rotation);
        crystal.setViewTranslate(translate[0]+_x,  translate[1]+_y);
        objects.add(crystal);
    }
    public void update(boolean createObject) {
        frameCounter = (frameCounter+1) % maxFrames;
        if (createObject && (frameCounter == 1)) createObject();
        final int objectsSize = objects.size();
        for (int i = 0; i < objectsSize; i++) {
            final Object object = objects.get(i);
            if (object.frameCounter < matrixTransform.length) {
                object.resetMatrix();
                object.setColorTransform(colorTransform[object.frameCounter]);
                object.setTransform(matrixTransform[object.frameCounter]);
                object.frameCounter++;
            } else {
                removeObjects.add(object);
            }
        }

        final int removeObjectsSize = removeObjects.size();
        for (int i = 0; i < removeObjectsSize; i++) {
            objects.remove(removeObjects.get(i));
        }
        removeObjects.clear();
    }
}
