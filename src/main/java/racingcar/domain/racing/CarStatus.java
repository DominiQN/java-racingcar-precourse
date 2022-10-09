package racingcar.domain.racing;

import static racingcar.utils.ValidationUtils.requireNotNull;

import java.util.Objects;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Distance;

public class CarStatus {
    private final String carName;
    private final int distanceFromStartingPoint;

    public CarStatus(CarName carName, Distance distanceFromStartingPoint) {
        requireNotNull(carName, "The car name should not be null!");
        requireNotNull(distanceFromStartingPoint, "The distance from starting point should not be null!");

        this.carName = carName.toString();
        this.distanceFromStartingPoint = distanceFromStartingPoint.toInt();
    }

    public static CarStatus from(Car car) {
        requireNotNull(car, "The car should not be null!");
        return new CarStatus(car.getName(), car.getDistanceFromStartingPoint());
    }

    public String getName() {
        return this.carName;
    }

    public int getDistanceFromStartingPoint() {
        return this.distanceFromStartingPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarStatus carStatus = (CarStatus) o;
        return distanceFromStartingPoint == carStatus.distanceFromStartingPoint && carName.equals(carStatus.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distanceFromStartingPoint);
    }
}
