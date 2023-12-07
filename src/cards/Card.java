package cards;

public abstract class Card {
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

   public boolean mathes(Card card){
        if(this.getColor() == card.getColor()){
            return true;
        }else{
            return false;
        }
   }

}
