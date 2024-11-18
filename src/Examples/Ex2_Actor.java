package Examples;

public class Ex2_Actor {

    private String name;
    private String role;
    private double sales;
    private boolean isPro;


    //constructor
    public Ex2_Actor(String n , String r){
        name = n;
        role =r;
        sales = 0;
        isPro = false;
    }//constructor
    public Ex2_Actor(String n , String r, boolean p){
        name = n;
        role =r;
        sales = 0;
        isPro = p;
    }//constructor 2

    public String toString(){
        return name + ",  " + role + ",  " + sales + ",  " + role;
    }//toString
    public void printMe(){
        System.out.println(name + ",  " + role + "\nTicket Sales: $" + sales + ",  " + role);
    }

    public void sellTix(int n){
        sales += n;
    }//sellTix

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSales() {
        return sales;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setName(String name) {
        this.name = name;
    }

}//class
