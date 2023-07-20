import java.util.Arrays;
import java.io.*;
import java.lang.*;
import java.util.*;
/**
 * floyd
 */
public class floyd {
   public static void floydWarshall(int arr[][]){

    for(int k=0;k<arr.length;k++){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = 9999;
        int arr[][]={
            {0,3,INF,7},
            {8,0,2,INF},
            {5,INF,0,1},
            {2,INF,INF,0}
        };
        for(int i[]:arr)
        System.out.println(Arrays.toString(i));
        int len = arr.length;
        floydWarshall(arr);

        for(int i[]:arr){
            System.out.println(Arrays.toString(i));
        }
        
    }
}