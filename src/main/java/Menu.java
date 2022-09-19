import BagsQueuesStacks.Deque;
import BagsQueuesStacks.ResizeDeque;
import BalancedBinSearchTrees.RedBlackBSTVerified;
import BinSearchTrees.BSTLeveled;
import Sorts.CaliforniaElectionCandidate;

import java.util.*;

public class Menu {
    public static Scanner userInp = new Scanner(System.in);
    public static String answer;

    public static void main(String args[]) {

        try {
            for (; ; ) {
                int exitStatus = 0;
                System.out.println("Choose an option:\n" +
                        "1.Deque\n" + "2.CaliforniaElection\n" +
                        "3.BinTreePrint\n" + "4.RedBlackTreeVerification\n" +
                        "5.\n" + "6.\n" +
                        "7.\n" + "8.\n" +
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
                             if (choice!=1 && choice!=2)
                                 System.out.println("No such option, try again");
                             else break;
                        }
                        if (choice==1)
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

                        break;
                    case (6):

                        break;
                    case (7):

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
                if (choice>10) choice=0;
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
                if (choice>7) choice=0;
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
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void californiaElectionTest(){
        System.out.println("Initial list:");
        List<CaliforniaElectionCandidate> candidates= new ArrayList<>();
        CaliforniaElectionCandidate Billy = new CaliforniaElectionCandidate("vqr");
        CaliforniaElectionCandidate Bobby = new CaliforniaElectionCandidate("rwq");
        CaliforniaElectionCandidate Johnny = new CaliforniaElectionCandidate("awqh");
        CaliforniaElectionCandidate Timmy = new CaliforniaElectionCandidate("gzxh");
        candidates.add(Billy);
        candidates.add(Bobby);
        candidates.add(Johnny);
        candidates.add(Timmy);
        candidates.forEach(e ->System.out.println(e.getName()));
        Collections.sort(candidates);
        System.out.println("Resulting list (must be rwq, vqr, awqh, gzxh):");
        candidates.forEach(e ->System.out.println(e.getName()));
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
                if (choice>7) choice=0;
                switch (choice) {
                    case (0):
                        System.out.println("No such option, try again");
                        break;
                    case (1):
                        System.out.println("Input name\n");
                        candidates.add(new CaliforniaElectionCandidate(userInp.nextLine()));
                        break;
                    case (2):
                        Collections.sort(candidates);
                        candidates.forEach(e ->System.out.println(e.getName()));
                        break;
                    case (3):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public static void binTreesTest(){
        BSTLeveled tree = new BSTLeveled();
        tree.put(4,"q");
        tree.put(2,"w");
        tree.put(1,"e");
        tree.put(3,"r");
        tree.put(6,"t");
        tree.put(7,"y");
        tree.put(9,"u");
        tree.put(8,"i");
        tree.put(5,"o");
        tree.put(0,"p");
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
                if (choice>2) choice=0;
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
                        if (tree.getNodeByKey(choice)==null)
                            System.out.println("No such option, try again");
                        else tree.printLevel(tree.getNodeByKey(choice));
                        break;
                    case (2):
                        exitStatus = 1;
                        break;
                }
                if (exitStatus == 1) break;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public static void redBlackTreeVerificationTest(){
        RedBlackBSTVerified tree = new RedBlackBSTVerified();
        tree.put(4,"q");
        tree.put(2,"w");
        tree.put(1,"e");
        tree.put(3,"r");
        tree.put(6,"t");
        tree.put(7,"y");
        tree.put(9,"u");
        tree.put(8,"i");
        tree.put(5,"o");
        tree.put(0,"p");
        System.out.println(tree.check());
    }

}


