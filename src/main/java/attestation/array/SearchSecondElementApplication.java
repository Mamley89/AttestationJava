package attestation.array;

import java.util.Optional;
import java.util.Scanner;

public class SearchSecondElementApplication {
    public static void main(String[] args) {
        System.out.println("Введите элементы массива через запятую(например 1,5,7,3,2,0,4,9,6):");
        Scanner scanner = new Scanner(System.in);
        int[] elements;
        do {
            try {
                String[] line = scanner.nextLine().split(",");
                elements = new int[line.length];
                for (int i = 0; i < line.length; i++) {
                    elements[i] = Integer.parseInt(line[i]);
                }
            } catch (Exception e) {
                elements = null;
                System.out.println("Введен неверный формат элементов массива, попробуйте снова через запятую(например 1,5,7,3,2,0,4,9,6):");
            }
        } while (elements == null);

        Optional<Integer> secondMaxElement = findSecondMax(elements);

        if (secondMaxElement.isPresent()) {
            System.out.println("Второй по величине элемент " + secondMaxElement.get());
        } else {
            System.out.println("В заданном массиве отсутствует второй по величине элемент.");
        }
    }

    private static Optional<Integer> findSecondMax(int[] elements) {
        if (elements == null || elements.length < 2) {
            return Optional.empty();
        }

        int max = elements[0];
        for (int element : elements) {
            if (element > max) {
                max = element;
            }
        }

        Integer secondMax = null;
        for (int element : elements) {
            if (secondMax == null && element < max) {
                secondMax = element;
                continue;
            }
            if (secondMax != null && element > secondMax && element < max) {
                secondMax = element;
            }
        }
        return Optional.ofNullable(secondMax);
    }
}
