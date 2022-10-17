package StringSorts;

public class LSDsort {

    public static void sort(Alphabet alpha, String[] strings, int wordLength) {
        for (int j = 0; j < strings.length; j++) {
            {
                for (int i = 0; i < strings[j].length(); i++) {
                    if (!alpha.contains(strings[j].charAt(i)))
                        throw new IllegalArgumentException("No such character in the alphabet " + strings[j].charAt(i));
                }
            }
        }
        int length = strings.length;
        int R = alpha.radix();
        String[] aux = new String[length];

        for (int d = wordLength - 1; d >= 0; d--) {

            int[] count = new int[R + 1];
            for (int i = 0; i < length; i++)
                count[alpha.toIndex(strings[i].charAt(d)) + 1]++;

            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            for (int i = 0; i < length; i++)
                aux[count[alpha.toIndex(strings[i].charAt(d))]++] = strings[i];

            for (int i = 0; i < length; i++)
                strings[i] = aux[i];
        }
    }
}
