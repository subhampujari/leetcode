class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res=new ArrayList<>();
        int n=arr.length;
        for(int i=n;i>1;i--){
            int idx=find(arr,i);
            flip(arr,idx);
            res.add(idx+1);
            flip(arr,i-1);
            res.add(i);
        }
        return res;
    }
    public void flip(int []arr,int n){
        int i=0;int j=n;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }       
    }
    public int find(int[]arr,int n){
        int idx=0;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[idx]){
                idx=i;
            }
        }
        return idx;
    }
}
