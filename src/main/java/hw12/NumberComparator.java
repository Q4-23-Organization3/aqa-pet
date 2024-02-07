package hw12;

import java.util.Comparator;

public class NumberComparator implements Comparator<Integer> {

    private final Integer x;
    public NumberComparator(Integer num) {
        this.x = num;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        Integer comparing1 = x.compareTo(o1);
        Integer comparing2 = x.compareTo(o2);
        return comparing2.compareTo(comparing1);
    }
}
