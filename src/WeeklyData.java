/**
 * WeeklyData stores and analyzes daily step counts for one week.
 */
public class WeeklyData {

    /** Stores steps for 7 days */
    private int[] steps;

    /**
     * Constructor
     * Creates a deep copy of the provided array
     *
     * @param data array containing step counts
     */
    public WeeklyData(int[] data) {
        steps = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            steps[i] = data[i];
        }
    }

    /**
     * Calculates total steps for the week
     *
     * @return total steps
     */
    public int getTotal() {
        int total = 0;
        for (int daySteps : steps) {
            total += daySteps;
        }
        return total;
    }

    /**
     * Calculates average daily steps
     *
     * @return average steps per day
     */
    public double getAverage() {
        return (double) getTotal() / steps.length;
    }

    /**
     * Finds the highest step count
     *
     * @return highest steps in a day
     */
    public int getHighest() {
        int highest = steps[0];
        for (int daySteps : steps) {
            if (daySteps > highest) {
                highest = daySteps;
            }
        }
        return highest;
    }

    /**
     * Finds the lowest step count
     *
     * @return lowest steps in a day
     */
    public int getLowest() {
        int lowest = steps[0];
        for (int daySteps : steps) {
            if (daySteps < lowest) {
                lowest = daySteps;
            }
        }
        return lowest;
    }

    /**
     * Provides a motivational message based on daily goal
     *
     * @param dayIndex index of the day
     * @param goal daily step goal
     * @return message string
     */
    public String getDailyMessage(int dayIndex, int goal) {
        if (steps[dayIndex] >= goal) {
            return "Congratulations! You reached your step goal!";
        } else {
            return "Keep going! Tomorrow is another chance.";
        }
    }
    @Override
    public String toString() {
        String result = "All Daily Step Counts:\n";
        for (int i = 0; i < steps.length; i++) {
            result += "Day " + (i + 1) + ": " + steps[i] + " steps\n";
        }
        return result;
    }
}
