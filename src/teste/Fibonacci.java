package teste;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira um número:");
        int num = input.nextInt();

        int fib1 = 0;
        int fib2 = 1;
        while (fib2 < num) {
            int temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
        }

        if (fib2 == num) {
            System.out.println(num + " pertence à sequência de Fibonacci!");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
    }
}
