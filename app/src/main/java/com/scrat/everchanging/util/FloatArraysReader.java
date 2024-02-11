package com.scrat.everchanging.util;

import android.content.res.AssetManager;

import java.io.DataInputStream;
import java.io.IOException;

public final class FloatArraysReader {

    private final AssetManager assets;

    public FloatArraysReader(final AssetManager assets) {
        this.assets = assets;
    }

    public float[][][] read(final String... assetNames) {
        final float[][][] output = new float[assetNames.length][][];
        for (int i = 0; i < assetNames.length; i++) {
            output[i] = read(assetNames[i]);
        }

        return output;
    }

    public float[][] read(final String assetName) {
        try (DataInputStream dis = new DataInputStream(assets.open(assetName))) {
            return readArrays(dis);
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
    private float[][] readArrays(final DataInputStream dis) throws IOException {
        // Create output with size of number of expected arrays
        final float[][] output = new float[dis.readInt()][];

        for (int i = 0; i < output.length; i++) {
            output[i] = readNextArray(dis);
        }

        return output;
    }

    private float[] readNextArray(final DataInputStream dis) throws IOException {
        // Create output with size of next array
        final float[] output = new float[dis.readInt()];

        for (int i = 0; i < output.length; i++) {
            output[i] = dis.readFloat();
        }

        return output;
    }
}
