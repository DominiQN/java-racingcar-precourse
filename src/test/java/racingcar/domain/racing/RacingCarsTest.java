package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.domain.Fixtures;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovingStrategy;

class RacingCarsTest {
    @ParameterizedTest(name = "경주할 자동차 목록은 null이 아니어야 한다.")
    @NullSource
    void carNamesShouldNotBeNull(List<Car> cars) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(cars))
                .withMessage("The 'elements' should not be null!");
    }

    @ParameterizedTest(name = "경주할 자동차 목록은 비어 있지 않아야 한다.")
    @EmptySource
    void carNamesShouldNotBeEmpty(List<Car> cars) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCars(cars))
                .withMessage("경주할 자동차는 하나 이상 필요합니다!");
    }

    @DisplayName("자동차 이름 목록과 전진 전략으로 생성할 수 있다.")
    @Test
    void createWithNamesAndStrategy() {
        final List<String> carNames = Arrays.asList("him", "her", "it");
        final CarMovingStrategy strategy = Fixtures.ALWAYS_FORWARD_ONE_STRATEGY;
        assertThatNoException().isThrownBy(() -> {
            final RacingCars cars = RacingCars.createdBy(carNames, strategy);
        });
    }

    @DisplayName("자동차들의 전체 주행 결과는 자동차의 이름 및 현재 위치를 반환한다.")
    @Test
    void name() {
        final List<String> carNames = Arrays.asList("him", "her", "it");
        final RacingCars cars = RacingCars.createdBy(carNames, Fixtures.ALWAYS_FORWARD_ONE_STRATEGY);
        final CarStatuses expected = Fixtures.carStatusesOf(1, "him", "her", "it");

        final CarStatuses actual = cars.moveAll();

        assertThat(actual).isEqualTo(expected);
    }
}
