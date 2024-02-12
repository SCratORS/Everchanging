package com.scrat.everchanging.util;

import static org.junit.Assert.assertArrayEquals;

import com.scrat.everchanging.tools.FloatArraySerializer1D;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Tests if recreated arrays are the same as original
 */
public class FloatArraysReaderAndSerializer1dTest {

    @Test
    public void readsWritten1dArray() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final float[] array = new float[]{34f, -23.43435f, 0f, 123f};

        FloatArraySerializer1D.serialize1d(new DataOutputStream(outputStream), array);

        recreateAndAssert(array, outputStream.toByteArray());
    }

    @Test
    public void readsWritten1dArrayOfSingleElement() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final float[] array = new float[]{99.224f};

        FloatArraySerializer1D.serialize1d(new DataOutputStream(outputStream), array);

        recreateAndAssert(array, outputStream.toByteArray());
    }

    private void recreateAndAssert(final float[] original, final byte[] bytes) throws IOException {
        final float[] recreated = FloatArraysReader1d.read1d(
                new DataInputStream(new ByteArrayInputStream(bytes))
        );

        assertArrayEquals(original, recreated, 0.0001f);
    }
}
