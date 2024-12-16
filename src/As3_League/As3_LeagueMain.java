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
        allTeams.get(0).addPlayer("Ivan Barbashev" , 1,13,15);
        allTeams.get(0).addPlayer("Mark Stone",2,6,16);
        //Washington
        allTeams.get(1).addPlayer("Alex Ovechkin",3,15,10);
        allTeams.get(1).addPlayer("Dylan Strome",4,9,26);
        //Dallas
        allTeams.get(2).addPlayer("Jason Robertson",5,6,11);
        allTeams.get(2).addPlayer("Miro Heiskanen",6,4,10);
        //NYR
        allTeams.get(3).addPlayer("Artemi Panarin",7,15,20);
        allTeams.get(3).addPlayer("Mika Zibanejad",8,6,15);
        allTeams.get(3).addPlayer("Adam Fox",9,1,24);
        //Edmonton
        allTeams.get(4).addPlayer("Leon Draisaitl",10,20,18);
        allTeams.get(4).addPlayer("Connor McDavid",11,14,24);
        allTeams.get(4).addPlayer("Ryan Nugent-Hopkins",12,4,10);
        allTeams.get(4).addPlayer("Evan Bouchard",13,6,14);
        allTeams.get(4).addPlayer("Mattias Ekholm",14,3,8);
        //Buffalo
        allTeams.get(5).addPlayer("Tage Thompson",15,16,7);
        allTeams.get(5).addPlayer("Ryan Mcleod",16,6,8);
        allTeams.get(5).addPlayer("Rasmus Dahlin",17,6,13);
        //Boston
        allTeams.get(6).addPlayer("David Pastrnak",18,10,18);
        allTeams.get(6).addPlayer("Charlie McAvoy",19,5,6);
        allTeams.get(6).addPlayer("Brad Marchand",20,11,11);
        //Philidelphia
        allTeams.get(7).addPlayer("Jamie Drysdale",21,1,3);
        allTeams.get(7).addPlayer("Matvei Michkov",22,11,16);
        //Detroit
        allTeams.get(8).addPlayer("Patrick Kane",23,3,7);
        allTeams.get(8).addPlayer("Dylan Larkin",24,12,11);
        //Utah
        allTeams.get(9).addPlayer("logan Cooley",25,7,15);
        allTeams.get(9).addPlayer("Mikhail Sergachev",26,7,13);
        //San Jose
        allTeams.get(10).addPlayer("Will Smith",27,5,6);
        allTeams.get(10).addPlayer("Cody Ceci",28,1,6);
        //Chicago
        allTeams.get(11).addPlayer("Seth Jones",29,2,8);
        allTeams.get(11).addPlayer("Connor Bedard",30,5,16);




        while(true) {

            System.out.println("Press 1 for List of Teams\nPress 2 to for most and least wins\nPress 3 to view a division\nPress 4 to sort by Points Percentage\nPress 5 to Update Stats\nPress 6 to Save changes\nPress 7 to print players\nPress 8 to print Total Team Stats\nPress 9 to Update Player Stats\nPress 0 to exit");


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
                saveFile("Data/TeamData.csv",allTeams);
                System.out.println("Changes Saved");

            }

            if (choice == 7) {
                System.out.println("Print Players");
                System.out.println();
                System.out.println("What team's players would you like to see?");
                String findTeam = Library.input.nextLine();
                int teamFound = searchByName(allTeams,findTeam);
                allTeams.get(teamFound).printPlayers();

            }
            if (choice == 8) {
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
            if (choice == 9) {
                System.out.println("Updating Stats");
                System.out.println();
                System.out.println("Which Player's stats would you like to update?");
                String playerChange = Library.input.nextLine();
                boolean foundPlayer = false;

                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).search(playerChange) != -1) {
                        foundPlayer = true;
                        break;
                    }
                    if(i >=11) {
                        System.out.println("Can't find player. Try again later.");
                    }
                }

                if(foundPlayer) {
                    System.out.println("What stat would you like to update?");
                    String statUpdate = Library.input.nextLine();
                           if (statUpdate.contains("assists")) {
                               for (int i = 0; i < allTeams.size(); i++) {
                                   int index = allTeams.get(i).search(playerChange);
                                   if (allTeams.get(i).search(playerChange) != -1) {
                                       allTeams.get(i).updateAssists(index);
                                   }
                               }
                           }

                           if (statUpdate.contains("goals")) {
                               for (int i = 0; i < allTeams.size(); i++) {
                                   int index = allTeams.get(i).search(playerChange);
                                   if (allTeams.get(i).search(playerChange) != -1) {
                                       allTeams.get(i).updateGoals(index);
                                   }
                               }
                           }
                       }



            }
            if (choice == 0) {
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

    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave += "," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getPkpct();
                toSave +="," + tempList.get(i).getPointPct();

//The above lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile


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


