package attestation.fence;

import java.util.Scanner;

public class Fence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину забора:");
        int endFence = scanner.nextInt();

        int letter = 15;
        int whitespace = 3;
        int number = 3;
        int entrerLetter = 62;
        int enterWhitespace = 12;

        int fence = (letter / number * entrerLetter) + (enterWhitespace * whitespace);

        if (endFence <= fence) {
            System.out.println("Надпись поместится на заборе");
        }
        else  {
            System.out.println("Надпись не поместится на заборе");
        }
    }
}