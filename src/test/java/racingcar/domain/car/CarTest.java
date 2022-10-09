package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

public class CarTest {
    private CarMovingStrategy strategy;

    @BeforeEach
    void setUp() {
        this.strategy = new AlwaysForwardStrategy();
    }

    @ParameterizedTest(name = "자동차 이름은 비어 있지 않아야 한다.")
    @NullSource
    void nameShouldNotNull(CarName name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name, strategy))
                .withMessage("The 'name' should not be null!");
    }

    @ParameterizedTest(name = "자동차 전진 전략은 비어 있지 않아야 한다.")
    @NullSource
    void strategyShouldNotNull(CarMovingStrategy strategy) {
        final CarName name = new CarName("Benz");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name, strategy))
                .withMessage("The 'strategy' should not be null!");
    }
}
