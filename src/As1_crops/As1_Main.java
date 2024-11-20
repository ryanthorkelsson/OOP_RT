package As1_crops;


import Examples.Library;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){


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
                System.out.println("Yeehaw!");

//                search and harvest

            }
            if (choice == 3) {
                System.out.println("Cool dadio!");

                //total revenue
            }
            if (choice == 4) {

                //Plant crop

            }
            if (choice == 5) {
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");









    }
}
