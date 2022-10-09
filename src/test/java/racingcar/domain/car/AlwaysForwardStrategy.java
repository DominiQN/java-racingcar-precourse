package racingcar.domain.car;

class AlwaysForwardStrategy implements CarMovingStrategy {

    private static final int DISTANCE = 1;

    @Override
    public int move() {
        return DISTANCE;
    }
}
