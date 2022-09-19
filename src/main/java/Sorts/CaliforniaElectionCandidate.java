package Sorts;

public class CaliforniaElectionCandidate implements Comparable<CaliforniaElectionCandidate> {

    private final  String candidateName;

    public String getName(){
        return candidateName;
    }

    public CaliforniaElectionCandidate(String name) {
        candidateName = name;
    }

    enum californiaAlphabet {
        r, w, q, o, j, m, v, a, h, b, s, g, z, x, n, t, c, i, e, k, u, p, d, y, f, l
        //a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
        //17 22 16 14 9  12 21 0  7  1  18 6  25 23 13 19 2  8  4  10 20 15 3  24 5  11
    }

    @Override
    public int compareTo(CaliforniaElectionCandidate another) {
        char[] letters = this.candidateName.toCharArray();
        for (int j = 0; j < letters.length; j++) {
            letters[j] = (char) (californiaAlphabet.
                    valueOf(Character.toString(letters[j])).
                    ordinal() + 97);
        }
        String one = String.valueOf(letters);
        letters = another.candidateName.toCharArray();
        for (int j = 0; j < letters.length; j++) {
            letters[j] = (char) (californiaAlphabet.
                    valueOf(Character.toString(letters[j])).
                    ordinal() + 97);
        }
        String two = String.valueOf(letters);
        return one.compareTo(two);
    }

}

