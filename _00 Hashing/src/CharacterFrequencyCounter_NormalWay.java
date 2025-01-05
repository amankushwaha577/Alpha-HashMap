import java.util.*;

class tUf {

    public static void main(String[] args) {
        // Dummy data for input string (replace with your own string if needed)
        String s = "aabcc";  // Example string

        // Array to store frequency of each character (256 for all ASCII characters)
        int[] hash = new int[256];

        // Precompute: Count the frequency of each character in the input string
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++; // Increment count for the character at index i

            // s.charAt(i): This retrieves the character at index i in the string s.
            // hash[s.charAt(i)]: This accesses the element in the hash array at the index corresponding to the ASCII value of the character s.charAt(i).
            // [a-z] = [ 97 - 122 ]
            // [A-Z] = [ 65 - 90 ]
        }

        // Dummy data for number of queries
        int q = 3;  // Example: number of queries

        // Dummy data for query characters (replace with your own query characters)
        char[] queries = {'a', 'b', 'c'};  // Example query characters

        // Processing each query
        for (int i = 0; i < q; i++) {
            char c = queries[i];  // Get the query character

            // Output the frequency of the character
            System.out.println(hash[c]);
        }
    }
}
