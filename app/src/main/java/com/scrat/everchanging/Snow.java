package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

import java.util.Calendar;

final class Snow extends TextureObject {

    private static final int[][] textureList = {{
            R.drawable.shape_29, R.drawable.shape_30, R.drawable.shape_31, R.drawable.shape_32,
            R.drawable.shape_33, R.drawable.shape_34, R.drawable.shape_35, R.drawable.shape_36,
            R.drawable.shape_37, R.drawable.shape_38, R.drawable.shape_7, R.drawable.shape_39,
            R.drawable.shape_40, R.drawable.shape_41, R.drawable.shape_42, R.drawable.shape_43,
            R.drawable.shape_44, R.drawable.shape_5
    }
    };

    private static final int[] AnimateTextureFrames = {
            R.drawable.shape_29, R.drawable.shape_29, R.drawable.shape_29, R.drawable.shape_29,
            R.drawable.shape_29, R.drawable.shape_29, R.drawable.shape_30, R.drawable.shape_31,
            R.drawable.shape_32, R.drawable.shape_33, R.drawable.shape_34, R.drawable.shape_35,
            R.drawable.shape_36, R.drawable.shape_37, R.drawable.shape_38, R.drawable.shape_7,
            R.drawable.shape_39, R.drawable.shape_40, R.drawable.shape_41, R.drawable.shape_42,
            R.drawable.shape_43, R.drawable.shape_44, R.drawable.shape_5
    };

    // @formatter:off
    private final float[][] AnimatedTextureMatrix = {
            {   1.00f,    1.00f,    0.00f,    0.00f,  180.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  179.75f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  179.50f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  178.75f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  178.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  176.75f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  175.50f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  173.75f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  172.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  169.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  167.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  164.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  162.10f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  158.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  155.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  151.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  148.10f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  143.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  139.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  134.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  130.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  124.95f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  119.70f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  113.95f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  108.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  102.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   95.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   89.05f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   82.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   75.05f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   67.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   60.10f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   52.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   44.15f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   35.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   27.15f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   18.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,    9.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,    0.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   -8.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -17.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -25.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -34.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -42.10f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -50.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -57.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -64.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -71.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -78.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -85.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -91.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -97.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -104.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -109.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -115.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -120.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -125.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -130.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -135.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -139.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -143.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -147.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -151.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -154.55f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -157.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -160.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -163.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -166.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -168.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -170.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -172.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -174.38f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -175.95f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -177.07f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -178.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -178.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -179.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -179.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -180.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -179.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -179.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -178.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -178.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -176.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -175.50f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -174.15f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -172.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -170.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -168.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -166.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -163.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -160.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -157.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -154.55f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -151.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -147.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -143.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -139.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -135.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -130.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -125.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -120.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -115.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -109.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f, -104.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -97.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -91.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -85.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -78.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -71.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -64.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -57.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -50.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -42.10f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -34.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -25.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  -17.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   -8.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,    0.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,    8.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   17.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   25.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   34.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   42.10f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   50.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   57.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   64.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   71.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   78.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   85.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   91.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,   97.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  104.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  109.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  115.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  120.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  125.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  130.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  135.00f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  139.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  143.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  147.40f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  151.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  154.55f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  157.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  160.85f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  163.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  166.30f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  168.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  170.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  172.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  174.35f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  175.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  177.05f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  178.20f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  178.90f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  179.60f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  179.80f,    0.00f},
            {   1.00f,    1.00f,    0.00f,    0.00f,  180.00f,    0.00f},
    };

    private static final float translate_x = 7.35f;
    private static final float translate_y = 12.65f;

