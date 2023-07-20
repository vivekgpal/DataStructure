import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkastras {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<int[]>pq = new PriorityQueue<>(V, (a, b) -> a[1] - b[1]);
        int arr[]=new int[V];
        Arrays.fill(arr,Integer.MAX_VALUE);
        
        arr[S] = 0;
        pq.add(new int[]{S,0});
        while(!pq.isEmpty()){
            int temp[]=pq.remove();
            for(int i=0;i<adj.get(temp[0]).size();i++){
                int node = adj.get(temp[0]).get(i).get(0);
                int weight = temp[1] + adj.get(temp[0]).get(i).get(1);
                if(arr[node]>weight){
                    arr[node]=weight;
                    pq.add(new int[]{node,weight});
                }
            }
        }
        
        return arr;
    }
    public static void main(String[] args) {
        int INF = 9999;
        int arrs[][]={
            {0,3,INF,7},
            {8,0,2,INF},
            {5,INF,0,1},
            {2,INF,INF,0}
        };
        int V=arrs.length;
        int s=0;
        ArrayList<ArrayList<ArrayList<Integer>>>adj=new ArrayList<>();
                for(int i=0;i<arrs.length;i++){
                    ArrayList<ArrayList<Integer>> edges=new ArrayList<>();//edges and value
                    adj.add(edges);
            for(int j=0;j<arrs.length;j++){
                if(arrs[i][j]!=INF)
                edges.add(new ArrayList<>(Arrays.asList(j,arrs[i][j])));
            }
        }
        int[]arr = dijkstra(V, adj, s);
        for(int i[]:arrs)
        System.out.println(Arrays.toString(i));
        System.out.println("shortes path");
        System.out.println(Arrays.toString(arr));
    }
}


//edges.add(new ArrayList<>(Arrays.asList(i,j,arrs[i][j])));