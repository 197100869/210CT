import java.util.Scanner;
public class BasicExercises1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Scanner Number = new Scanner(System.in);
				System.out.println("Enter 3-digit number");

				String EnterNumber = Number.nextLine();

				int number = Integer.parseInt(EnterNumber);

				int length = String.valueOf(number).length();
				if (length == 3) {

					int num;
					int temp;
					int total = 0;
					num = number;
					while (num != 0) {
						temp = num % 10; // get the last number than mid number than first number
						total = total + temp * temp * temp; // sum of last number to the third power, mid to the third
															// power and first to the third power
						num = num / 10; // save left number
					}

					if (total == number) // check total == user input
						System.out.println("Yes");
					else
						System.out.println("No");
					break;
				}
			} catch (NumberFormatException e) {

			}
		}
	}

}
