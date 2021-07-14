public class Ex3_1 {
    

    public static void geussNumber(int N) {

		if (N < 0) {
			System.out.println("error");

		}

		int min = 0;
		int max = N;

		N = N / 2;

		int condition = 0;
		int counter = 1;

		while (N > 0 || condition == 0) {
			System.out.println(N);
			condition = MyConsole.readInt("equals:1 less than:2 bigger:3 ");
			while (condition != 1 && condition != 2 && condition != 3) {
				condition = MyConsole.readInt("equals:1 less than:2 bigger:3 ");
			}

			if (condition == 1) {
				System.out.println("the number =" + N);
				System.out.println("steps: " + counter);
				break;
			}

			if (condition == 2) {
				max = N;
				N = (N + min) / 2;
			}

			if (condition == 3) {
				min = N;
				N = (N + max) / 2;
			}

			if ((max - min) == 2) {
				System.out.println("the number =" + N);
				System.out.println("steps: " + counter);
				break;
			}

			counter++;
		}

	}
}
