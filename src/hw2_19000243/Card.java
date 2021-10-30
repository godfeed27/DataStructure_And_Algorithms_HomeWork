package hw2_19000243;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Bài 6+7
enum Suit {
    SPADE, CLUB, DIAMOND, HEART
}

public class Card {
    private int rank;
    private Suit suit;

    public Card(int r, Suit s) {
        rank = r;
        suit = s;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String rankToString(int rank) {
        switch (rank) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return "Invalid card";
        }
    }

    public String toString() {
        return rankToString(rank) + " " + suit;
    }

    public int getIndex() {
        switch (this.suit) {
            case SPADE:
                return 0;
            case CLUB:
                return 1;
            case DIAMOND:
                return 2;
            case HEART:
                return 3;
            default:
                throw new IllegalArgumentException("Unexpected value: " + this.suit);
        }

    }

    // sắp xếp lại
    static ArrayList<Card> Sort(ArrayList<Card> cards) {
        Collections.sort(cards, new Comparecard());
        return cards;
    }

    // tạo 1 bộ bài mới
    static ArrayList<Card> Create() {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 1; i < 14; i++) {
            for (Suit suit : Suit.values()) {
                Card newCard = new Card(i, suit);
                cards.add(newCard);
            }
        }
        return cards;
    }

    static ArrayList<Card> Mix(ArrayList<Card> cards) {
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            int randomNumber = random.nextInt(51);
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomNumber));
            cards.set(randomNumber, temp);
        }
        return cards;
    }

    public static void main(String args[]) {
        ArrayList<Card> cards = Create();
        System.out.println("Tạo bộ bài");
        System.out.println(cards);
        System.out.println("Trộn bộ bài");
        Mix(cards);
        System.out.println(cards);
        System.out.println("Sắp xếp lại");
        Sort(cards);
        System.out.println(cards);
    }
}
