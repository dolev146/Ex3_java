public class Ex3_3_2 {
    

    public static int removeDuplicate(int arr[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        // Changing original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return j;
    }

    public static int phi(int n) {
        if (n <= 0) {
            return -1;
        }
        int[] primeArray = primeDividers(n);
        int[] tempPrimeArr = primeArray.clone();
        int length = removeDuplicate(tempPrimeArr, primeArray.length);
        int[] noDuplicate = new int[length];
        for (int i = 0; i < length; i++) {
            noDuplicate[i] = tempPrimeArr[i];
        }

        int[] amountOfPower = new int[length];

        for (int i = 0; i < amountOfPower.length; i++) {
            amountOfPower[i] = countOccurrences(primeArray, primeArray.length, noDuplicate[i]);
        }
        int ResultOfPhi = 1;

        for (int i = 0; i < noDuplicate.length; i++) {
            ResultOfPhi *= (power(noDuplicate[i], amountOfPower[i]) - power(noDuplicate[i], amountOfPower[i] - 1));
        }

        return ResultOfPhi;

    }

    static int countOccurrences(int arr[], int n, int x) {
        int res = 0;
        for (int i = 0; i < n; i++)
            if (x == arr[i])
                res++;
        return res;
    }

    public static int power(int base, int exponent) {
        int sum = 1;
        for (int i = 0; i < exponent; i++) {
            sum *= base;
        }
        return sum;

    }

    public static boolean isPrime(int num) {

        boolean isPrime = false;
        for (int i = 2; i * i <= num; ++i) {

            if (num % i == 0) {
                isPrime = true;
                break;
            }
        }

        if (!isPrime) {
            return true;
        } else {
            return false;
        }

    }

    public static int[] primeDividers(int n) {

        if (n <= 1) {
            // System.exit(-1);
            int[] a = {};

            return a;
        }

        boolean isPrime = isPrime(n);
        if (isPrime) {
            int[] arr = { n };
            return arr;
        }

        int amountOfPrimes = 0;
        int numberGiven = n;

        while (n % 2 == 0) {

            n /= 2;
            amountOfPrimes++;
        }

        for (int i = 3; i * i <= n; i += 2) {

            while (n % i == 0) {

                n /= i;
                amountOfPrimes++;
            }
        }

        if (n > 2) {

            amountOfPrimes++;
        }

        int[] primeNumbers = new int[amountOfPrimes];

        int index = 0;

        while (numberGiven % 2 == 0) {
            primeNumbers[index] = 2;
            numberGiven /= 2;
            index++;
        }

        for (int i = 3; i <= numberGiven; i += 2) {

            while (numberGiven % i == 0) {
                primeNumbers[index] = i;
                numberGiven /= i;
                index++;
            }
        }

        if (numberGiven > 2) {
            primeNumbers[index] = numberGiven;
        }
        return primeNumbers;

    }

}
