class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
         int n = hand.length;
        if (n % groupSize != 0) return false;  // If the hand length is not divisible by group size, return false

        // Count the frequency of each card
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Sort the cards to make sure we try to form groups starting from the smallest card
        Arrays.sort(hand);

        // Try to create groups starting with the smallest card
        for (int card : hand) {
            // If this card has already been used in a group, skip it
            if (!map.containsKey(card)) {
                continue;
            }

            // Start forming a group with the current card
            int currentCard = card;
            
            // Try to form a sequence of groupSize consecutive cards
            for (int i = 0; i < groupSize; i++) {
                // If there's no card in the map or it's used up, return false
                if (!map.containsKey(currentCard) || map.get(currentCard) == 0) {
                    return false;
                }

                // Decrease the count of the current card as it's being used in the group
                map.put(currentCard, map.get(currentCard) - 1);

                // If the card count reaches zero, remove it from the map
                if (map.get(currentCard) == 0) {
                    map.remove(currentCard);
                }

                currentCard++;  // Move to the next consecutive card
            }
        }

        return true;
    }
}
