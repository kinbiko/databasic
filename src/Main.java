import java.util.Scanner;
/*
* https://stackoverflow.com/questions/2066307/how-do-you-input-commandline-argument-in-intellij-idea
* */
public class Main{

    public static void main(String[] args){

        // To keep the user input (insert o query statements)
        //String userInput;
        // We instanciate a new Scanner
        //Scanner scanner = new Scanner(System.in);
        /*System.out.println("Welcome to databasic\n====================");
        System.out.println("Type a command:");
        userInput = scanner.nextLine();*/

        // Check if input isn't empty
        InputProcessor inputProcessor = new InputProcessor();
        inputProcessor.validateInput(args);







        // Insert. 'databasic insert <path-to-file>'

        // Query. Ex: 'databasic <id> <json-path>'

    }

}