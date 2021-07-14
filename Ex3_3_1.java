public class Ex3_3_1 {
    public static int mod(int m, int n) {

        if (m == 0 || n == 0) {
            return -1;
        }

        if (m < 0) {
            m = (-1) * m;
        }
        if (n < 0) {
            n = (-1) * n;
        }

        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        if (n == 1) {
            return m;
        }

        int a = m / n;
        return m - (a * n);

        // 18/5=3.2
        // 18-3*5

    }

    public static int[] sortModArray(int[] a, int n) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {

                if (a[j] % n > a[j + 1] % n) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }

        return a;
    }

    public static int searchModArray(int[] a, int n, int num) {

        int left = 0;
        int right = a.length - 1;
        int target = num;

        while (left <= right) {

            int midIndex = (left + right) / 2;

            if (target % n < a[midIndex] % n) {
                right = midIndex - 1;

            } else if (target % n > a[midIndex] % n) {
                left = midIndex + 1;
            } else {

                while (left <= right) {
                    int NewmidIndex = (left + right) / 2;
                    if (target % n < a[NewmidIndex] % n) {
                        right = NewmidIndex - 1;

                    } else

                    if (target % n > a[NewmidIndex] % n) {

                        left = NewmidIndex + 1;

                    } else {
                        int MidIndex2 = NewmidIndex;

                        while (left <= right) {

                            MidIndex2 = (left + right) / 2;

                            if (target == a[MidIndex2]) {

                                return MidIndex2;

                            } else if (target < a[MidIndex2]) {

                                right = MidIndex2 - 1;

                            } else if (target > a[MidIndex2]) {

                                left = MidIndex2 + 1;

                            }
                        }

                        return -1;

                    }
                }

                return midIndex;
            }

        }
        return -1;

    }

}
