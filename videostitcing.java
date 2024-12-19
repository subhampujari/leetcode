class Solution {
    int[][] dp;
    public int videoStitching(int[][] clips, int time) {
        dp = new int[clips.length+1][time+1];
        Arrays.sort(clips, (o1,o2)->{
            if(o1[0] < o2[0]) return -1;
            else if(o1[0] > o2[0]) return 1;
            else if(o1[0]==o2[0]) return 0;
            else return Integer.compare(o1[1],o2[1]);
        });
        int res = solve(clips,0,time,0,0);
        if(res == Integer.MAX_VALUE || res == Integer.MAX_VALUE-1) return -1;
        else return res;
            
        
    }
    public int solve(int[][] clips, int ind,int time,int startcurr ,int currEnd){
        if(currEnd>=time)return 0;
        if(ind>= clips.length) return Integer.MAX_VALUE-1;

        if(dp[ind][currEnd]!=0) return dp[ind][currEnd];
        int cuts =0;

        int start = clips[ind][0];
        int end = clips[ind][1];
        if(start <= currEnd ){
            cuts=Math.min( 1 + 
            solve(clips,ind+1,time,startcurr,Math.max(end,currEnd)) ,   
            solve(clips,ind+1,time,startcurr,currEnd) );
        }
        else  cuts = solve(clips,ind+1,time,startcurr,currEnd);

        return dp[ind][currEnd]=cuts ;
        
    }
}