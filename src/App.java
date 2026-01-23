import java.util.Scanner;

/**
 * The App class serves as the main entry point for the Weekly Step Analyzer application.
 * It collects daily step counts from the user, validates the input, and displays a comprehensive
 * weekly summary including total steps, average, highest and lowest days, and personalized feedback
 * based on a user-defined daily goal.
 *
 * @author Krishan Avila
 * @version 1.0
 */
public class App {

    /**
     * The main method is the entry point of the application.
     * It prompts the user to enter step counts for each day of the week,
     * validates the input, creates a WeeklyData object to analyze the data,
     * and displays a detailed weekly summary with personalized feedback.
     *
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] weeklySteps = new int[7];

        System.out.println("Weekly Step Analyzer");
        System.out.println("--------------------");
        
        // Get user's daily goal
        System.out.print("Enter your daily step goal: ");
        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Enter a whole number: ");
            input.next();
        }
        int DAILY_GOAL = input.nextInt();
        
        while (DAILY_GOAL < 0) {
            System.out.print("Goal cannot be negative. Try again: ");
            DAILY_GOAL = input.nextInt();
        }

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
        System.out.println("Daily Goal Feedback (Goal: " + DAILY_GOAL + " steps)");
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
