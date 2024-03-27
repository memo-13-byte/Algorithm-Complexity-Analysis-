import java.util.Random;

public class Searching {

    private static int BS(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (x == a[m]) return m;
            if (x > a[m]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static int LS(int[] a, int x) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == x) return i;
        return -1;
    }

    public static double[][] tS(int[] a, int x, String t) {
        Random r = new Random();
        int i = -1;
        double[][] rs = new double[3][10];
        for (int j = 500; j < 257000; j *= 2) {
            if (j == 256000) j = 250000;
            int rsrch = 0, fsrch = 0, nfsrch = 0;
            i++;
            int[] arr = new int[j];
            for (int k = 0; k < 1000; k++) {
                System.arraycopy(a, 0, arr, 0, j);
                int rnd = sel(a);
                long s = System.nanoTime();
                LS(arr, rnd);
                long e = System.nanoTime();
                rsrch += e - s;
            }
            rsrch /= 1000;

            IS is = new IS();
            int[] sortedArr = is.sortMet(arr);
            for (int k = 0; k < 1000; k++) {
                int rnd = sel(sortedArr);
                long s = System.nanoTime();
                LS(sortedArr, rnd);
                long e = System.nanoTime();
                fsrch += e - s;

            }
            fsrch /= 1000;

            for (int k = 0; k < 1000; k++) {
                int rnd = sel(sortedArr);
                long s = System.nanoTime();
                BS(sortedArr, rnd);
                long e = System.nanoTime();
                nfsrch += e - s;

            }
            nfsrch /= 1000;
            rs[0][i] = rsrch;
            rs[1][i] = fsrch;
            rs[2][i] = nfsrch;
        }
        return rs;
    }

    public static int sel(int[] a) {
        Random r = new Random();
        return a[r.nextInt(a.length)];
    }
}