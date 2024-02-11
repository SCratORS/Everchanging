package com.scrat.everchanging.tools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

final class AssetsFilePathProvider {

    static Path provideAssetsFilePath(final String fileName) {
        return Paths.get("src" + File.separatorChar +
                "main" + File.separatorChar +
                "assets" + File.separatorChar +
                fileName);
    }
}
