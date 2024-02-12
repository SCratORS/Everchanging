package com.scrat.everchanging.tools;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public final class FloatArraySerializer2D {

    /**
     * Will serialise 2D float arrays and create the file in src/main/assets/ with the specified
     * file name.<br/><br/>
     *
     * @param array    array to serialise
     * @param fileName output file name in Assets folder. Generation is tested on GNU/Linux. I am
     *                 not sure if currectly outputs file in assets folder on Windows.
     */
    public static void serialize2d(final float[][] array, final String fileName) throws IOException {
        try (final DataOutputStream outputStream = new DataOutputStream(
                Files.newOutputStream(AssetsFilePathProvider.provideAssetsFilePath(fileName))
        )) {
            serialize2d(outputStream, array);
        }
    }

    /**
     * Will serialise 2D float arrays into output stream<br/><br/>
     * <p>
     * 2D float arrays are serialized with the following format:<br/>
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
     * @param outputStream OutputStream to write to
     * @param array        array to serialise
     */
    public static void serialize2d(
            final DataOutputStream outputStream,
            final float[][] array
    ) throws IOException {
        outputStream.writeInt(array.length);
        for (final float[] subArray : array) {
            FloatArraySerializer1D.serialize1d(outputStream, subArray);
        }
    }
}
