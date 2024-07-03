package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.FloatArraysReader3d;
import com.scrat.everchanging.util.ReusableIterator;

final class Blick extends TextureObject {

    // @formatter:off
    private final float[][] spritesStartTransform = {
            {   0.319300f,    0.459100f,   -0.006485f,    0.009308f,   73.900000f,  159.450000f},
            {   0.193100f,   -0.193100f,   -0.416900f,   -0.416900f,  136.150000f,  322.800000f},
            {  -0.460100f,    0.460100f,    0.000000f,    0.000000f,  249.500000f,  133.100000f},
            {  -0.103800f,    0.103800f,    0.447900f,    0.447900f,   24.000000f,  119.850000f},
            {   0.446500f,    0.446600f,    0.105200f,   -0.105200f,   75.500000f,   48.650000f},
            {   0.375600f,    0.375600f,    0.264700f,   -0.264700f,  129.300000f,   71.200000f},
            {  -0.230100f,    0.230100f,    0.398500f,    0.398500f,  124.000000f,   82.450000f},
            {  -0.276100f,    0.276100f,    0.000000f,    0.000000f,  172.700000f,  148.200000f},
            {   0.444400f,    0.444400f,    0.119100f,   -0.119100f,  104.050000f,  177.400000f},
            {  -0.694100f,    0.997800f,   -0.014080f,   -0.020230f,  287.850000f,   78.400000f},
            {  -0.419600f,   -0.419600f,   -0.906200f,    0.906200f,  151.000000f,  433.350000f},
            {   1.000000f,    1.000000f,    0.000000f,    0.000000f,  -95.450000f,   22.500000f},
            {   0.225600f,    0.225600f,    0.973500f,   -0.973500f,  396.700000f,   -5.650000f},
            {  -0.970600f,    0.970600f,    0.228700f,    0.228700f,  284.700000f, -162.450000f},
            {  -0.816300f,    0.816400f,    0.575400f,    0.575400f,  168.050000f, -112.500000f},
            {   0.500000f,    0.500000f,    0.866000f,   -0.866000f,  178.100000f,  -89.100000f},
            {   0.600000f,    0.600000f,    0.000000f,    0.000000f,   73.700000f,   54.400000f},
            {  -0.965900f,    0.965900f,    0.258800f,    0.258800f,  221.450000f,  118.400000f},
    };

    private final float[][][] spritesStartColorTransform = {
            //redMultiTerm, greenMultiTerm, blueMultiTerm, alphaMultiTerm
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{184, 184, 184, 256}, {29, 57, 57,  0}},
            {{184, 184, 184, 256}, { 0, 71, 71,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{256, 256, 256, 256}, { 0,  0,  0,  0}},
            {{184, 184, 184, 256}, {29, 57, 57,  0}},
            {{184, 184, 184, 256}, { 0, 71, 71,  0}}
    };
    // @formatter:on

    private final int[] spriteIndex = {0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1};

    private final float[][][] matrixTransform;

    private final float[][] animationObjectTransform = {
            {1f, 1.00f},
            {1f, 0.54f},
            {0f, 0.08f},
            {0f, 0.27f},
            {0f, 0.46f},
            {0f, 0.73f},
            {0f, 1.00f},
            {0f, 0.73f},
            {0f, 0.46f},
            {0f, 0.27f},
            {0f, 0.08f},
            {0f, 0.08f},
            {1f, 0.08f},
            {1f, 0.27f},
            {1f, 0.46f},
    };

    private static final int[][] textureList = {{
            R.drawable.shape_3,
            R.drawable.shape_6
    }};

    private int index = 0;

    Blick(final Context context) {
        super(context, textureList, null);
        matrixTransform = FloatArraysReader3d.read3d(context.getAssets(), "BlickMatrixTransform");
    }

    void createObject() {
        if (objects.objectsInUseCount() > spritesStartTransform.length) return;

        final int textureIndex = textureManager.getTextureIndex(textureList[0][0]);
        final Object object = objects.obtain(textureManager.getTexture(textureIndex), 1.0f);
        final float svgScale = textureManager.dipToPixels(1);
        object.setObjectScale(1.0f / svgScale / ratio);

        object.resetViewMatrix();
        object.setViewTransform(spritesStartTransform[index]);
        object.setColorTransform(spritesStartColorTransform[index]);

        object.setViewScale(100 * ratio, ratio * 100);

        object.animCounter = 0;
        object.frameCounter = 0;
        object.index = index;
        index = (index + 1) % spriteIndex.length;
    }

    void objectAnimate(final Object object) {
        object.setTexture(textureManager.getTexture(textureManager.getTextureIndex(textureList[0][(int) animationObjectTransform[object.animCounter][0]])), 1.0f);
        object.setColorTransform(spritesStartColorTransform[object.index]);
        object.setScale(1f, animationObjectTransform[object.animCounter][1]);
        object.animCounter = (object.animCounter + 1) % animationObjectTransform.length;

    }

    void update(final boolean createObject) {
        if (createObject) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            object.resetMatrix();
            objectAnimate(object);
            object.setTransform(matrixTransform[spriteIndex[object.index]][object.frameCounter]);
            object.frameCounter = (object.frameCounter + 1) % matrixTransform[spriteIndex[object.index]].length;
            if (!createObject && (object.frameCounter == 0)) iterator.remove();
        }

        iterator.release();
    }
}
