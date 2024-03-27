import java.util.Arrays;



public class Sorting  {



    public static double[][] t(int[] n, SortAlgorithm s, String sn) {
        if(sn.equals("Insertion Sort")){
            s = (IS) s;
        }
        if(sn.equals("Merge Sort")){
            s = s;
        }

        if(sn.equals("Counting Sort")){
            s = (CS) s;
        }
        int i = -1;
        double[][] r = new double[3][10];
        for (int j = 500; j < 257000; j = j * 2) {
            if (j == 256000) {
                j = 250000;
            }
            int rs = 0;
            int ss = 0;
            int rv = 0;
            i++;
            int[] a = new int[j];
            int[] ra = new int[j];
            for (int k = 0; k < 10; k++) {
                System.arraycopy(n, 0, a, 0, j);
                long st = System.currentTimeMillis();
                s.sortMet(a);
                long e = System.currentTimeMillis();
                rs += e - st;
            }
            rs = rs / 10;

            System.arraycopy(a, 0, a, 0, j);
            s.sortMet(a);
            for (int k = 0; k < 10; k++) {
                long st = System.currentTimeMillis();
                s.sortMet(a);
                long e = System.currentTimeMillis();
                ss += e - st;
            }
            ss = ss / 10;

            Integer[] rvr = new Integer[j];
            for (int k = 0; k < j; k++) {
                rvr[k] = a[j - k - 1];
            }
            a = Arrays.stream(rvr).mapToInt(Integer::intValue).toArray();
            for (int k = 0; k < 10; k++) {
                System.arraycopy(a, 0, ra, 0, j);
                long st = System.currentTimeMillis();
                s.sortMet(ra);
                long e = System.currentTimeMillis();
                rv += e - st;
            }
            rv = rv / 10;

            r[0][i] = rs;
            r[1][i] = ss;
            r[2][i] = rv;
        }
        return r;
    }



}
