package com.scrat.everchanging.tools;

import org.junit.Test;

import java.io.IOException;

/**
 * Added as an example of usage.
 * <p>
 * Not an actual test, but is here so that we can easily run it from IDE.<br/><br/>
 * <p>
 * This will generate MatrixTransform for Crystal as binary.<br/>
 * Any 2D float array can be serialised like this.
 */
public class CrystalMatrixTransformSerializer {

    // @formatter:off
    private final float[][] matrixTransform = {
            { 0.75000f,  0.75240f,  0.00000f,  0.00000f,  7.50000f,  0.00000f},
            { 0.76955f,  0.77175f,  0.00000f,  0.00000f,  8.67500f,  0.00000f},
            { 0.78910f,  0.79110f,  0.00000f,  0.00000f,  9.85000f,  0.00000f},
            { 0.81645f,  0.81815f,  0.00000f,  0.00000f, 11.50000f,  0.00000f},
            { 0.84380f,  0.84520f,  0.00000f,  0.00000f, 13.15000f,  0.00000f},
            { 0.87895f,  0.88005f,  0.00000f,  0.00000f, 15.25000f,  0.00000f},
            { 0.91410f,  0.91490f,  0.00000f,  0.00000f, 17.35000f,  0.00000f},
            { 0.95705f,  0.95745f,  0.00000f,  0.00000f, 19.92500f,  0.00000f},
            { 1.00000f,  1.00000f,  0.00000f,  0.00000f, 22.50000f,  0.00000f},
            { 0.96780f,  0.96780f,  0.00000f,  0.00000f, 25.72500f,  0.00000f},
            { 0.93560f,  0.93560f,  0.00000f,  0.00000f, 28.95000f,  0.00000f},
            { 0.90560f,  0.90560f,  0.00000f,  0.00000f, 31.95000f,  0.00000f},
            { 0.87560f,  0.87560f,  0.00000f,  0.00000f, 34.95000f,  0.00000f},
            { 0.84780f,  0.84780f,  0.00000f,  0.00000f, 37.72500f,  0.00000f},
            { 0.82000f,  0.82000f,  0.00000f,  0.00000f, 40.50000f,  0.00000f},
            { 0.79445f,  0.79445f,  0.00000f,  0.00000f, 43.05000f,  0.00000f},
            { 0.76890f,  0.76890f,  0.00000f,  0.00000f, 45.60000f,  0.00000f},
            { 0.74555f,  0.74555f,  0.00000f,  0.00000f, 47.95000f,  0.00000f},
            { 0.72220f,  0.72220f,  0.00000f,  0.00000f, 50.30000f,  0.00000f},
            { 0.70110f,  0.70110f,  0.00000f,  0.00000f, 52.40000f,  0.00000f},
            { 0.68000f,  0.68000f,  0.00000f,  0.00000f, 54.50000f,  0.00000f},
            { 0.66110f,  0.66110f,  0.00000f,  0.00000f, 56.40000f,  0.00000f},
            { 0.64220f,  0.64220f,  0.00000f,  0.00000f, 58.30000f,  0.00000f},
            { 0.62555f,  0.62555f,  0.00000f,  0.00000f, 59.95000f,  0.00000f},
            { 0.60890f,  0.60890f,  0.00000f,  0.00000f, 61.60000f,  0.00000f},
            { 0.59445f,  0.59445f,  0.00000f,  0.00000f, 63.05000f,  0.00000f},
            { 0.58000f,  0.58000f,  0.00000f,  0.00000f, 64.50000f,  0.00000f},
            { 0.56780f,  0.56780f,  0.00000f,  0.00000f, 65.72500f,  0.00000f},
            { 0.55560f,  0.55560f,  0.00000f,  0.00000f, 66.95000f,  0.00000f},
            { 0.54560f,  0.54560f,  0.00000f,  0.00000f, 67.95000f,  0.00000f},
            { 0.53560f,  0.53560f,  0.00000f,  0.00000f, 68.95000f,  0.00000f},
            { 0.52780f,  0.52780f,  0.00000f,  0.00000f, 69.72500f,  0.00000f},
            { 0.52000f,  0.52000f,  0.00000f,  0.00000f, 70.50000f,  0.00000f},
            { 0.51445f,  0.51445f,  0.00000f,  0.00000f, 71.05000f,  0.00000f},
            { 0.50890f,  0.50890f,  0.00000f,  0.00000f, 71.60000f,  0.00000f},
            { 0.50555f,  0.50555f,  0.00000f,  0.00000f, 71.95000f,  0.00000f},
            { 0.50220f,  0.50220f,  0.00000f,  0.00000f, 72.30000f,  0.00000f},
            { 0.50110f,  0.50110f,  0.00000f,  0.00000f, 72.40000f,  0.00000f},
            { 0.50000f,  0.50000f,  0.00000f,  0.00000f, 72.50000f,  0.00000f},
    };
    // @formatter:on

    @Test
    public void crystalMatrixTransform() throws IOException {
        FloatArraySerializer2D.serialize2d(matrixTransform, "CrystalMatrixTransform");
    }
}