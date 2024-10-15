package net.salesianos.utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
    private static final String WORD_FINDER_ROUTE = "src\\net\\salesianos\\process\\WordFinder.java";

    public static Process initWordFinder(String text, String outputFileName, String word) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("java", WORD_FINDER_ROUTE, text, word);
        builder.redirectOutput(new File("./outputs/files/" + outputFileName));
        builder.redirectError(new File("./outputs/errors/" + outputFileName));
        return builder.start();
    }
}
