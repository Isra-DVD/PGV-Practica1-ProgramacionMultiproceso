package net.salesianos.process;

public class WordFinder {
    public static void main(String[] args) {
        String line = args[0];
        String word = args[1];
        Boolean haveTheWord = false;

        String[] lineWords = line.split(" ");
        for (String element : lineWords) {
            if (element.contains(word)) {
                System.out.println(line.replace(word, "[" + word + "]"));
                haveTheWord = true;
                break;
            }
        }
        if (!haveTheWord) {
            System.out.println("No se encuentra la palabra en esta linea");
        }

    }
}