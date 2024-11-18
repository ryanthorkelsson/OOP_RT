package Examples;

import Examples.Ex2_Actor;

import java.util.ArrayList;
public class Ex2_Main {


    public static void run(){

    ArrayList<Ex2_Actor> allActors = new ArrayList<>();
    allActors.add(new Ex2_Actor("Mr. Hempel", "Othello"));
    allActors.add(new Ex2_Actor("Ms. Bone", "Iago"));
    allActors.add(new Ex2_Actor("Ms. Smith", "Desdemona", true));
    allActors.add(new Ex2_Actor("Mr. Vetch", "Cassio", true));
    allActors.add(new Ex2_Actor("Mr. van GinHoven", "Emilia"));

//    allActors.get(1).sales = 125;
    allActors.get(1).sellTix(125);

    String seller = "Mr. Vetch";
    int sold = 75;

    int foundIndex = searchByName(allActors,seller);
    allActors.get(foundIndex).sellTix(sold);

        for (int i = 0; i < allActors.size(); i++) {
            System.out.println(allActors.get(i));

//            allActors.get(i).printMe();
//            System.out.println(allActors.get(i).getRole() + " is played by " + allActors.get(i).getName());
        }


        //calculate revenue at

        int total =0;
        for (int i = 0; i < allActors.size(); i++) {
            total += allActors.get(i).getSales();
        }

        System.out.println("We sold " + total + " tickets for a total revenue of $" + (total * 15));



    }//run


   public static int searchByName(ArrayList<Ex2_Actor> list , String searchTerm){
       for (int i = 0; i < list.size(); i++) {
           if(searchTerm.equalsIgnoreCase(list.get(i).getName() ) ){
                return i;
           }
       }
        return -1;
   }
}//class
