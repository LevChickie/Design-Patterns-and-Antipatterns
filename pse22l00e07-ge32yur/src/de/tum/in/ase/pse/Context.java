package de.tum.in.ase.pse;

import java.util.Iterator;
import java.util.List;

public class Context {
    private List<Chapter> book;
    private SearchStrategy searchAlgorithm;
    public int search(String name) {
        return searchAlgorithm.performSearch(book, name);
    }

    public boolean isChaptersSortedByName() {
        if (book.isEmpty() || book.size() == 1) {
            return true;
        }
        Iterator<Chapter> iterator = book.iterator();
        Chapter current = iterator.next();
        Chapter previous = current;
        while (iterator.hasNext()) {
            current = iterator.next();
            if (previous.getName().compareTo(current.getName()) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public void setBook(List<Chapter> book) {
        this.book = book;
    }

    public List<Chapter> getBook() {
        return book;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }
}
