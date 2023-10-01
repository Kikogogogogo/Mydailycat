package api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Data implements DataAccess{
    @Override
    public Integer[] getRatingFromCSV(String fileName) {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            BufferedReader filereader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = filereader.readLine()) != null) {
                result.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Integer[] r = new Integer[result.size()];
        r = result.toArray(r);
        return r;
    }

    @Override
    public void setRatingInCSV(String fileName, int rating) {
        String r = ((Integer) rating).toString();
        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.write(r + '\n');
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setPictureRating(int rating) {
        setRatingInCSV("PictureRating.csv", rating);
    }

    @Override
    public Integer[] getPictureRating() {
        return getRatingFromCSV("PictureRating.csv");
    }

    @Override
    public void setFactRating(int rating) {
        setRatingInCSV("FactRating.csv", rating);
    }

    @Override
    public Integer[] getFactRating() {
        return getRatingFromCSV("FactRating.csv");
    }
}
