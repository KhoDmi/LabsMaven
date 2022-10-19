import BagsQueuesStacks.Deque;
import BagsQueuesStacks.ResizeDeque;
import BalancedBinSearchTrees.RedBlackBSTVerified;
import BinSearchTrees.BSTLeveled;
import HashTable.LinearProbingLD;
import Sorts.CaliforniaElectionCandidate;
import StringSorts.Alphabet;
import StringSorts.LSDsort;
import StringSorts.MSDsort;
import TernarySearchTrees.TST;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

public class Menu {
    public static Scanner userInp = new Scanner(System.in);
    public static String answer;

    public static void main(String[] args) {

        try {
            for (; ; ) {
                int exitStatus = 0;
                System.out.println("Choose an option:\n" +
                        "1.Deque\n" + "2.CaliforniaElection\n" +
                        "3.BinTreePrint\n" + "4.RedBlackTreeVerification\n" +
                        "5.LazyDeletion\n" + "6.Alphabet\n" +
                        "7.NumberOfLStrings\n" + "8.\n" +
                        "9.\n" + "10.Exit\n");
                answer = userInp.nextLine();
                int choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = 0;
                }
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        for (; ; ) {
                            System.out.println("1.Doubly linked list or 2.Resizing array?");
                            try {
                                answer = userInp.nextLine();
                                choice = Integer.parseInt(answer);
                            } catch (NumberFormatException e) {
                                choice = 0;
                            }
                            if (choice != 1 && choice != 2)
                                System.out.println("No such option, try again");
                            else break;
                        }
                        if (choice == 1)
                            dequeTest();
                        else resizeDequeTest();
                        break;
                    case (2):
                        californiaElectionTest();
                        break;
                    case (3):
                        binTreesTest();
                        break;
                    case (4):
                        redBlackTreeVerificationTest();
                        break;
                    case (5):
                        linearProbingLDTest();
                        break;
                    case (6):
                        alphabetTest();
                        break;
                    case (7):
                        testNumIfLStr();
                        break;
                    case (8):

                        break;
                    case (9):

                        break;
                    case (10):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }


    }

