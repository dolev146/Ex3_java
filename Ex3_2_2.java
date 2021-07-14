import java.util.ArrayList;

public class Ex3_2_2 {

    public static void main(String[] args) {
        System.out.println(checkPowerThree(9));

    }

    public static int getPower(int x) {
        int biggestPower = 0;
        for (int i = 0; Math.pow(3, i) <= x; i++) {
            if (i > biggestPower) {
                biggestPower = i;
            }
        }
        return biggestPower;
    }

    public static int power(int base, int exponent) {
        int sum = 1;
        for (int i = 0; i < exponent; i++) {
            sum *= base;
        }
        return sum;

    }

    public static boolean checkPowerThree(int x) {

        int target = x;

        ArrayList<Integer> powerList = new ArrayList<>();

        while (x > 0) {
            int power = getPower(x);
            powerList.add(power);
            x = x - power(3, power);
        }

        int sum = 0;

        // iterate over list
        for (int i = 0; i < powerList.size(); i++) {
            sum += power(3, powerList.get(i));
        }

        if (sum == target) {
            for (int i = 0; i < powerList.size(); i++) {
                if (!countIfOccurOnlyOnce(powerList, powerList.get(i))) {
                    return false;
                }
            }
            return true;

        } else {

            return false;
        }

    }

    public static boolean countIfOccurOnlyOnce(ArrayList<Integer> list, int searched) {
        int numCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searched) {
                numCount++;
            }
        }
        if (numCount > 1) {
            return false;
        }
        return true;
    }
}
