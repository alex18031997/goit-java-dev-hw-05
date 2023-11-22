package services;


import config.Database;
import props.PropertyReader;

import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        ReadSQLFile readFile = new ReadSQLFile();
        String DBPopulateFile = PropertyReader.getDataFromProp("db.populate.path", false);
        String[] sqlStatements = readFile.readFile(DBPopulateFile);

        for (String sql : sqlStatements) {
            Database.insertValueToDB(sql);
        }
    }
}
