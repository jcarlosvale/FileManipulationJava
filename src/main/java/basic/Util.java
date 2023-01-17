package basic;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Util {

    public static Path getPathFromResourcesFolder(final String filename) throws URISyntaxException {
        URI fileURI =
                Objects.requireNonNull(
                        Util.class
                                .getClassLoader()
                                .getResource(filename)).toURI();
        return Paths.get(fileURI);
    }
}
