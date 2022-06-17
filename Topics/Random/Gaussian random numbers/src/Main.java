import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        int count = 0;
        do {
            Random random = new Random(k++);
            count = 0;
            do {
                if(random.nextGaussian() <= m) {
                    count++;
                } else {
                    break;
                }
            } while (count != n);
        } while (count != n);
        System.out.println(k - 1);
    }
}