public class CS extends SortAlgorithm {

    @Override
    public int[] sortMet(int[] a) {
        int N = a.length;
        int[] o = new int[N + 1];
        int m = a[0];
        for (int i = 1; i < N; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        int[] c = new int[m + 1];
        for (int i = 0; i < m; ++i) {
            c[i] = 0;
        }
        for (int i = 0; i < N; i++) {
            c[a[i]]++;
        }
        for (int i = 1; i <= m; i++) {
            c[i] += c[i - 1];
        }
        for (int i = N - 1; i >= 0; i--) {
            o[c[a[i]] - 1] = a[i];
            c[a[i]]--;
        }
        System.arraycopy(o, 0, a, 0, N);
        return a;
    }
}
