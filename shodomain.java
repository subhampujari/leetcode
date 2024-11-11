class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
       // Map to store the visit counts for each subdomain
        Map<String, Integer> domainCountMap = new HashMap<>();
        
        // Iterate through each input domain string
        for(int i = 0; i < cpdomains.length; i++) {
            // Split the input string into count and domain
            String[] cpdomain = cpdomains[i].split(" ");
            Integer occurance = Integer.parseInt(cpdomain[0]);
            String[] domain = cpdomain[1].split("\\.");
            
            // Initialize the current domain as an empty string
            String currDomain = "";
            
            // Build subdomains from the full domain down to the root domain
            for (int j = domain.length - 1; j >= 0; j--) {
                if (currDomain.isEmpty()) {
                    currDomain = domain[j];
                } else {
                    currDomain = domain[j] + "." + currDomain;
                }
                
                // Update the count for the current subdomain
                domainCountMap.put(currDomain, domainCountMap.getOrDefault(currDomain, 0) + occurance);
            }
        }
        
        // Prepare the result list with the count-paired domains
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCountMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        
        return result;
    }
}
