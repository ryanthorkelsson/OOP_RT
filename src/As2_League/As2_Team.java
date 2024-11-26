package As2_League;

public class As2_Team {

    private String name;
    private String city;
    private String division;
    private double pointPct;
    private int wins;
    private double pkpct;

    public As2_Team(String n, String c, String d,double pp,int w, double pk){
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
}
