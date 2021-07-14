public class Ex3_2_1 {

	public static double assign(String s, int x) {
 
		if (!isFormula(s)) {
			return Double.NaN;
		}

		return RecAssain(s, x);

	}

	public static double RecAssain(String s, int x) {

		int IndexOfMiddleString = getIndexOfMiddleOperator(s);

		double valueOfResults = 0;

		if (IndexOfMiddleString != -1) {

			// if (s.charAt(i) == 'x' || s.charAt(i) == '-' || s.chartAt(i) == '*' ||
			// s.chartAt(i) == '%') {
			//
			// }
			if (s.charAt(IndexOfMiddleString) == '-') {
				//
				valueOfResults += RecAssain(s.substring(1, IndexOfMiddleString), x)
						- RecAssain(s.substring(IndexOfMiddleString + 1, s.length() - 1), x);
			} else if (s.charAt(IndexOfMiddleString) == '+') {
				//
				valueOfResults += (RecAssain(s.substring(1, IndexOfMiddleString), x))
						+ (RecAssain(s.substring(IndexOfMiddleString + 1, s.length() - 1), x));
			} else if (s.charAt(IndexOfMiddleString) == '*') {
				//
				valueOfResults += RecAssain(s.substring(1, IndexOfMiddleString), x)
						* RecAssain(s.substring(IndexOfMiddleString + 1, s.length() - 1), x);
			}

			// return false;

			// return false;

		} else {
			if (s.equals("x")) {
				// return false;
				return x;
			} else {
				return Double.parseDouble(s);
			}
			// return true;
		}

		return valueOfResults;
	}

	public static int getIndexOfMiddleOperator(String s) {
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				return -1;
			}
			if (!isValidChar(s.charAt(i)) && s.charAt(i) != ')' && s.charAt(i) != '(') {
				return -1;
			}
			if (s.charAt(i) == ')') {
				counter1++;
			}
			if (s.charAt(i) == '(') {
				counter2++;
			}

			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
				if (counter1 == counter2) {
					return i;
				}

			}

		}
		return -1;
	}

	public static boolean isValidChar(char charGiven) {
		if (charGiven == '1' || charGiven == '2' || charGiven == '3' || charGiven == '4' || charGiven == '5'
				|| charGiven == '6' || charGiven == '7' || charGiven == '8' || charGiven == '9' || charGiven == '0'
				|| charGiven == 'x' || charGiven == '+' || charGiven == '*' || charGiven == '-') {
			return true;
		} else
			return false;
	}

	public static boolean valueOfFormula(String s) {
		int IndexOfMiddleString = getIndexOfMiddleOperator(s);

		if (IndexOfMiddleString != -1) {
			if (!valueOfFormula(s.substring(1, IndexOfMiddleString))) {
				return false;
			}
			if (!valueOfFormula(s.substring(IndexOfMiddleString + 1, s.length() - 1))) {
				return false;
			}

		} else {
			if (s.length() != 1) {
				return false;
			}
			return true;
		}

		// adding if else for special case
		if (IndexOfMiddleString == -1 && s.length() == 0) {
			return false;
		}

		return true;
	}

	// public static boolean checkCorrectNumberOfBrackets(String s, int leftCounter,
	// int RightCounter) {

	// boolean check = false;
	// boolean check2 = false;
	// boolean check3 = false;
	// if (s.length() == 0) {
	// if (check == check2 && leftCounter == RightCounter) {
	// return true;
	// }
	// } else {
	// if (s.charAt(0) == ')') {
	// check = checkCorrectNumberOfBrackets(s.substring(1, s.length()), leftCounter,
	// ++RightCounter);
	// }
	// if (s.charAt(0) == '(') {
	// check2 = checkCorrectNumberOfBrackets(s.substring(1, s.length()),
	// ++leftCounter, RightCounter);
	// }

	// check3 = checkCorrectNumberOfBrackets(s.substring(1, s.length()),
	// leftCounter, RightCounter);

	// }
	// if (check3 || check2 || check) {
	// return true;
	// }
	// return false;
	// }

	// public static boolean checkCorrectNumberOfBrackets(String s) {
	// 	int leftCounter = 0;
	// 	int rightCounter = 0;

	// 	for (int i = 0; i < s.length() - 1; i++) {
	// 		if (rightCounter > leftCounter) {
	// 			return false;
	// 		}
	// 		if (leftCounter != 0 && leftCounter - 1 > rightCounter) {
	// 			return false;
	// 		}
	// 		if (s.charAt(i) == ')') {
	// 			rightCounter++;
	// 		}

	// 		if (s.charAt(i) == '(') {
	// 			leftCounter++;
	// 		}

	// 	}
	// 	return true;
	// }

	public static boolean hasBalancedBrackets(String str) {
		int brackets = 0;
		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == '(') {
				brackets++;
			} else if (str.charAt(i) == ')') {
				brackets--;
			} else {
				// non-bracket chars
			}
			if (brackets < 0) { // closing bracket before opening bracket
				return false;
			}
		}
		return brackets >= 0;
	}

	public static boolean isFormula(String s) {
		if (s == "" || s == null || s.charAt(0) == ')') {
			return false;
		}
	

		if (!hasBalancedBrackets(s)) {
			return false;
		}

		return valueOfFormula(s);

	}

}
