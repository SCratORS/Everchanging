package com.scrat.everchanging;

import android.content.Context;

import com.scrat.everchanging.util.ReusableIterator;

final class Fly extends TextureObject {

    interface CrystalCreatorCallback {
        void callingCrystallCreatorCallback(float[] transform, float[] translate);

        void callingCrystallEndCallback(float[] transform, float[] translate);
    }

    CrystalCreatorCallback creatorCallback;

    // @formatter:off

    private final float[][][] matrixTransform = {
            {
                    {  0.300f,   0.300f,   0.000f,   0.000f,   4.200f,  18.700f},
                    {  0.475f,   0.475f,   0.000f,   0.000f,   3.300f,  18.750f},
                    {  0.650f,   0.650f,   0.000f,   0.000f,   2.400f,  18.800f},
                    {  0.825f,   0.825f,   0.000f,   0.000f,   1.250f,  19.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  22.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  21.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.900f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.650f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,   0.100f,  20.400f},
            },
            {
                    {  0.300f,   0.300f,   0.000f,   0.000f,  18.400f, -47.300f},
                    {  0.475f,   0.475f,   0.000f,   0.000f,  18.250f, -47.200f},
                    {  0.650f,   0.650f,   0.000f,   0.000f,  18.100f, -47.100f},
                    {  0.825f,   0.825f,   0.000f,   0.000f,  18.100f, -47.050f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.500f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -44.950f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -45.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -46.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f,  18.100f, -47.000f},
            },
            {
                    {  0.300f,   0.300f,   0.000f,   0.000f, -76.700f, -43.400f},
                    {  0.475f,   0.475f,   0.000f,   0.000f, -77.700f, -45.450f},
                    {  0.650f,   0.650f,   0.000f,   0.000f, -78.700f, -47.500f},
                    {  0.825f,   0.825f,   0.000f,   0.000f, -79.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.100f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.100f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.100f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -49.550f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -50.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -80.700f, -51.600f}
            },
            {
                    {  0.300f,   0.300f,   0.000f,   0.000f, -75.000f,  34.000f},
                    {  0.475f,   0.475f,   0.000f,   0.000f, -76.000f,  31.950f},
                    {  0.650f,   0.650f,   0.000f,   0.000f, -77.000f,  29.900f},
                    {  0.825f,   0.825f,   0.000f,   0.000f, -78.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  25.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  28.300f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  25.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  28.300f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  25.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  28.300f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  25.800f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  28.300f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.850f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.400f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  27.000f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.600f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  26.200f},
                    {  1.000f,   1.000f,   0.000f,   0.000f, -79.000f,  25.800f},
            }
    };

    // @formatter:on

    private final float[][] colorTransform = {{256, 256, 256, 256}, {0, 0, 0, 0}};

    private static final int[][] textureList = {{R.drawable.image_271, R.drawable.image_273}};

    Fly(final Context context) {
        super(context, textureList, null);
    }

    public void createObject(float[] transform, float[] translate, int xscale, int index) {
        TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][0]));
        final Object object = objects.obtain(texture, 0.25f);
        object.resetMatrix();
        object.resetViewMatrix();
        object.setViewTransform(transform);
        object.setViewTranslate(translate[0], translate[1]);
        object.frameCounter = 0;
        object.animCounter = 0;
        object.index = index;
        object.setScale(xscale == 0 ? 1 : -1, 1);
    }

    public void update() {
        final ReusableIterator<Object> iterator = objects.iterator();
        iterator.acquire();

        while (iterator.hasNext()) {
            final Object object = iterator.next();
            if (object.frameCounter < matrixTransform[object.index].length) {
                creatorCallback.callingCrystallCreatorCallback(object.transformMatrix, object.ViewTranslate);
                TextureManager.Texture texture = textureManager.getTexture(textureManager.getTextureIndex(textureList[0][object.animCounter]));
                object.setTexture(texture, 0.25f);
                float scale = object.x_scalefactor;
                object.resetMatrix();
                object.setScale(scale, 1);
                object.setTransform(matrixTransform[object.index][object.frameCounter]);
                object.setColorTransform(colorTransform);
                if (object.frameCounter % 2 == 0) object.animCounter = (object.animCounter + 1) % 2;
                object.frameCounter++;
            } else {
                creatorCallback.callingCrystallEndCallback(object.transformMatrix, object.ViewTranslate);
                iterator.remove();
            }
        }

        iterator.release();
    }

    public void registerCallBack(CrystalCreatorCallback callback) {
        this.creatorCallback = callback;
    }
}
