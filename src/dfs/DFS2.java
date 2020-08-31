package dfs;

/**
 * Created by wuyue on 2020/7/30.
 */
public class DFS2 {

    int n =5;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int vst[][] =new int[n][n];
    int map[][] =new int[][]{{0,0,1,1,0},
                             {1,0,0,1,1},
                             {1,1,0,0,0},
                             {1,0,0,1,1},
                             {0,0,1,0,0}};

    public static void main(String[] args){
        DFS2 dfs2 =new DFS2();
        dfs2.init();


    }
    private void init(){
        for (int i =0;i<n ;i++){
            for (int j = 0;j<n;j++){
                vst[i][j]=0;
            }
        }

        dfs(0,0);

        for (int i =0;i<n ;i++){
            for (int j = 0;j<n;j++){
                if (vst[i][j] == 1)
                    System.out.println( "("+i+","+j+")");
            }
        }

    }
    private void dfs(int x ,int y){
        vst[x][y] =1;
//        System.out.println( "("+x+","+y+")");
        for (int i =0;i<4;i++){ // 这里的4为4个方向
            if (check(x+dir[i][0] ,y+dir[i][1]))
                dfs(x+dir[i][0],y+dir[i][1]);
        }

    }
    boolean check(int i,int j){
        return (0<=i && i<=n-1 && 0<=j && j<=n-1 && vst[i][j] == 0 && map[i][j] == 0 );
    }
}
