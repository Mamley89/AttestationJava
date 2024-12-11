package attestation.game;

import java.util.Scanner;

public class StoneScissorsPaperApplication {

    public static void main(String[] args) {
        int userPoints = 0;
        int computerPoints = 0;

        for (int round = 1; round <= 5; round++) {
            RandomStoneScissorsPaperGenerator randomItemGenerator = new RandomStoneScissorsPaperGenerator();
            Item computerItem = randomItemGenerator.getItem();

            System.out.println("\nРаунд " + round);
            Item userItem = scanUserItem();

            switch (userItem) {
                case STONE:
                    switch (computerItem) {
                        case SCISSORS: {
                            userPoints += 1;
                            System.out.println("Ваш камень затупил ножницы противника, вы получаете 1 очко.");
                            break;
                        }
                        case PAPER: {
                            computerPoints += 5;
                            System.out.println("Бумага противника накрыла ваш камень, противник получает 5 очков.");
                            break;
                        }
                        case STONE: {
                            System.out.println("У вас и у противника камень, никто не получает очков.");
                            break;
                        }
                    }
                    break;
                case SCISSORS:
                    switch (computerItem) {
                        case SCISSORS: {
                            System.out.println("У вас и у противника ножницы, никто не получает очков.");
                            break;
                        }
                        case PAPER: {
                            userPoints += 2;
                            System.out.println("Ваши ножницы порезали бумагу противника, вы получаете 2 очка.");
                            break;
                        }
                        case STONE: {
                            computerPoints += 1;
                            System.out.println("Ваши ножницы затупились о камень противника, противник получает 1 очко.");
                            break;
                        }
                    }
                    break;
                case PAPER:
                    switch (computerItem) {
                        case SCISSORS: {
                            computerPoints += 2;
                            System.out.println("Вашу бумагу порезали ножницы противника, противник получает 2 очка.");
                            break;
                        }
                        case PAPER: {
                            System.out.println("У вас и у противника бумага, никто не получает очков.");
                            break;
                        }
                        case STONE: {
                            userPoints += 5;
                            System.out.println("Ваша бумага накрыла камень противника, вы получаете 5 очков.");
                            break;
                        }
                    }
                    break;
            }
        }

        System.out.println("Итоговый счет: " + userPoints + " - " + computerPoints);
        if (userPoints == computerPoints) {
            System.out.println("Ничья");
        } else if (userPoints > computerPoints) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Победил компьютер.");
        }
    }

    private static Item scanUserItem() {
        System.out.println("Введите букву(К - камень, Н - ножницы, Б - бумага):");
        Scanner scanner = new Scanner(System.in);
        Item userItem = null;
        do {
            try {
                String str = scanner.nextLine();
                userItem = switch (str) {
                    case "К" -> Item.STONE;
                    case "Н" -> Item.SCISSORS;
                    case "Б" -> Item.PAPER;
                    default -> null;
                };
            } catch (Exception e) {
                System.out.println("Введена неверная буква, попробуйте снова(К - камень, Н - ножницы, Б - бумага):");
            }
        } while (userItem == null);

        return userItem;
    }
}