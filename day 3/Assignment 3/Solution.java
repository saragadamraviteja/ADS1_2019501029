class Solution{
    public int[] sortInsertion(int[] arr){
        // fill you code Here
        for(int i =0; i < arr.length; i++) {
            for(int j = i; j>0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j , j-1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }
    public int[] sortSelection(int[] arr){
        // fill you code Here
        for(int i =0; i < arr.length; i++) {
            int min = i;
            for(int j =i+1; j< arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            } swap(arr, min, i);
            
        }
        return arr;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}