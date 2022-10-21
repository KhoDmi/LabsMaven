package StringSorts;

import java.util.Arrays;

public class Alphabet {

    private final char[] alphabet;
    private final int[] inverse;
    private final int R;

    public Alphabet(String alpha) {

        boolean[] duplicate = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (duplicate[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character " + c);
            duplicate[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        Arrays.fill(inverse, -1);

        for (int c = 0; c < R; c++)
            inverse[alphabet[c]] = c;
    }


    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    public int radix() {
        return R;
    }

    public int lgR() {
        int lgR = 0;
        for (int t = R - 1; t >= 1; t /= 2)
            lgR++;
        return lgR;
    }

    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " is not in the alphabet");
        }
        return inverse[c];
    }

    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target = new int[s.length()];
        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);
        return target;
    }


    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IllegalArgumentException("Illegal index:index must be between 0 and " + R);
        }
        return alphabet[index];
    }

    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int index : indices) s.append(toChar(index));
        return s.toString();
    }

}