package As3_League;

import java.util.ArrayList;
import java.util.Comparator;

public class As3_Team {

    private String name;
    private String city;
    private String division;
    private double pointPct;
    private int wins;
    private double pkpct;

    public As3_Team(String n, String c, String d, double pp, int w, double pk){
        name =n;
        city = c;
        division =d;
        pointPct = pp;
        wins =w;
        pkpct = pk;
    }

    @Override
    public String toString() {
        return "As2_Team{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", division='" + division + '\'' +
                ", pointPct=" + pointPct +
                ", wins=" + wins +
                ", pkpct=" + pkpct +
                '}';
    }

    public void list (){
        System.out.println(city + " " + name + "  Division: " + division + "  Wins: " + wins +"  Points Percentage: " + pointPct + "  Penalty Kill Percent: " + pkpct);
    }

    public int getWins() {
        return wins;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDivision() {
        return division;
    }
    public void divisionSort(){
        System.out.println(city + " " + name + " wins: " + wins );

    }

    public double getPointPct() {
        return pointPct;
    }

    public double getPkpct() {
        return pkpct;
    }

    public void setPointPct(double pointPct) {
        this.pointPct = pointPct;
    }

    public void setPkpct(double pkpct) {
        this.pkpct = pkpct;
    }
    public void won(){
        wins +=1;
    }
}//class
