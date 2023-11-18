package services;


import config.Database;
import props.PropertyReader;

public class DatabasePopulateService {
    public static void main(String[] args) {
        ReadSQLFile readFile = new ReadSQLFile();
        String DBPopulateFile = PropertyReader.getDataFromProp("db.populate.path", false);
        String[] sqlStatements = readFile.readFile(DBPopulateFile);

        for (String sql : sqlStatements) {
            Database.executeUpdate(sql);
        }
    }
}
