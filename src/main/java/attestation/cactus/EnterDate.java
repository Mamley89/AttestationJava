package attestation.cactus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class EnterDate {

    public static void main(String[] args) {
        System.out.println("Введите дату последнего полива в формате год-месяц-день(например 2024-12-03):");
        Scanner scanner = new Scanner(System.in);
        LocalDate previousWaterDate = null;
        do {
            try {
                previousWaterDate = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Введен неверный формат даты, попробуйте снова в формате год-месяц-день(например 2024-12-03):");
            }
        } while (previousWaterDate == null);

        LocalDate now = LocalDate.now();
        if (now.isBefore(previousWaterDate)) {
            System.out.println("Вы уже полили кактус в будущем.");
            return;
        }

        RandomHumiditySensor humiditySensor = new RandomHumiditySensor();
        int humidity = humiditySensor.getHumidity();

        WaterCactusScheduler waterPlantScheduler = new WaterCactusScheduler();
        Optional<LocalDate> nextWaterDate = waterPlantScheduler.calculateNextWaterDate(previousWaterDate, now, humidity);

        if (nextWaterDate.isPresent()) {
            System.out.println("Дата следующего полива: "
                    + nextWaterDate.get().format(DateTimeFormatter.ISO_DATE));
        } else {
            System.out.println("При текущей дате и влажности полив не требуется, попробуйте позже.");
        }
    }
}
