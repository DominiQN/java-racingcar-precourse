package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DistanceTest {
    @DisplayName("정수로 생성할 수 있다.")
    @Test
    void construct() {
        final int givenValue = 1;
        final Distance distance = new Distance(givenValue);

        assertThat(distance.toInt()).isEqualTo(givenValue);
    }

    @ParameterizedTest(name = "가지고 있는 값이 같으면, 동일하다. [{0}]")
    @ValueSource(ints = {0, 1, 100})
    void equality(int value) {
        final Distance one = new Distance(value);
        final Distance another = new Distance(value);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("ZERO의 값은 0이다.")
    @Test
    void zero() {
        assertThat(Distance.ZERO).isEqualTo(new Distance(0));
    }
}
