package As3_League;


import Examples.Library;

import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
public class As3_LeagueMain {

    public static void run(){

        ArrayList<As3_Team> allTeams = new ArrayList<>();

        loadFile("Data/TeamData.csv",allTeams);


        while(true) {

            System.out.println("Press 1 for List of Teams\nPress 2 to for most and least wins\nPress 3 to view a division\nPress 4 to sort by Points Percentage\nPress 5 to Update Stats\nPress 6 to exit");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.println("List of Teams and Stats:");
                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.get(i).list();

                }

            }
            if (choice == 2) {
                System.out.println("Highest and Lowest Wins");
                System.out.println();
                int highestIndex =0;
                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getWins() > allTeams.get(highestIndex).getWins()){
                        highestIndex =i;
                    }
                }
                System.out.println("The team with the most wins this year is: " + allTeams.get(highestIndex).getName() + " with a total of " + allTeams.get(highestIndex).getWins() + " wins");
                int lowestIndex =0;
                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getWins() < allTeams.get(lowestIndex).getWins()){
                        lowestIndex = i;
                    }
                }
                System.out.println("The team with the least wins this year is: " + allTeams.get(lowestIndex).getName() + " with a total of " + allTeams.get(lowestIndex).getWins() + " wins");

            }
            if (choice == 3) {
                System.out.println("Divisions");
                System.out.println();
                System.out.println("Which division would you like to see? \nChoose from: Atlantic, Metropolitan, Central, Pacific");

                String chooseDiv = Library.input.nextLine();
                System.out.println();
                System.out.println(chooseDiv + ":");
                int wrongDiv = 0;

                for (int i = 0; i < allTeams.size(); i++) {
                    if(chooseDiv.equalsIgnoreCase(allTeams.get(i).getDivision())){
                        allTeams.get(i).divisionSort();
                    }
                    else{
                        wrongDiv += 1;
                    }
                    if(wrongDiv >24){
                        System.out.println("Division not accepted. Try again later.");
                        break;
                    }
                }

            }
            if (choice == 4) {
                System.out.println("Sort by Points Percentage");

            }
            if (choice == 5) {
                System.out.println("N/A");
            }
            if (choice == 6) {
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");






    }//run

    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                //list.add( new As2_Team(  tempArray[0],tempArray[1], String.parseString(tempArray[2]),Boolean.parseBoolean(tempArray[3]), Double.parseDouble(tempArray[4])   ));
                list.add(new As3_Team(tempArray[0],tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]),Double.parseDouble(tempArray[5]) ));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

//    public static void selectionSortDoubleArr(ArrayList arr ) {
//        for (int i = 0; i < arr.size() - 1; i++) {
//            int lowestIndex = i;
//            for (int j = i + 1; j < arr.size(); j++) {
//                if (arr.get(j).get < arr.get(lowestIndex) {
//                    lowestIndex = j;
//                }
//            }
////swaps the lowest to the beginning
//            double temp = arr[i];
//            arr[i] = arr[lowestIndex];
//            arr[lowestIndex] = temp;
//
//        }
//    }
    
}//class
