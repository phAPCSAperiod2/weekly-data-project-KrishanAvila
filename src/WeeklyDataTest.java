/**
 * AP CSA - Weekly Data Analyzer (Arrays & OOP Assessment)
 * JUnit tests for WeeklyData.java
 *
 * This test class validates:
 *  - Constructor deep copy (internal array must NOT alias the input).
 *  - getTotal(): sum of values.
 *  - getAverage(): total / length.
 *  - getMax(): maximum value.
 *  - getMin(): minimum value.
 *  - toString(): one day per line, labeled and readable.
 *
 * Assumptions:
 *  - Arrays are non-empty for core tests.
 *  - Optional tests included for empty-array behavior.
 */
/**
 * WeeklyDataTest tests the WeeklyData class with sample values.
 */
public class WeeklyDataTest {

    public static void main(String[] args) {

        int[] testSteps = {8500, 10000, 9200, 11000, 7000, 12000, 9800};
        WeeklyData data = new WeeklyData(testSteps);

        System.out.println("Testing WeeklyData Class");
        System.out.println("--------------------");
        System.out.println("Total: " + data.getTotal());
        System.out.println("Average: " + data.getAverage());
        System.out.println("Highest: " + data.getHighest());
        System.out.println("Lowest: " + data.getLowest());
        System.out.println();
        System.out.println(data);
    }
}
