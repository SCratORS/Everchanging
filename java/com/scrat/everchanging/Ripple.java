package com.scrat.everchanging;

import android.content.Context;
import java.util.ArrayList;

public class Ripple extends TextureObject  {
    static final String[][] textureList = {{"shape_23","shape_262"}};
    ArrayList<Object> removeObjects = new ArrayList<>();
    float speedScaleX = 1.3f;
    float speedScaleY = 1.05f;
    int startAplpha = 80;
    int maxFrames = 6;
    float deltaAplpha = (float) startAplpha / maxFrames;
    int typesAnim;
    public Ripple(Context context, int anim) {
        super(context, textureList, null);
        this.typesAnim = anim;
    }

    public void createObject(Object object) {
        object.frameCounter = 0;
        object.setAplpha(startAplpha);
        objects.add(object);
    }

    public void update() {
        final int objectsSize = objects.size();
        for (int i = 0; i < objectsSize; i++) {
            final Object object = objects.get(i);
            if (object.frameCounter > 0) {
                if (object.frameCounter == 1) {
                    int textureIndex = textureManager.getTextureIndex(textureList[0][typesAnim]);
                    object.setTexture(textureManager.getTexture(textureIndex), 1.0f);
                    object.setAplpha(startAplpha);
                }
                object.setScale(speedScaleX, (typesAnim > 0) ? speedScaleY : 1f);
                object.setAplpha(Math.max((startAplpha - (int) (deltaAplpha * object.frameCounter)), 0));
            }
            object.frameCounter++;
            if (object.frameCounter > maxFrames) removeObjects.add(object);
        }

        final int removeObjectsSize = removeObjects.size();
        for (int i = 0; i < removeObjectsSize; i++) {
            objects.remove(removeObjects.get(i));
        }
        removeObjects.clear();
    }
}
