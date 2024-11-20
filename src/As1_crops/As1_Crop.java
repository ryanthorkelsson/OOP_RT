package As1_crops;

public class As1_Crop {

    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;

    //constructor
    public As1_Crop(String n,double y, String u, double p){
        name =n;
        yield = y;
        units =u;
        price = p;
        acres = 0;
    }


    public String toString(){
        return name + ",  " + yield + ",  " + units + ",  " + price + "  "  + acres;
    }//toString

    public void summary(){
        System.out.println("We have " + yield + " " + units + "s of " + name + " planted on " + acres + " acres. The price for this crop is $" + price + "/" + units);
    }
    public void setAcres(int acres) {
        this.acres = acres;
    }
}
