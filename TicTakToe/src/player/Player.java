package player;

public class Player {
    public String name;
    private int id;
    private String status;
    public char PlayerSymbol;
    public void setAttributesOFPlayer(String name,int id,String status,char Symbol)
    {
        this.name=name;
        this.id=id;
        this.status=status;
        this.PlayerSymbol=Symbol;
    }
    
    public void printPlayerDetails()
    {
        System.out.print("Name "+name+"\n"+"id "+id+"\n"+"Symbol "+PlayerSymbol+"\n");
    }


    
}
