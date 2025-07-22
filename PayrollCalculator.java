import java.lang.reflect.Type;
import java.net.Proxy;

public class PayrollCalculator {

    public static double CalculateWeekPay(String employType, double hours, double Rate) {
        if (hours < 0|| Rate < 0){
            System.out.println("error:not allowed");
            return  0;
        }
        switch (employType) {
            case "fullTime":
                if (hours <= 40)
                    return hours * Rate;
                else
                    return 40 * Rate + (hours - 40) * Rate * 1.5;

            case "PartTime":
                if (hours > 25) hours = 25;
                return hours * Rate;

            case "Contractor":
                return hours * Rate;

            case "Intern":
                if (hours > 20) hours = 20;
                return hours * Rate * 0.8;

            default:
                System.out.println("Employee Type:" + employType);
                return 0;


        }
    }

    public static double CalculateTax(double grossPay, boolean hasHealthInsurance) {
        double Tax;
        if (grossPay <= 500)
            Tax = grossPay * 0.10;
        else if (grossPay<= 1000)
            Tax = grossPay * 0.15;
        else if (grossPay<= 2000)
            Tax = grossPay * 0.20;

        else
            Tax = grossPay* 0.25;
        if (hasHealthInsurance)
            Tax -= 50;
        return Math.max(0, Tax);
    }

    public static void processPayroll(String types, double hours, double Rates, String names) {
        int count = Math.min(Math.min(types.length, hours.length), Math.min(rates.length, names.length));
        double totalPay = 0;
        int overtimeCount = 0;

        String highestPaid = "";
        String lowestPaid = "";
        double maxPay = 0;
        double minPay = Double.MAX_VALUE;

        System.out.println("%-10s%-12s%-6s%-7s%-14s%-5s/n", "Name", "Type", "hours", "rate", "pay", "Tax");

        for (int i = 0; i < count; i++) {
            double pay =CalculateWeekPay(types[i], hours[i], rates[i]);
            double tax =CalculateTax (pay, true);
            totalPay += pay;

            if (pay > maxPay) {
                maxPay = pay;
                highestPaid = names[i];

            }
            if (pay < minPay) {
                minPay = pay;
                lowestPaid = names[i];

            }
            if (types[i].equals("fullTime") && hours[i] > 40) {
                overtimeCount++;
            }
            System.out.println("%-10s%-12s%-6s%-7.3f%-14.2f%-5.1f/n", names[i], types[i], hours[i], rate[i], pay, tax);
        }
        System.out.println(" Payroll ");
        System.out.println("Highest Paid: " + highestPaid + " ($" + maxPay + ")");
        System.out.println("Lowest Paid: " + lowestPaid + " ($" + minPay + ")");
        System.out.printf("Average Pay: $%.2f\n", totalPay / count);
        System.out.println("Employees with Overtime: " + overtimeCount);
    }

    public static void main(String[] args) {
        String[] types = {"fullTime", "PartTime", "Contractor", "Intern", "fullTime "};
        double[] hours = {47, 40, 25, 12, 33};
        double[] rates = {05, 41, 89, 34, 11};
        String[] names = {"Ali", "Ahmad", "Maha", "Noor", "Jone"};


        processPayroll(types, hours, rates, names);
    }
}