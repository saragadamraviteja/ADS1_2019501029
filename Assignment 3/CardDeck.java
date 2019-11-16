import java.util.*;

public class CardDeck {
    
    public static void method(String[] arr) {
        String sut = "";
        String val = "";
        int size = 0;
        Card[] cards = new Card[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 2) {
                val = String.valueOf(arr[i].substring(0,2));
                sut = String.valueOf(arr[i].charAt(2));
            } else {
                if (arr[i].length() == 2) {
                    val = String.valueOf(arr[i].charAt(1));
                    sut = String.valueOf(arr[i].charAt(0));
                }
            Card rr = new Card(sut, val);
            cards[size++] = rr;
            }
        }

        Insertion mySort = new Insertion();
        mySort.sort(cards);

        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        String[] arr = ss.split(" ");
        // Card[] myCards = new
        // for (int i = 0; i < arr.length; i++) {
        //     Card obj = new Card();
        // }
        method(arr);
        
    }
}