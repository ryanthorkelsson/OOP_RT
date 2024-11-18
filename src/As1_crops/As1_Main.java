package As1_crops;

import Examples.Ex2_Actor;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){

        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        allCrops.add(new As1_Crop("Corn",202,"Bushels", 5.96));
        allCrops.add(new As1_Crop("Canola",32.7,"Bushels",14.61));
        allCrops.add(new As1_Crop("Potato",400,"Kilograms",4.13));
        allCrops.add(new As1_Crop("Carrot",15,"Tonnes",1.23));
        allCrops.add(new As1_Crop("Beets",30,"Tonnes",2.00));
    }
}
