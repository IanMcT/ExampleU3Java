class Deck{
  Card[] cards;

  public void replaceDeck(Card[] c){
    
  }
  public Deck(){
    cards = new Card[52];
    for(int i = 0; i < 52; i++){
       cards[i] = new Card(i);
    }//end loop
  }//end constructor

  public String showDeck(){
    String output = "";
    for(int i = 0; i < 52; i++){
      output += this.cards[i].Face() + " of " + this.cards[i].Suit()+"\n";
    }//end loop
    return output;
  }//end show deck
}//end class
