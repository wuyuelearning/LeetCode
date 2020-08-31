package dfs;

/**
 * Created by wuyue on 2020/7/30.
 */
public class DFS1 {
    private int graph[][] ;
    private boolean t[];
    private int max =10;
    public static void main(String[] args){
        DFS1 dfs1 =new DFS1();
    }

    private void start(){
       for (int i=0;i<max;i++){
           t[i]=false;
       }
        for (int i =0 ;i<max;i++){
            if (!t[i]){
                dfs(graph,i);
            }
        }
    }

    private void dfs(int[][] graph ,int i){
        int j ;
        t[i]=true;

        for (j=0;j<max;j++){
            if (graph[i][j] ==1 && !t[j]){
                dfs(graph,j);
            }
        }

    }

}
