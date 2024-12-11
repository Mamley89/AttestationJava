package attestation.game;

import java.util.Random;

public class RandomStoneScissorsPaperGenerator implements StoneScissorsPaperGenerator {

    @Override
    public Item getItem() {
        int randomInt = new Random().nextInt(3);
        if (randomInt == 0) {
            return Item.STONE;
        } else if (randomInt == 1) {
            return Item.SCISSORS;
        } else {
            return Item.PAPER;
        }
    }
}