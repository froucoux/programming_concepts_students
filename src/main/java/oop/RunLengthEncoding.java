package oop;

import java.util.ArrayList;
import java.util.List;


/*
 Imagine a string that contains a lot of characters that are repeated,
 for example like this:
    "dddddaaazzzzzzdddz"

 To be more space efficient, we could represent the string as a list
 where the elements of the list tell us how often a character is repeated.
 For our example, this would look like this:
    [  (5,'d'), (3,'a'), (6,'z'), (3,'d') , (1,'z') ]
 An element like (6,'z') means that there are 6 consecutive 'z' at this
 position in the string.

 This kind of compression is called Run Length Encoding.

 The class RunLengthEncoding below is an implementation of such a
 compressed representation. It uses a List containing objects of the
 class RepeatingValue.

 Your must implement the constructors and methods marked as "TODO".
*/

public class RunLengthEncoding {

    /**
     * Class that represents one repeating character.
     */
    public static class RepeatingValue {
        private char value;            // the character
        private int numRepetitions;    // the number of repetitions

        /**
         * Constructs a RepeatingValue for the given character and number of repetitions.
         */
        public RepeatingValue(char value, int numRepetitions) {
            this.value = value;
            this.numRepetitions = numRepetitions;
        }

        public char getValue() {
            return value;
        }

        public int getNumRepetitions() {
            return numRepetitions;
        }
    }


    /**
     * You should use only the following member variable to store the Run Length Encoding.
     * There's no need to create any additional member variables.
     **/
    private final List<RepeatingValue> repeatingValues;


    /**
     * Constructs a new RunLengthEncoding object representing an empty string.
     */
    public RunLengthEncoding() {
        // TODO
         repeatingValues = null;
    }

    /**
     * Constructs a new RunLengthEncoding object representing a string.
     * You can assume that the string is NOT null.
     *
     * @param content the string to be encoded using Run Length Encoding
     */
    public RunLengthEncoding(String content) {
        // TODO
         repeatingValues = null;
    }

    /**
     * Appends a character to the end of the string.
     *
     * @param value the character to be appended
     */
    public void append(char value) {
        // TODO
    }

    /**
     * Returns the compressed representation.
     */
    public List<RepeatingValue> getCompressed() {
        return repeatingValues;
    }

    /**
     * Returns the uncompressed string represented by this RunLengthEncoding object.
     * Example:
     *   If the object currently stores the information that 'd' is repeated five times
     *   and 'a' is repeated three times, this method returns "dddddaaa".
     *
     * @return the uncompressed string
     */
    public String getUncompressed() {
        // TODO
         return null;
    }

    // Run this main method to see an example:
    public static void main(String[] args) {
        RunLengthEncoding rle = new RunLengthEncoding("dddddaaazzzzzzddd");

        // let's look what is inside the object:
        for (RepeatingValue rv: rle.getCompressed()) {
            System.out.println(rv.getNumRepetitions() + " times the character " + rv.getValue());
        }

        System.out.println("Here is the uncompressed string: " + rle.getUncompressed());
    }
}
