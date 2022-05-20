import java.util.ArrayList;

public class UCS{
    private String name;
    private ArrayList<Connect> connection;
    private int costFinal;
    private String path;

    public UCS(){

    }
    
    public UCS(String name){
        this.name = name;
        this.costFinal = 0;
        this.connection = new ArrayList<>();
        this.path = "";
    }

    public UCS(UCS Connect){
        this.name = Connect.name;
        this.connection = Connect.connection;
        this.costFinal = Connect.costFinal;
        this.path = Connect.path;
    }

    public void setConnection(String name, int cost){
        Connect temp = new Connect();
        temp.setData(name,cost);
        this.connection.add(temp);
    }

    public void setConnectionArr(ArrayList<Connect> arr){
        this.connection = arr;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Connect> getConnection(){
        return this.connection;
    }

    public int getCostFinal(){
        return this.costFinal;
    }

    public void setCostFinal(int cost){
        this.costFinal = cost;
    }

    public void setPath(String node){
        this.path = node;
    }

    public String getPath(){
        return this.path;
    }
}