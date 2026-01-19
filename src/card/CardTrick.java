/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * Modified: 2025-01-19 by Ethan McTague (991573216):
 *  - Model hand of random cards
 *  - Prompt for new card and check if it's in the hand.
 *  - Create a lucky card (committed from GH web editor)
 *  - Fully replace the custom card with the lucky card.
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue((int)(Math.random() * 13 + 1));
            c.setSuit(Card.SUITS[(int)(Math.random() * Card.SUITS.length)]);
            magicHand[i] = c;
        }
    
        Scanner scanner = new Scanner(System.in);

        // Create a lucky card.
        Card luckyCard = new Card();
        luckyCard.setValue(1);
        luckyCard.setSuit(Card.SUITS[0]);
       
        // Search the array for the card
        boolean hasMagic = Arrays.stream(magicHand)
                .anyMatch(card ->
                        card.getSuit().equals(luckyCard.getSuit()) &&
                        card.getValue() == luckyCard.getValue());
        
        if (hasMagic) System.out.println("Your card is in the magic hand!");
        else System.out.println("Your card isn't in the magic hand :(");
    }
}
