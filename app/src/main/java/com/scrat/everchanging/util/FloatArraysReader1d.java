package com.scrat.everchanging.util;

import java.io.DataInputStream;
import java.io.IOException;

public final class FloatArraysReader1d {

    /**
     * Reads 1D float array from input stream.<br/><br/>
     * <p>
     * float arrays are serialized with the following format:<br/>
     * [int][float][float][float]<br/><br/>
     * <p>
     * First integer tells array length, followed by array contents.
     * <p>
     * E.g.<br/>
     * [5][1f][2f][3f][4f][5f]<br/><br/>
     * <p>
     * Which corresponds to the following array:
     * <pre>
     * float[] = {1f, 2f, 4f, 4f, 5f}
     * </pre>
     *
     * @param dis input stream to read from
     * @return read array
     */
    public static float[] read1d(final DataInputStream dis) throws IOException {
        // Create output with size of next array
        final float[] output = new float[dis.readInt()];

        for (int i = 0; i < output.length; i++) {
            output[i] = dis.readFloat();
        }

        return output;
    }
}
