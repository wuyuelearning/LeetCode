package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wuyue on 2020/7/31.
 */
public class BFS1 {
    int n =4;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int vst[][] =new int[n][n];
    int map[][] =new int[][]{{1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}};
    public static void main(String[] args){
        BFS1 bfs1 =new BFS1();
        bfs1.init();

    }

    private void init(){
        for (int i =0;i<n ;i++){
            for (int j = 0;j<n;j++){
                vst[i][j]=0;
            }
        }
        Node node =new Node(0,0,0);
        vst[0][0] =1;
        bfs(node);
//        for (int i =0;i<n ;i++){
//            for (int j = 0;j<n;j++){
//                if (vst[i][j] == 1)
//                    System.out.println( "("+i+","+j+")");
//            }
//        }
    }
    private void bfs(Node node){
        Queue<Node> queue =new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            print(queue);
            Node temp =queue.poll();
            for (int i=0;i<4;i++){
                // 在队列头部的元素，下一步的坐标
                int next_i  =temp.x+dir[i][0];
                int next_j = temp.y+dir[i][1];
                if (check(next_i,next_j)){
                    vst[next_i][next_j]=1;
                    queue.offer(new Node(next_i,next_j,temp.count+1));
                }
            }
        }
    }

    /**
     * 1
     * 2  5
     * 5  3  6
     * 3  6  9
     * 6  9  4  7
     * .....
     *
     * 初始化：
     *   1 入队列
     *
     * 第一次：
     * 1 出队列
     * 1 可以走的第一步有 2 和5  将2 和 5  入队列
     *
     * 第二次：
     *  2 出队列
     *  2 可以走的一步 ：3 和 6 入队列
     *
     *
     * @param queue
     */
    private void print(Queue<Node> queue){ //  队列中的
        Object[] objects = queue.toArray();
        for (Object o :objects){
            Node y =(Node)o;
            System.out.print(map[y.x][y.y]+"  ");
        }

        System.out.println();
    }

    boolean check(int i,int j){
        return (0<=i && i<=n-1 && 0<=j && j<=n-1 && vst[i][j] == 0  );
    }
    class Node{
        int x,y,count;
        public Node(int x ,int y,int count){
            this.x =x;
            this.y =y;
            this.count =count;
        }
    }
}
