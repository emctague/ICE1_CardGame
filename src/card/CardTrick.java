/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * Modified: 2025-01-19 by Ethan McTague (991573216):
 *  - Model hand of random cards
 *  - Prompt for new card and check if it's in the hand.
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
        
        // Prompt for a card.
        System.out.println("Pick a card, any card!");
        int rank = retryPrompt(CardTrick::readRank, scanner);
        String suit = retryPrompt(CardTrick::readSuit, scanner);
        
        // Search the array for the card
        boolean hasMagic = Arrays.stream(magicHand)
                .anyMatch(card ->
                        card.getSuit().equals(suit) &&
                        card.getValue() == rank);
        
        if (hasMagic) System.out.println("Your card is in the magic hand!");
        else System.out.println("Your card isn't in the magic hand :(");
     
        
        //insert code to ask the user for Card value and suit, create their card
        // and search magicHand here
        //Then report the result here
        // add one luckcard hard code 2,clubs
    }
    
    /** Repeatedly try to call a prompt function until it doesn't throw. */
    static <T> T retryPrompt(Function<Scanner, T> handler, Scanner scanner) {
        while (true) {
            try {
                return handler.apply(scanner);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again!");
            }
        }
    }
    
    /** Prompt handler to read a card rank. */
    static int readRank(Scanner scanner) {
        System.out.print("Card rank (a, j, q, k, 1-13): ");
        String rankText = scanner.nextLine().trim().toLowerCase();

        int rank = switch (rankText) {
            case "a" -> 1;
            case "j" -> 11;
            case "q" -> 12;
            case "k" -> 13;
            default -> Integer.parseInt(rankText);
        };
        
        if (rank > 13 || rank < 1)
            throw new RuntimeException("Rank out of range.");
        
        return rank;
    }
    
    /** Prompt handler to read a card suit. */
    static String readSuit(Scanner scanner) {
        System.out.print("Suit (Hearts, Diamonds, Spades, Clubs): ");
        String suitText = scanner.nextLine().trim().toLowerCase();
        
        int index = switch (suitText.charAt(0)) {
            case 'h' -> 0;
            case 'd' -> 1;
            case 's' -> 2;
            case 'c' -> 3;
            default -> throw new RuntimeException("Invalid Suit");
        };
        
        return Card.SUITS[index];
    }
    
}
