package StringSorts;

public class MSDsort {

    private static final int CUTOFF = 15;


    public static void sort(Alphabet alpha, String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        sort(alpha, a, 0, N - 1, 0, aux);
    }

    private static int charAt(Alphabet alpha, String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return alpha.toIndex(s.charAt(d));
    }

    private static void sort(Alphabet alpha, String[] a, int lo, int hi, int d, String[] aux) {

        int R = alpha.radix();

        if (hi <= lo + CUTOFF) {
            insertion(alpha, a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(alpha, a[i], d);
            count[c + 2]++;
        }

        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++) {
            int c = charAt(alpha, a[i], d);
            aux[count[c + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(alpha, a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
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

    private static boolean less(Alphabet alpha, String v, String w, int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        boolean less = false;
        for (int i = d; i < v.length() && i < w.length(); i++) {
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
