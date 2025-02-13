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
        // this.buckets = [null, null, null, null];
        // Array of 4 null references

        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>(); // Initialize each bucket as an empty linked list
        }
        // this.buckets = [LinkedList{}, LinkedList{}, LinkedList{}, LinkedList{}];
        // Array of 4 empty LinkedLists
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
    // 8 % 5 = either 0/1/2/3/4 only
    // It returns bucket index in a way that our node will be stored in different different buckets.
    // so sizes of each bucket will be almost same.
    // ---------------------------------------------------------------
    // So Our n Nodes will be divided on all N buckes
    // Nodes in each bucket(λ) = n / N
    // λ (lambda) = n /N
    // Note : Size of each bucket can be less/equal<= λ
    // ---------------------------------------------------------------

    // ---------------------------------------------------------------
    // Sometime we gives threshold value k where it means :  λ <= k
    // mean, λ (lambda) should always be less / equal to this k else rehash.
    // ---------------------------------------------------------------

    // ---------------------------------------------------------------
    // n  ∝  λ
    // if n (nodes) increase than  λ  will also increase.
    // (i).  If we set k= 2
    //       λ = 7 / 4
    //       λ = 1.75 ≤ k ✓ correct
    // (ii). One More node is added
    //       λ = 8 / 4
    //       λ = 2    ≤ k ✓ correct
    // (iii).One More node is added
    //       λ = 9 / 4
    //       λ = 2.25   > k x Incorrect
    //       Need Rehashing
    //       because if λ icreases time complexity of put will increase
    //       λ should be ≤ k for better performance
    // Solution:
    // Create double size array =  N x 2
    // Now do rehashing
    // Now apply put() on individual node
    // now node will be on different buckets where λ ≤ k
    // ---------------------------------------------------------------



    // Helper method to search for a key in a specific bucket and return its index
    // Takes (bucket index + key) => return data index at LL
    private int searchInLL(K key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        // Fetch the linked list at the specified bucket index

        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key == key) {
                return i; // Return the index if the key is found
            }
        }
        return -1; // Return -1 if the key is not found
    }

    // Inserts a new key-value pair or updates an existing key with a new value
    public void put(K key, V value) {
        int bi = hashFunction(key);
        //  bucket index : Get the bucket index for the key
        int di = searchInLL(key, bi);
        //  data index : Check if the key already exists in the bucket

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
        // Step 1: Save the current buckets (before resizing) into a temporary variable
        LinkedList<Node>[] oldBuckets = buckets; // Copy the current buckets

        // Step 2: Double the number of buckets
        N = 2 * N; // New bucket count will be double the old size

        // Step 3: Create a new array of LinkedLists to hold the new buckets
        buckets = new LinkedList[N];

        // Step 4: Initialize each bucket as an empty LinkedList
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>(); // Initialize each bucket as an empty linked list
        }

        // Step 5: Reset the size of the map (number of elements)
        n = 0; // Reset element count, we'll reinsert all elements

        // Step 6: Reinsert all elements from the old buckets into the new buckets
        for (LinkedList<Node> ll : oldBuckets) { // Loop through each old bucket
            for (Node node : ll) { // Loop through each node (key-value pair) in the linked list
                put(node.key, node.value); // Insert the node into the new bucket
            }
        }
    }


    // Implementing the keySet() method to return all keys in the HashMap
    public ArrayList<K> keySet() {
        // Create an ArrayList to hold all keys
        ArrayList<K> keys = new ArrayList<>();

        // Loop through each bucket in the hash map
        for (int i = 0; i < buckets.length; i++) {  // bi  -> Traverse through each bucket in the array
            LinkedList<Node> ll = buckets[i]; // Get the linked list (bucket) at index i

            // Loop through each node in the current linked list (bucket)
            for (int j = 0; j < ll.size(); j++) {   // di  -> Traverse through each node in the bucket
                Node node = ll.get(j); // Get the node at index j in the linked list
                keys.add(node.key); // Add the key of the node to the 'keys' list
            }
        }

        // Return the list of all keys in the HashMap
        return keys;
    }


    // Implementing the get() method to retrieve the value associated with the given key
    public V get(K key) {
        // Get the bucket index for the key using the hash function
        int bi = hashFunction(key); // bi -> Bucket index of the key

        // Search for the key in the corresponding linked list (bucket)
        int di = searchInLL(key, bi); // di -> Index of the key in the linked list, -1 if not found

        // If the key does not exist in the hash map (di == -1), return null
        if (di == -1) {
            return null; // Key not found, return null
        } else {
            // If the key exists, retrieve the corresponding node from the bucket
            Node node = buckets[bi].get(di); // Get the node from the bucket at index bi
            return node.value; // Return the value of the found node
        }
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

        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
    }
}


// private LinkedList<Node>[] buckets ?
// array of LinkedList &  LinkedList is having 'Node' type elements

// private LinkedList<Node> ll ?
// LinkedList having 'Node' type elements
