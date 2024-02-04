package com.scrat.everchanging;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;

public class FireWork extends TextureObject{
    static private final String[][] textureList = {{
            "shape_180", "shape_181", "shape_182", "shape_183", "shape_184", "shape_185", "shape_186", "shape_187", "shape_188", "shape_189",
            "shape_190", "shape_191", "shape_192", "shape_193", "shape_194", "shape_195", "shape_196", "shape_197", "shape_198", "shape_199",
            "shape_200", "shape_201", "shape_202", "shape_203", "shape_204", "shape_205", "shape_206", "shape_207", "shape_208", "shape_209",
            "shape_210", "shape_211", "shape_212", "shape_213", "shape_214", "shape_215", "shape_216", "shape_217"}};
    private final byte[] spriteTable = {
            0,1,2,3,4,5,6,7,8,8,8,8,8,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,8
    };
    private final float[] transformMatrix = {1.0f, 1.0f, 0.0f, 0.0f, 19.7f, -88.5f};
    private final float[][][] colorTransform = {
            {{0, 0, 0, 256}, {0, 213, 213, 0}},
            {{0, 0, 0, 256}, {213, 0, 170, 0}},
            {{0, 0, 0, 256}, {235, 114, 29, 0}},
            {{0, 0, 0, 256}, {189, 236, 2, 0}},
            {{0, 0, 0, 256}, {221, 66, 0, 0}}
    };

    int numClips = minObjects;
    float svgScale = 1.0f;
    int frameCounter = 0;
    boolean init = false;
    int maxFrames = 5;
    ArrayList<Object> removeObjects = new ArrayList<>();

    private final Calendar calendar;

    private boolean get010104() {
        svgScale = textureManager.dipToPixels(1);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentYear = calendar.get(Calendar.YEAR);
        return (currentMonth==1) && (currentDay==1) && (currentYear % 4 == 0);
    }

    FireWork(final Context context, final Calendar calendar) {
        super(context, textureList, null);
        this.calendar = calendar;
    }

    void resetObject(Object object) {
        int _x = random.nextInt(240);
        int _y = random.nextInt(240);
        int _yscale = random.nextInt(150);
        object.resetMatrix();
        object.resetViewMatrix();
        object.setViewTransform(transformMatrix);
        object.setViewScale(_yscale, _yscale);
        object.setViewPosition(_x,  height - 220 + _y);
        object.setViewRotate(object.getRotation());
        object.frameCounter = random.nextInt(5);
        object.index--;
    }

    void createObject() {
        if (objects.size() >= numClips) return;
        int textureIndex = textureManager.getTextureIndex(textureList[0][0]);
        Object object = new Object(textureManager.getTexture(textureIndex), 1.0f);

        object.setObjectScale(1.0f/svgScale);
        int _x = random.nextInt(240);
        int _y = random.nextInt(220);
        int _rotation = random.nextInt(20) - 10;
        int _yscale = random.nextInt(85) + 25;
        int _xscale = _yscale;
        if (random.nextInt(2) == 0 ) _xscale *= -1;
        object.resetViewMatrix();
        object.resetMatrix();

        object.setViewTransform(transformMatrix);
        object.setViewScale(_xscale, _yscale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x,  height - 220 + _y);
        object.setColorTransform(colorTransform[random.nextInt(5)]);
        object.frameCounter = 0;
        object.index = random.nextInt(5);
        objects.add(object);
    }

    public void update(boolean createObject) {
        frameCounter = (frameCounter + 1) % maxFrames;
        if (!init && createObject)  numClips = (get010104()?maxObjects:(minObjects + random.nextInt(maxObjects - 4)));
        init = createObject;

        if ((createObject) && (frameCounter==2) && (random.nextInt(3) == 0)) createObject();

        for (Object object : objects) {
            if (object.frameCounter < spriteTable.length) {
                object.resetMatrix();
                object.setTexture(textureManager.getTexture(textureManager.getTextureIndex(textureList[0][spriteTable[object.frameCounter]])), 1.0f);
                object.frameCounter++;
            } else {
                if ((createObject) && (object.index>0)) resetObject(object);
                else removeObjects.add(object);
            }
        }
        for (Object object : removeObjects) objects.remove(object);
        removeObjects.clear();
    }
}
