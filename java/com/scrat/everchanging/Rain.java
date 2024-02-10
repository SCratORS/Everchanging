package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

import java.util.Calendar;

final class Rain extends TextureObject {

    interface FinishCallback {
        void callingFinishCallback(Object object);
    }

    private final float[][][][] colorTransform = {
            //{redMultiTerm, greenMultiTerm, blueMultiTerm, alphaMultiTerm},{redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm}
            {
                    {{0, 0, 0, 256}, {127, 232, 255, 0}},
                    {{0, 0, 0, 256}, {130, 8, 193, 0}},
                    {{0, 0, 0, 256}, {255, 253, 103, 0}},
                    {{0, 0, 0, 256}, {40, 94, 37, 0}},
                    {{0, 0, 0, 256}, {126, 3, 3, 0}}
            },

            {
                    {{0, 0, 0, 256}, {213, 0, 170, 0}},
                    {{0, 0, 0, 256}, {255, 0, 72, 0}},
                    {{0, 0, 0, 256}, {221, 66, 0, 0}},
                    {{0, 0, 0, 256}, {255, 0, 255, 0}},
                    {{0, 0, 0, 256}, {255, 255, 255, 0}}
            }
    };

    private static final String[][] textureList = {{"shape_22"}};

    private static final int MAX_FRAMES = 2;
    private static final float SPEED = 320.0f / 7.0f;

    private final Calendar calendar;

    private int frameCounter = 0;
    private int frameMoveCount = 0;
    private int numClips = minObjects;
    private boolean init = false;

    private FinishCallback finishCallback;
    private final int typesAnim;

    Rain(final Context context, final Calendar calendar, final int anim) {
        super(context, textureList, null);
        this.calendar = calendar;
        this.typesAnim = anim;
    }

    void registerCallBack(final FinishCallback callback) {
        this.finishCallback = callback;
    }

    void createObject() {
        if (objects.objectsInUseCount() >= numClips) return;

        final int textureIndex = textureManager.getTextureIndex(textureList[0][0]);
        final Object object = objects.obtain(textureManager.getTexture(textureIndex), 1.0f);
        final float svgScale = textureManager.dipToPixels(1);
        object.setObjectScale(0.5f / svgScale);

        final float _scale = (random.nextInt(20) + 80);
        final int half_w = (int) (width * 0.5f);
        final float _x = random.nextInt(height + half_w) + half_w;
        final float _y = (height - 90) - (frameMoveCount * SPEED * 0.8f);

        object.resetMatrix();
        object.resetViewMatrix();
        object.setColorTransform(colorTransform[typesAnim][random.nextInt(5)]);
        object.setViewScale(_scale, _scale);
        object.setAplpha(85);
        object.setViewPosition(_x, _y);

        final float frameScale = (random.nextInt(15) + 115) / 100.0f;
        object.setScale(frameScale, frameScale);
        object.frameCounter = 0;
    }


    private boolean get0403() {
        frameMoveCount = 1 + (int) (height / SPEED);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        return (currentMonth == 3) && (currentDay == 4);
    }

    void update(final boolean createObject) {
        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (!init && createObject)
            numClips = get0403() ? maxObjects : (minObjects + random.nextInt(maxObjects - 4));
        init = createObject;
        if (createObject && frameCounter == 1) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            object.setTranslate(-SPEED, SPEED);
            if (++object.frameCounter == frameMoveCount) {
                finishCallback.callingFinishCallback(object);
                iterator.remove();
            }
        }

        iterator.release();
    }
}
