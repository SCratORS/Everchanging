package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

import java.util.Calendar;

public class FireFlie extends TextureObject {

    // @formatter:off
    private final float[][] matrixTransform = {
            //  scaleX,      scaleY,      rotateSkew0, rotateSkew1,translateX,  translateY
            {   1.00000f,    1.00000f,    0.00000f,    0.00000f,  -33.10000f,   26.20000f},
            {   0.95835f,    0.95835f,   -0.03611f,    0.03611f,  -39.57500f,   22.30000f},
            {   0.91670f,    0.91670f,   -0.07222f,    0.07222f,  -46.05000f,   18.40000f},
            {   0.87890f,    0.87890f,   -0.07872f,    0.07872f,  -51.72500f,   14.50000f},
            {   0.84110f,    0.84110f,   -0.08522f,    0.08522f,  -57.40000f,   10.60000f},
            {   0.80925f,    0.80925f,   -0.03220f,    0.03220f,  -62.07500f,    6.10000f},
            {   0.77740f,    0.77740f,    0.02083f,   -0.02083f,  -66.75000f,    1.60000f},
            {   0.74465f,    0.74465f,    0.04786f,   -0.04786f,  -70.07500f,   -3.35000f},
            {   0.71190f,    0.71190f,    0.07489f,   -0.07489f,  -73.40000f,   -8.30000f},
            {   0.67140f,    0.67140f,    0.13409f,   -0.13409f,  -75.62500f,  -13.10000f},
            {   0.63090f,    0.63090f,    0.19330f,   -0.19330f,  -77.85000f,  -17.90000f},
            {   0.49520f,    0.49520f,    0.34315f,   -0.34315f,  -77.30000f,  -22.45000f},
            {   0.35950f,    0.35950f,    0.49300f,   -0.49300f,  -76.75000f,  -27.00000f},
            {   0.24990f,    0.24990f,    0.52140f,   -0.52140f,  -73.90000f,  -30.17500f},
            {   0.14030f,    0.14030f,    0.54980f,   -0.54980f,  -71.05000f,  -33.35000f},
            {   0.10268f,    0.10268f,    0.53820f,   -0.53820f,  -67.97501f,  -35.25000f},
            {   0.06506f,    0.06506f,    0.52660f,   -0.52660f,  -64.90000f,  -37.15000f},
            {   0.04561f,    0.04561f,    0.51295f,   -0.51295f,  -62.20000f,  -38.27500f},
            {   0.02617f,    0.02617f,    0.49930f,   -0.49930f,  -59.50000f,  -39.40000f},
            {   0.01177f,    0.01177f,    0.50920f,   -0.50920f,  -57.62500f,  -39.97500f},
            {  -0.00262f,   -0.00262f,    0.51910f,   -0.51910f,  -55.75000f,  -40.55000f},
            {  -0.02498f,   -0.02498f,    0.52885f,   -0.52885f,  -53.60000f,  -40.97500f},
            {  -0.04733f,   -0.04733f,    0.53860f,   -0.53860f,  -51.45000f,  -41.40000f},
            {  -0.07771f,   -0.07771f,    0.54640f,   -0.54640f,  -49.02500f,  -41.52500f},
            {  -0.10810f,   -0.10810f,    0.55420f,   -0.55420f,  -46.60000f,  -41.65000f},
            {  -0.14680f,   -0.14680f,    0.55780f,   -0.55780f,  -43.87500f,  -41.37500f},
            {  -0.18550f,   -0.18550f,    0.56140f,   -0.56140f,  -41.15000f,  -41.10000f},
            {  -0.22785f,   -0.22785f,    0.55995f,   -0.55995f,  -38.27500f,  -40.32500f},
            {  -0.27020f,   -0.27020f,    0.55850f,   -0.55850f,  -35.40000f,  -39.55000f},
            {  -0.29465f,   -0.29465f,    0.56360f,   -0.56360f,  -32.47500f,  -38.05000f},
            {  -0.31910f,   -0.31910f,    0.56870f,   -0.56870f,  -29.55000f,  -36.55000f},
            {  -0.26435f,   -0.26435f,    0.61140f,   -0.61140f,  -26.40000f,  -35.22500f},
            {  -0.20960f,   -0.20960f,    0.65410f,   -0.65410f,  -23.25000f,  -33.90000f},
            {  -0.10673f,   -0.10673f,    0.68925f,   -0.68925f,  -19.67500f,  -33.02500f},
            {  -0.00386f,   -0.00386f,    0.72440f,   -0.72440f,  -16.10000f,  -32.15000f},
            {   0.16427f,    0.16427f,    0.70560f,   -0.70560f,  -12.12500f,  -32.50000f},
            {   0.33240f,    0.33240f,    0.68680f,   -0.68680f,   -8.15000f,  -32.85000f},
            {   0.47170f,    0.47170f,    0.60530f,   -0.60530f,   -4.42500f,  -34.85000f},
            {   0.61100f,    0.61100f,    0.52380f,   -0.52380f,   -0.70000f,  -36.85000f},
            {   0.72600f,    0.72600f,    0.32480f,   -0.32480f,    2.25000f,  -40.12500f},
            {   0.84100f,    0.84100f,    0.12580f,   -0.12580f,    5.20000f,  -43.40000f},
            {   0.85315f,    0.85315f,   -0.05565f,    0.05565f,    5.97500f,  -48.15000f},
            {   0.86530f,    0.86530f,   -0.23710f,    0.23710f,    6.75000f,  -52.90000f},
            {   0.88820f,    0.88820f,   -0.24740f,    0.24740f,    7.55000f,  -58.00000f},
            {   0.91110f,    0.91110f,   -0.25770f,    0.25770f,    8.35000f,  -63.10000f},
            {   0.95555f,    0.95555f,   -0.12885f,    0.12885f,   10.02500f,  -68.12500f},
            {   1.00000f,    1.00000f,    0.00000f,    0.00000f,   11.70000f,  -73.15000f},
            {   0.97835f,    0.97835f,    0.00000f,    0.00000f,   16.37500f,  -77.60001f},
            {   0.95670f,    0.95670f,    0.00000f,    0.00000f,   21.05000f,  -82.05000f},
            {   0.93595f,    0.93595f,    0.00000f,    0.00000f,   26.47500f,  -85.10001f},
            {   0.91520f,    0.91520f,    0.00000f,    0.00000f,   31.90000f,  -88.15000f},
            {   0.89530f,    0.89530f,    0.00000f,    0.00000f,   37.62500f,  -89.87500f},
            {   0.87540f,    0.87540f,    0.00000f,    0.00000f,   43.35000f,  -91.60000f},
            {   0.85640f,    0.85640f,    0.00000f,    0.00000f,   49.07500f,  -92.10000f},
            {   0.83740f,    0.83740f,    0.00000f,    0.00000f,   54.80000f,  -92.60000f},
            {   0.81920f,    0.81920f,    0.00000f,    0.00000f,   60.22500f,  -92.02499f},
            {   0.80100f,    0.80100f,    0.00000f,    0.00000f,   65.65000f,  -91.45000f},
            {   0.78370f,    0.78370f,    0.00000f,    0.00000f,   70.05000f,  -88.77499f},
            {   0.76640f,    0.76640f,    0.00000f,    0.00000f,   74.45000f,  -86.10000f},
            {   0.75000f,    0.75000f,    0.00000f,    0.00000f,   77.14999f,  -81.97500f},
            {   0.73360f,    0.73360f,    0.00000f,    0.00000f,   79.85000f,  -77.85000f},
            {   0.71800f,    0.71800f,    0.00000f,    0.00000f,   81.25000f,  -73.37500f},
            {   0.70240f,    0.70240f,    0.00000f,    0.00000f,   82.65000f,  -68.90000f},
            {   0.68770f,    0.68770f,    0.00000f,    0.00000f,   82.95000f,  -64.47500f},
            {   0.67300f,    0.67300f,    0.00000f,    0.00000f,   83.25000f,  -60.05000f},
            {   0.65915f,    0.65915f,    0.00000f,    0.00000f,   82.67500f,  -55.90000f},
            {   0.64530f,    0.64530f,    0.00000f,    0.00000f,   82.10000f,  -51.75000f},
            {   0.63235f,    0.63235f,    0.00000f,    0.00000f,   81.35000f,  -48.00000f},
            {   0.61940f,    0.61940f,    0.00000f,    0.00000f,   80.60000f,  -44.25000f},
            {   0.60730f,    0.60730f,    0.00000f,    0.00000f,   79.92500f,  -40.80000f},
            {   0.59520f,    0.59520f,    0.00000f,    0.00000f,   79.25000f,  -37.35000f},
            {   0.58395f,    0.58395f,    0.00000f,    0.00000f,   78.62500f,  -34.10000f},
            {   0.57270f,    0.57270f,    0.00000f,    0.00000f,   78.00000f,  -30.85000f},
            {   0.56230f,    0.56230f,    0.00000f,    0.00000f,   77.47500f,  -27.85000f},
            {   0.55190f,    0.55190f,    0.00000f,    0.00000f,   76.95000f,  -24.85000f},
            {   0.54240f,    0.54240f,    0.00000f,    0.00000f,   76.52499f,  -22.07500f},
            {   0.53290f,    0.53290f,    0.00000f,    0.00000f,   76.10000f,  -19.30000f},
            {   0.52425f,    0.52425f,    0.00000f,    0.00000f,   75.82500f,  -16.85000f},
            {   0.51560f,    0.51560f,    0.00000f,    0.00000f,   75.55000f,  -14.40000f},
            {   0.50780f,    0.50780f,    0.00000f,    0.00000f,   76.07500f,  -12.17500f},
            {   0.50000f,    0.50000f,    0.00000f,    0.00000f,   76.60000f,   -9.95000f},
            {   0.50780f,    0.50780f,    0.00000f,    0.00000f,   77.42500f,   -8.70000f},
            {   0.51560f,    0.51560f,    0.00000f,    0.00000f,   78.25000f,   -7.45000f},
            {   0.52425f,    0.52425f,    0.00000f,    0.00000f,   79.45000f,   -6.22500f},
            {   0.53290f,    0.53290f,    0.00000f,    0.00000f,   80.65000f,   -5.00000f},
            {   0.54240f,    0.54240f,    0.00000f,    0.00000f,   82.05000f,   -3.75000f},
            {   0.55190f,    0.55190f,    0.00000f,    0.00000f,   83.45000f,   -2.50000f},
            {   0.56230f,    0.56230f,    0.00000f,    0.00000f,   85.07500f,   -1.22500f},
            {   0.57270f,    0.57270f,    0.00000f,    0.00000f,   86.70000f,    0.05000f},
            {   0.58395f,    0.58395f,    0.00000f,    0.00000f,   88.55000f,    1.30000f},
            {   0.59520f,    0.59520f,    0.00000f,    0.00000f,   90.40000f,    2.55000f},
            {   0.60730f,    0.60730f,    0.00000f,    0.00000f,   92.50000f,    3.72500f},
            {   0.61940f,    0.61940f,    0.00000f,    0.00000f,   94.60000f,    4.90000f},
            {   0.63235f,    0.63235f,    0.00000f,    0.00000f,   96.95000f,    5.97500f},
            {   0.64530f,    0.64530f,    0.00000f,    0.00000f,   99.30000f,    7.05000f},
            {   0.65915f,    0.65915f,    0.00000f,    0.00000f,  101.92500f,    7.95000f},
            {   0.67300f,    0.67300f,    0.00000f,    0.00000f,  104.55000f,    8.85000f},
            {   0.68770f,    0.68770f,    0.00000f,    0.00000f,  107.37500f,    9.57500f},
            {   0.70240f,    0.70240f,    0.00000f,    0.00000f,  110.20000f,   10.30000f},
            {   0.71800f,    0.71800f,    0.00000f,    0.00000f,  113.27499f,   10.77500f},
            {   0.73360f,    0.73360f,    0.00000f,    0.00000f,  116.35000f,   11.25000f},
            {   0.75000f,    0.75000f,    0.00000f,    0.00000f,  119.55000f,   11.55000f},
            {   0.76640f,    0.76640f,    0.00000f,    0.00000f,  122.75000f,   11.85000f},
            {   0.78375f,    0.78375f,    0.00000f,    0.00000f,  125.97500f,   12.60000f},
            {   0.80110f,    0.80110f,    0.00000f,    0.00000f,  129.20000f,   13.35000f},
            {   0.81925f,    0.81925f,    0.00000f,    0.00000f,  132.12500f,   15.27500f},
            {   0.83740f,    0.83740f,    0.00000f,    0.00000f,  135.05000f,   17.20000f},
            {   0.85640f,    0.85640f,    0.00000f,    0.00000f,  136.52499f,   20.67500f},
            {   0.87540f,    0.87540f,    0.00000f,    0.00000f,  138.00000f,   24.15000f},
            {   0.89530f,    0.89530f,    0.00000f,    0.00000f,  137.70000f,   28.12500f},
            {   0.91520f,    0.91520f,    0.00000f,    0.00000f,  137.39999f,   32.10000f},
            {   0.93600f,    0.93600f,    0.00000f,    0.00000f,  135.54999f,   35.75000f},
            {   0.95680f,    0.95680f,    0.00000f,    0.00000f,  133.70000f,   39.40000f},
            {   0.97840f,    0.97840f,    0.00000f,    0.00000f,  130.75000f,   42.50000f},
            {   1.00000f,    1.00000f,    0.00000f,    0.00000f,  127.80000f,   45.60000f},
            {   0.98630f,    0.98630f,    0.00000f,    0.00000f,  124.92500f,   48.15000f},
            {   0.97260f,    0.97260f,    0.00000f,    0.00000f,  122.05000f,   50.70000f},
            {   0.95920f,    0.95920f,    0.00000f,    0.00000f,  119.02500f,   52.90000f},
            {   0.94580f,    0.94580f,    0.00000f,    0.00000f,  116.00000f,   55.10000f},
            {   0.93280f,    0.93280f,    0.00000f,    0.00000f,  112.87500f,   57.00000f},
            {   0.91980f,    0.91980f,    0.00000f,    0.00000f,  109.75000f,   58.90000f},
            {   0.90710f,    0.90710f,    0.00000f,    0.00000f,  106.55000f,   60.50000f},
            {   0.89440f,    0.89440f,    0.00000f,    0.00000f,  103.35000f,   62.10000f},
            {   0.88205f,    0.88205f,    0.00000f,    0.00000f,  100.12500f,   63.40000f},
            {   0.86970f,    0.86970f,    0.00000f,    0.00000f,   96.90000f,   64.70000f},
            {   0.85770f,    0.85770f,    0.00000f,    0.00000f,   93.70000f,   65.72500f},
            {   0.84570f,    0.84570f,    0.00000f,    0.00000f,   90.50000f,   66.75000f},
            {   0.83405f,    0.83405f,    0.00000f,    0.00000f,   87.35000f,   67.35000f},
            {   0.82240f,    0.82240f,    0.00000f,    0.00000f,   84.20000f,   67.95000f},
            {   0.81105f,    0.81105f,    0.00000f,    0.00000f,   81.07500f,   68.10000f},
            {   0.79970f,    0.79970f,    0.00000f,    0.00000f,   77.95000f,   68.25000f},
            {   0.78875f,    0.78875f,    0.00000f,    0.00000f,   74.89999f,   67.85000f},
            {   0.77780f,    0.77780f,    0.00000f,    0.00000f,   71.85000f,   67.45000f},
            {   0.76715f,    0.76715f,    0.00000f,    0.00000f,   69.00000f,   66.52499f},
            {   0.75650f,    0.75650f,    0.00000f,    0.00000f,   66.15000f,   65.60000f},
            {   0.74620f,    0.74620f,    0.00000f,    0.00000f,   63.57500f,   64.22500f},
            {   0.73590f,    0.73590f,    0.00000f,    0.00000f,   61.00000f,   62.85000f},
            {   0.72595f,    0.72595f,    0.00000f,    0.00000f,   58.75000f,   61.15000f},
            {   0.71600f,    0.71600f,    0.00000f,    0.00000f,   56.50000f,   59.45000f},
            {   0.70645f,    0.70645f,    0.00000f,    0.00000f,   54.57500f,   57.52500f},
            {   0.69690f,    0.69690f,    0.00000f,    0.00000f,   52.65000f,   55.60000f},
            {   0.68760f,    0.68760f,    0.00000f,    0.00000f,   51.00000f,   53.60000f},
            {   0.67830f,    0.67830f,    0.00000f,    0.00000f,   49.35000f,   51.60000f},
            {   0.66940f,    0.66940f,    0.00000f,    0.00000f,   47.75000f,   49.70000f},
            {   0.66050f,    0.66050f,    0.00000f,    0.00000f,   46.15000f,   47.80000f},
            {   0.65195f,    0.65195f,    0.00000f,    0.00000f,   44.52500f,   46.05000f},
            {   0.64340f,    0.64340f,    0.00000f,    0.00000f,   42.90000f,   44.30000f},
            {   0.63515f,    0.63515f,    0.00000f,    0.00000f,   41.25000f,   42.72500f},
            {   0.62690f,    0.62690f,    0.00000f,    0.00000f,   39.60000f,   41.15000f},
            {   0.61900f,    0.61900f,    0.00000f,    0.00000f,   37.90000f,   39.72500f},
            {   0.61110f,    0.61110f,    0.00000f,    0.00000f,   36.20000f,   38.30000f},
            {   0.60355f,    0.60355f,    0.00000f,    0.00000f,   34.50000f,   37.05000f},
            {   0.59600f,    0.59600f,    0.00000f,    0.00000f,   32.80000f,   35.80000f},
            {   0.58880f,    0.58880f,    0.00000f,    0.00000f,   31.10000f,   34.70000f},
            {   0.58160f,    0.58160f,    0.00000f,    0.00000f,   29.40000f,   33.60000f},
            {   0.57475f,    0.57475f,    0.00000f,    0.00000f,   27.72500f,   32.65000f},
            {   0.56790f,    0.56790f,    0.00000f,    0.00000f,   26.05000f,   31.70000f},
            {   0.56140f,    0.56140f,    0.00000f,    0.00000f,   24.42500f,   30.87500f},
            {   0.55490f,    0.55490f,    0.00000f,    0.00000f,   22.80000f,   30.05000f},
            {   0.54870f,    0.54870f,    0.00000f,    0.00000f,   21.20000f,   29.35000f},
            {   0.54250f,    0.54250f,    0.00000f,    0.00000f,   19.60000f,   28.65000f},
            {   0.53670f,    0.53670f,    0.00000f,    0.00000f,   18.07500f,   28.07500f},
            {   0.53090f,    0.53090f,    0.00000f,    0.00000f,   16.55000f,   27.50000f},
            {   0.52540f,    0.52540f,    0.00000f,    0.00000f,   15.07500f,   27.02500f},
            {   0.51990f,    0.51990f,    0.00000f,    0.00000f,   13.60000f,   26.55000f},
            {   0.51475f,    0.51475f,    0.00000f,    0.00000f,   12.22500f,   26.17500f},
            {   0.50960f,    0.50960f,    0.00000f,    0.00000f,   10.85000f,   25.80000f},
            {   0.50480f,    0.50480f,    0.00000f,    0.00000f,    9.52500f,   25.55000f},
            {   0.50000f,    0.50000f,    0.00000f,    0.00000f,    8.20000f,   25.30000f},
    };

