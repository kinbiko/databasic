package databasic;

import java.util.Scanner;

public class Querier {
    Scanner scanner = new Scanner( System.in );
    System.out.print( "What would you like to search for in the database? Enter ID or a keyword: " );
    String queryInput = scanner.nextLine();
    System.out.println("The query " + queryInput + "retrieves the following");


}
