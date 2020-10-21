package learn;

public enum Move {
    ROCK(1), PAPER(2), SCISSORS(3);

    private int moveValue;

    Move(int moveValue) {
        this.moveValue = moveValue;
    }

    public int getMoveValue() {
        return moveValue;
    }


}
