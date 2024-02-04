package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

public class Ripple extends TextureObject  {
    static final String[][] textureList = {{"shape_23","shape_262"}};
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

    public void createObjectCopy(final Object object) {
        final Object newObject = objects.obtain();
        newObject.copyFrom(object);

        newObject.setAplpha(0);
        newObject.frameCounter = 0;
    }

    public void update() {
        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
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
            if (object.frameCounter > maxFrames) iterator.remove();
        }

        iterator.release();
    }
}
