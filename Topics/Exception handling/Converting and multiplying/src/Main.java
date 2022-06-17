import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        while (!("0".equals(a))) {
            try {
                System.out.println(Integer.parseInt(a) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + a);
            } finally {
                a = scanner.nextLine();
            }
        }
    }
}