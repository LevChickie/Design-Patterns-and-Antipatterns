package de.tum.in.ase.pse;

import java.util.List;

public class LinearSearch implements SearchStrategy {
    public int performSearch(List<Chapter> chapterList, String chapter) {
        for (Chapter ch : chapterList) {
            if (ch.getName().equals(chapter)) {
                return ch.getPageNumber();
            }
        }
        return -1;
    }
}
