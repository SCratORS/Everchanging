package com.scrat.everchanging;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;

public class Snow extends TextureObject{

    static private final String[][] textureList = {{"shape_29", "shape_30", "shape_31", "shape_32", "shape_33", "shape_34",
            "shape_35", "shape_36", "shape_37", "shape_38", "shape_7", "shape_39", "shape_40", "shape_41",
            "shape_42", "shape_43", "shape_44", "shape_5"}};

    private final String[] AnimateTextureFrames = {
            "shape_29", "shape_29", "shape_29", "shape_29", "shape_29", "shape_29", "shape_30", "shape_31",
            "shape_32", "shape_33", "shape_34", "shape_35", "shape_36", "shape_37", "shape_38", "shape_7",
            "shape_39", "shape_40", "shape_41", "shape_42", "shape_43", "shape_44", "shape_5"
    };
    private final float[][] AnimatedTextureMatrix = {
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 180f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 179.5f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 178.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 175.5f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 172.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 167.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 162.1f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 155.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 148.1f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 139.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 130.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 119.7f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 108.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 95.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 82.3f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 67.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 52.4f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 35.9f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 18.4f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -17.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -34.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -50.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -64.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -78.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -91.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -104.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -115.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -125.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -135.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -143.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -151.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -157.9f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -163.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -168.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -172.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -175.95f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -178.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -179.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -180.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -179.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -178.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -175.5f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -172.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -168.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -163.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -157.9f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -151.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -143.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -135.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -125.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -115.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -104.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -91.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -78.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -64.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -50.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -34.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, -17.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 17.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 34.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 50.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 64.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 78.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 91.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 104.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 115.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 125.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 135.0f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 143.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 151.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 157.9f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 163.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 168.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 172.8f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 175.9f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 178.2f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 179.6f, 0f},
            {1.0000f, 1.0000f, 0.0000f, 0.0000f, 180.0f, 0f}
    };
    private final float translate_x = 7.35f;
    private final float translate_y = 12.65f;
    private final float[][][] colorTransform = {
            //{redMultiTerm, greenMultiTerm, blueMultiTerm, alphaMultiTerm},{redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm}
            {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 255}, {0, 0, 0, 0}},
            {{256, 256, 256, 254}, {0, 0, 0, 0}},
            {{256, 256, 256, 253}, {0, 0, 0, 0}},
            {{256, 256, 256, 251}, {0, 0, 0, 0}},
            {{256, 256, 256, 249}, {0, 0, 0, 0}},
            {{256, 256, 256, 246}, {0, 0, 0, 0}},
            {{256, 256, 256, 243}, {0, 0, 0, 0}},
            {{256, 256, 256, 240}, {0, 0, 0, 0}},
            {{256, 256, 256, 236}, {0, 0, 0, 0}},
            {{256, 256, 256, 232}, {0, 0, 0, 0}},
            {{256, 256, 256, 228}, {0, 0, 0, 0}},
            {{256, 256, 256, 223}, {0, 0, 0, 0}},
            {{256, 256, 256, 217}, {0, 0, 0, 0}},
            {{256, 256, 256, 212}, {0, 0, 0, 0}},
            {{256, 256, 256, 205}, {0, 0, 0, 0}},
            {{256, 256, 256, 199}, {0, 0, 0, 0}},
            {{256, 256, 256, 192}, {0, 0, 0, 0}},
            {{256, 256, 256, 185}, {0, 0, 0, 0}},
            {{256, 256, 256, 177}, {0, 0, 0, 0}},
            {{256, 256, 256, 169}, {0, 0, 0, 0}},
            {{256, 256, 256, 160}, {0, 0, 0, 0}},
            {{256, 256, 256, 152}, {0, 0, 0, 0}},
            {{256, 256, 256, 142}, {0, 0, 0, 0}},
            {{256, 256, 256, 133}, {0, 0, 0, 0}},
            {{256, 256, 256, 122}, {0, 0, 0, 0}},
            {{256, 256, 256, 112}, {0, 0, 0, 0}},
            {{256, 256, 256, 101}, {0, 0, 0, 0}},
            {{256, 256, 256, 90}, {0, 0, 0, 0}},
            {{256, 256, 256, 78}, {0, 0, 0, 0}},
            {{256, 256, 256, 66}, {0, 0, 0, 0}},
            {{256, 256, 256, 54}, {0, 0, 0, 0}},
            {{256, 256, 256, 41}, {0, 0, 0, 0}},
            {{256, 256, 256, 28}, {0, 0, 0, 0}},
            {{256, 256, 256, 14}, {0, 0, 0, 0}},
            {{256, 256, 256, 0}, {0, 0, 0, 0}}
    };

    private final Calendar calendar;

    ArrayList<Object> removeObjects = new ArrayList<>();
    int frameCounter = 0;
    int maxFrames = 8;
    int numClips = minObjects;
    boolean init = false;
    int heightMax = 0;

    public Snow (final Context context, final Calendar calendar) {
        super(context, textureList,null);
        this.calendar = calendar;
    }

    private boolean get0404() {
        heightMax = (int) (height * 0.5f) + colorTransform.length + 10;
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        return (currentMonth==4) && (currentDay==4);
    }


    private void createObject() {
        if (objects.size() >= numClips) return;
        Object object = new Object(null, 1.0f);
        object.setObjectScale(1.0f/textureManager.dipToPixels(1));
        resetObject(object);
        objects.add(object);
    }

    private void resetObject(Object object) {
        int _x = random.nextInt(width + height) - height;
        float _y = (height - 140) - ((heightMax - colorTransform.length) * translate_y * 0.12f /* умножить на минимальный sale*/);
        _y -= (random.nextInt(10) - 30);
        int _yscale = random.nextInt(10) + 12;
        int indexTexture = (int) (_yscale + 0.5f);
        int texture = textureManager.getTextureIndex(AnimateTextureFrames[indexTexture]);
        object.setTexture(textureManager.getTexture(texture), 1.0f);
        object.resetMatrix();
        object.resetViewMatrix();
        object.setViewScale(_yscale, _yscale);
        if (indexTexture == 17) object.setScale(0.754f, 0.754f);
        object.setViewPosition(_x,  _y);
        object.setAplpha((int) (_yscale*4.5f));
        object.frameCounter = 0;
        object.animCounter = 0;
    }

    public void update(boolean createObject) {
        frameCounter = (frameCounter+1) % maxFrames;
        if (!init && createObject) numClips = (int) (ratio * 2 * (get0404()?maxObjects:(minObjects + random.nextInt(maxObjects - 4))));
        init = createObject;

        if (createObject && (frameCounter == 2)) createObject();

        for (Object object : objects) {
            object.resetMatrix();
            object.setTransform(AnimatedTextureMatrix[object.animCounter]);
            if (object.frameCounter < heightMax - colorTransform.length ) {
                object.setColorTransform(colorTransform[0]);
                object.setTranslate(translate_x * object.frameCounter, translate_y * object.frameCounter);
                object.animCounter = (object.animCounter+1) % AnimatedTextureMatrix.length;
            } else {
                object.setTranslate(translate_x * (heightMax - colorTransform.length), translate_y * (heightMax - colorTransform.length));
                object.setColorTransform(colorTransform[object.frameCounter - (heightMax - colorTransform.length)]);
            }
            object.frameCounter = (object.frameCounter+1 ) % heightMax;

            if (object.frameCounter == 0) {
                if (createObject) resetObject(object);
                else removeObjects.add(object);
            }

        }
        for (Object object : removeObjects) objects.remove(object);
        removeObjects.clear();
    }
}
