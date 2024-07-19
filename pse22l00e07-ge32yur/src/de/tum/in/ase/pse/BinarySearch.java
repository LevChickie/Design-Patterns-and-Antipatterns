package de.tum.in.ase.pse;


import java.util.List;

public class BinarySearch implements SearchStrategy {
    public int bin(List<Chapter> chapterList, String chapter) {
        int low = 0;
        int mid;
        int comparison;
        int high = chapterList.size() - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            comparison = chapterList.get(mid).getName().compareTo(chapter);
            if (comparison == 0) {
                return chapterList.get(mid).getPageNumber();
            }
            else if (comparison > 0) {
                high = mid - 1;
            }
            else if (comparison < 0) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
