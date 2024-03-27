import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import java.io.IOException;
import java.util.Arrays;


class Main {
    public static void main(String args[]) throws IOException {

        CSVFileReading c = new CSVFileReading();
        Integer[] n = c.readTrafficData(args[0]);
        int[] iN = Arrays.stream(n).mapToInt(Integer::intValue).toArray();
        System.arraycopy(iN, 0, iN, 0, iN.length);
        Sorting s = new Sorting();
//        s.insertionSort(iN);
        SortAlgorithm i = new IS();
        SortAlgorithm co = new CS();
        SortAlgorithm m = new MS();

        double[][] r_m = Sorting.t(iN, m, "Merge Sort");
        double[][] r_c = Sorting.t(iN, co, "Counting Sort");
        double[][] r_i = Sorting.t(iN, i, "Insertion Sort");

        CSVFileReading.randomizeData(n);
        iN = Arrays.stream(n).mapToInt(Integer::intValue).toArray();
        double[][] r_s = Searching.tS(iN, 797, "Searching");
        int[] xA = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};
        double[][] y_r = new double[4][10];
        double[][] y_so = new double[4][10];
        double[][] y_re = new double[4][10];
        y_r[0] = r_c[0];
        y_r[1] = r_i[0];
        y_r[2] = r_m[0];
        y_so[0] = r_c[1];
        y_so[1] = r_i[1];
        y_so[2] = r_m[1];
        y_re[0] = r_c[2];
        y_re[1] = r_i[2];
        y_re[2] = r_m[2];



        showAndSaveChart("Random Data Test", xA, y_r);
        showAndSaveChart("Sorted Data Test", xA, y_so);
        showAndSaveChart("Reversed Data Test", xA, y_re);
        showAndSaveChartForSearching("Search Algorithms", xA, r_s);


    }

    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("Counting Sort", doubleX, yAxis[0]);
        chart.addSeries("Insertion Sort", doubleX, yAxis[1]);
        chart.addSeries("Merge Sort", doubleX, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }


    public static void showAndSaveChartForSearching(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("Linear Search", doubleX, yAxis[0]);
        chart.addSeries("Sorted Linear Search", doubleX, yAxis[1]);
        chart.addSeries("Binary Search", doubleX, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
}
