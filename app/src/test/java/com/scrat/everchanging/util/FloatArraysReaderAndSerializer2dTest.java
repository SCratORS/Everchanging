package com.scrat.everchanging.util;

import static org.junit.Assert.assertTrue;

import com.scrat.everchanging.tools.FloatArraySerializer2D;

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
public class FloatArraysReaderAndSerializer2dTest {

    @Test
    public void readsWritten2dArray() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final float[][] array = new float[][]{
                {1f, 2f, 3f, -5f, 66f},
                {99f, -133f}
        };

        FloatArraySerializer2D.serialize2d(new DataOutputStream(outputStream), array);

        recreateAndAssert(array, outputStream.toByteArray());
    }

    @Test
    public void readsWritten2dArrayOfSingleElement() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final float[][] array = new float[][]{{99.224f}};

        FloatArraySerializer2D.serialize2d(new DataOutputStream(outputStream), array);

        recreateAndAssert(array, outputStream.toByteArray());
    }

    private void recreateAndAssert(final float[][] original, final byte[] bytes) throws IOException {
        final float[][] recreated = FloatArraysReader2d.read2d(
                new DataInputStream(new ByteArrayInputStream(bytes))
        );

        assertTrue(Arrays.deepEquals(original, recreated));
    }
}
