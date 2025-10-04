package basics;

import java.util.ArrayList;
import java.util.Arrays;

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
    private static boolean isForbidden(int codePoint, int[] forbidden) {
        for (int fcp : forbidden) {
            if (codePoint == fcp) {
                return true;
            }
        }
        return false;
    }

    private static int[] convertToCodePoint(String[] sentence) {
        int numChars = sentence.length;
        int[] codePoints = new int[numChars];
        for (int i = 0; i < numChars; i++) {
            codePoints[i] = Integer.parseInt(sentence[i]);
        }
        return codePoints;
    }

    private static int[] filterForbiddenCodePoints(int[] codePoints, int[] forbidden) {
        return Arrays.stream(codePoints)
                .filter(cp -> !isForbidden(cp, forbidden))
                .toArray();
    }

    private static String decodeSentence(int[] codePoints) {
        StringBuilder sb = new StringBuilder();
        for (int cp : codePoints) {
            sb.appendCodePoint(cp);
        }
        return sb.toString();
    }

    public static String[] decode(int[] forbidden, String[][] sentences) {
        String[] decodedSentences = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            String[] currentCodedSentence = sentences[i];
            int[] codePoints = convertToCodePoint(currentCodedSentence);

            int[] filteredCodePoints;
            if (forbidden == null) {
                filteredCodePoints = codePoints;
            } else {
                filteredCodePoints = filterForbiddenCodePoints(codePoints, forbidden);
            }

            String decodedSentence = decodeSentence(filteredCodePoints);
            decodedSentences[i] = decodedSentence;
        }
        return decodedSentences;
    }
}
