package hw2_19000243;

import java.util.Comparator;

// Bài 6+7
public class Comparecard implements Comparator<Card> {

    public Comparecard() {
    }

    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getRank() < o2.getRank())
            return -1;
        else if (o1.getRank() > o2.getRank())
            return 1;
        else {
            if (o1.getIndex() < o2.getIndex())
                return -1;
            else if (o1.getIndex() > o2.getIndex())
                return 1;
            else
                return 0;
        }
    }

}
