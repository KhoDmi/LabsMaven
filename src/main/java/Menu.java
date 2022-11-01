import BagsQueuesStacks.Deque;
import BagsQueuesStacks.ResizeDeque;
import BalancedBinSearchTrees.RedBlackBSTVerified;
import BinSearchTrees.BSTLeveled;
import HashTable.LinearProbingLD;
import Sorts.CaliforniaElectionCandidate;
import StringSorts.Alphabet;
import StringSorts.LSDSort;
import StringSorts.MSDSort;
import SubstringSearch.CyclicSearch;
import TernarySearchTrees.TST;


import java.util.*;
import java.util.regex.Pattern;

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
                        "7.NumberOfLStrings\n" + "8.CyclicSearch\n" +
                        "9.RegularExpressions\n" + "10.Exit\n");
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
                        testCyclicSearch();
                        break;
                    case (9):
                        testRegEx();
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
                        try {
                            candidates.add(new CaliforniaElectionCandidate(inp));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
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
        BSTLeveled<Integer, String> tree = new BSTLeveled<>();
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
                System.out.println("----------\n" +
                        "List of options :\n" +
                        "1.Choose another key\n" + "2.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void redBlackTreeVerificationTest() {
        RedBlackBSTVerified<Integer, String> tree = new RedBlackBSTVerified<>();
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
        System.out.println(tree.isRedBlackBST());
        System.out.println("List of options :\n" +
                "1.Add new element\n" + "2.Delete element\n" +
                "3.Check tree\n" + "4.Exit\n");
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
                if (choice > 4) choice = 0;
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
                            System.out.println("Illegal key");
                            break;
                        }
                        System.out.println("Input value\n");
                        answer = "";
                        while (answer.equals("")) {
                            answer = userInp.nextLine();
                        }
                        tree.put(choice, answer);
                        break;
                    case (2):
                        System.out.println("Input key\n");
                        answer = userInp.nextLine();
                        try {
                            choice = Integer.parseInt(answer);
                        } catch (NumberFormatException e) {
                            System.out.println("Illegal key");
                            break;
                        }
                        if (!tree.contains(choice)) {
                            System.out.println("no such key");
                            break;
                        }
                        tree.delete(choice);
                        break;
                    case (3):
                        System.out.println(tree.isRedBlackBST());
                        break;
                    case (4):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------\n" +
                        "List of options :\n" +
                        "1.Add new element\n" + "2.Delete element\n" +
                        "3.Check tree\n" + "4.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void linearProbingLDTest() {
        LinearProbingLD<String, Integer> ht = new LinearProbingLD<>();
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
        ht.put("a",1);
        ht.delete("m");
        ht.put("m",2);
        ht.delete("p");
        ht.put("p",3);
        ht.delete("l");
        ht.delete("e");
        ht.put("l",4);
        ht.put("e",5);
        System.out.println("Table size after 6 Lazy deletions and 5 rewrites :" + ht.size());
        ht.delete("a");
        ht.delete("m");
        ht.delete("p");
        ht.delete("l");
        ht.delete("e");
        System.out.println("Table size after 5 more Lazy deletions (which leads to resize):" + ht.size());
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
        try {
            LSDSort.sort(alpha, arrayToSortLSD, 3);
            System.out.print("Sorted LSD array:");
            for (String s : arrayToSortLSD) {
                System.out.print(" " + s);
            }
            System.out.println();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
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
        try {
            MSDSort.sort(alpha, arrayToSortMSD);
            System.out.print("Sorted MSD array:");
            for (String s : arrayToSortMSD) {
                System.out.print(" " + s);
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("----------");
    }

    public static void numOfSubstrings(String s, int L) {
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
        String s = "cgcgggcgcg";
        int L = 3;
        numOfSubstrings(s, L);
        System.out.println("List of options :\n" +
                "1.Check another string\n" + "2.Exit\n");
        try {
            int exitStatus = 0;
            for (; ; ) {
                answer = userInp.nextLine();
                int choice;
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
                        answer = "";
                        while (answer.equals("")) {
                            answer = userInp.nextLine();
                        }
                        s = answer;
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

                        numOfSubstrings(s, L);
                        break;
                    case (2):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------\n" +
                        "List of options :\n" +
                        "1.Check another string\n" + "2.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void testCyclicSearch() {
        CyclicSearch srch = new CyclicSearch("string");
        System.out.println("Word 1: string");
        System.out.print("Word 2: 'trings' - ");
        System.out.println(srch.search("trings"));
        System.out.print("Word 2: 'string ' - ");
        System.out.println(srch.search("string "));
        System.out.print("Word 2: 'strings' - ");
        System.out.println(srch.search("strings"));
        System.out.print("Word 2: 'ingstr' - ");
        System.out.println(srch.search("ingstr"));
        System.out.println("List of options :\n" +
                "1.Change word 1\n" + "2.Search word 2\n" +
                "3.Exit");
        try {
            int exitStatus = 0;
            for (; ; ) {
                answer = userInp.nextLine();
                int choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = -1;
                }
                if (choice > 3) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println("Input string\n");
                        answer = "";
                        while (answer.equals("")) {
                            answer = userInp.nextLine();
                        }
                        srch.setPattern(answer);
                        break;
                    case (2):
                        System.out.println("Input string\n");
                        answer = "";
                        while (answer.equals("")) {
                            answer = userInp.nextLine();
                        }
                        System.out.println(srch.search(answer));
                        break;
                    case (3):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("----------\n" +
                        "List of options :\n" +
                        "1.Change word 1\n" + "2.Search word 2\n" +
                        "3.Exit");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void testRegEx() {
        System.out.println("Any string except 11 and 111");
        String patOne = ".|(((11.0)|(110.)|(0.)|(10)|((11){2}))+.*)";
        System.out.println("111 " + Pattern.matches(patOne, "111"));//false
        System.out.println("11 " + Pattern.matches(patOne, "11"));//false
        System.out.println("1 " + Pattern.matches(patOne, "1"));//true
        System.out.println("01 " + Pattern.matches(patOne, "01"));//true
        System.out.println("011 " + Pattern.matches(patOne, "011"));//true
        System.out.println("00 " + Pattern.matches(patOne, "00"));//true
        System.out.println("10 " + Pattern.matches(patOne, "10"));//true
        System.out.println("1110 " + Pattern.matches(patOne, "1110"));//true
        System.out.println("1111 " + Pattern.matches(patOne, "1111"));//true
        System.out.println("01111 " + Pattern.matches(patOne, "01111"));//true
        System.out.println("111111 " + Pattern.matches(patOne, "111111"));//true
        System.out.println("\n1s at every odd position");
        String patTwo = "(1.)+1?";
        System.out.println("0 " + Pattern.matches(patTwo, "0"));//false
        System.out.println("01 " + Pattern.matches(patTwo, "01"));//false
        System.out.println("101001 " + Pattern.matches(patTwo, "101001"));//false
        System.out.println("01110 " + Pattern.matches(patTwo, "01110"));//false
        System.out.println("011 " + Pattern.matches(patTwo, "011"));//false
        System.out.println("00 " + Pattern.matches(patTwo, "00"));//false
        System.out.println("10 " + Pattern.matches(patTwo, "10"));//true
        System.out.println("1110 " + Pattern.matches(patTwo, "1110"));//true
        System.out.println("1111 " + Pattern.matches(patTwo, "1111"));//true
        System.out.println("101111 " + Pattern.matches(patTwo, "101111"));//true
        System.out.println("1011101 " + Pattern.matches(patTwo, "1011101"));//true
        System.out.println("\nAt least two 0s and not more than one 1");
        String patThree = "(1?00+)|(0+1?0+)|(00+1?)";
        System.out.println("0 " + Pattern.matches(patThree, "0"));//false
        System.out.println("01 " + Pattern.matches(patThree, "01"));//false
        System.out.println("100001 " + Pattern.matches(patThree, "100001"));//false
        System.out.println("1010 " + Pattern.matches(patThree, "1010"));//false
        System.out.println("011 " + Pattern.matches(patThree, "011"));//false
        System.out.println("0001 " + Pattern.matches(patThree, "0001"));//true
        System.out.println("010 " + Pattern.matches(patThree, "010"));//true
        System.out.println("001 " + Pattern.matches(patThree, "001"));//true
        System.out.println("00 " + Pattern.matches(patThree, "00"));//true
        System.out.println("100 " + Pattern.matches(patThree, "100"));//true
        System.out.println("00000000 " + Pattern.matches(patThree, "00000000"));//true
        System.out.println("00001000 " + Pattern.matches(patThree, "00001000"));//true
        System.out.println("\nNo double 1s");
        String patFour = ".?((01)|(0))*0?";
        System.out.println("1011 " + Pattern.matches(patFour, "1011"));//false
        System.out.println("11001 " + Pattern.matches(patFour, "11001"));//false
        System.out.println("0011 " + Pattern.matches(patFour, "0011"));//false
        System.out.println("01011 " + Pattern.matches(patFour, "01011"));//false
        System.out.println("1 " + Pattern.matches(patFour, "1"));//true
        System.out.println("01 " + Pattern.matches(patFour, "01"));//true
        System.out.println("101 " + Pattern.matches(patFour, "101"));//true
        System.out.println("001 " + Pattern.matches(patFour, "001"));//true
        System.out.println("00 " + Pattern.matches(patFour, "00"));//true
        System.out.println("100 " + Pattern.matches(patFour, "100"));//true
        System.out.println("101010 " + Pattern.matches(patFour, "101010"));//true
        System.out.println("0101001 " + Pattern.matches(patFour, "0101001"));//true

        System.out.println("List of options :\n" +
                "1.Test 1st expression\n" + "2.Test 2nd expression\n" +
                "3.Test 3d expression\n" + "4.Test 4th expression\n" +
                "5.Exit\n");
        try {
            int exitStatus = 0;
            for (; ; ) {
                answer = userInp.nextLine();
                int goodAnswer;
                int choice;
                try {
                    choice = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    choice = -1;
                }
                if (choice > 5) choice = 0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println("Any string except 11 and 111");
                        System.out.println("Input string\n");
                        answer = userInp.nextLine();
                        goodAnswer = 1;
                        for (int i = 0; i < answer.length(); i++) {
                            if (answer.charAt(i) != '1' && answer.charAt(i) != '0') {
                                goodAnswer = 0;
                                break;
                            }
                        }
                        if (goodAnswer == 1)
                            System.out.println(Pattern.matches(patOne, answer));
                        else
                            System.out.println("Number must be binary");
                        break;
                    case (2):
                        System.out.println("1s at every odd position");
                        System.out.println("Input string\n");
                        answer = userInp.nextLine();
                        goodAnswer = 1;
                        for (int i = 0; i < answer.length(); i++) {
                            if (answer.charAt(i) != '1' && answer.charAt(i) != '0') {
                                goodAnswer = 0;
                                break;
                            }
                        }
                        if (goodAnswer == 1)
                            System.out.println(Pattern.matches(patTwo, answer));
                        else
                            System.out.println("Number must be binary");
                        break;
                    case (3):
                        System.out.println("At least two 0s and not more than one 1");
                        System.out.println("Input string\n");
                        answer = userInp.nextLine();
                        goodAnswer = 1;
                        for (int i = 0; i < answer.length(); i++) {
                            if (answer.charAt(i) != '1' && answer.charAt(i) != '0') {
                                goodAnswer = 0;
                                break;
                            }
                        }
                        if (goodAnswer == 1)
                            System.out.println(Pattern.matches(patThree, answer));
                        else
                            System.out.println("Number must be binary");
                        break;
                    case (4):
                        System.out.println("No double 1s");
                        System.out.println("Input string\n");
                        answer = userInp.nextLine();
                        goodAnswer = 1;
                        for (int i = 0; i < answer.length(); i++) {
                            if (answer.charAt(i) != '1' && answer.charAt(i) != '0') {
                                goodAnswer = 0;
                                break;
                            }
                        }
                        if (goodAnswer == 1)
                            System.out.println(Pattern.matches(patFour, answer));
                        else
                            System.out.println("Number must be binary");
                        break;
                    case (5):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
                System.out.println("List of options :\n" +
                        "1.Test 1st expression\n" + "2.Test 2nd expression\n" +
                        "3.Test 3d expression\n" + "4.Test 4th expression\n" +
                        "5.Exit\n");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}


