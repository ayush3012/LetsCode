package DailyCheck.com.MyPack.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    static List<String> solveMaze(int[][] maze)
    {
        boolean[][] visited=new boolean[maze.length][maze.length];
        List<String> paths=new ArrayList<>();
        dfs(maze,0,0,visited,new StringBuilder(),paths);

      return paths;
    }
    static void dfs(int[][] maze,int r,int c,boolean[][] visited,StringBuilder path,List<String> paths)
    {
        if(r<0 || r>= maze.length || c<0 || c>=maze[0].length || maze[r][c]==0 || visited[r][c])
            return;
        if(r== maze.length-1 && c==maze.length-1)
        {
            paths.add(path.toString());
            return;
        }

        visited[r][c]=true;

        int[] dr={1,0,0,-1};
        int[] dc={0,1,-1,0};
        char[] dir={'D','R','L','U'};

        for(int i=0;i<4;i++)
        {
            path.append(dir[i]);
            dfs(maze,r+dr[i],c+dc[i],visited,path,paths);
            path.deleteCharAt(path.length()-1);
        }
        visited[r][c]=false;
    }
    public static void main(String[] args) {
        int[][] maze={{1,0,0,0},
                      {1,1,0,1},
                      {1,1,0,0},
                      {1,1,1,1}};

        solveMaze(maze).forEach(System.out::println);
    }
}
