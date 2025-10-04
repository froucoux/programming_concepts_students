package basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ASCIIDecoder {

    /*
     * The 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["72", "101", "108", "108", "111"], ["87", "111", "114", "108", "100"]]
     * to your decode method, you should return : [ "Hello", "World" ].
     * 
     * Forbidden characters are passed as an array of int.
     * Each element of this array corresponds to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * Use the StringBuilder class and its method appendCodePoint(int) to translate the ASCII code.
     *
     * You should NEVER return null or an array containing null.
     */
    private static int[] convertToCodePoint(String[] sentence) {
        int numChars = sentence.length;
        int[] codePoints = new int[numChars];
        for (int i = 0; i < numChars; i++) {
            codePoints[i] = Integer.parseInt(sentence[i]);
        }
        return codePoints;
    }

    private static int[] filterForbiddenCodePoints(int[] codePoints, Set<Integer> forbidden) {
        return Arrays.stream(codePoints)
                .filter(cp -> !forbidden.contains(cp))
                .toArray();
    }

    private static String decodeSentence(int[] codePoints) {
        StringBuilder sb = new StringBuilder();
        for (int cp : codePoints) {
            sb.appendCodePoint(cp);
        }
        return sb.toString();
    }

    private static Set<Integer> buildForbiddenSet(int[] forbidden) {
        Set<Integer> forbiddenSet = new HashSet<>();
        if (forbidden != null) {
            for (int cp : forbidden) {
                forbiddenSet.add(cp);
            }
        }
        return forbiddenSet;
    }

    public static String[] decode(int[] forbidden, String[][] sentences) {
        String[] decodedSentences = new String[sentences.length];
        Set<Integer> forbiddenSet = buildForbiddenSet(forbidden);
        for (int i = 0; i < sentences.length; i++) {
            String[] currentCodedSentence = sentences[i];
            int[] codePoints = convertToCodePoint(currentCodedSentence);

            int[] filteredCodePoints;
            if (forbiddenSet == null) {
                filteredCodePoints = codePoints;
            } else {
                filteredCodePoints = filterForbiddenCodePoints(codePoints, forbiddenSet);
            }

            String decodedSentence = decodeSentence(filteredCodePoints);
            decodedSentences[i] = decodedSentence;
        }
        return decodedSentences;
    }
}
