package attestation.cactus;

import java.time.LocalDate;
import java.util.Optional;

public interface WaterPlantScheduler {

    Optional<LocalDate> calculateNextWaterDate(LocalDate previousWaterDate, LocalDate now, Integer humidity);
}