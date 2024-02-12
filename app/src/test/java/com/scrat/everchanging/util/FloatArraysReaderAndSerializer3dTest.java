package com.scrat.everchanging.util;

import static org.junit.Assert.assertTrue;

import com.scrat.everchanging.tools.FloatArraySerializer3D;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Tests if recreated arrays are the same as original
 */
public class FloatArraysReaderAndSerializer3dTest {

    @Test
    public void readsWritten3dArray() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final float[][][] array = new float[][][]{
                {
                        {1f, 2f, 3f, -5f, 66f},
                        {99f, -133f}
                },
                {
                        {88f, 122.3f, -3115f, 66.34343f},
                        {0.00434f, -434.56454f}
                }
        };

        FloatArraySerializer3D.serialize3d(new DataOutputStream(outputStream), array);

        recreateAndAssert(array, outputStream.toByteArray());
    }

    @Test
    public void readsWritten3dArrayOfSingleElement() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final float[][][] array = new float[][][]{{{99.224f}}};

        FloatArraySerializer3D.serialize3d(new DataOutputStream(outputStream), array);

        recreateAndAssert(array, outputStream.toByteArray());
    }

    private void recreateAndAssert(final float[][][] original, final byte[] bytes) throws IOException {
        final float[][][] recreated = FloatArraysReader3d.read3d(
                new DataInputStream(new ByteArrayInputStream(bytes))
        );

        assertTrue(Arrays.deepEquals(original, recreated));
    }
}
