import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
//import com.fasterxml.jackson;

class InputProcessor {

    /*
    * Process the input args: help, insert or a query
    * */
    void validateInput(String[] args) {

        // Check commands
        if (args[0].equals(DataBasicCommands.HELP.toString())) {
            help();
            return;
        }

        if (args[0].equals(DataBasicCommands.INSERT.toString())) {
            validateInsert(args);
            return;
        }

        // Default, make a query
        // TODO: Validate and process the query
        System.out.println("Querying...");

    }

    /*
    * Validate insert command: insert <path-to-file>
    * */
    private void validateInsert(String[] args) {

        if (args.length == 2) {
            processInsert(args[1]);

        } else {
            System.err.println("Error: You have to provide a path to JSON file");
            help();

        }

    }

    /*
    * Process inserted path to JSON file
    * */
    private void processInsert(String arg) {

        // Corner case: Provided file is empty ""
        if (arg.isEmpty()) {
            System.err.println("Error: The provided path is empty");
            help();
            return;

        }

        openFile(arg);

    }

    /*
    * Open JSON file in given path
    * For the moment this calls the method to put into an ArrayList
    * and print in console
    * TODO: Load the file to a single line from the beginning (now doing it in several steps)
    * */
    private void openFile(String fileName) {

        String jsonFile = "";

        try {
            List<String> lines = getLines(fileName);
            for (String line : lines) {
                jsonFile += line;

            }
            System.out.println("jsonFile = " + jsonFile);

        } catch (IOException io) {
            System.err.println("Error: cannot open file: " + fileName);
            io.printStackTrace();
        }

    }

    /*
    * Save lines into an ArrayList List
    * */
    private List<String> getLines(String fileName) throws IOException {

        Stream<String> linesStream = Files.lines(Paths.get(fileName));
        List<String> lines = new ArrayList<>();

        System.out.println("<!-----Read all lines as a Stream-----!>");
        linesStream.forEach(s -> lines.add(s));
        linesStream.close();
        return lines;

    }

    /*
    * Shows help
    * */
    private void help() {

        String insertCommand = makeBold(DataBasicCommands.INSERT.name() + " <path-to-file>") + "    Inserts an registry into databasic.";
        String queryCommand = makeBold("<id> <json-path>") + "         Executes a query to databasic.";
        String helpCommand = makeBold("help") + "                     Displays this help and exit";

        System.out.println("\nDatabasic");
        System.out.println("-------------------");
        System.out.println("Available commands are:");
        System.out.println(java.util.Arrays.asList(DataBasicCommands.values()) + "\n");
        System.out.println(insertCommand);
        System.out.println(queryCommand);
        System.out.println(helpCommand);
        System.out.println("-------------------");

    }

    /*
    * Format text in bold
    * */
    private String makeBold(String s) {

        String boldedString = "\u001B[1m";
        boldedString += s + "\u001B[0m";
        return boldedString;

    }

}