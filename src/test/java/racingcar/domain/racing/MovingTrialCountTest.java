package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingTrialCountTest {
    @ParameterizedTest(name = "전진 시도 횟수는 양수여야 한다. 입력값: [{0}]")
    @ValueSource(ints = {0, -1})
    void shouldBePositive(int count) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MovingTrialCount(count))
                .withMessageMatching("시도할 횟수는 1 이상이어야 합니다! 입력값: .+");
    }

    @DisplayName("정수로 바꿀 수 있다.")
    @Test
    void value() {
        final int value = 3;
        final MovingTrialCount count = new MovingTrialCount(value);
        assertThat(count.toInt()).isEqualTo(value);
    }

    @DisplayName("값이 같다면, 동일하다.")
    @Test
    void equality() {
        final MovingTrialCount one = new MovingTrialCount(1);
        final MovingTrialCount another = new MovingTrialCount(1);
        assertThat(one).isEqualTo(another);
    }
}
