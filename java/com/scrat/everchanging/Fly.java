package com.scrat.everchanging;

import android.content.Context;

import java.util.ArrayList;

public class Fly extends TextureObject {

    interface CrystalCreatorCallback {
        void callingCrystallCreatorCallback(float[] transform, float[] translate);

        void callingCrystallEndCallback(float[] transform, float[] translate);
    }

    CrystalCreatorCallback creatorCallback;

    private final float[][][] matrixTransform = {
        {
            {0.3f, 0.3f, 0.0000f, 0.0000f, 4.2f, 18.7f},{0.65f, 0.65f, 0.0000f, 0.0000f, 2.4f, 18.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.4f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.9f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.4f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.9f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.4f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.9f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.4f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 22.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 21.9f},{1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 0.1f, 20.4f},
        },{
            {0.3f, 0.3f, 0.0000f, 0.0000f, 18.4f, -47.3f},{0.65f, 0.65f, 0.0000f, 0.0000f, 18.1f, -47.1f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -44.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -45.4f},{1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -46.2f},
            {1.0f, 1.0f, 0.0000f, 0.0000f, 18.1f, -47.0f}
        },{
            {0.3f, 0.3f, 0.0000f, 0.0000f, -76.7f, -43.4f},{0.65f, 0.65f, 0.0000f, 0.0000f, -78.7f, -47.5f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -51.6f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.0f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -49.1f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.0f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -51.6f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.0f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -49.1f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.0f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -51.6f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.0f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -49.1f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.0f},{1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -50.8f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-80.7f, -51.6f},
        },{
            {0.3f, 0.3f, 0.0000f, 0.0000f, -75.0f, 34.0f},{0.65f, 0.65f, 0.0000f, 0.0000f, -77.0f, 29.9f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 25.8f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 28.3f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 25.8f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 28.3f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 25.8f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 28.3f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 25.8f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 28.3f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 27.4f},{1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 26.6f},
            {1.0f, 1.0f, 0.0000f, 0.0000f,-79.0f, 25.8f},
        }

    };
    private final float[][] colorTransform = {{256,256,256,256},{0,0,0,0}};

    static final String[][] textureList = {{"image_271","image_273"}};
    ArrayList<Object> removeObjects = new ArrayList<>();
    public Fly(Context context) {
        super(context, textureList, null);
    }

    public void createObject(float[] transform, float[] translate, int xscale, int index) {
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][0]));
        Object object = new Object(texture, 0.25f);
        object.resetMatrix();
        object.resetViewMatrix();
        object.setViewTransform(transform);
        object.setViewTranslate( translate[0],translate[1]);
        object.frameCounter = 0;
        object.animCounter = 0;
        object.index = index;
        object.setScale(xscale==0?1:-1, 1);
        objects.add(object);
    }
    public void update() {
        final int objectsSize = objects.size();
        for (int i = 0; i < objectsSize; i++) {
            final Object object = objects.get(i);
            if (object.frameCounter < matrixTransform[object.index].length) {
                creatorCallback.callingCrystallCreatorCallback(object.transformMatrix, object.ViewTranslate);
                TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][object.animCounter]));
                object.setTexture(texture, 0.25f);
                float scale = object.x_scalefactor;
                object.resetMatrix();
                object.setScale(scale, 1);
                object.setTransform(matrixTransform[object.index][object.frameCounter]);
                object.setColorTransform(colorTransform);
                object.animCounter = (object.animCounter+1) % 2;
                object.frameCounter++;
            } else {
                creatorCallback.callingCrystallEndCallback(object.transformMatrix, object.ViewTranslate);
                removeObjects.add(object);
            }
        }

        final int removeObjectsSize = removeObjects.size();
        for (int i = 0; i < removeObjectsSize; i++) {
            objects.remove(removeObjects.get(i));
        }
        removeObjects.clear();
    }

    public void registerCallBack(CrystalCreatorCallback callback){
        this.creatorCallback = callback;
    }
}
