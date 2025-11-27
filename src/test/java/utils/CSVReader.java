package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    // Utility method to read a CSV file from src/test/resources
    public static Object[][] readCSV(String relativePath) {

        String filePath = "src/test/resources/" + relativePath;

        List<Object[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {
                // skip header row (first line)
                if (header) {
                    header = false;
                    continue;
                }

                String[] data = line.split(",");
                rows.add(new Object[]{data[0], data[1]});
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not read CSV file: " + filePath, e);
        }

        return rows.toArray(new Object[0][]);
    }
}