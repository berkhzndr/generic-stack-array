package MainPackage;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        StackArray sa = new StackArray(15);

        Scanner intg = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        System.out.println("1- Push\n"
                + "2- Pop\n"
                + "3- Print\n"
                + "4- Delete middle\n"
                + "5- isPalindrome\n"
                + "6- Exit\n"
                + "Which task you want to do?");

        int inputFirst;

        do {
            System.out.println("Please enter a digit.(1-5)");
            try {
                inputFirst = intg.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error! You've entered wrong type of input.");
                break;
            }

            if (inputFirst == 1) { //push
                System.out.println("How many pushes you want to do?");
                int input1 = intg.nextInt();

                System.out.println("Enter " + input1 + " inputs.");
                for (int i = 0; i < input1; i++) {
                    Object strElement = (Object) str.next();
                    sa.push(strElement);
                }
                sa.print();

            } else if (inputFirst == 2) { //pop

                try {
                    sa.pop();
                    System.out.println("Top element: \n" +
                            sa.data[(sa.top) + 1] + "\n" +
                            "has removed.");
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    System.out.println("Stack is empty.");
                }

            } else if (inputFirst == 3) { //print
                sa.print();

            } else if (inputFirst == 4) { //delete middle
                int firstTop = sa.top;

                sa.deleteMiddle();

                int secondTop = sa.top;

                if (firstTop - secondTop == 1) { //double check
                    System.out.println("The middle element has been deleted.");
                }

            } else if (inputFirst == 5) { // is palindrome
                if (sa.isPalindrome()) {
                    System.out.println("The stack is palindrome.");
                } else {
                    System.out.println("The stack is not palindrome.");
                }

            } else if (inputFirst == 6) {
                System.out.println("Exiting...");
            }

        } while (inputFirst != 6);

    }

}