package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Converter {

    public List<Integer> convertToArrayList(int[] arrayInteger) {
        List<Integer> integerList = new LinkedList<>();
        for (int number : arrayInteger) {
            integerList.add(number);
        }
        return integerList;
    }
}
