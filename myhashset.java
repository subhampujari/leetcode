class MyHashSet {
    private static final int SIZE = 1000; // Size of the hash table
    private ArrayList<LinkedList<Integer>> table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            table.add(new LinkedList<>()); // Initialize each bucket as a LinkedList
        }
    }

    /** Calculate the hash code for a given key. */
    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    /** Inserts the value key into the HashSet. */
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = table.get(index);
        
        // Check if the key already exists
        if (!bucket.contains(key)) {
            bucket.add(key); // Add the key to the bucket
        }
    }

    /** Returns whether the value key exists in the HashSet. */
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = table.get(index);
        return bucket.contains(key); // Check if the key is in the bucket
    }

    /** Removes the value key in the HashSet. */
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = table.get(index);
        bucket.remove((Integer) key); // Remove the key from the bucket if present
    }

}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
