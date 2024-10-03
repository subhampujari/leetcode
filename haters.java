class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // Step 1: Sort the houses and heaters
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int maxRadius = 0;
        int heaterIndex = 0;
        int heatersLength = heaters.length;

        // Step 2: Iterate through each house
        for (int house : houses) {
            // Move the heaterIndex to the right heater that's the nearest
            while (heaterIndex < heatersLength - 1 && 
                   Math.abs(heaters[heaterIndex + 1] - house) <= Math.abs(heaters[heaterIndex] - house)) {
                heaterIndex++;
            }
            // Calculate the distance to the nearest heater
            int distanceToHeater = Math.abs(heaters[heaterIndex] - house);
            // Update maxRadius if this distance is greater
            maxRadius = Math.max(maxRadius, distanceToHeater);
        }

        return maxRadius;
    }
}
