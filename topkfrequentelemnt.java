class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      /*  // we can do the question in O(N) time complexity using the bucket Sort
          // Step 1: Count the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert the frequency map to a list of entries
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort the list by frequency in descending order
        entryList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // Step 4: Extract the k most frequent elements
        int[]res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=entryList.get(i).getKey();
        }
        return res;
        */
        //bucket Sort
        //step 1
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);// put the element inso the map with the frequency 
        }
  //step 2 find the maxNumber inthe array
  int maxNumber=0;
  for(int freq:map.values()){
    maxNumber=Math.max(maxNumber,freq);
  }

//step 3 creating one buket array with the maxNumber +1
 List<Integer>[] bucket=new ArrayList[maxNumber+1];
 for(int i=0;i<=maxNumber;i++){
 bucket[i]=new ArrayList<>();
}
//fill the buket array of arraylist from the map 
    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
     int num=entry.getKey();
    int freq=entry.getValue();
    bucket[freq].add(num);
}

//create one array of k sinze to add the elements into the array 
     // Step 3: Collect the top k frequent elements from the buckets
        List<Integer> result = new ArrayList<>();
        for (int i = maxNumber; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
         int[] res=new int[k];
         for(int i=0;i<k;i++){
            res[i]=result.get(i);
         }
         return res;
    }
}