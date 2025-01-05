import java.util.*;

public class CharacterFrequencyCounter {

    public static void main(String[] args) {
        // Template input string
        String s = "abacaba"; // Example string to count character frequency

        // Precompute the frequency of each character in the string
        int[] hash = new int[26]; // Array to store the frequency of each lowercase letter (a-z)
        for (int i = 0; i < s.length(); i++) {
            // Increment frequency count for the character
            hash[s.charAt(i) - 'a']++;
            // s.charAt(i) extracts the character at index i.
            // -'a' converts the character into a zero-based index for the hash array
            // Example: 'a' - 'a' → 0, 'b' - 'a' → 1, ..., 'z' - 'a' → 25.
            // hash[...]++ increments the count at the corresponding index
        }

        // Template queries for demonstration
        char[] queries = {'a', 'b', 'c', 'd'};

        // Answer each query by printing the frequency of the given character
        for (char c : queries) {
            // Print the frequency of the character using the precomputed hash array
            System.out.println("Frequency of '" + c + "': " + hash[c - 'a']);
        }
    }
}
