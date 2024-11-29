class Solution {
    private int n;   // number of different songs
     private int goal; // number of total songs to be played
     private int k;   // minimum number of other songs before a song can be repeated
     private long[][] dp; // dp[i][j] will store the number of playlists with i songs used and j songs played
     private final long MOD = 1_000_000_007;
 
     public int numMusicPlaylists(int n, int goal, int k) {
         this.n = n;
         this.k = k;
         this.goal = goal;
         dp = new long[goal + 1][n + 1]; // dp[i][j]: i songs played, j songs used
         for (long[] row : dp) {
             Arrays.fill(row, -1);
         }
         
         return (int) solve(0, 0); // start with 0 songs used and 0 songs played
     }
 
     public long solve(int usedSong, int currSong) {
         // If we've played all the required songs
         if (currSong == goal) {
             return usedSong == n ? 1 : 0; // valid if all songs are used
         }
 
         // Return the cached result if already computed
         if (dp[currSong][usedSong] != -1) {
             return dp[currSong][usedSong];
         }
 
         long totalWays = 0;
 
         // Case 1: Use a new song (if available)
         if (usedSong < n) {
             totalWays += solve(usedSong + 1, currSong + 1) * (n - usedSong) % MOD;
         }
 
         // Case 2: Reuse an existing song (if it's allowed, i.e., played at least k other songs since it was last used)
         if (usedSong > k) {
             totalWays += solve(usedSong, currSong + 1) * Math.max(0, usedSong - k) % MOD;
         }
 
         // Modulo operation to prevent overflow
         totalWays %= MOD;
 
         dp[currSong][usedSong] = totalWays; // Cache the result
         return totalWays;
     }
 }
