package Sorts;

import static java.sql.Types.NULL;

public class CaliforniaElectionCandidate implements Comparable<CaliforniaElectionCandidate> {

    private final String candidateName;

    public String getName() {
        return candidateName;
    }

    public CaliforniaElectionCandidate(String name) {
        char[] letters = name.toCharArray();
        for (int j = 0; j < letters.length; j++){
            try{
                californiaAlphabet.valueOf(Character.toString(letters[j])).ordinal();
            } catch (Exception e){
                System.out.println("Name should contain only capital latin letters");
            }
        }
        candidateName = name;
    }

    enum californiaAlphabet {
        R, W, Q, O, J, M, V, A, H, B, S, G, Z, X, N, T, C, I, E, K, U, P, D, Y, F, L
        //A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
        //17 22 16 14 9  12 21 0  7  1  18 6  25 23 13 19 2  8  4  10 20 15 3  24 5  11
    }

    @Override
    public int compareTo(CaliforniaElectionCandidate another) {
        char[] letters = this.candidateName.toCharArray();
        for (int j = 0; j < letters.length; j++) {
            letters[j] = (char) (californiaAlphabet.
                    valueOf(Character.toString(letters[j])).
                    ordinal() + 65);
        }
        String one = String.valueOf(letters);
        letters = another.candidateName.toCharArray();
        for (int j = 0; j < letters.length; j++) {
            letters[j] = (char) (californiaAlphabet.
                    valueOf(Character.toString(letters[j])).
                    ordinal() + 65);
        }
        String two = String.valueOf(letters);
        return one.compareTo(two);
    }

}

