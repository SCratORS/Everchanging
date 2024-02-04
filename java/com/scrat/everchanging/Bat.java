package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

public class Bat extends TextureObject {
    static final String[][] textureList = {{"shape_49","shape_50","shape_51","shape_52"}};
    static final float[][] texturePivot = {{26.15f, 79.05f},{46.15f, 59.1f},{67.15f, 37.2f},{41.65f, 27.5f}};
    private final byte[] spriteTable = {0,1,2,3,2,1};
    private final float[] startMatrix = {1.0000f, 1.0000f, 0.0000f, 0.0000f, -18.25f, 39.5f};
    private final float[][] animateMatrix = {
        {1f, 0.9994f, 0.0000f, 0.0000f, 0f, 0f},
        {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, -6f},
        {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, -10f},
        {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, -15f},
        {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, -10.75f},
        {1.0000f, 1.0000f, 0.0000f, 0.0000f, 0f, 0f}
    };
    private final float[][] matrixTransform = {
            {0.05655f, 0.06366f, 0.0000f, 0.0000f, -748.7f, -282.4f},
            {0.05756f, 0.06465f, 0.0000f, 0.0000f, -747.6f, -281.9f},
            {0.05928f, 0.06639f, 0.0000f, 0.0000f, -745.85f, -281.15f},
            {0.06171f, 0.0688f, 0.0000f, 0.0000f, -743.35f, -280.2f},
            {0.0648f, 0.0719f, 0.0000f, 0.0000f, -740.1f, -278.85f},
            {0.06859f, 0.07567f, 0.0000f, 0.0000f, -736.2f, -277.25f},
            {0.07304f, 0.08012f, 0.0000f, 0.0000f, -731.5f, -275.3f},
            {0.0782f, 0.08527f, 0.0000f, 0.0000f, -726.2f, -273.1f},
            {0.08409f, 0.09114f, 0.0000f, 0.0000f, -720.1f, -270.65f},
            {0.09061f, 0.09764f, 0.0000f, 0.0000f, -713.3f, -267.85f},
            {0.09785f, 0.1049f, 0.0000f, 0.0000f, -705.85f, -264.8f},
            {0.1058f, 0.1128f, 0.0000f, 0.0000f, -697.5f, -261.4f},
            {0.1144f, 0.1214f, 0.0000f, 0.0000f, -688.6f, -257.75f},
            {0.1237f, 0.1306f, 0.0000f, 0.0000f, -678.95f, -253.8f},
            {0.1336f, 0.1406f, 0.0000f, 0.0000f, -668.7f, -249.55f},
            {0.1444f, 0.1513f, 0.0000f, 0.0000f, -657.5f, -245f},
            {0.1557f, 0.1626f, 0.0000f, 0.0000f, -645.65f, -240.15f},
            {0.1677f, 0.1746f, 0.0000f, 0.0000f, -633.25f, -235.1f},
            {0.1805f, 0.1874f, 0.0000f, 0.0000f, -620f, -229.65f},
            {0.1939f, 0.2007f, 0.0000f, 0.0000f, -606.05f, -223.9f},
            {0.208f, 0.2148f, 0.0000f, 0.0000f, -591.4f, -217.9f},
            {0.2229f, 0.2296f, 0.0000f, 0.0000f, -576.05f, -211.6f},
            {0.2384f, 0.2451f, 0.0000f, 0.0000f, -559.9f, -205f},
            {0.2545f, 0.2612f, 0.0000f, 0.0000f, -543.1f, -198.2f},
            {0.2714f, 0.2781f, 0.0000f, 0.0000f, -525.6f, -190.95f},
            {0.289f, 0.2956f, 0.0000f, 0.0000f, -507.35f, -183.55f},
            {0.3073f, 0.3138f, 0.0000f, 0.0000f, -488.4f, -175.75f},
            {0.3262f, 0.3327f, 0.0000f, 0.0000f, -468.75f, -167.7f},
            {0.3458f, 0.3523f, 0.0000f, 0.0000f, -448.4f, -159.35f},
            {0.3661f, 0.3726f, 0.0000f, 0.0000f, -427.35f, -150.7f},
            {0.3871f, 0.3936f, 0.0000f, 0.0000f, -405.45f, -141.75f},
            {0.4088f, 0.4152f, 0.0000f, 0.0000f, -382.9f, -132.55f},
            {0.4312f, 0.4375f, 0.0000f, 0.0000f, -359.7f, -123f},
            {0.4543f, 0.4606f, 0.0000f, 0.0000f, -335.75f, -113.25f},
            {0.478f, 0.4843f, 0.0000f, 0.0000f, -311.1f, -103.1f},
            {0.5025f, 0.5087f, 0.0000f, 0.0000f, -285.75f, -92.75f},
            {0.5276f, 0.5338f, 0.0000f, 0.0000f, -259.6f, -82f},
            {0.5535f, 0.5596f, 0.0000f, 0.0000f, -232.75f, -71.05f},
            {0.58f, 0.586f, 0.0000f, 0.0000f, -205.25f, -59.8f},
            {0.6071f, 0.6131f, 0.0000f, 0.0000f, -177.05f, -48.25f},
            {0.6351f, 0.641f, 0.0000f, 0.0000f, -148f, -36.3f},
            {0.6636f, 0.6695f, 0.0000f, 0.0000f, -118.35f, -24.25f},
            {0.6929f, 0.6987f, 0.0000f, 0.0000f, -88f, -11.75f},
            {0.7229f, 0.7286f, 0.0000f, 0.0000f, -56.8f, 1f},
            {0.7535f, 0.7592f, 0.0000f, 0.0000f, -25.05f, 14f},
            {0.7849f, 0.7905f, 0.0000f, 0.0000f, 7.5f, 27.35f},
            {0.8169f, 0.8225f, 0.0000f, 0.0000f, 40.7f, 40.95f},
            {0.8496f, 0.8551f, 0.0000f, 0.0000f, 74.65f, 54.85f},
            {0.8831f, 0.8885f, 0.0000f, 0.0000f, 109.4f, 69.1f},
            {0.9171f, 0.9225f, 0.0000f, 0.0000f, 144.8f, 83.55f},
            {0.9519f, 0.9572f, 0.0000f, 0.0000f, 180.9f, 98.35f},
            {0.9874f, 0.9926f, 0.0000f, 0.0000f, 217.75f, 113.5f},
            {1.024f, 1.029f, 0.0000f, 0.0000f, 255.25f, 128.85f},
            {1.06f, 1.065f, 0.0000f, 0.0000f, 293.5f, 144.5f},
            {1.098f, 1.103f, 0.0000f, 0.0000f, 332.55f, 160.45f},
            {1.136f, 1.141f, 0.0000f, 0.0000f, 372.2f, 176.7f},
            {1.175f, 1.18f, 0.0000f, 0.0000f, 412.55f, 193.25f},
            {1.215f, 1.219f, 0.0000f, 0.0000f, 453.65f, 210.1f},
            {1.255f, 1.26f, 0.0000f, 0.0000f, 495.55f, 227.2f},
            {1.296f, 1.3f, 0.0000f, 0.0000f, 538.05f, 244.65f},
            {1.338f, 1.342f, 0.0000f, 0.0000f, 581.35f, 262.35f},
            {1.38f, 1.384f, 0.0000f, 0.0000f, 625.3f, 280.4f},
            {1.423f, 1.427f, 0.0000f, 0.0000f, 670.05f, 298.7f},
            {1.467f, 1.471f, 0.0000f, 0.0000f, 715.35f, 317.25f},
            {1.511f, 1.515f, 0.0000f, 0.0000f, 761.45f, 336.15f},
            {1.556f, 1.56f, 0.0000f, 0.0000f, 808.4f, 355.4f},
            {1.602f, 1.606f, 0.0000f, 0.0000f, 855.9f, 374.8f},
            {1.649f, 1.652f, 0.0000f, 0.0000f, 904.1f, 394.55f},
            {1.696f, 1.7f, 0.0000f, 0.0000f, 953.15f, 414.6f},
            {1.744f, 1.747f, 0.0000f, 0.0000f, 1002.8f, 435f},
            {1.792f, 1.796f, 0.0000f, 0.0000f, 1053.3f, 455.65f},
            {1.841f, 1.845f, 0.0000f, 0.0000f, 1104.45f, 476.6f},
            {1.891f, 1.895f, 0.0000f, 0.0000f, 1156.25f, 497.85f},
            {1.942f, 1.945f, 0.0000f, 0.0000f, 1208.9f, 519.4f},
            {1.993f, 1.996f, 0.0000f, 0.0000f, 1262.05f, 541.2f},
            {2.045f, 2.048f, 0.0000f, 0.0000f, 1316.05f, 563.3f},
            {2.098f, 2.101f, 0.0000f, 0.0000f, 1370.8f, 585.7f},
            {2.151f, 2.154f, 0.0000f, 0.0000f, 1426.2f, 608.4f},
            {2.205f, 2.208f, 0.0000f, 0.0000f, 1482.25f, 631.35f},
            {2.26f, 2.263f, 0.0000f, 0.0000f, 1539.2f, 654.65f},
            {2.316f, 2.318f, 0.0000f, 0.0000f, 1596.75f, 678.2f},
            {2.372f, 2.374f, 0.0000f, 0.0000f, 1655.05f, 702.1f},
            {2.429f, 2.431f, 0.0000f, 0.0000f, 1713.95f, 726.25f},
            {2.486f, 2.488f, 0.0000f, 0.0000f, 1773.65f, 750.7f},
            {2.544f, 2.546f, 0.0000f, 0.0000f, 1834.15f, 775.5f},
            {2.603f, 2.605f, 0.0000f, 0.0000f, 1895.25f, 800.5f},
            {2.663f, 2.664f, 0.0000f, 0.0000f, 1957.15f, 825.85f},
            {2.723f, 2.725f, 0.0000f, 0.0000f, 2019.75f, 851.45f},
            {2.784f, 2.785f, 0.0000f, 0.0000f, 2082.95f, 877.35f},
            {2.846f, 2.847f, 0.0000f, 0.0000f, 2146.95f, 903.5f},
            {2.908f, 2.909f, 0.0000f, 0.0000f, 2211.75f, 930.15f},
            {2.971f, 2.972f, 0.0000f, 0.0000f, 2277.1f, 956.85f},
            {3.035f, 3.036f, 0.0000f, 0.0000f, 2343.15f, 983.95f},
            {3.099f, 3.1f, 0.0000f, 0.0000f, 2410.15f, 1011.35f},
            {3.164f, 3.165f, 0.0000f, 0.0000f, 2477.65f, 1039f},
            {3.23f, 3.231f, 0.0000f, 0.0000f, 2546f, 1067.05f},
            {3.296f, 3.297f, 0.0000f, 0.0000f, 2615f, 1095.25f},
            {3.364f, 3.364f, 0.0000f, 0.0000f, 2684.65f, 1123.75f},
            {3.431f, 3.432f, 0.0000f, 0.0000f, 2755.2f, 1152.7f}
    };

