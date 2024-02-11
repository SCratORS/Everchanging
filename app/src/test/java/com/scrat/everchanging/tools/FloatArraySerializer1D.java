package com.scrat.everchanging.tools;

import java.io.DataOutputStream;
import java.io.IOException;

public final class FloatArraySerializer1D {

    /**
     * Will write 1D float array into output stream.<br/><br/>
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
     * @param outputStream stream to write to
     * @param array        array to write
     */
    public static void serialize1d(
            final DataOutputStream outputStream,
            final float[] array
    ) throws IOException {
        outputStream.writeInt(array.length);
        for (final float v : array) {
            outputStream.writeFloat(v);
        }
    }
}
