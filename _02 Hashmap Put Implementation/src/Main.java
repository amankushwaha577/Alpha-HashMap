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
        this.buckets = new LinkedList[N]; // currently each bucket have null.
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>(); // Initialize each bucket as an empty linked list
        }
    }

    // Hash function to calculate the bucket index for a given key
    private int hashFunction(K key) {
        int bi = key.hashCode(); // Generate a hash code for the key
        return Math.abs(bi) % N; // Ensure the index is non-negative and within the array size
    }

    // Helper method to search for a key in a specific bucket and return its index
    private int searchInLL(K key, int bi) {
        LinkedList<Node> bucket = buckets[bi]; // Fetch the linked list at the specified bucket index
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
        double loadFactor = (double) n / N; // Calculate the load factor
        if (loadFactor > 2.0) {
            rehash(); // Perform rehashing if the load factor exceeds 2.0
        }
    }

    // Rehashing method to resize the HashMap and redistribute elements
    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets; // Store the current buckets temporarily
        N = 2 * N; // Double the number of buckets
        buckets = new LinkedList[N]; // Create a new bucket array with the updated size
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>(); // Initialize each new bucket as an empty linked list
        }
        n = 0; // Reset the number of key-value pairs

        // Reinsert all elements into the new buckets
        for (LinkedList<Node> bucket : oldBuckets) {
            for (Node node : bucket) {
                put(node.key, node.value); // Reinsert all nodes into the resized hash map
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a HashMap instance with String keys and Integer values
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190); // Add entry for India
        map.put("China", 200); // Add entry for China
        map.put("US", 50);     // Add entry for US
    }
}
