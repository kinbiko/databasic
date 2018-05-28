package databasic;

import java.io.File;

public class Main{


    public static void main(String[] args){
        System.out.println("Welcome to databasic!");
        Cli cli = new Cli();
        Formatter formatter = new Formatter();
        Inserter inserter = new Inserter();
        //accept file name or directory name through command line args
        //String insertFileName =args[0];
        //String insertFilePath = "/Users/unityspace/Documents/Java/databasic/json_example.json";
        String insertFilePath = "../json_example.json";
        Querier querier = new Querier();

        if (args[0].equals("stats")){
            cli.stats();
        }
        else if (args[0].equals("query")){
            cli.stats();
        }

        formatter.formatQuery(new Object());
        formatter.formatInsert(new Id());

        inserter.insert(new File(insertFilePath));

        querier.findString(new Id(), new JsonPath());
    }
}
