package attestation.cactus;

import java.time.LocalDate;
import java.time.Month;
import java.util.EnumSet;
import java.util.Optional;

public class WaterCactusScheduler implements WaterPlantScheduler {
    private final EnumSet<Month> winter = EnumSet.of(Month.DECEMBER, Month.JANUARY, Month.FEBRUARY);
    private final EnumSet<Month> summer = EnumSet.of(Month.JUNE, Month.JULY, Month.AUGUST);

    @Override
    public Optional<LocalDate> calculateNextWaterDate(LocalDate previousWaterDate, LocalDate now, Integer humidity) {
        Month currentMonth = now.getMonth();
        if (winter.contains(currentMonth)) {
            return getNextWinterWaterDate(previousWaterDate, now);
        } else if (summer.contains(currentMonth)) {
            return getNextSummerWaterDate(previousWaterDate, now, humidity);
        } else {
            return getNextSpringOrFallWaterDate(previousWaterDate, now);
        }
    }

    private Optional<LocalDate> getNextWinterWaterDate(LocalDate previousWaterDate, LocalDate now) {
        LocalDate nextWaterDate = previousWaterDate.plusMonths(1);
        if (nextWaterDate.isBefore(now)) {
            return Optional.of(now);
        }
        return Optional.of(nextWaterDate);
    }

    private Optional<LocalDate> getNextSummerWaterDate(LocalDate previousWaterDate, LocalDate now, Integer humidity) {
        if (humidity < 30) {
            LocalDate nextWaterDate = previousWaterDate.plusDays(2);
            if (nextWaterDate.isBefore(now)) {
                return Optional.of(now);
            }
            return Optional.of(nextWaterDate);
        } else {
            return Optional.empty();
        }
    }

    private Optional<LocalDate> getNextSpringOrFallWaterDate(LocalDate previousWaterDate, LocalDate now) {
        LocalDate nextWaterDate = previousWaterDate.plusWeeks(1);
        if (nextWaterDate.isBefore(now)) {
            return Optional.of(now);
        }
        return Optional.of(nextWaterDate);
    }
}
