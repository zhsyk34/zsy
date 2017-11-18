package com.cat.zsy.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;

@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public abstract class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static Path createPath(Path path) throws IOException {
        path = path.normalize();
        if (!Files.exists(path)) {
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
                logger.debug("dir {} not exists,create...", parent.toAbsolutePath());
                Files.createDirectories(parent);
            }

            logger.debug("create file {}...", path.getFileName());
            Files.createFile(path);
        }

        return path;
    }

    public static Path createPath(String path) throws IOException {
        return createPath(Paths.get(path));
    }
}
