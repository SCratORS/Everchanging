package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class Ripple extends TextureObject {

    private static final String[][] textureList = {{"shape_23", "shape_262"}};

    private static final float SPEED_SCALE_X = 1.15f;
    private static final float SPEED_SCALE_Y = 1.025f;

    private final int startAplpha = 80;
    private final int maxFrames = 12;
    private final float deltaAlpha = (float) startAplpha / maxFrames;
    private final int typesAnim;

    Ripple(final Context context, final int anim) {
        super(context, textureList, null);
        this.typesAnim = anim;
    }

    void createObjectCopy(final Object object) {
        final Object newObject = objects.obtain();
        newObject.copyFrom(object);

        newObject.setAplpha(0);
        newObject.frameCounter = 0;
    }

    void update() {
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
                object.setScale(SPEED_SCALE_X, (typesAnim > 0) ? SPEED_SCALE_Y : 1f);
                object.setAplpha(Math.max((startAplpha - (int) (deltaAlpha * object.frameCounter)), 0));
            }
            object.frameCounter++;
            if (object.frameCounter > maxFrames) iterator.remove();
        }

        iterator.release();
    }
}
