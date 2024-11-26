package As1_crops;


import Examples.Ex3_Client;
import Examples.Library;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){

        double totalRevenue = 0;

        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(new As1_Crop("Corn",202,"Bushel", 5.96));
        allCrops.add(new As1_Crop("Canola",32.7,"Bushel",14.61));
        allCrops.add(new As1_Crop("Potato",400,"Kilogram",4.13));
        allCrops.add(new As1_Crop("Carrot",15,"Tonne",1.23));
        allCrops.add(new As1_Crop("Beets",30,"Tonne",2.00));

        allCrops.get(0).setAcres(250);
        allCrops.get(1).setAcres(200);
        allCrops.get(2).setAcres(200);
        allCrops.get(3).setAcres(175);
        allCrops.get(4).setAcres(175);



        while(true) {

            System.out.println("Press 1 for Farm Summary\nPress 2 to for Searching and havesting crops\nPress 3 for Total Revenue\nPress 4 to Plant a crop.\nPress 5 to exit");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.println("Farm Summary");
                System.out.println();

                for (int i = 0; i < allCrops.size(); i++) {
                    allCrops.get(i).summary();
                }

            }
            if (choice == 2) {
                System.out.println("Search and harvest crop");
                System.out.println();
                System.out.println("What crop would you like to search for?");
                String searchCrop = Library.input.nextLine();
                int foundCrop = searchByName(allCrops, searchCrop);

               if(foundCrop != -1) {
                   System.out.println(allCrops.get(foundCrop));
                   System.out.println();
                   System.out.println("Would you like to harvest this crop?");
                   String response = Library.input.nextLine();
                   if(response.contains("y") || response.contains("Y")){
                       totalRevenue += allCrops.get(foundCrop).harvest();
                   }
               }
               else{
                   System.out.println("Crop not found. Try again later.");
               }
            }
            if (choice == 3) {
                System.out.println("Total Revenue");
                System.out.println();
                System.out.println("Total Revenue: $" + totalRevenue);
                //total revenue
            }
            if (choice == 4) {
                System.out.println("Planting crop");
                System.out.println();
                System.out.println("What crop would you like to plant");
                String plant = Library.input.nextLine();
                System.out.println("How many acres of this crop will be planted?");
                int newAcres = Library.input.nextInt();
                Library.input.nextLine();
                int foundCrop = searchByName(allCrops, plant);
                if(foundCrop != -1){
                    allCrops.get(foundCrop).cropExist(newAcres);
                }
                else{
                    System.out.println();
                    System.out.println("What is the average crop yield?");
                    double newYield = Library.input.nextDouble();
                    System.out.println("What are the units for this crop?");
                    String newUnits = Library.input.nextLine();
                    System.out.println("What is the price/unit of this crop?");
                    double newPrice = Library.input.nextDouble();
                    allCrops.add(new As1_Crop(plant, newYield,newUnits,newPrice));
                }

            }
            if (choice == 5) {
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");









    }//run

    public static int searchByName(ArrayList<As1_Crop> list, String searchTerm ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;
            }
        }
        return -1;
    }//searchByName
}//class
