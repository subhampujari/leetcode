class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
         // Create a set for fast access to valid genes in the bank
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // If the end gene is not in the bank, return -1
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        // Characters that can be used for mutation
        char[] genes = {'A', 'C', 'G', 'T'};
        
        // BFS queue
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        
        // Map to track visited genes
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        
        // Mutation count
        int mutations = 0;

        // BFS to find the minimum mutations
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();

                // If we reached the end gene, return the mutation count
                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                // Try all possible mutations
                for (int j = 0; j < currentGene.length(); j++) {
                    for (char gene : genes) {
                        // Skip if the gene is the same
                        if (currentGene.charAt(j) == gene) {
                            continue;
                        }

                        // Create a new mutated gene
                        String mutatedGene = currentGene.substring(0, j) + gene + currentGene.substring(j + 1);
                        
                        // If it's in the bank and hasn't been visited yet
                        if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            queue.add(mutatedGene);
                            visited.add(mutatedGene);
                        }
                    }
                }
            }
            // Increment the mutation count after processing the current level
            mutations++;
        }

        // If we exhaust the queue without finding the end gene, return -1
        return -1;
    }
}