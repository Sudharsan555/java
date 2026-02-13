public class ArmstrongNumber {

    public static void main(String[] args) {

        int num = 9474;   // Try different numbers
        int temp = num;
        int sum = 0;
        int digits = 0;

        // Count number of digits
        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        temp = num; // Reset temp

        // Calculate sum of powers
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp = temp / 10;
        }

        if (sum == num) {
            System.out.println(num + " is an Armstrong number");
        } else {
            System.out.println(num + " is not an Armstrong number");
        }
    }
}
