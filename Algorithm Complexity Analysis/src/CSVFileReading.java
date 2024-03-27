import java.lang.*;
import java.io.*;
import java.util.*;
public class CSVFileReading {
    public static Integer[] readTrafficData(String filename)  {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<Integer> data = new ArrayList<>();
            reader.readLine(); // Skip the first line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitted = line.split(",");
                data.add(Integer.parseInt(splitted[6]));
            }

            Integer[] resultArr = new Integer[data.size()];
            resultArr = randomizeData(data.toArray(resultArr));
            return data.toArray(resultArr);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }


    // TODO : Implement the readTrafficData method


    // TODO:  Randomize the readed data
    public static Integer[] randomizeData(Integer[] data) {
        List<Integer> list = Arrays.asList(data);
        Collections.shuffle(list);

        return list.toArray(new Integer[0]);
    }

}
