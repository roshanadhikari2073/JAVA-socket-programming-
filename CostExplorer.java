// Cost Explorer Development Task for a Payment Platform
// Objective: Develop a "Cost Explorer" feature for a payment platform. This feature should calculate the monthly cost of subscription-based services for each month in a year and provide the total cost for the year.

// Background: Atlassian, a software company, offers various subscription plans with different pricing tiers. The subscription plans and their respective monthly costs are as follows:

// Basic Plan: $9.99 per month
// Standard Plan: $49.99 per month
// Premium Plan: $249.99 per month
// Requirements:

// Date Range Filtering: The Cost Explorer must allow users to specify a start and end date for the cost calculation. The dates should be in a standard date-time format.
// Annual Cost Calculation: The output should include the cost for each month within the specified date range and the total cost for that period. Although the focus is on a 12-month period, the functionality should accommodate any specified date range within a year.
// Flexible Plan Options: The feature should be able to calculate costs for any of the provided subscription plans (Basic, Standard, Premium).
// Sample Test Case:

// Input: Subscription plan (e.g., Jira, Basic), Start date (e.g., 2024-01-01)
// Expected Output: A list of monthly costs for a 12-month period starting from the given date, followed by the sum of these costs as the annual total. For example, if the Basic plan is chosen with a start date of 2024-01-01, the output should be: [9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99], Total: 119.88
// Task: Create the functional logic in a programming language of your choice that fulfills the above requirements, ensuring accuracy and efficiency in the cost calculations.

//Author - Roshan Adhikari

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CostExplorer {

    // Prices tier constants
    private static final double BASIC = 9.99;
    private static final double STANDARD = 49.99;
    private static final double PREMIUM = 249.99;

    // Method to calculate the monthly and total costs
    public static List<Double> calculateCosts(String tier, LocalDate endDate) {
        double monthlyRate = getMonthlyRate(tier);
        List<Double> costs = new ArrayList<>();

        LocalDate currentDate = LocalDate.now(); // Use the current date as the start date

        // Calculate costs for each month from the current date up to but excluding the end date month
        while (currentDate.isBefore(endDate)) {
            costs.add(monthlyRate);
            currentDate = currentDate.plusMonths(1);
        }

        double totalCost = costs.stream().mapToDouble(Double::doubleValue).sum();

        // Add the total cost as the last element
        List<Double> result = new ArrayList<>(costs);
        result.add(totalCost);

        return result;
    }

    // Helper method to get the monthly rate based on the tier
    private static double getMonthlyRate(String tier) {
        if ("basic".equalsIgnoreCase(tier)) {
            return BASIC;
        } else if ("standard".equalsIgnoreCase(tier)) {
            return STANDARD;
        } else if ("premium".equalsIgnoreCase(tier)) {
            return PREMIUM;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // Example usage
        String tier = "Basic";
        LocalDate endDate = LocalDate.of(2024, 3, 30); // Example end date: March 1st, 2024

        // Calculate costs
        List<Double> costs = calculateCosts(tier, endDate);

        // Print monthly costs and total cost
        System.out.println("Monthly Costs: " + costs.subList(0, costs.size() - 1));
        System.out.println("Total Cost up to End Date: " + costs.get(costs.size() - 1));
    }
}
