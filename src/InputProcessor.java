/*
* https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html
* https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
* Bold text https://stackoverflow.com/a/29109958 - http://ascii-table.com/ansi-escape-sequences.php
*/
class InputProcessor {
        void validateInput(String[] args) {
                if (args.length > 0 ) {

                        // We could compare here when args[0] be help
                        //We compare if args[0] match with insert command
                        if (args[0].equals(DataBasicCommands.insert.name())){   // https://stackoverflow.com/a/9858135
                                // We check then 2nd argument exists
                                if( args.length == 2) {

                                        if ( !args[1].isEmpty() ){

                                                System.out.println("Path to JSON file args[1] = " + args[1]);

                                                // Then we check the validity of the path, this can be in a method

                                        } else {
                                                System.out.println("Error: \u001B[1mYou have to specify a correct path\u001B[0m");

                                        }

                                } else {
                                        System.out.println("Error: \u001B[1mInvalid number of arguments\u001B[0m");
                                        this.help();
                                }
                        // Else we compare if match with the query format
                        } else {
                                // this is the default error if the query isn't well formed
                                System.out.println("Error: \u001B[1m"+ args[0] + "\u001B[0m Invalid command\n");
                                this.help();
                        }

                        /* For using switch I must set up options like constants, so "insert" would be redundant here
                         and in the enum*/
                        /*
                        switch (args[0]){
                                case "insert":
                                        System.out.println("input ok");
                                        break;
                                case "help":
                                        System.out.println("help");
                                        break;
                                default:
                                        System.out.println("query");

                        }*/

                        /*Just for test purposes*/
                        /*System.out.println("args.length = " + args.length);
                        for (String arg:args) { // Foreach
                                System.out.println("arg = " + arg);
                        }*/


                } else {
                        System.out.println("Error: \u001B[1mYou have to provide an argument.\u001B[0m");
                        this.help();
                }

        }

        private void help() {
                System.out.println("\nDatabasic");
                System.out.println("-------------------");
                System.out.println("Available commands are:");
                // To print all the enum values
                System.out.println(java.util.Arrays.asList(DataBasicCommands.values())+"\n");  // https://stackoverflow.com/a/14413618
                System.out.println("\u001B[1m" + DataBasicCommands.insert.name()+ " <path-to-file>\u001B[0m     Inserts an registry into databasic.");
                System.out.println("\u001B[1m<id> <json-path>\u001B[0m          Executes a query to databasic.");
                System.out.println("\u001B[1mhelp\u001B[0m                      Displays this help and exit");
                System.out.println("-------------------");
        }


       /* void processInput(String input){
                System.out.println("Your input = " + input);
        }*/

}