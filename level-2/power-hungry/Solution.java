import java.math.BigInteger;

public class Solution {
    public static String solution(int[] xs) {
        if(xs.length==1)return Integer.toString(xs[0]);

        int minNegative = Integer.MIN_VALUE, negative = 0, positive = 0;
        BigInteger maximumProduct = BigInteger.valueOf(1);
        boolean containsZero = false;

        for (int n : xs) {
            if (n < 0) {
                negative++;
                minNegative = Integer.max(minNegative, n);
            } else if (n > 0) positive++;

            if (n == 0) containsZero = true;
            else maximumProduct = maximumProduct.multiply(BigInteger.valueOf(n));
        }


        if ((negative & 1) != 0) {
            maximumProduct = maximumProduct.divide(BigInteger.valueOf(minNegative));
        }
        if (positive == 0 && negative == 0 && containsZero) {
            maximumProduct = BigInteger.valueOf(0);
        }
        if (negative == 1 && positive == 0 && containsZero) {
            maximumProduct = BigInteger.valueOf(0);
        }

        return maximumProduct.toString();
    }
}