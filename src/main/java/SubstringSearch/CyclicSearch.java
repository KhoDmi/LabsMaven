package SubstringSearch;

public class CyclicSearch {
    private int[][] dfa;
    private String pat;

    public CyclicSearch(String pat) {
        setPattern(pat);
    }

    public void setPattern(String pattern) {
        this.pat = pattern;
        int patternSize = pattern.length();
        dfa = new int[256][patternSize];
        dfa[pattern.charAt(0)][0] = 1;
        for (int i = 0, j = 1; j < patternSize; j++) {
            for (int c = 0; c < 256; c++)
                dfa[c][j] = dfa[c][i];
            dfa[pattern.charAt(j)][j] = j + 1;
            i = dfa[pattern.charAt(j)][i];
        }
    }

    public boolean search(String txt) {
        int M = pat.length();
        int N = txt.length();
        if (N != M)
            return false;
        txt = txt + txt;
        N = txt.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        return (j == M);
    }
}
