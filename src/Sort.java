import java.util.Arrays;

public class Sort {
    
    // O(n lg n)
    public static class MergeSort{

        public static void merge(int arr[], int l, int m, int r){
            
            int larr[] = Arrays.copyOfRange(arr, l, m+1);
            int rarr[] = Arrays.copyOfRange(arr, m+1, r+1);

            int lidx = 0;
            int ridx = 0;

            int idx = l;
            while(lidx < larr.length && ridx < rarr.length){

                if(larr[lidx] < rarr[ridx]){
                    arr[idx++] = larr[lidx++];
                }
                else{
                    arr[idx++] = rarr[ridx++];
                }
                
            }

            while(lidx <  larr.length ){
                arr[idx++] = larr[lidx++];
            }
            
            while(ridx <  rarr.length){
                arr[idx++] = rarr[ridx++];
            }
        }
        public static void sort(int arr[], int l, int r){

            if(l < r){

                int mid = (r+l)/2;
                
                sort(arr, l, mid);
                sort(arr, mid+1, r);
                merge(arr, l, mid, r);

            }
        }
    }
}
