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

        //Vegas
        allTeams.get(0).addPlayer("Ivan Barbashev" , 1,0,0);
        allTeams.get(0).addPlayer("Mark Stone",2,0,0);
        //Washington
        allTeams.get(1).addPlayer("Alex Ovechkin",3,0,0);
        allTeams.get(1).addPlayer("Dylan Strome",4,0,0);
        //Dallas
        allTeams.get(2).addPlayer("Jason Robertson",5,0,0);
        allTeams.get(2).addPlayer("Miro Heiskanen",6,0,0);
        //NYR
        allTeams.get(3).addPlayer("Artemi Panarin",7,0,0);
        allTeams.get(3).addPlayer("Mika Zibanejad",8,0,0);
        allTeams.get(3).addPlayer("Adam Fox",9,0,0);
        //Edmonton
        allTeams.get(4).addPlayer("Leon Draisaitl",10,0,0);
        allTeams.get(4).addPlayer("Connor McDavid",11,0,0);
        allTeams.get(4).addPlayer("Ryan Nugent-Hopkins",12,0,0);
        allTeams.get(4).addPlayer("Evan Bouchard",13,0,0);
        allTeams.get(4).addPlayer("Mattias Ekholm",14,0,0);
        //Buffalo
        allTeams.get(5).addPlayer("Tage Thompson",15,0,0);
        allTeams.get(5).addPlayer("Ryan Mcleod",16,0,0);
        allTeams.get(5).addPlayer("Rasmus Dahlin",17,0,0);
        //Boston
        allTeams.get(6).addPlayer("David Pastrnak",18,0,0);
        allTeams.get(6).addPlayer("Charlie McAvoy",19,0,0);
        allTeams.get(6).addPlayer("Brad Marchand",20,0,0);
        //Philidelphia
        allTeams.get(7).addPlayer("Jamie Drysdale",21,0,0);
        allTeams.get(7).addPlayer("Matvei Michkov",22,0,0);
        //Detroit
        allTeams.get(8).addPlayer("Patrick Kane",23,0,0);
        allTeams.get(8).addPlayer("Dylan Larkin",24,0,0);
        //Utah
        allTeams.get(9).addPlayer("logan Cooley",25,0,0);
        allTeams.get(9).addPlayer("Mikhail Sergachev",26,0,0);
        //San Jose
        allTeams.get(10).addPlayer("Will Smith",27,0,0);
        allTeams.get(10).addPlayer("Cody Ceci",28,0,0);
        //Chicago
        allTeams.get(11).addPlayer("Seth Jones",29,0,0);
        allTeams.get(11).addPlayer("Connor Bedard",30,0,0);




        while(true) {

            System.out.println("Press 1 for List of Teams\nPress 2 to for most and least wins\nPress 3 to view a division\nPress 4 to sort by Points Percentage\nPress 5 to Update Stats\nPress 6 to print players\nPress 7 to print Total Team Stats\nPress 8 to Update Player Stats\nPress 9 to exit");


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
                    if (wrongDiv > 9) {
                        System.out.println("Division not accepted. Try again later.");
                        break;
                    }
                }

            }
            if (choice == 4) {
                System.out.println("Sort by Points Percentage");

                sortByPPCT(allTeams);



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
                System.out.println("Print Players");
                System.out.println();
                System.out.println("What team's players would you like to see?");
                String teamPlayers = Library.input.nextLine();
                int teamFound = searchByName(allTeams,teamPlayers);
                allTeams.get(teamFound).printPlayers();


            }
            if (choice == 7) {
                System.out.println("Team Totals");

                System.out.println(allTeams.get(0).getName() + " Goals: " + allTeams.get(0).totalGoals() + "  Assists: " + allTeams.get(0).totalAssists());
                System.out.println(allTeams.get(1).getName() + " Goals: " + allTeams.get(1).totalGoals() + "  Assists: " + allTeams.get(1).totalAssists());
                System.out.println(allTeams.get(2).getName() + " Goals: " + allTeams.get(2).totalGoals() + "  Assists: " + allTeams.get(2).totalAssists());
                System.out.println(allTeams.get(3).getName() + " Goals: " + allTeams.get(3).totalGoals() + "  Assists: " + allTeams.get(3).totalAssists());
                System.out.println(allTeams.get(4).getName() + " Goals: " + allTeams.get(4).totalGoals() + "  Assists: " + allTeams.get(4).totalAssists());
                System.out.println(allTeams.get(5).getName() + " Goals: " + allTeams.get(5).totalGoals() + "  Assists: " + allTeams.get(5).totalAssists());
                System.out.println(allTeams.get(6).getName() + " Goals: " + allTeams.get(6).totalGoals() + "  Assists: " + allTeams.get(6).totalAssists());
                System.out.println(allTeams.get(7).getName() + " Goals: " + allTeams.get(7).totalGoals() + "  Assists: " + allTeams.get(7).totalAssists());
                System.out.println(allTeams.get(8).getName() + " Goals: " + allTeams.get(8).totalGoals() + "  Assists: " + allTeams.get(8).totalAssists());
                System.out.println(allTeams.get(9).getName() + " Goals: " + allTeams.get(9).totalGoals() + "  Assists: " + allTeams.get(9).totalAssists());
                System.out.println(allTeams.get(10).getName() + " Goals: " + allTeams.get(10).totalGoals() + "  Assists: " + allTeams.get(10).totalAssists());
                System.out.println(allTeams.get(11).getName() + " Goals: " + allTeams.get(11).totalGoals() + "  Assists: " + allTeams.get(11).totalAssists());

            }
            if (choice == 8) {
                System.out.println("Updating Stats");
                System.out.println();
                System.out.println("Which Player's stats would you like to update?");
                String playerChange = Library.input.nextLine();

            }
            if (choice == 9) {
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




    public static void sortByPPCT (ArrayList<As3_Team> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getPointPct() > list.get(lowestIndex).getPointPct()) {
                    lowestIndex = j;
                }

            }

            As3_Team tempTeam = list.get(i);
            list.set(i, list.get(lowestIndex));
            list.set(lowestIndex, tempTeam);

        }


    }

}//class


