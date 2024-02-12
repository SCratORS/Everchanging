package com.scrat.everchanging.tools;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

final class FloatArraySerializer {

    /**
     * Will serialise 2D float arrays and create the file in src/main/assets/ with the specified
     * file name.<br/><br/>
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
     * @param array    array to serialise
     * @param fileName output file name in Assets folder. Generation is tested on GNU/Linux. I am
     *                 not sure if currectly outputs file in assets folder on Windows.
     */
    static void serialize2d(final float[][] array, final String fileName) throws IOException {
        try (
                final DataOutputStream outputStream = new DataOutputStream(
                        Files.newOutputStream(
                                Paths.get("src" + File.separatorChar +
                                        "main" + File.separatorChar +
                                        "assets" + File.separatorChar +
                                        fileName
                                )
                        )
                )
        ) {
            outputStream.writeInt(array.length);
            for (final float[] subArray : array) {
                serialize1d(outputStream, subArray);
            }
        }
    }

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
    private static void serialize1d(
            final DataOutputStream outputStream,
            final float[] array
    ) throws IOException {
        outputStream.writeInt(array.length);
        for (final float v : array) {
            outputStream.writeFloat(v);
        }
    }
}
