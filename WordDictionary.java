import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordDictionary {
    public static void main(String[] args) {
        String fileName = "dictionary.txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            if (args.length == 3 && (args[0].equals("-a") || args[0].equals("-A"))) {
                add(args[1].toLowerCase(), args[2].toLowerCase(), fileWriter);
            } else if (args.length == 2 && (args[0].equals("-g") || args[0].equals("-G"))) {
                get(args[1].toLowerCase(), reader);
            } else if (args.length == 2 && (args[0].equals("-rm") || args[0].equals("-RM"))) {
                remove(args[1].toLowerCase(), fileName, reader);
            } else {
                System.out.println("Invalid arguments");
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }

    private static void remove(String word, String fileName, BufferedReader reader) {
        try {
            String line;
            StringBuilder fileData = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                if (!words[0].equals(word)) {
                    fileData.append(line + "\n");
                }
            }
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(fileData.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void get(String word, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(",");
            if (words[0].equals(word)) {
                System.out.println("Meaning of " + words[0] + " is " + words[1]);
                return;
            }
        }
        System.out.println("Word not present in dictionary");
    }

    private static void add(String word, String meaning, FileWriter fileWriter) throws IOException {
        fileWriter.write(word + "," + meaning + "\n");
        System.out.println("Successfully added " + word + " to dictionary");
    }
}
