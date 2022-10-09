package racingcar.domain.car;

import static racingcar.utils.ValidationUtils.requireNotNull;

public class Car {
    private final CarName name;
    private final CarMovingStrategy strategy;

    public Car(CarName name, CarMovingStrategy strategy) {
        requireNotNull(name, "The 'name' should not be null!");
        requireNotNull(strategy, "The 'strategy' should not be null!");

        this.name = name;
        this.strategy = strategy;
    }
}
