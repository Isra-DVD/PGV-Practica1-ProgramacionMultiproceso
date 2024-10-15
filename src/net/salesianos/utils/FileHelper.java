package net.salesianos.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileHelper {
    public static ArrayList<String> getAllLines(String fileRoute) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileRoute, StandardCharsets.UTF_8));) {
            String currentLine = reader.readLine();

            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("No se han podido obtener las lineas del fichero " + fileRoute);
        }

        return lines;
    }

    public static int counterSearchedWord(String line, String word) {
        String[] lineWords = line.split(" ");
        int tempCounter = 0;
        for (String element : lineWords) {
            if (element.contains(word)) {
                tempCounter++;
            }
        }
        return tempCounter;
    }
}
