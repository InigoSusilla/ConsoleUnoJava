package Uno.cards;

import Uno.Descriptable;

public abstract class Card implements Descriptable {
    private Color color;

    public Card(Color color) {
        this.color = color;

    }

    public String getColor() {
        return color.toString();
    }

    protected void setColor(String color) {
        this.color = Color.valueOf(color);
    }

   public abstract boolean matches(Card card);



}