    int maxFrames = 33;
    int frameCounter = 0;
    int numClips = 7;
    public Bat(Context context) {
        super(context, textureList, texturePivot);
    }

    void resetObject(Object object) {
        int _x = random.nextInt(50) + random.nextInt(600) - 300;
        int _y = random.nextInt(25) - 50;
        int _yscale = random.nextInt(10) + 10;
        object.resetViewMatrix();
        object.resetMatrix();
        object.setViewTransform(startMatrix);
        object.setViewScale(_yscale * ratio, _yscale * ratio);
        object.setViewPosition(_x, _y * ratio);
        object.frameCounter = 0;
        object.animCounter = 0;
        object.index = 0;
    }
    void createObject() {
        if (objects.objectsInUseCount() > numClips) return;
        int textureIndex = textureManager.getTextureIndex(textureList[0][0]);
        Object object = objects.obtain(textureManager.getTexture(textureIndex), 1.0f);
        float svgScale = textureManager.dipToPixels(1);
        object.setObjectScale(1.0f/svgScale);
        int _x = random.nextInt(50) + random.nextInt(600) - 300;
        int _y = random.nextInt(25) - 50;
        int _yscale = random.nextInt(15) + 10;
        object.resetViewMatrix();
        object.setViewTransform(startMatrix);
        object.setViewScale(_yscale * ratio, _yscale * ratio);
        object.setViewPosition(_x, _y * ratio);
        object.frameCounter = 0;
        object.animCounter = 0;
        object.index = 0;
    }

    public void update(boolean createObject) {
        frameCounter = (frameCounter+1) % maxFrames;
        if (createObject && (frameCounter==2)) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < matrixTransform.length) {
                object.resetMatrix();
                object.setTexture(textureManager.getTexture(textureManager.getTextureIndex(textureList[0][spriteTable[object.animCounter]])), 1.0f);
                object.setTransform(animateMatrix[object.animCounter]);
                object.setTransform(matrixTransform[object.frameCounter]);
                object.animCounter = (object.animCounter+1) % spriteTable.length;
                object.frameCounter++;
            } else {
                if (createObject) resetObject(object);
               else iterator.remove();
            }
        }

        iterator.release();
    }

}
