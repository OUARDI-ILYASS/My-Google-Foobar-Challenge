import java.math.BigInteger;

public class Solution {
    public static String solution(long x, long y) {
        BigInteger ID = BigInteger.valueOf(1);
        int distanceNextNumber = 2;
        for (int i = 1; i < x; i++) {
            ID = ID.add(BigInteger.valueOf(distanceNextNumber));
            distanceNextNumber++;
        }
        distanceNextNumber--;
        for (int i = 1; i < y; i++) {
            ID = ID.add(BigInteger.valueOf(distanceNextNumber));
            distanceNextNumber++;
        }
        return ID.toString();
    }
}