    public static void dequeTest() {
        System.out.println("Basic test result (expected: true 0 5 6 7 8 OK):");
        Deque<Integer> testDeque = new Deque<>();
        System.out.println(testDeque.isEmpty());
        System.out.println(testDeque.size());
        testDeque.pushLeft(6);
        testDeque.pushRight(8);
        testDeque.pushRight(7);
        testDeque.pushLeft(5);
        try {
            System.out.println(testDeque.popLeft());
            System.out.println(testDeque.popLeft());
            System.out.println(testDeque.popRight());
            System.out.println(testDeque.popRight());
        } catch (NullPointerException e) {
            System.out.println("Deque is empty\n");
        }
        System.out.println("OK\n");

        System.out.println("List of options :\n" +
                "1.isEmpty()\n" + "2.size()\n" +
                "3.pushLeft(String string)\n" +
                "4.pushRight(String string)\n" +
                "5.popLeft()\n" + "6.popRight\n" + "7.Exit\n");
        try {
            int exitStatus = 0;
            Deque<String> manualTestDeque = new Deque<>();
            for (; ; ) {
                answer = userInp.nextLine();
                int choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = 0;
                }
                if (choice > 10) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println(manualTestDeque.isEmpty());
                        break;
                    case (2):
                        System.out.println(manualTestDeque.size());
                        break;
                    case (3):
                        System.out.println("Input string to push left:\n");
                        manualTestDeque.pushLeft(userInp.nextLine());
                        break;
                    case (4):
                        System.out.println("Input string to push right:\n");
                        manualTestDeque.pushRight(userInp.nextLine());
                        break;
                    case (5):
                        try {
                            System.out.println(manualTestDeque.popLeft());
                        } catch (NullPointerException e) {
                            System.out.println("Deque is empty\n");
                        }
                        break;
                    case (6):
                        try {
                            System.out.println(manualTestDeque.popRight());
                        } catch (NullPointerException e) {
                            System.out.println("Deque is empty\n");
                        }
                        break;
                    case (7):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------\n" +
                        "List of options :\n" +
                        "1.isEmpty()\n" + "2.size()\n" +
                        "3.pushLeft(String string)\n" +
                        "4.pushRight(String string)\n" +
                        "5.popLeft()\n" + "6.popRight\n" + "7.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void resizeDequeTest() {
        System.out.println("Basic test result (expected: true 0 5 6 7 8 OK):");
        ResizeDeque<Integer> resizeDequeTest = new ResizeDeque<>();
        System.out.println(resizeDequeTest.isEmpty());
        System.out.println(resizeDequeTest.size());
        resizeDequeTest.pushLeft(6);
        resizeDequeTest.pushRight(8);
        resizeDequeTest.pushRight(7);
        resizeDequeTest.pushLeft(5);
        try {
            System.out.println(resizeDequeTest.popLeft());
            System.out.println(resizeDequeTest.popLeft());
            System.out.println(resizeDequeTest.popRight());
            System.out.println(resizeDequeTest.popRight());
        } catch (NullPointerException e) {
            System.out.println("Deque is empty\n");
        }
        System.out.println("OK\n");

        System.out.println("List of options :\n" +
                "1.isEmpty()\n" + "2.size()\n" +
                "3.pushLeft(String string)\n" +
                "4.pushRight(String string)\n" +
                "5.popLeft()\n" + "6.popRight\n" + "7.Exit\n");
        try {
            int exitStatus = 0;
            ResizeDeque<String> manualResizeTestDeque = new ResizeDeque<>();
            for (; ; ) {
                answer = userInp.nextLine();
                int choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = 0;
                }
                if (choice > 7) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println(manualResizeTestDeque.isEmpty());
                        break;
                    case (2):
                        System.out.println(manualResizeTestDeque.size());
                        break;
                    case (3):
                        System.out.println("Input string to push left:\n");
                        manualResizeTestDeque.pushLeft(userInp.nextLine());
                        break;
                    case (4):
                        System.out.println("Input string to push right:\n");
                        manualResizeTestDeque.pushRight(userInp.nextLine());
                        break;
                    case (5):
                        try {
                            System.out.println(manualResizeTestDeque.popLeft());
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Deque is empty\n");
                        }
                        break;
                    case (6):
                        try {
                            System.out.println(manualResizeTestDeque.popRight());
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Deque is empty\n");
                        }
                        break;
                    case (7):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------\n" +
                        "List of options :\n" +
                        "1.isEmpty()\n" + "2.size()\n" +
                        "3.pushLeft(String string)\n" +
                        "4.pushRight(String string)\n" +
                        "5.popLeft()\n" + "6.popRight\n" + "7.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void californiaElectionTest() {
        System.out.println("Initial list:");
        List<CaliforniaElectionCandidate> candidates = new ArrayList<>();
        CaliforniaElectionCandidate Billy = new CaliforniaElectionCandidate("VQR");
        CaliforniaElectionCandidate Bobby = new CaliforniaElectionCandidate("RWQ");
        CaliforniaElectionCandidate Johnny = new CaliforniaElectionCandidate("AWQH");
        CaliforniaElectionCandidate Timmy = new CaliforniaElectionCandidate("GZXH");
        candidates.add(Billy);
        candidates.add(Bobby);
        candidates.add(Johnny);
        candidates.add(Timmy);
        candidates.forEach(e -> System.out.println(e.getName()));
        Collections.sort(candidates);
        System.out.println("Resulting list (must be RWQ, VQR, AWQH, GZXH):");
        candidates.forEach(e -> System.out.println(e.getName()));
        System.out.println("List of options :\n" +
                "1.addNewCandidate\n" + "2.sort\n" +
                "3.Exit\n");
        try {
            int exitStatus = 0;
            for (; ; ) {
                answer = userInp.nextLine();
                int choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = 0;
                }
                if (choice > 7) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println("Input name\n");
                        String inp = userInp.nextLine();
                        inp = inp.toUpperCase();
                        char[] letters = inp.toCharArray();
                        int i = 0;
                        for (i = 0; i < inp.length(); i++) {
                            if ((int) letters[i] < 65 || (int) letters[i] > 90)
                                break;
                        }
                        if (i < inp.length()) {
                            System.out.println("String should contain only capital latin letters");
                            break;
                        }
                        candidates.add(new CaliforniaElectionCandidate(inp));
                        break;
                    case (2):
                        Collections.sort(candidates);
                        candidates.forEach(e -> System.out.println(e.getName()));
                        break;
                    case (3):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("-----------\n" +
                        "List of options :\n" +
                        "1.addNewCandidate\n" + "2.sort\n" +
                        "3.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void binTreesTest() {
        BSTLeveled tree = new BSTLeveled();
        tree.put(4, "q");
        tree.put(2, "w");
        tree.put(1, "e");
        tree.put(3, "r");
        tree.put(6, "t");
        tree.put(7, "y");
        tree.put(9, "u");
        tree.put(8, "i");
        tree.put(5, "o");
        tree.put(0, "p");
        System.out.println("Initial tree:");
        tree.printLevel(tree.getNodeByKey(4));
        System.out.println("List of options :\n" +
                "1.Choose another key\n" + "2.Exit\n");
        try {
            int exitStatus = 0;
            for (; ; ) {
                answer = userInp.nextLine();
                Integer choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = -1;
                }
                if (choice > 2) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println("Input key\n");
                        answer = userInp.nextLine();
                        try {
                            choice = Integer.parseInt(answer);
                        } catch (NumberFormatException e) {
                            choice = null;
                        }
                        if (tree.getNodeByKey(choice) == null)
                            System.out.println("No such option, try again");
                        else tree.printLevel(tree.getNodeByKey(choice));
                        break;
                    case (2):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------" +
                        "List of options :\n" +
                        "1.Choose another key\n" + "2.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void redBlackTreeVerificationTest() {
        RedBlackBSTVerified tree = new RedBlackBSTVerified();
        tree.put(4, "q");
        tree.put(2, "w");
        tree.put(1, "e");
        tree.put(3, "r");
        tree.put(6, "t");
        tree.put(7, "y");
        tree.put(9, "u");
        tree.put(8, "i");
        tree.put(5, "o");
        tree.put(0, "p");
        System.out.println(tree.check());
    }

    public static void linearProbingLDTest() {
        LinearProbingLD ht = new LinearProbingLD<>();
        ht.put("s", 1);
        ht.put("e", 2);
        ht.put("a", 3);
        ht.put("r", 4);
        ht.put("c", 5);
        ht.put("h", 6);
        ht.put("e", 7);
        ht.put("x", 8);
        ht.put("a", 9);
        ht.put("m", 10);
        ht.put("p", 11);
        ht.put("l", 12);
        ht.put("e", 13);
        System.out.println("Table size:" + ht.size());
        ht.delete("x");
        System.out.println("Table size after 1 Lazy deletion:" + ht.size());
        ht.delete("a");
        ht.delete("m");
        ht.delete("p");
        ht.delete("l");
        ht.delete("e");
        System.out.println("Table size after 6 Lazy deletions (which leads to resize):" + ht.size());
    }

    public static void alphabetTest() {
        Alphabet alpha = new Alphabet("zyxwvutsrqponmlkjihgfedcba");
        String[] arrayToSortLSD = new String[8];
        System.out.println("Initial LSD array: hat, rat, pet, dad, fat, cat, yep, yet");
        arrayToSortLSD[0] = "hat";
        arrayToSortLSD[1] = "rat";
        arrayToSortLSD[2] = "pet";
        arrayToSortLSD[3] = "dad";
        arrayToSortLSD[4] = "fat";
        arrayToSortLSD[5] = "cat";
        arrayToSortLSD[6] = "yep";
        arrayToSortLSD[7] = "yet";
        LSDsort.sort(alpha, arrayToSortLSD, 3);
        System.out.print("Sorted LSD array:");
        for (String s : arrayToSortLSD) {
            System.out.print(" " + s);
        }
        System.out.println();
        System.out.println("----------");

        String[] arrayToSortMSD = new String[14];
        System.out.println("Initial MSD array: she, sells, seashells, by, the, sea, shore, the, shells, she, sells," +
                " are, surely, seashells");
        arrayToSortMSD[0] = "she";
        arrayToSortMSD[1] = "sells";
        arrayToSortMSD[2] = "seashells";
        arrayToSortMSD[3] = "by";
        arrayToSortMSD[4] = "the";
        arrayToSortMSD[5] = "sea";
        arrayToSortMSD[6] = "shore";
        arrayToSortMSD[7] = "the";
        arrayToSortMSD[8] = "shells";
        arrayToSortMSD[9] = "she";
        arrayToSortMSD[10] = "sells";
        arrayToSortMSD[11] = "are";
        arrayToSortMSD[12] = "surely";
        arrayToSortMSD[13] = "seashells";
        MSDsort.sort(alpha, arrayToSortMSD);
        System.out.print("Sorted MSD array:");
        for (String s : arrayToSortMSD) {
            System.out.print(" " + s);
        }
        System.out.println();
        System.out.println("----------");
    }

    public static void numOfSubstrings(@NotNull String s, int L) {
        TST<Integer> tst = new TST<>();
        tst.clear();
        int num = 0;
        String subs;
        for (int i = 0; i < s.length() - L; i++) {
            subs = s.substring(i, i + L);
            if (tst.containsNullKey(subs))
                continue;
            tst.put(subs, null);
            num++;
            System.out.print("Unique key " + num + ": ");
            System.out.println(subs);
        }
        tst.clear();
        System.out.println("Number of " + L + "-letter substrings in string " + s + " is: " + num);
    }
    public static void testNumIfLStr() {
        TST<Integer> tst = new TST<>();
        String s="cgcgggcgcg";
        Integer L=3;
        numOfSubstrings(s,L);
        System.out.println("List of options :\n" +
                "1.Check another string\n" + "2.Exit\n");
        try {
            int exitStatus = 0;
            for (; ; ) {
                answer = userInp.nextLine();
                Integer choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = -1;
                }
                if (choice > 2) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println("Input string\n");
                        answer="";
                        while (answer.equals("")){
                            answer = userInp.nextLine();
                        }
                        s=answer;
                        L = 0;

                        System.out.println("Input length of substrings\n");
                        while (L < 1) {
                            answer = userInp.nextLine();
                            try {
                                L = Integer.parseInt(answer);
                            } catch (NumberFormatException e) {
                                L = 0;
                                System.out.println("Illegal option, try again\n");
                            }
                        }

                        numOfSubstrings(s,L);
                        break;
                    case (2):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------" +
                        "List of options :\n" +
                        "1.Check another string\n" + "2.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}


