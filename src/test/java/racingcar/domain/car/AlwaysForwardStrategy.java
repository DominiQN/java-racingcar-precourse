package racingcar.domain.car;

class AlwaysForwardStrategy implements CarMovingStrategy {
    private final Distance distanceAtOnce;

    public AlwaysForwardStrategy(Distance distanceAtOnce) {
        this.distanceAtOnce = distanceAtOnce;
    }

    @Override
    public Distance move() {
        return distanceAtOnce;
    }
}
