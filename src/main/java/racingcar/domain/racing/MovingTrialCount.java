package racingcar.domain.racing;

import java.util.Objects;

public class MovingTrialCount {
    private final int value;

    public MovingTrialCount(int value) {
        requireMovingTrialsPositive(value);
        this.value = value;
    }

    private void requireMovingTrialsPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다! 입력값: " + count);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovingTrialCount that = (MovingTrialCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int toInt() {
        return this.value;
    }
}
