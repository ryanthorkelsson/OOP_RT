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
                for (As3_Team allTeam : allTeams) {
                    allTeam.list();

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

                for (As3_Team allTeam : allTeams) {
                    if (chooseDiv.equalsIgnoreCase(allTeam.getDivision())) {
                        allTeam.divisionSort();
                    } else {
                        wrongDiv += 1;
                    }
                    if (wrongDiv > 24) {
                        System.out.println("Division not accepted. Try again later.");
                        break;
                    }
                }

            }
            if (choice == 4) {
                System.out.println("Sort by Points Percentage");

            }
            if (choice == 5) {
                System.out.println("Enter Game Info");
                System.out.println();
                System.out.println("Which teams Played in the game?");
                System.out.println("Team 1:");
                String t1 = Library.input.nextLine();
                System.out.println("Team 2:");
                String t2 = Library.input.nextLine();

                System.out.println("Which team won?");
                String winner = Library.input.nextLine();

                if(t1.equalsIgnoreCase(winner)) {
                    int teamWin = searchByName(allTeams, t1);
                    int teamLose = searchByName(allTeams,t2);
                    allTeams.get(teamWin).won();

                    System.out.println("For the winning team:");
                    System.out.println("What is their new point Percentage?");
                    double newPpct = Library.input.nextDouble();
                    Library.input.nextLine();
                    System.out.println("What is their new Penalty Kill Percentage?");
                    double newpkPct = Library.input.nextDouble();
                    Library.input.nextLine();
                    allTeams.get(teamWin).setPkpct(newpkPct);
                    allTeams.get(teamWin).setPointPct(newPpct);

                    System.out.println("For the losing team:");
                    System.out.println("What is their new point Percentage?");
                    double newPpct2 = Library.input.nextDouble();
                    Library.input.nextLine();
                    System.out.println("What is their new Penalty Kill Percentage?");
                    double newpkPct2 = Library.input.nextDouble();
                    Library.input.nextLine();
                    allTeams.get(teamLose).setPkpct(newpkPct2);
                    allTeams.get(teamLose).setPointPct(newPpct2);

                }
                if(t2.equalsIgnoreCase(winner)) {
                    int teamWin = searchByName(allTeams, t2);
                    int teamLose = searchByName(allTeams,t2);
                    allTeams.get(teamWin).won();

                    System.out.println("For the winning team:");
                    System.out.println("What is their new point Percentage?");
                    double newPpct = Library.input.nextDouble();
                    Library.input.nextLine();
                    System.out.println("What is their new Penalty Kill Percentage?");
                    double newpkPct = Library.input.nextDouble();
                    Library.input.nextLine();
                    allTeams.get(teamWin).setPkpct(newpkPct);
                    allTeams.get(teamWin).setPointPct(newPpct);

                    System.out.println("For the losing team:");
                    System.out.println("What is their new point Percentage?");
                    double newPpct2 = Library.input.nextDouble();
                    Library.input.nextLine();
                    System.out.println("What is their new Penalty Kill Percentage?");
                    double newpkPct2 = Library.input.nextDouble();
                    Library.input.nextLine();
                    allTeams.get(teamLose).setPkpct(newpkPct2);
                    allTeams.get(teamLose).setPointPct(newPpct2);
                }

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

    public static int searchByName(ArrayList<As3_Team> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }//searchByName


    /*

    if(list.get(j).getVariable() < list.get(lowestIndex).getVariable){
        lowestIndex = j

    //Only swap the objects
        Team tempTeam = list.get(j);
        list.set(j, list.get(lowestIndex);
        list.set(lowestIndex,tempTeam)

     */


}//class
