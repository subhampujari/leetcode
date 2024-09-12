class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
       /* int k=primes.length;
        int [] ugly=new int[n];
        int [] next=new int[k];
        int [] indx=new int[k];
        Arrays.fill(indx,0);//filling with th 0 
        Arrays.fill(next,1);//filling with then1
        ugly[0]=1;
        for(int i=1;i<n;i++){
            int nextUgly=Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                next[j]=ugly[indx[j]]*primes[j];//mulptly the value of primes and storde int nexxt
                nextUgly=Math.min(nextUgly,next[j]);
            }
            ugly[i]=nextUgly;
            for(int j=0;j<k;j++){
                if(nextUgly==next[j]){
                    indx[j]++;//updates the value of indx
                }
            }
        }
        return ugly[n-1];
        */
      /* PriorityQueue<Long> q=new PriorityQueue();
        Set<Long> st=new HashSet<>();
        q.add(1L);
        st.add(1L);
         long uglyNumber=1L;
        for(int i=0;i<n;i++){
           uglyNumber=q.poll();
            for(int prime:primes){
                long newUglyNumber=uglyNumber*prime;
                if(!st.contains(newUglyNumber)){
                q.add(newUglyNumber);
                st.add(newUglyNumber);
                }
            }
        }
        return (int) uglyNumber;
        */
        // Create an array to store the super ugly numbers
        long[] uglyNumbers = new long[n];
        uglyNumbers[0] = 1; // The first super ugly number is 1
        
        // Array to store the current index for each prime
        int[] indices = new int[primes.length];
        // Array to store the next multiple of each prime
        long[] nextMultiples = new long[primes.length];
        
        // Initialize the next multiples
        for (int i = 0; i < primes.length; i++) {
            nextMultiples[i] = primes[i];
        }
        
        // Generate the nth super ugly number
        for (int i = 1; i < n; i++) {
            // Find the minimum value among the next multiples
            long nextUglyNumber = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nextUglyNumber = Math.min(nextUglyNumber, nextMultiples[j]);
            }
            
            // Add this minimum value to the ugly numbers array
            uglyNumbers[i] = nextUglyNumber;
            
            // Update the next multiples for the primes that match the minimum value
            for (int j = 0; j < primes.length; j++) {
                if (nextMultiples[j] == nextUglyNumber) {
                    indices[j]++;
                    nextMultiples[j] = uglyNumbers[indices[j]] * primes[j];
                }
            }
        }
        
        // Return the nth super ugly number
        return (int)uglyNumbers[n - 1];
    }
}
