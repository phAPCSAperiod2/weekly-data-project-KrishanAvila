import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] weeklySteps = new int[7];
        final int DAILY_GOAL = 10000;

        System.out.println("Weekly Step Analyzer");
        System.out.println("--------------------");

        // Input with validation
        for (int i = 0; i < weeklySteps.length; i++) {
            System.out.print("Enter the number of steps for Day " + (i + 1) + ": ");

            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Enter a whole number: ");
                input.next();
            }

            int steps = input.nextInt();

            while (steps < 0) {
                System.out.print("Steps cannot be negative. Try again: ");
                steps = input.nextInt();
            }

            weeklySteps[i] = steps;
        }

        WeeklyData data = new WeeklyData(weeklySteps);

        // Output
        System.out.println("\nWeekly Summary");
        System.out.println("--------------------");
        System.out.println("Total Steps: " + data.getTotal());
        System.out.printf("Average Steps Per Day: %.2f\n", data.getAverage());
        System.out.println("Highest Day: " + data.getHighest());
        System.out.println("Lowest Day: " + data.getLowest());

        System.out.println();
        System.out.println(data);

        // Daily feedback
        System.out.println("Daily Goal Feedback (Goal: 10,000 steps)");
        System.out.println("--------------------");
        for (int i = 0; i < 7; i++) {
            System.out.println("Day " + (i + 1) + ": " + data.getDailyMessage(i, DAILY_GOAL));
        }

        // Weekly insight
        if (data.getAverage() >= DAILY_GOAL) {
            System.out.println("\nAmazing! You met your step goal on average this week!");
        } else {
            System.out.println("\nGood effort! Try adding a short walk each day next week.");
        }

        input.close();
    }
}
