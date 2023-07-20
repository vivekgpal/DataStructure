import java.util.ArrayList;
import java.util.Arrays;

public class bellman {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        int arr[] = new int[V];
        Arrays.fill(arr,(int)1e8);
        arr[S]=0;
        for(int i=0;i<arr.length-1;i++){
            
                for(int j=0;j<edges.size();j++){
                    int u =edges.get(j).get(0);
                    int v = edges.get(j).get(1);
                    int wt = edges.get(j).get(2);
                   
                    if(arr[v]>arr[u]+wt)
                    arr[v]=arr[u]+wt;
                    
                }
            }
            
            
            for(ArrayList<Integer> it : edges){    
                 int u =it.get(0);    
                    int v = it.get(1);
                    int wt = it.get(2);
                   
                    if(arr[v]>arr[u]+wt){
                        return new int[]{-1};
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
            int s=0; //source
            for(int i[]:arrs)
              System.out.println(Arrays.toString(i));

              
        ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
        int size=4;
        int c=0;
        for(int i=0;i<arrs.length;i++){
            for(int j=0;j<arrs.length;j++){
                if(arrs[i][j]!=INF)
                edges.add(new ArrayList<>(Arrays.asList(i,j,arrs[i][j])));
            }
        }

        edges.add(new ArrayList<>(Arrays.asList(0,1,5)));
      
       int arr[] =  bellman_ford(arrs.length, edges,  s);
       System.out.println("shortes path");
       System.out.println(Arrays.toString(arr));
        }
}
