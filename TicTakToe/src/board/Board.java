package board;
public class Board {
    public int size;
    public char matrix[][];
    char Symbol;
    public Board(int n,char c)
    {
        size=n;
        matrix=new char[n][n];
        Symbol=c;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]='-';
            }
        }
    }
    public void printConfig()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
