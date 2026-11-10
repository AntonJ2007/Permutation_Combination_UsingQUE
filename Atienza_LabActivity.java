package atienza_lab_act;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Atienza_LabActivity {

    static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String element = input.next();

            queue.add(element);
        }

        System.out.println("Elements successfully added to Queue.");
    }

    // TODO 2: Display all elements in the Queue
    static void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue: " + queue);

        System.out.println("Front element: " + queue.peek());

        // Dequeue two elements
        System.out.println("\nDequeue two elements:");

        for (int i = 0; i < 2; i++) {

            if (!queue.isEmpty()) {
                System.out.println("Removed: " + queue.poll());
            }
        }

        System.out.println("Updated Queue: " + queue);
    }

    // TODO 3: Generate all possible permutations
    static void generatePermutations() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Enter number of elements to arrange: ");
        int r = input.nextInt();

        String[] elements = queue.toArray(new String[0]);

        if (r < 1 || r > elements.length) {
            System.out.println("Invalid number of elements!");
            return;
        }

        int[] count = {0};

        System.out.println("\nPermutations:");

        permutation(elements, new boolean[elements.length],
                    "", r, count);

        System.out.println("\nTotal Permutations: " + count[0]);
    }

    // Recursive permutation algorithm
    static void permutation(String[] elements, boolean[] used,
                            String result, int r, int[] count) {

        if (result.length() == r) {
            System.out.println(result);
            count[0]++;
            return;
        }

        for (int i = 0; i < elements.length; i++) {

            if (!used[i]) {

                used[i] = true;

                permutation(elements, used,
                        result + elements[i], r, count);

                used[i] = false;
            }
        }
    }

    // TODO 4: Generate all possible combinations
    static void generateCombinations() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Enter number of elements to select: ");
        int r = input.nextInt();

        String[] elements = queue.toArray(new String[0]);

        if (r < 1 || r > elements.length) {
            System.out.println("Invalid number of elements!");
            return;
        }

        int[] count = {0};

        System.out.println("\nCombinations:");

        combination(elements, 0, "", r, count);

        System.out.println("\nTotal Combinations: " + count[0]);
    }

    // Recursive combination algorithm
    static void combination(String[] elements, int start,
                            String result, int r, int[] count) {

        if (result.length() == r) {
            System.out.println(result);
            count[0]++;
            return;
        }

        for (int i = start; i < elements.length; i++) {

            combination(elements, i + 1,
                    result + elements[i], r, count);
        }
    }
}
