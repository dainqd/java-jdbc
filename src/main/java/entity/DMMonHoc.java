package entity;

import dao.DMMonHocDAO;

import java.sql.*;
import java.util.Scanner;

public class DMMonHoc implements DMMonHocDAO {
    @Override
    public void createMonHoc() {
        String sqlInsert = "INSERT INTO dmmonhoc VALUES(?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter monhocID colum to create: ");
            String createMonhocID = scanner.next();
            System.out.println("Enter monhoc colum to create: ");
            String createMonhoc = scanner.next();

            if (createMonhocID != null || createMonhocID != "") {
                preparedStatement.setString(1, createMonhocID);
                preparedStatement.setString(2, createMonhoc);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai MonhocID va mon hoc");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateMonHoc() {
        String sqlUpdate = "UPDATE dmmonhoc SET monhoc = ? WHERE monhocID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter khoaID colum to update: ");
            String idMONHOC = scanner.next();
            System.out.println("Enter nameKhoa colum to update: ");
            String updateMonhoc = scanner.next();

            preparedStatement.setString(1, updateMonhoc);
            preparedStatement.setString(2, idMONHOC);

            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum update done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMonHoc() {
        String sqlDelete = "delete from dmmonhoc where monhocID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter monhocID colum to delete: ");
            String idDelete = scanner.next();
            System.out.println("monhocID to delete is: " + idDelete);

            preparedStatement.setString(1, idDelete);
            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum delete done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readMonHoc() {
        String sqlPrint = "select * from dmMonhoc";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlPrint);
        ) {

            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                String monhocID = resultset.getString("khoaID");
                String monhoc = resultset.getString("nameKhoa");
                System.out.println("DMKhoa:" + monhocID + ", " + monhoc);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createManyMonHoc() {
        String sqlInsert = "INSERT INTO dmmonhoc VALUES(?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter monhocID colum to create: ");
            String createmonhocID = scanner.next();
            System.out.println("Enter monhoc colum to create: ");
            String createmonhoc = scanner.next();

            System.out.println("Enter monhocID 2 colum to create: ");
            String createmonhocID1 = scanner.next();
            System.out.println("Enter monhoc 2 colum to create: ");
            String createmonhoc1 = scanner.next();

            System.out.println("Enter monhocID 3 colum to create: ");
            String createmonhocID2 = scanner.next();
            System.out.println("Enter monhoc 3 colum to create: ");
            String createmonhoc2 = scanner.next();

            if (createmonhocID != null || createmonhocID != "") {
                preparedStatement.setString(1, createmonhocID);
                preparedStatement.setString(2, createmonhoc);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai monhocID va monhoc");
            }

            if (createmonhocID1 != null || createmonhocID1 != "") {
                preparedStatement.setString(1, createmonhocID1);
                preparedStatement.setString(2, createmonhoc1);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai monhocID va monhoc");
            }

            if (createmonhocID2 != null || createmonhocID2 != "") {
                preparedStatement.setString(1, createmonhocID2);
                preparedStatement.setString(2, createmonhoc2);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai monhocID va monhoc");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
