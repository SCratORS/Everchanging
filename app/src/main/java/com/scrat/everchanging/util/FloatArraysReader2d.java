package com.scrat.everchanging.util;

import android.content.res.AssetManager;

import java.io.DataInputStream;
import java.io.IOException;

public final class FloatArraysReader2d {

    public static float[][] read2d(final AssetManager assets, final String assetName) {
        try (DataInputStream dis = new DataInputStream(assets.open(assetName))) {
            return read2d(dis);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads float arrays from DataInputStream<br/><br/>
     * <p>
     * Float arrays are serialized with the following format:<br/>
     * [int][int][float][float][float][int][float][float]<br/><br/>
     * <p>
     * First integer tells how many float arrays follow.
     * Next integer tells the length of next float array, then the contents of array follows.
     * <p>
     * E.g.<br/>
     * [2][5][1f][2f][3f][4f][5f][2][1f][2f]<br/><br/>
     * <p>
     * Which corresponds to the following array:
     * <pre>
     * float[][] = {
     *      {1f, 2f, 4f, 4f, 5f},
     *      {1f, 2f}
     * }
     * </pre>
     *
     * @param dis stream to read from
     */
    static float[][] read2d(final DataInputStream dis) throws IOException {
        // Create output with size of number of expected arrays
        final float[][] output = new float[dis.readInt()][];

        for (int i = 0; i < output.length; i++) {
            output[i] = FloatArraysReader1d.read1d(dis);
        }

        return output;
    }
}
