import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import net.salesianos.utils.ProcessLauncher;
import net.salesianos.utils.FileHelper;

public class App {
    public static void main(String[] args) throws Exception {

        final String ROUTE = "./files/UD1 - Actividades 1 - Contenido.txt";
        final Scanner SC = new Scanner(System.in);
        int wordsSum = 0;
        String saveLine = "";

        System.out.println("Introduce la palabra a buscar");
        String word = SC.nextLine();

        ArrayList<String> lines = FileHelper.getAllLines(ROUTE);

        ArrayList<Process> finderWordSubProcess = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            Process subProcess = ProcessLauncher.initWordFinder(lines.get(i),
                    "line" + (i + 1) + ".txt", word);
            finderWordSubProcess.add(subProcess);
        }

        for (Process process : finderWordSubProcess) {
            process.waitFor();
        }

        for (int i = 0; i < lines.size(); i++) {
            File file = new File("./outputs/files/line" + (i + 1) + ".txt");
            File fileError = new File("./outputs/errors/line" + i + ".txt");
            wordsSum += FileHelper.counterSearchedWord(lines.get(i), word);
            if (FileHelper.isTheWord(lines.get(i), word)) {
                saveLine += "linea " + (i + 1) + ", ";
            }

            if (file.exists() && fileError.exists()) {
                file.delete();
                fileError.delete();
            }
        }

        System.out.println(
                "Hay un total de " + wordsSum + " palabras \"" + word + "\", estas estan en: " + saveLine + ".");

        SC.close();
    }

}
