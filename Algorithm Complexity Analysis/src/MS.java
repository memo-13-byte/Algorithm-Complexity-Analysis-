public class MS extends SortAlgorithm{


    public static int[] m(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                C[k++] = B[j++];
            } else {
                C[k++] = A[i++];
            }
        }
        while (i < A.length) {
            C[k++] = A[i++];
        }
        while (j < B.length) {
            C[k++] = B[j++];
        }
        return C;
    }

    @Override
    public int[] sortMet(int[] A) {
        int n = A.length;
        if (n <= 1)
            return A;
        int m = n / 2;
        int[] l = new int[m];
        int[] r = new int[n - m];
        for (int i = 0; i < m; i++)
            l[i] = A[i];
        for (int i = m; i < n; i++)
            r[i - m] = A[i];
        l = sortMet(l);
        r = sortMet(r);
        return m(l, r);
    }
}
