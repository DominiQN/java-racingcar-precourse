package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.car.CarMovingStrategy;

public class Racing {
    private final RacingCars racingCars;

    private final RacingTrialCounter racingTrialCounter;

    public Racing(List<String> carNames, int movingTrials, CarMovingStrategy carMovingStrategy) {
        this.racingCars = RacingCars.createdBy(carNames, carMovingStrategy);
        this.racingTrialCounter = new RacingTrialCounter(movingTrials);
    }

    public CarStatuses raceOnce() {
        racingTrialCounter.incrementTrialCount();
        return racingCars.moveAll();
    }

    public boolean isFinished() {
        return racingTrialCounter.isReachingTrialLimit();
    }
}
