public class reverseinteger {
      public int reverse(int x) {
        int dig;
        long rev = 0;

        while (x != 0) {
            dig = x % 10;
            rev = (rev * 10) + dig;
            x = x / 10;

            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) rev;
    }

    public static void main(String[] args) {
        reverseinteger sol = new reverseinteger();

        int input = 123;
        int result = sol.reverse(input);
        System.out.println("Reversed: " + result);

        input = -456;
        result = sol.reverse(input);
        System.out.println("Reversed: " + result);

        input = 1534236469;
        result = sol.reverse(input);
        System.out.println("Reversed: " + result);
    }
    
}
