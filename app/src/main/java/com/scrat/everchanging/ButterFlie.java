package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.FloatArraysReader3d;
import com.scrat.everchanging.util.ReusableIterator;

import java.util.Calendar;

final class ButterFlie extends TextureObject {

    private static final String[][] textureList = {{
            "shape_147",
            "shape_148",
            "shape_149",
            "shape_150",
            "shape_151",
            "shape_152",
            "shape_153",
            "shape_154",
            "shape_155",
            "shape_156",
            "shape_157",
            "shape_158"
    }};

    private final float[][][] matrixTransform;

    private final float[][][] animationStartColor = {
            //{redMultiTerm, greenMultiTerm, blueMultiTerm, alphaMultiTerm},{redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm}
            {{192, 192, 192, 256}, {103, 204, 0, 0}},
            {{192, 192, 192, 256}, {157, 70, 255, 0}},
            {{192, 192, 192, 256}, {227, 66, 0, 0}},
            {{192, 192, 192, 256}, {228, 229, 0, 0}},
            {{192, 192, 192, 256}, {254, 8, 0, 0}}
    };

    private static final int MAX_FRAMES = 20;

    private final float[] animationStartPosition = {1.0f, 1.0f, 0.0000f, 0.0000f, 3.40f, -3.60f};

    private final Calendar calendar;

    private boolean init;
    private float svgScale = 1.0f;
    private int frameCounter;
    private int numClips = minObjects;

    ButterFlie(final Context context, final Calendar calendar) {
        super(context, textureList, null);
        this.calendar = calendar;
        matrixTransform = FloatArraysReader3d.read3d(context.getAssets(), "ButterfliesMatrixTransform");
    }

    private int ConvertRange(
            int originalStart, int originalEnd, // original range
            int newStart, int newEnd, // desired range
            int value) // value to convert
    {
        double scale = (double) (newEnd - newStart) / (originalEnd - originalStart);
        return (int) (newStart + ((value - originalStart) * scale));
    }

    private boolean get2401() {
        svgScale = textureManager.dipToPixels(1);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        return (currentMonth == 1) && (currentDay == 24);
    }

    void createObject() {
        if (objects.objectsInUseCount() > numClips) return;
        int textureIndex = textureManager.getTextureIndex(textureList[0][0]);

        final Object object = objects.obtain(textureManager.getTexture(textureIndex), 1.0f);
        object.index = (random.nextInt(5) == 0) ? 0 : 1;
        object.resetViewMatrix();
        object.resetMatrix();

        int _xscale = 100;
        if (random.nextInt(2) == 0) _xscale *= -1;
        object.setViewScale(_xscale, 100.0f);
        object.setColorTransform(animationStartColor[random.nextInt(5)]);

        final float _yscale = (random.nextInt(12) + 8) / 100.0f;
        final int _y = ConvertRange(-320, 320, -height, height, random.nextInt(640) - 320);
        object.setViewPosition(120, _y);
        object.setObjectScale(_yscale / svgScale);
        object.animCounter = 0;
        object.animCounterSkip = false;
        object.frameCounter = 0;
    }

    public void update(final boolean createObject) {
        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (!init && createObject)
            numClips = get2401() ? (int) (maxObjects / 2 + 0.5f) : (int) ((minObjects + random.nextInt(maxObjects - 4)) / 2 + 0.5f);
        init = createObject;

        if (frameCounter == 2) if (createObject) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < matrixTransform[object.index].length) {
                object.resetMatrix();
                object.setTexture(textureManager.getTexture(textureManager.getTextureIndex(textureList[0][object.animCounter])), 1.0f);
                object.setTransform(animationStartPosition);
                object.setTransform(matrixTransform[object.index][object.frameCounter]);
                object.frameCounter++;
                /*
                    If we have 40 FPS, then there is no point in coming up with a more complicated one.
                 */
                if (object.frameCounter % 2 == 0) object.animCounter = (object.animCounter + 1) % textureList[0].length;
            } else iterator.remove();
        }

        iterator.release();
    }

}