    private static final float[][][] colorTransform = {
            //{redMultiTerm, greenMultiTerm, blueMultiTerm, alphaMultiTerm},{redAddTerm, greenAddTerm, blueAddTerm, alphaAddTerm}
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 255}, {0, 0, 0, 0}}, {{256, 256, 256, 254}, {0, 0, 0, 0}},
            {{256, 256, 256, 254}, {0, 0, 0, 0}}, {{256, 256, 256, 254}, {0, 0, 0, 0}},
            {{256, 256, 256, 253}, {0, 0, 0, 0}}, {{256, 256, 256, 252}, {0, 0, 0, 0}},
            {{256, 256, 256, 251}, {0, 0, 0, 0}}, {{256, 256, 256, 250}, {0, 0, 0, 0}},
            {{256, 256, 256, 249}, {0, 0, 0, 0}}, {{256, 256, 256, 248}, {0, 0, 0, 0}},
            {{256, 256, 256, 246}, {0, 0, 0, 0}}, {{256, 256, 256, 244}, {0, 0, 0, 0}},
            {{256, 256, 256, 243}, {0, 0, 0, 0}}, {{256, 256, 256, 242}, {0, 0, 0, 0}},
            {{256, 256, 256, 240}, {0, 0, 0, 0}}, {{256, 256, 256, 238}, {0, 0, 0, 0}},
            {{256, 256, 256, 236}, {0, 0, 0, 0}}, {{256, 256, 256, 234}, {0, 0, 0, 0}},
            {{256, 256, 256, 232}, {0, 0, 0, 0}}, {{256, 256, 256, 230}, {0, 0, 0, 0}},
            {{256, 256, 256, 228}, {0, 0, 0, 0}}, {{256, 256, 256, 226}, {0, 0, 0, 0}},
            {{256, 256, 256, 223}, {0, 0, 0, 0}}, {{256, 256, 256, 220}, {0, 0, 0, 0}},
            {{256, 256, 256, 217}, {0, 0, 0, 0}}, {{256, 256, 256, 214}, {0, 0, 0, 0}},
            {{256, 256, 256, 212}, {0, 0, 0, 0}}, {{256, 256, 256, 208}, {0, 0, 0, 0}},
            {{256, 256, 256, 205}, {0, 0, 0, 0}}, {{256, 256, 256, 202}, {0, 0, 0, 0}},
            {{256, 256, 256, 199}, {0, 0, 0, 0}}, {{256, 256, 256, 196}, {0, 0, 0, 0}},
            {{256, 256, 256, 192}, {0, 0, 0, 0}}, {{256, 256, 256, 188}, {0, 0, 0, 0}},
            {{256, 256, 256, 185}, {0, 0, 0, 0}}, {{256, 256, 256, 181}, {0, 0, 0, 0}},
            {{256, 256, 256, 177}, {0, 0, 0, 0}}, {{256, 256, 256, 173}, {0, 0, 0, 0}},
            {{256, 256, 256, 169}, {0, 0, 0, 0}}, {{256, 256, 256, 164}, {0, 0, 0, 0}},
            {{256, 256, 256, 160}, {0, 0, 0, 0}}, {{256, 256, 256, 156}, {0, 0, 0, 0}},
            {{256, 256, 256, 152}, {0, 0, 0, 0}}, {{256, 256, 256, 147}, {0, 0, 0, 0}},
            {{256, 256, 256, 142}, {0, 0, 0, 0}}, {{256, 256, 256, 138}, {0, 0, 0, 0}},
            {{256, 256, 256, 133}, {0, 0, 0, 0}}, {{256, 256, 256, 128}, {0, 0, 0, 0}},
            {{256, 256, 256, 122}, {0, 0, 0, 0}}, {{256, 256, 256, 117}, {0, 0, 0, 0}},
            {{256, 256, 256, 112}, {0, 0, 0, 0}}, {{256, 256, 256, 106}, {0, 0, 0, 0}},
            {{256, 256, 256, 101}, {0, 0, 0, 0}}, {{256, 256, 256,  96}, {0, 0, 0, 0}},
            {{256, 256, 256,  90}, {0, 0, 0, 0}}, {{256, 256, 256,  84}, {0, 0, 0, 0}},
            {{256, 256, 256,  78}, {0, 0, 0, 0}}, {{256, 256, 256,  72}, {0, 0, 0, 0}},
            {{256, 256, 256,  66}, {0, 0, 0, 0}}, {{256, 256, 256,  60}, {0, 0, 0, 0}},
            {{256, 256, 256,  54}, {0, 0, 0, 0}}, {{256, 256, 256,  48}, {0, 0, 0, 0}},
            {{256, 256, 256,  41}, {0, 0, 0, 0}}, {{256, 256, 256,  34}, {0, 0, 0, 0}},
            {{256, 256, 256,  28}, {0, 0, 0, 0}}, {{256, 256, 256,  21}, {0, 0, 0, 0}},
            {{256, 256, 256,  14}, {0, 0, 0, 0}}, {{256, 256, 256,   7}, {0, 0, 0, 0}},
            {{256, 256, 256,   0}, {0, 0, 0, 0}},
    };

    // @formatter:on

    private static final int MAX_FRAMES = 16;

    private final Calendar calendar;

    private int frameCounter = 0;
    private int numClips = minObjects;
    private boolean init = false;
    private int heightMax = 0;

    Snow(final Context context, final Calendar calendar) {
        super(context, textureList, null);
        this.calendar = calendar;
    }

    private boolean get0404() {
        heightMax = (int) (height * 0.5f) + colorTransform.length + 10;
        final int currentMonth = calendar.get(Calendar.MONTH) + 1;
        final int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        return (currentMonth == 4) && (currentDay == 4);
    }


    private void createObject() {
        if (objects.objectsInUseCount() >= numClips) return;

        final int _yscale = random.nextInt(10) + 12;
        final int indexTexture = (int) (_yscale + 0.5f);
        final int texture = textureManager.getTextureIndex(AnimateTextureFrames[indexTexture]);

        final Object object = objects.obtain(textureManager.getTexture(texture), 1.0f);
        object.setObjectScale(1.0f / textureManager.dipToPixels(1));
        resetObject(object);
    }

    private void resetObject(final Object object) {
        final int _x = random.nextInt(width + height) - height;
        float _y = (height - 140) - ((heightMax - colorTransform.length) * translate_y * 0.12f /* умножить на минимальный sale*/);
        _y -= (random.nextInt(10) - 30);

        final int _yscale = random.nextInt(10) + 12;
        final int indexTexture = (int) (_yscale + 0.5f);
        final int texture = textureManager.getTextureIndex(AnimateTextureFrames[indexTexture]);

        object.setTexture(textureManager.getTexture(texture), 1.0f);
        object.resetMatrix();
        object.resetViewMatrix();
        object.setViewScale(_yscale, _yscale);

        if (indexTexture == 17) object.setScale(0.754f, 0.754f);
        object.setViewPosition(_x, _y);
        object.setAplpha((int) (_yscale * 4.5f));
        object.frameCounter = 0;
        object.animCounter = 0;
    }

    void update(final boolean createObject) {
        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (!init && createObject)
            numClips = (int) (ratio * 2 * (get0404() ? maxObjects : (minObjects + random.nextInt(maxObjects - 4))));
        init = createObject;

        if (createObject && (frameCounter == 2)) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            object.resetMatrix();
            object.setTransform(AnimatedTextureMatrix[object.animCounter]);
            if (object.frameCounter < heightMax - colorTransform.length) {
                object.setColorTransform(colorTransform[0]);
                object.setTranslate(translate_x * object.frameCounter, translate_y * object.frameCounter);
                object.animCounter = (object.animCounter + 1) % AnimatedTextureMatrix.length;
            } else {
                object.setTranslate(translate_x * (heightMax - colorTransform.length), translate_y * (heightMax - colorTransform.length));
                object.setColorTransform(colorTransform[object.frameCounter - (heightMax - colorTransform.length)]);
            }
            object.frameCounter = (object.frameCounter + 1) % heightMax;

            if (object.frameCounter == 0) {
                if (createObject) resetObject(object);
                else iterator.remove();
            }

        }

        iterator.release();
    }
}
