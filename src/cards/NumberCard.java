package cards;

public class NumberCard extends Card {
    final int[] ALLOWED_NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int number;

    public NumberCard(Color color, int number) {
        super(color);
        this.number = number;
    }


    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean mathes(Card other) {
        if (other instanceof NumberCard) {
            if (this.getColor() == other.getColor() || this.number == ((NumberCard) other).getNumber()) {
                return true;
            } else {
                return false;
            }


        }else {
            return this.getColor() == other.getColor();
        }
    }

    @Override
    public String toString() {
        return this.getColor() + "_" + this.getNumber();
    }
}
