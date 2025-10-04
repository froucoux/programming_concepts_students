package basics;

public class CommonElements {

    /**
     *
     * @param tab1 is a non null array
     * @param tab2 is a non null array
     * @return the number of elements that are the same at the same index more
     * exactly the size of set {i such that tab1[i] == tab2[i]} for instance
     * count([1,3,5,5],[1,2,5,5,6]) = 3
     */
    public static int count(int[] tab1, int[] tab2) {
        int tab1Length = tab1.length;
        int tab2Length = tab2.length;
        int minLength = Math.min(tab1Length, tab2Length);
        int count = 0;
        for (int i = 0; i < minLength; i++) {
            if (tab1[i] == tab2[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param tab1 is a non null 2D array
     * @param tab2 is a non null 2D array
     * @return the number of elements that are the same at the same index more
     * exactly the size of set {(i,j) such that tab1[i][j] == tab2[i][j]}
     */
    public static int count(int[][] tab1, int[][] tab2) {
        int count = 0;
        int tab1RowLength = tab1.length;
        int tab2RowLength = tab2.length;
        int minRowLength = Math.min(tab1RowLength, tab2RowLength);

        for (int rowIdx = 0; rowIdx < minRowLength; rowIdx++) {
            int[] tab1Row = tab1[rowIdx];
            int[] tab2Row = tab2[rowIdx];
            int row1Length = tab1Row.length;
            int row2Length = tab2Row.length;
            int minColLength = Math.min(row1Length, row2Length);
            for (int colIdx = 0; colIdx < minColLength; colIdx++) {
                if (tab1Row[colIdx] == tab2Row[colIdx]) {
                    count++;
                }
            }
        }

        return count;
    }
}
