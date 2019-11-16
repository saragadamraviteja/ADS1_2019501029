class Card implements Comparable<Card> {
   // class Card {
    String suit;
    String value;
    // public Card(){

    // }
    public Card(String suit1, String value1) {
        this.suit = suit1;
        this.value = value1;
    }

     public int compareTo(Card p) {
         int suitvalue = 0;
         int pvalue = 0;
         int aa = 0;
         int bb = 0;
         if (this.suit.equals("S")) {
            suitvalue = 1;
         } else if (this.suit.equals("H")) {
             suitvalue = 2;
         } else if (this.suit.equals("C")){
             suitvalue = 3;
         } else if (this.suit.equals("D")) {
             suitvalue = 4;
         }
         if (p.suit.equals("S")) {
             pvalue = 1;
         } else if (p.suit.equals("H")) {
            pvalue = 2;
        } else if (p.suit.equals("C")){
            pvalue = 3;
        } else if (p.suit.equals("D")) {
            pvalue = 4;
        }
        if(pvalue > suitvalue) {
            return 1;
        } else if (pvalue  < suitvalue) {
            return -1;
        } else {
    //   if (pvalue == suitvalue) {
            if (this.value.equals("A")) {
                aa = 1;
            } else if (this.value.equals("J")) {
                aa = 11;
            } else if (this.value.equals("Q")) {
                aa = 12;
            } else if (this.value.equals("K")) {
                aa = 13;
            }
            if (p.value.equals("A")) {
                bb = 1;
            } else if (p.value.equals("J")) {
                bb = 11;
            } else if (p.value.equals("Q")) {
                bb = 12;
            } else if (p.value.equals("K")) {
                bb = 13;
            }
            
        }

        // if (this.value.equals("A")) {
        //     aa = 1;
        // } else if (this.value.equals("J")) {
        //     aa = 11;
        // } else if (this.value.equals("Q")) {
        //     aa = 12;
        // } else if (this.value.equals("K")) {
        //     aa = 13;
        // }
        // if (p.value.equals("A")) {
        //     bb = 1;
        // } else if (p.value.equals("J")) {
        //     bb = 11;
        // } else if (p.value.equals("Q")) {
        //     bb = 12;
        // } else if (p.value.equals("K")) {
        //     bb = 13;
        // }
            
        if (aa == 0) {
            // System.out.println(value);
            aa = Integer.parseInt(this.value);
        }
        if (bb == 0) {
            bb = Integer.parseInt(p.value);
        }
        if (aa > bb) {
            return -1;
        } else if (aa < bb) {
            return 1;
        } else return 0;
    }
    public String toString() {
        
        String str = "";
        str += this.suit + "   " + this.value  ;
        return str;
    }
}