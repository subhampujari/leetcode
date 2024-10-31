class MyCalendarThree {
    private TreeMap<Integer, Integer> timeline;
      public MyCalendarThree() {
           timeline = new TreeMap<>();
      }
      
      public int book(int startTime, int endTime) {
            timeline.put(startTime, timeline.getOrDefault(startTime, 0) + 1);
          // Decrement at endTime
          timeline.put(endTime, timeline.getOrDefault(endTime, 0) - 1);
  
          // Calculate the maximum number of overlapping events
          int ongoingEvents = 0;
          int maxBookings = 0;
          
          for (int count : timeline.values()) {
              ongoingEvents += count;
              maxBookings = Math.max(maxBookings, ongoingEvents);
          }
  
          return maxBookings; // Return the maximum k-booking
      }
  }
  
  /**
   * Your MyCalendarThree object will be instantiated and called as such:
   * MyCalendarThree obj = new MyCalendarThree();
   * int param_1 = obj.book(startTime,endTime);
   */
