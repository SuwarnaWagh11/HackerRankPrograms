package xmlutil.samples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLUtils {

    public static String readXMLFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
}
