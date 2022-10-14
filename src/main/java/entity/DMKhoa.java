package entity;

import dao.DMKhoaDAO;

import java.sql.*;
import java.util.Scanner;

public class DMKhoa implements DMKhoaDAO {
    @Override
    public void createKhoa() {
        String sqlInsert = "INSERT INTO DMKHOA VALUES(?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter khoaID colum to create: ");
            String createKhoaID = scanner.next();
            System.out.println("Enter nameKhoa colum to create: ");
            String createNameKhoa = scanner.next();

            preparedStatement.setString(1,createKhoaID);
            preparedStatement.setString(2,createNameKhoa);

            int rowInsert = preparedStatement.executeUpdate();
            System.out.println(rowInsert + " Colum delete done");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateKhoa() {
        String sqlUpdate = "UPDATE DMKHOA SET nameKhoa = ? WHERE khoaID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter khoaID colum to update: ");
            String idKHOA = scanner.next();
            System.out.println("Enter nameKhoa colum to update: ");
            String updateNameKhoa = scanner.next();

            preparedStatement.setString(1, updateNameKhoa);
            preparedStatement.setString(2,idKHOA);

            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum update done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteKhoa() {
        String sqlDelete = "delete from DMKhoa where khoaID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter khoaID colum to delete: ");
            String idDelete = scanner.next();
            System.out.println("khoaID to delete is: " + idDelete);

            preparedStatement.setString(1, idDelete);
            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum delete done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readKhoa() {
        String sqlPrint = "select * from dmkhoa";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlPrint);
        ) {

            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                String khoaID = resultset.getString("khoaID");
                String khoaName = resultset.getString("nameKhoa");
                System.out.println("DMKhoa:" + khoaID + ", " + khoaName);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createManyKhoa() {

    }
}
