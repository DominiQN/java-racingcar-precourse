package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.AlwaysForwardStrategy;
import racingcar.domain.car.CarMovingStrategy;

class RacingTest {
    private final CarMovingStrategy strategy = new AlwaysForwardStrategy(1);

    @ParameterizedTest(name = "경주할 자동차 이름 목록은 null이 아니어야 한다.")
    @NullSource
    void carNamesShouldNotBeNull(List<String> carNames) {
        final int movingTrials = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing(carNames, movingTrials, strategy));
    }

    @ParameterizedTest(name = "경주할 자동차 이름 목록은 비어 있지 않아야 한다.")
    @EmptySource
    void carNamesShouldNotBeEmpty(List<String> carNames) {
        final int movingTrials = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing(carNames, movingTrials, strategy));
    }

    @ParameterizedTest(name = "전진 시도 횟수는 양수여야 한다. 시도 횟수: {0}")
    @ValueSource(ints = {0, -1})
    void movingTrialsShouldBePositive(int movingTrials) {
        final List<String> carNames = Arrays.asList("pobi", "crong");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing(carNames, movingTrials, strategy));
    }

    @ParameterizedTest(name = "전진 전략은 null이 아니어야 한다.")
    @NullSource
    void carMovingStrategyShouldNotBeNull(CarMovingStrategy carMovingStrategy) {
        final List<String> carNames = Arrays.asList("pobi", "crong");
        final int movingTrials = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing(carNames, movingTrials, carMovingStrategy));
    }
}
