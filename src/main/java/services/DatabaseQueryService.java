package services;

import config.Database;
import interfaces.*;
import props.PropertyReader;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private static ReadSQLFile readSQLFile = new ReadSQLFile();

    public static void main(String[] args) throws IOException, SQLException {
        List<MaxProjectCountClient> maxProjectCountClients = findMaxProjectsClient();
        List<MaxSalaryWorker> maxSalaryWorker = findMaxSalaryWorker();
        List<MaxYoungestEldestWorker> maxYoungestEldestWorkers = findYoungestEldestWorker();
        List<ProjectPrices> projectPrices = findProjectPrices();
        List<LongestProject> longestProject = findLongestProject();

        System.out.println(maxProjectCountClients);
        System.out.println(maxSalaryWorker);
        System.out.println(maxYoungestEldestWorkers);
        System.out.println(projectPrices);
        System.out.println(longestProject);
    }

    public static List<LongestProject> findLongestProject() throws IOException {

        List<LongestProject> longestProjects = new ArrayList<>();

        try {
            String longestProjectFile = PropertyReader.getDataFromProp("db.find.longest.project.path", false);
            String readFile = ReadSQLFile.readSelectFile(longestProjectFile);

            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readFile);


            while (resultSet.next()) {
                LongestProject project = new LongestProject();
                String name = resultSet.getString("NAME");
                int MONTH_COUNT = resultSet.getInt("MONTH_COUNT");
                project.setName(name);
                project.setMonthCount(MONTH_COUNT);
                longestProjects.add(project);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }

        return longestProjects;
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {

        List<MaxProjectCountClient> maxProjectsClient = new ArrayList<>();

        try {
            String maxProjectsClientFile = PropertyReader.getDataFromProp("db.find.max.projects.client.path", false);
            String readFile = ReadSQLFile.readSelectFile(maxProjectsClientFile);
            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readFile);

            while (resultSet.next()) {
                MaxProjectCountClient project = new MaxProjectCountClient();
                String name = resultSet.getString("NAME");
                int PROJECT_COUNT = resultSet.getInt("PROJECT_COUNT");
                project.setName(name);
                project.setProjectCount(PROJECT_COUNT);
                maxProjectsClient.add(project);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }

        return maxProjectsClient;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {

        List<MaxSalaryWorker> maxSalaryWorker = new ArrayList<>();

        try {
            String maxSalaryWorkerFile = PropertyReader.getDataFromProp("db.find.max.salary.worker.path", false);
            String readFile = ReadSQLFile.readSelectFile(maxSalaryWorkerFile);

            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readFile);

            while (resultSet.next()) {
                MaxSalaryWorker worker = new MaxSalaryWorker();
                String name = resultSet.getString("NAME");
                int MONTH_COUNT = resultSet.getInt("SALARY");
                worker.setName(name);
                worker.setSalary(MONTH_COUNT);
                maxSalaryWorker.add(worker);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }

        return maxSalaryWorker;
    }

    public static List<MaxYoungestEldestWorker> findYoungestEldestWorker() throws IOException, SQLException {

        List<MaxYoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        try {
            String youngestEldestWorkerFile = PropertyReader.getDataFromProp("db.find.youngest.eldest.workers.path", false);
            String readFile = ReadSQLFile.readSelectFile(youngestEldestWorkerFile);

            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readFile);

            while (resultSet.next()) {
                MaxYoungestEldestWorker worker = new MaxYoungestEldestWorker();
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");
                worker.setType(type);
                worker.setName(name);
                worker.setBirthday(birthday);
                youngestEldestWorkers.add(worker);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }

        return youngestEldestWorkers;
    }

    public static List<ProjectPrices> findProjectPrices() throws IOException, SQLException {

        List<ProjectPrices> projectsPrices = new ArrayList<>();

        try {
            String projectsPricesFile = PropertyReader.getDataFromProp("db.print.projects.prices.path", false);
            String readFile = readSQLFile.readSelectFile(projectsPricesFile);

            Statement statement = Database.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(readFile);

            while (resultSet.next()) {
                ProjectPrices projectPrice = new ProjectPrices();
                String name = resultSet.getString("NAME");
                int PRICE = resultSet.getInt("PRICE");
                projectPrice.setName(name);
                projectPrice.setPrice(PRICE);
                projectsPrices.add(projectPrice);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }

        return projectsPrices;
    }
}
