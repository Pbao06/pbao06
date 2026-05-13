import java.util.Scanner;

public class BaiTapTongHop {

    // 1. Find Greatest Common Divisor (GCD)
    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 2. Check for Perfect Number
    public static boolean isPerfectNumber(int n) {
        if (n <= 0) return false;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    // 3. Check if all digits are even
    public static boolean hasAllEvenDigits(int n) {
        if (n == 0) return true;
        n = Math.abs(n);
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0) return false; // Found an odd digit
            n /= 10;
        }
        return true;
    }

    // 4. Calculate S(x, n) from image_66da38.png
    public static double calculateSeries(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            int k = 2 * i + 1;
            sum += Math.pow(x, k) / factorial(k);
        }
        return sum;
    }

    // Helper for factorial
    public static long factorial(int k) {
        long fact = 1;
        for (int i = 1; i <= k; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test GCD
        System.out.println("--- 1. GCD ---");
        System.out.print("Enter a and b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("GCD: " + getGCD(a, b));

        // Test Perfect Number
        System.out.println("\n--- 2. Perfect Number ---");
        System.out.print("Enter n to check: ");
        int p = sc.nextInt();
        System.out.println(p + " is perfect? " + isPerfectNumber(p));

        // Test All Even Digits
        System.out.println("\n--- 3. All Even Digits ---");
        System.out.print("Enter number to check digits: ");
        int e = sc.nextInt();
        System.out.println("All digits even? " + hasAllEvenDigits(e));

        // Test Mathematical Series
        System.out.println("\n--- 4. Series S(x, n) ---");
        System.out.print("Enter x and n: ");
        double x = sc.nextDouble();
        int nSeries = sc.nextInt();
        System.out.println("Result: " + calculateSeries(x, nSeries));
        
        sc.close();
    }
}