package BagsQueuesStacks;

import java.util.Scanner;

public class Menu {
    public static Scanner userInp = new Scanner(System.in);
    public static String answer;

    public static void main(String args[]) {

        try {
            for (; ; ) {
                int exitStatus = 0;
                System.out.println("Choose an option:\n" +
                        "1.Deque\n" + "2.\n" + "3.\n" +
                        "4.\n" + "5.\n" + "6.\n" +
                        "7.\n" + "8.\n" + "9.\n" + "10.Exit\n");
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
                        dequeTest();
                        break;
                    case (2):

                        break;
                    case (3):

                        break;
                    case (4):

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
        System.out.println("Basic test result:\n");
        Deque<Integer> testDeque = new Deque<>();
        System.out.println(testDeque.isEmpty());
        System.out.println(testDeque.size());
        testDeque.pushLeft(6);
        testDeque.pushRight(7);
        testDeque.pushRight(8);
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
}


