
class Card{
  enum Suit {CLUBS,DIAMOND,HEART,SPADE};
  enum Face {ACE, TWO, THREE, FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING};
  private int cardNumber;
  public Card(int cardNumber){
    this.cardNumber = cardNumber;
  }//end constructor

  public String Suit(){
    Suit suit = Suit.values()[(this.cardNumber/13)];
    return suit.name();
  }//end suit
  public String Face(){
    Face face = Face.values()[(this.cardNumber%13)];
    return face.name();
  }//end face
}//end class