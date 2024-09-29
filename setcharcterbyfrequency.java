class Solution {
    public String frequencySort(String s) {
         // Step 1: Create a map for storing the frequency 
        Map<Character, Integer> fMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            fMap.put(c, fMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a list based on the frequency map
        List<Map.Entry<Character, Integer>> res = new ArrayList<>(fMap.entrySet());

        // Sort the list based on decreasing order of values in the map 
        res.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 3: Insert the characters into a string based on frequency 
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : res) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
