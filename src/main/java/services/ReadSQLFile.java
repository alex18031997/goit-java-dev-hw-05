package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadSQLFile {
    public static String[] readFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }
            reader.close();

            return sqlBuilder.toString().split(";");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readSelectFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }
            reader.close();

            return sqlBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