    private final float[][][] colorTransform = {
            //redMultiTerm, greenMultiTerm, blueMultiTerm, alphaMultiTerm
            {{256, 256, 256,   0}, {0, 0, 0, 0}}, {{256, 256, 256,  10}, {0, 0, 0, 0}},
            {{256, 256, 256,  21}, {0, 0, 0, 0}}, {{256, 256, 256,  30}, {0, 0, 0, 0}},
            {{256, 256, 256,  40}, {0, 0, 0, 0}}, {{256, 256, 256,  49}, {0, 0, 0, 0}},
            {{256, 256, 256,  58}, {0, 0, 0, 0}}, {{256, 256, 256,  66}, {0, 0, 0, 0}},
            {{256, 256, 256,  74}, {0, 0, 0, 0}}, {{256, 256, 256,  82}, {0, 0, 0, 0}},
            {{256, 256, 256,  89}, {0, 0, 0, 0}}, {{256, 256, 256,  96}, {0, 0, 0, 0}},
            {{256, 256, 256, 102}, {0, 0, 0, 0}}, {{256, 256, 256, 108}, {0, 0, 0, 0}},
            {{256, 256, 256, 113}, {0, 0, 0, 0}}, {{256, 256, 256, 118}, {0, 0, 0, 0}},
            {{256, 256, 256, 123}, {0, 0, 0, 0}}, {{256, 256, 256, 127}, {0, 0, 0, 0}},
            {{256, 256, 256, 131}, {0, 0, 0, 0}}, {{256, 256, 256, 134}, {0, 0, 0, 0}},
            {{256, 256, 256, 136}, {0, 0, 0, 0}}, {{256, 256, 256, 138}, {0, 0, 0, 0}},
            {{256, 256, 256, 141}, {0, 0, 0, 0}}, {{256, 256, 256, 144}, {0, 0, 0, 0}},
            {{256, 256, 256, 147}, {0, 0, 0, 0}}, {{256, 256, 256, 150}, {0, 0, 0, 0}},
            {{256, 256, 256, 154}, {0, 0, 0, 0}}, {{256, 256, 256, 158}, {0, 0, 0, 0}},
            {{256, 256, 256, 161}, {0, 0, 0, 0}}, {{256, 256, 256, 165}, {0, 0, 0, 0}},
            {{256, 256, 256, 169}, {0, 0, 0, 0}}, {{256, 256, 256, 174}, {0, 0, 0, 0}},
            {{256, 256, 256, 178}, {0, 0, 0, 0}}, {{256, 256, 256, 182}, {0, 0, 0, 0}},
            {{256, 256, 256, 187}, {0, 0, 0, 0}}, {{256, 256, 256, 192}, {0, 0, 0, 0}},
            {{256, 256, 256, 197}, {0, 0, 0, 0}}, {{256, 256, 256, 202}, {0, 0, 0, 0}},
            {{256, 256, 256, 208}, {0, 0, 0, 0}}, {{256, 256, 256, 214}, {0, 0, 0, 0}},
            {{256, 256, 256, 219}, {0, 0, 0, 0}}, {{256, 256, 256, 224}, {0, 0, 0, 0}},
            {{256, 256, 256, 230}, {0, 0, 0, 0}}, {{256, 256, 256, 236}, {0, 0, 0, 0}},
            {{256, 256, 256, 243}, {0, 0, 0, 0}}, {{256, 256, 256, 250}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 256}, {0, 0, 0, 0}},
            {{256, 256, 256, 256}, {0, 0, 0, 0}}, {{256, 256, 256, 249}, {0, 0, 0, 0}},
            {{256, 256, 256, 242}, {0, 0, 0, 0}}, {{256, 256, 256, 235}, {0, 0, 0, 0}},
            {{256, 256, 256, 228}, {0, 0, 0, 0}}, {{256, 256, 256, 222}, {0, 0, 0, 0}},
            {{256, 256, 256, 215}, {0, 0, 0, 0}}, {{256, 256, 256, 208}, {0, 0, 0, 0}},
            {{256, 256, 256, 202}, {0, 0, 0, 0}}, {{256, 256, 256, 196}, {0, 0, 0, 0}},
            {{256, 256, 256, 189}, {0, 0, 0, 0}}, {{256, 256, 256, 183}, {0, 0, 0, 0}},
            {{256, 256, 256, 177}, {0, 0, 0, 0}}, {{256, 256, 256, 171}, {0, 0, 0, 0}},
            {{256, 256, 256, 165}, {0, 0, 0, 0}}, {{256, 256, 256, 159}, {0, 0, 0, 0}},
            {{256, 256, 256, 153}, {0, 0, 0, 0}}, {{256, 256, 256, 148}, {0, 0, 0, 0}},
            {{256, 256, 256, 142}, {0, 0, 0, 0}}, {{256, 256, 256, 136}, {0, 0, 0, 0}},
            {{256, 256, 256, 131}, {0, 0, 0, 0}}, {{256, 256, 256, 126}, {0, 0, 0, 0}},
            {{256, 256, 256, 121}, {0, 0, 0, 0}}, {{256, 256, 256, 116}, {0, 0, 0, 0}},
            {{256, 256, 256, 111}, {0, 0, 0, 0}}, {{256, 256, 256, 106}, {0, 0, 0, 0}},
            {{256, 256, 256, 101}, {0, 0, 0, 0}}, {{256, 256, 256,  96}, {0, 0, 0, 0}},
            {{256, 256, 256,  91}, {0, 0, 0, 0}}, {{256, 256, 256,  86}, {0, 0, 0, 0}},
            {{256, 256, 256,  82}, {0, 0, 0, 0}}, {{256, 256, 256,  78}, {0, 0, 0, 0}},
            {{256, 256, 256,  73}, {0, 0, 0, 0}}, {{256, 256, 256,  69}, {0, 0, 0, 0}},
            {{256, 256, 256,  65}, {0, 0, 0, 0}}, {{256, 256, 256,  61}, {0, 0, 0, 0}},
            {{256, 256, 256,  57}, {0, 0, 0, 0}}, {{256, 256, 256,  53}, {0, 0, 0, 0}},
            {{256, 256, 256,  49}, {0, 0, 0, 0}}, {{256, 256, 256,  46}, {0, 0, 0, 0}},
            {{256, 256, 256,  42}, {0, 0, 0, 0}}, {{256, 256, 256,  38}, {0, 0, 0, 0}},
            {{256, 256, 256,  35}, {0, 0, 0, 0}}, {{256, 256, 256,  32}, {0, 0, 0, 0}},
            {{256, 256, 256,  28}, {0, 0, 0, 0}}, {{256, 256, 256,  25}, {0, 0, 0, 0}},
            {{256, 256, 256,  22}, {0, 0, 0, 0}}, {{256, 256, 256,  19}, {0, 0, 0, 0}},
            {{256, 256, 256,  16}, {0, 0, 0, 0}}, {{256, 256, 256,  13}, {0, 0, 0, 0}},
            {{256, 256, 256,  10}, {0, 0, 0, 0}}, {{256, 256, 256,   8}, {0, 0, 0, 0}},
            {{256, 256, 256,   5}, {0, 0, 0, 0}}, {{256, 256, 256,   2}, {0, 0, 0, 0}},
            {{256, 256, 256,   0}, {0, 0, 0, 0}},
    };
    // @formatter:on

    private static final int MAX_FRAMES = 12;

    private int numClips = minObjects;
    private int frameCounter = 0;
    private boolean init = false;

    private final Calendar calendar;

    private static final int[][] textureList = {{R.drawable.image_168, R.drawable.image_170}};
    private static final float[][] pivotList = {{7.5f, 7.5f}, {7.5f, 7.5f}};

    FireFlie(final Context context, final Calendar calendar) {
        super(context, textureList, pivotList);
        this.calendar = calendar;
    }

    void createObject() {
        if (objects.objectsInUseCount() >= numClips) return;

        final TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][random.nextInt(2)]));
        final Object object = objects.obtain(texture, 1.0f);
        texture.width = 15.0f;
        texture.height = 15.0f;

        final float _x = random.nextInt(width);
        final float _y = random.nextInt(100) + 150;
        final int _rotation = random.nextInt(20) - 10;
        int _yscale = random.nextInt(90) + 10;
        int _xscale = _yscale;
        if (random.nextInt(2) == 0) _xscale *= -1;
        if (random.nextInt(2) == 0) _yscale *= -1;

        object.setViewScale(_xscale, _yscale);
        object.setViewRotate(_rotation);
        object.setViewPosition(_x, height - 320 + _y);
        object.setColorTransform(colorTransform[0]);
        object.frameCounter = 0;
    }

    void resetObject(final Object object) {
        object.frameCounter = 0;
        final int textureIndex = textureManager.getTextureIndex(textureList[0][random.nextInt(2)]);
        object.setTexture(textureManager.getTexture(textureIndex), 1.0f);

        final float x = random.nextInt(width);
        final float y = random.nextInt(100) + 150;
        final int r = random.nextInt(20) - 10;
        int sy = random.nextInt(90) + 10;
        int sx = sy;
        if (random.nextInt(2) == 0) sx *= -1;
        if (random.nextInt(2) == 0) sy *= -1;

        object.resetViewMatrix();
        object.resetMatrix();
        object.setColorTransform(colorTransform[0]);
        object.setViewScale(sx, sy);
        object.setViewRotate(r);
        object.setViewPosition(x, height - 320 + y);
        object.frameCounter = 0;
    }

    private boolean get2501() {
        final int currentMonth = calendar.get(Calendar.MONTH) + 1;
        final int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        return (currentMonth == 1) && (currentDay == 25);
    }

    public void update(final boolean createObject) {
        frameCounter = (frameCounter + 1) % MAX_FRAMES;
        if (!init && createObject)
            numClips = get2501() ? maxObjects : (minObjects + random.nextInt(maxObjects - 4));
        init = createObject;
        if (createObject && frameCounter == 2) createObject();

        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < matrixTransform.length) {
                object.resetMatrix();
                object.setColorTransform(colorTransform[object.frameCounter]);
                object.setTransform(matrixTransform[object.frameCounter]);
                object.frameCounter++;
            } else {
                if (createObject) resetObject(object);
                else iterator.remove();
            }
        }

        iterator.release();
    }
}
