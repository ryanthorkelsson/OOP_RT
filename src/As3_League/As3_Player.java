package As3_League;

public class As3_Player {

    private String name;
    private int ID;
    private int goalsScored;
    private int assists;

    public As3_Player (String n, int i, int g, int a){
        name =n;
        ID =i;
        goalsScored =g;
        assists =a;
    }

    public void addGoal(){
        goalsScored +=1;
    }
    public void addAssist(){
        assists += 1;
    }

    public void PrintMe(){
        System.out.println("Name: " + name + " / ID: " + ID + "  Goals:" + goalsScored + "  Assists: " + assists);
    }



}
