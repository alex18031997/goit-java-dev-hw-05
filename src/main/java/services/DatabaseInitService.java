package services;

import config.Database;
import props.PropertyReader;

import java.sql.Connection;

public class DatabaseInitService {

    public static void main(String[] args) {
        Connection conn = Database.getConnection();
        System.out.println(conn);
        String dBInitFile = PropertyReader.getDataFromProp("db.init.path", false);
        ReadSQLFile readFile = new ReadSQLFile();
        String[] sqlStatements = readFile.readFile(dBInitFile);

        for (String sql : sqlStatements) {
            Database.executeUpdate(sql);
        }
    }

}
