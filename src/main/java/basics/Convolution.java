package basics;

public class Convolution {

    /**
     *
     * @param input is a n1 x m1 non-null rectangular matrix with at least 3
     * rows and 3 cols
     * @param kernel is a 3 x 3 square matrix
     * @return a matrix M with dimension (n1-2) x (m1-2) with M[i][j] = sum_{k
     * in 0..2, l in 0..2} input[i+k][j+l]*kernel[k][l]
     */
    static final int KERNEL_WIDTH = 3;

    public static int[][] convolution(int[][] input, int[][] kernel) {
        int n1 = input.length;
        int m1 = input[0].length;
        int resultRowsSize = n1 - (KERNEL_WIDTH - 1);
        int resultColsSize = m1 - (KERNEL_WIDTH - 1);

        int[][] result = new int[resultRowsSize][resultColsSize];

        for (int i = 0; i < resultRowsSize; i++) {
            for (int j = 0; j < resultColsSize; j++) {
                int sum = 0;
                for (int k = 0; k < KERNEL_WIDTH; k++) {
                    for (int l = 0; l < KERNEL_WIDTH; l++) {
                        sum += input[i + k][j + l] * kernel[k][l];
                    }
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
}
