import java.util.ArrayList;
import java.util.LinkedList;

public class MainX {

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
            return Math.abs(key.hashCode()) % N;
        }

        // Searches for a key in the specified bucket and returns the index
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) { // Use .equals() for proper comparison
                    return i; // Key found, return index
                }
            }
            return -1; // Key not found
        }

        // Doubles the bucket array size and rehashes all keys
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets; // Store the old buckets
            N = 2 * N; // Double the size
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>(); // Initialize new buckets
            }
            n = 0; // Reset key-value pair count

            // Reinsert all nodes into the new bucket array
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        // Inserts or updates a key-value pair in the HashMap
        public void put(K key, V value) {
            int bi = hashFunction(key); // Get the bucket index
            int di = searchInLL(key, bi); // Search for the key in the bucket

            if (di == -1) { // Key not found, insert new node
                buckets[bi].add(new Node(key, value));
                n++;
            } else { // Key exists, update its value
                buckets[bi].get(di).value = value;
            }

            // Check the load factor and rehash if necessary
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        // Checks if a key exists in the HashMap
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            return searchInLL(key, bi) != -1;
        }

        // Removes a key-value pair from the HashMap
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) { // Key not found
                return null;
            } else { // Key found, remove the node and return its value
                n--;
                return buckets[bi].remove(di).value;
            }
        }

        // Retrieves the value associated with a key
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) { // Key not found
                return null;
            } else { // Key found, return the value
                return buckets[bi].get(di).value;
            }
        }

        // Returns a list of all keys present in the HashMap
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // Checks if the HashMap is empty
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        // Printing all keys and their corresponding values
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // Removing a key and checking the result
        map.remove("India");
        System.out.println("Value for India: " + map.get("India"));
    }
}
