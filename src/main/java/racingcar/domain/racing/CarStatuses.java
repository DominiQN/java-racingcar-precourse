package racingcar.domain.racing;

import static racingcar.utils.ValidationUtils.requireNotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarStatuses {
    private final List<CarStatus> elements;

    public CarStatuses(List<CarStatus> elements) {
        requireNotNull(elements, "The car status list should not be null!");
        this.elements = elements;
    }

    public List<CarStatus> toList() {
        return Collections.unmodifiableList(this.elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarStatuses that = (CarStatuses) o;
        return elements.equals(that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
