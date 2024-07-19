 package de.tum.in.ase.pse;

public class Policy {
    private Context context;

    public Policy(Context context) {
        this.context = context;
    }

    public void configure() {
        if (context.isChaptersSortedByName()) {
            BinarySearch binarySearch = new BinarySearch();
            context.setSearchAlgorithm(binarySearch);
        }
        else {
            LinearSearch linearSearch = new LinearSearch();
            context.setSearchAlgorithm(linearSearch);
        }
    }
}
