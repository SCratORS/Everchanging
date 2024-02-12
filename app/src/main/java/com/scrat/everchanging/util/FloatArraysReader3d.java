package com.scrat.everchanging.util;

import android.content.res.AssetManager;

import java.io.DataInputStream;
import java.io.IOException;

public final class FloatArraysReader3d {

    public static float[][][] read3d(final AssetManager assets, final String assetName) {
        try (DataInputStream dis = new DataInputStream(assets.open(assetName))) {
            return read3d(dis);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads float arrays from DataInputStream<br/><br/>
     * <p>
     *
     * @param dis stream to read from
     */
    public static float[][][] read3d(final DataInputStream dis) throws IOException {
        // Create output with size of number of expected arrays
        final float[][][] output = new float[dis.readInt()][][];

        for (int i = 0; i < output.length; i++) {
            output[i] = FloatArraysReader2d.read2d(dis);
        }

        return output;
    }
}
