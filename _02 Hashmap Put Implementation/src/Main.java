import java.util.*;

public class Main {

    // Custom HashMap implementation using separate chaining
    static class HashMap<K, V> {

        // Node class representing a key-value pair
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Number of stored key-value pairs
        private int N; // Number of buckets (array length)
        private LinkedList<Node>[] buckets; // Array of linked lists for separate chaining

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4; // Initial size of the bucket array
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>(); // Initializing each bucket as an empty linked list
            }
        }

        // Hash function to determine bucket index for a given key
        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Inserts or updates a key-value pair in the HashMap
        public void put(K key, V value) {
            int bi = hashFunction(key); // Get the bucket index
            LinkedList<Node> bucket = buckets[bi];

            // Check if the key already exists, and update its value if so
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return; // If key found, update and return
                }
            }

            // If key is not found, add a new node
            bucket.add(new Node(key, value));
            n++; // Increment the number of key-value pairs

            // Check the load factor and rehash if necessary
            double loadFactor = (double) n / N;
            if (loadFactor > 2.0) {
                rehash(); // Rehash if load factor exceeds 2
            }
        }

        // Method to rehash the HashMap (doubling the bucket size)
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets; // Store the old buckets
            N = 2 * N; // Double the size
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>(); // Initialize new buckets
            }
            n = 0; // Reset the number of key-value pairs

            // Reinsert all nodes into the new bucket array
            for (LinkedList<Node> bucket : oldBuckets) {
                for (Node node : bucket) {
                    put(node.key, node.value); // Insert each node into the new buckets
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
    }
}
