package DailyCheck_WarmUP.TwoDArray;

import java.util.Arrays;

public class SurroundedRegion130 {

    static void dfs(char[][] board,int i,int j)
    {
        if(i<0 || i>= board.length || j<0 || j>= board[0].length || board[i][j]!='O')
            return;
        board[i][j]='#';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
    static void solve(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1)
                    dfs(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};

        solve(board);

        for (char[] ch:board)
            System.out.println(Arrays.toString(ch));
    }
}
