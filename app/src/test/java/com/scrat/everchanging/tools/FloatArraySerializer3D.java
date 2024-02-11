package com.scrat.everchanging.tools;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public final class FloatArraySerializer3D {

    /**
     * Will serialise 2D float arrays and create the file in src/main/assets/ with the specified
     * file name.<br/><br/>
     *
     * @param array    array to serialise
     * @param fileName output file name in Assets folder. Generation is tested on GNU/Linux. I am
     *                 not sure if correctly outputs file in assets folder on Windows.
     */
    public static void serialize3d(final float[][][] array, final String fileName) throws IOException {
        try (final DataOutputStream outputStream = new DataOutputStream(
                Files.newOutputStream(AssetsFilePathProvider.provideAssetsFilePath(fileName))
        )) {
            serialize3d(outputStream, array);
        }
    }

    /**
     * Will serialise 3D float arrays into output stream<br/><br/>
     *
     * @param outputStream OutputStream to write to
     * @param array        array to serialise
     */
    public static void serialize3d(
            final DataOutputStream outputStream,
            final float[][][] array
    ) throws IOException {
        outputStream.writeInt(array.length);
        for (final float[][] subArray : array) {
            FloatArraySerializer2D.serialize2d(outputStream, subArray);
        }
    }
}
