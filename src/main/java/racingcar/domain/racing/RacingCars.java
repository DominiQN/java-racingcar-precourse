package racingcar.domain.racing;

import static racingcar.utils.ValidationUtils.requireNotNull;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovingStrategy;
import racingcar.domain.car.CarName;

public class RacingCars {
    private final List<Car> elements;

    public RacingCars(List<Car> elements) {
        requireNotNull(elements, "The 'elements' should not be null!");
        requireNotEmpty(elements);
        this.elements = elements;
    }

    public static RacingCars createdBy(List<String> carNames, CarMovingStrategy carMovingStrategy) {
        requireNotNull(carNames, "The 'carNames' should not be null!");
        requireNotNull(carMovingStrategy, "The 'carMovingStrategy' should not be null!");

        final List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            final CarName carName = new CarName(name);
            final Car car = new Car(carName, carMovingStrategy);
            carList.add(car);
        }

        return new RacingCars(carList);
    }

    private void requireNotEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차는 하나 이상 필요합니다!");
        }
    }
}
