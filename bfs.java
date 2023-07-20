import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class bfs {

    public static ArrayList<Integer> traversal(int V,int start, ArrayList<ArrayList<Integer>> edges){

        boolean visited[]=new boolean[V];
        
        Queue<Integer> s = new LinkedList<>();
        s.add(start);
        visited[start]=true;
        ArrayList<Integer> ans= new ArrayList<>();
        while(!s.isEmpty()){
            int top = s.poll();
            ans.add(top);
            for(int i=0;i<edges.get(top).size();i++){
                int elt = edges.get(top).get(i);
                if(visited[elt]==false){ 
                    s.add(elt);
                    visited[elt]=true;
                }
            }

        }
        return ans;
    }
    public static void main(String[] args) {
         int arr[][]={
            {1,1,1,1},
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,1}
        };
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
        
        int V = arr.length;
        int start =0;
        ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            edges.add(new ArrayList<>());
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]==1)
                edges.get(i).add(j);
            }
        }
      ArrayList<Integer>  ans =  traversal(V,start, edges);
       
       System.out.println("bredth first traversal");
       System.out.println(ans);
    }
}
