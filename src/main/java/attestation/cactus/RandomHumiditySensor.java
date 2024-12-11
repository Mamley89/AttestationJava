package attestation.cactus;

import java.util.Random;

public class RandomHumiditySensor implements HumiditySensor {

    @Override
    public Integer getHumidity() {
        return new Random().nextInt(100);
    }
}