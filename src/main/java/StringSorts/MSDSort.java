package StringSorts;

public class MSDSort {

    private static final int CUTOFF = 10;


    public static void sort(Alphabet alpha, String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(alpha, a, 0, N - 1, 0, aux);
    }

    private static int charAt(Alphabet alpha, String s, int pos) {
        assert pos >= 0 && pos <= s.length();
        if (pos == s.length()) return -1;
        return alpha.toIndex(s.charAt(pos));
    }

    private static void sort(Alphabet alpha, String[] a, int lo, int hi, int pos, String[] aux) {

        int R = alpha.radix();

        if (hi <= lo + CUTOFF) {
            insertion(alpha, a, lo, hi, pos);
            return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(alpha, a[i], pos);
            count[c + 2]++;
        }

        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++) {
            int c = charAt(alpha, a[i], pos);
            aux[count[c + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(alpha, a, lo + count[r], lo + count[r + 1] - 1, pos + 1, aux);
    }

    private static void insertion(Alphabet alpha, String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(alpha, a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Alphabet alpha, String v, String w, int pos) {
        assert v.substring(0, pos).equals(w.substring(0, pos));
        boolean less = false;
        for (int i = pos; i < v.length() && i < w.length(); i++) {
            if (alpha.toIndex(v.charAt(i)) > alpha.toIndex(w.charAt(i)))
                break;
            if (alpha.toIndex(v.charAt(i)) < alpha.toIndex(w.charAt(i))) {
                less = true;
                break;
            }
            if (i == v.length() - 1 || i == w.length() - 1 && v.length() < w.length()) less = true;
        }
        return less;
    }

}
