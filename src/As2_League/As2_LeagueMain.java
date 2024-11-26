package As2_League;


import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
public class As2_LeagueMain {

    public static void run(){

        ArrayList<As2_Team> allTeams = new ArrayList<>();

        loadFile("Data/TeamData.csv",allTeams);

        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println(allTeams);
        }

    }//run

    public static void loadFile(String filename, ArrayList<As2_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                //list.add( new As2_Team(  tempArray[0],tempArray[1], String.parseString(tempArray[2]),Boolean.parseBoolean(tempArray[3]), Double.parseDouble(tempArray[4])   ));
                list.add(new As2_Team(tempArray[0],tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]),Double.parseDouble(tempArray[5]) ));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile
    
}//class
