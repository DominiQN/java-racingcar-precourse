package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.CarMovingStrategy;

public class Racing {
    private final RacingCars racingCars;

    private final MovingTrialCount movingTrialCount;

    public Racing(List<String> carNames, int movingTrials, CarMovingStrategy carMovingStrategy) {
        this.racingCars = RacingCars.createdBy(carNames, carMovingStrategy);
        this.movingTrialCount = new MovingTrialCount(movingTrials);
    }
}
