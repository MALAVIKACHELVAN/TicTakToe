package game;
import player.Player;
import board.Board;
import java.util.*;
public class Game {
    Board board;
    Player[] players;
    int turn,noOfMoves;
    boolean gameOver;
    String zero,cross;

    public Game(Player players[],Board board)
    {
        this.players=players;
        this.board=board;
        this.turn=0;
        this.noOfMoves=0;
        this.gameOver=false;
        
        StringBuilder z=new StringBuilder();
        StringBuilder c=new StringBuilder();

        for(int i=0;i<board.size;i++)
        {
            z.append('0');
            c.append('x');
        }

        this.zero=z.toString();
        this.cross=c.toString();
    }
    public void play()
    {
        printBoardConfig();
        int size=board.size;
        while(!gameOver)
        {
            System.out.println(noOfMoves);
            noOfMoves++;
            int index=getIndex();
            int row=index/size;
            int col=index%size;
            board.matrix[row][col]=players[turn].PlayerSymbol;
            if(noOfMoves>=size*size)
            {
                System.out.println("Game Over");
                return;
            }
            if(noOfMoves>=2*size-1 && checkCombination()==true)
            {
                gameOver=true;
                printBoardConfig();
                System.out.println("Winner is "+players[turn].name);
                return;
            }
            turn=(turn+1)%2;
            printBoardConfig();
        }
    } 
    public void printBoardConfig()
    {
        for(int i=0;i<board.size;i++)
        {
            for(int j=0;j<board.size;j++)
            {
                System.out.print(board.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    @SuppressWarnings("resource")
    public int getIndex()
    {
        while(true)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Player: "+players[turn].name+" give one position");
            int pos=sc.nextInt()-1;
            int size=board.size;
            int row=pos/size;
            int col=pos%size;
             turn=turn%2;
            if(row<0||row>=size||col<0||col>=size)
            {
                System.out.println("Invalid Position");
                continue;
            }
            if(board.matrix[row][col]!='-')
            {
                System.out.println("Position already occupied");
            }
            return pos;
        }
    }
    public boolean checkCombination()
    {
        int size=board.size;
        for(int i=0;i<size;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<size;j++)
            {
                   sb.append(board.matrix[i][j]);
            }
            String st=sb.toString();
            if(st.equals(zero)||st.equals(cross))
            {
                return true;
            }
        }
        for(int i=0;i<size;i++)
        {
            StringBuilder sb2=new StringBuilder();
            for(int j=0;j<size;j++)
            {
                   sb2.append(board.matrix[j][i]);
            }
            String st1=sb2.toString();
            if(st1.equals(zero)||st1.equals(cross))
            {
                return true;
            }
        }
        int i=0;
        int j=0;
        StringBuilder sb3=new StringBuilder();
        while(i<size)
        {
            sb3.append(cross);
            i++;
            j++;
        }


        String pat=sb3.toString();
        if(pat.equals(zero)||pat.equals(cross))
        {
             return true;
        }
         i=0;
         j=size;
         sb3=new StringBuilder();
        while(i<size)
        {
            sb3.append(cross);
            i++;
            j++;
        }

        pat=sb3.toString();
        if(pat.equals(zero)||pat.equals(cross))
        {
             return true;
        }

        return false;
    }
}
