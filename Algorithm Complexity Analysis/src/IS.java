public class IS extends SortAlgorithm {

    private static void sw(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    @Override
    public int[] sortMet(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < (a[j - 1])) {
                    sw(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return a;
    }
}
