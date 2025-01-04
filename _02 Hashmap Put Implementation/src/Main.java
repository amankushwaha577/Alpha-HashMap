import java.util.*;

// Custom HashMap implementation using separate chaining
class HashMap<K, V> { // Generics used for key (K) and value (V)

    // Node class representing a key-value pair
    private class Node {
        K key; // The key associated with this node
        V value; // The value associated with the key

        // Constructor to initialize a node with key and value
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n; // Total number of key-value pairs stored
    private int N; // Number of buckets (size of the array)
    private LinkedList<Node>[] buckets; // Array of linked lists for separate chaining

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.N = 4; // Initial number of buckets
        this.buckets = new LinkedList[N]; // Each bucket initially null
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>(); // Initialize each bucket as an empty linked list
        }
    }

    // Hash function to calculate the bucket index for a given key
    // 1. Generate Hash Code: key.hashCode() generates a hash code for the given key, which can be positive or negative.
    // 2. Ensure Non-Negative: Math.abs(bi) ensures the hash code is non-negative.
    // 3. Index Calculation: The hash code is then taken modulo N (number of buckets) to ensure the index fits within the array size:
    private int hashFunction(K key) {
        int bi = key.hashCode(); // Generate hash code for the key
        return Math.abs(bi) % N; // Ensure the index is non-negative and within the array size
    }
    // returns bucket index in the range [0, N-1]
    // It returns bucket index in a way that our node will be stored in different different buckets.
    // so sizes of each bucket will be almost same.
    // ---------------------------------------------------------------
    // So Our n Nodes will be divided on all N buckes
    // Nodes in each bucket(λ) = n / N
    // λ (lambda) = n /N
    // Note : Size of each bucket can be less/equal<= λ
    // ---------------------------------------------------------------
    // Sometime we gives threshold value k where it means :  λ <= k
    // mean, λ (lambda) should always be less / equal to this k else rehash.


    // Helper method to search for a key in a specific bucket and return its index
    private int searchInLL(K key, int bi) {
        LinkedList<Node> bucket = buckets[bi];
        // Fetch the linked list at the specified bucket index

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key.equals(key)) {
                return i; // Return the index if the key is found
            }
        }
        return -1; // Return -1 if the key is not found
    }

    // Inserts a new key-value pair or updates an existing key with a new value
    public void put(K key, V value) {
        int bi = hashFunction(key); // Get the bucket index for the key
        int di = searchInLL(key, bi); // Check if the key already exists in the bucket

        if (di != -1) {
            // If key exists, update the value
            buckets[bi].get(di).value = value;
        } else {
            // If key does not exist, add a new key-value pair
            buckets[bi].add(new Node(key, value));
            n++; // Increment the number of stored key-value pairs
        }

        // Check the load factor and rehash if necessary
        double loadFactor = (double) n / N;
        if (loadFactor > 2.0) {
            rehash(); // Perform rehashing if the load factor exceeds 2.0
        }
    }

    // Rehashing method to resize the HashMap and redistribute elements
    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        N = 2 * N; // Double the number of buckets
        buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
        n = 0;

        // Reinsert all elements into the new buckets
        for (LinkedList<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    // Implementing the keySet() method to return all keys in the HashMap
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {  // bi   // Traverse through each bucket
            LinkedList<Node> ll = buckets[i];
            for (int j = 0; j < ll.size(); j++) {   // di   // Traverse through each node in the bucket
                Node node = ll.get(j);
                keys.add(node.key); // Add key to the list
            }
        }
        return keys;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a HashMap instance with String keys and Integer values
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        map.put("Brazil", 100);
        map.put("UK", 80);

        // Print the keys using the keySet() method
        System.out.println("Keys in the HashMap:");
        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
