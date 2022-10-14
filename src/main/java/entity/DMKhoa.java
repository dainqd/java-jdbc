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

            if (createKhoaID != null || createKhoaID !=""){
                preparedStatement.setString(1,createKhoaID);
                preparedStatement.setString(2,createNameKhoa);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai khoaID va nameKhoa");
            }
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

            System.out.println("Enter khoaID 2 colum to create: ");
            String createKhoaID1 = scanner.next();
            System.out.println("Enter nameKhoa 2 colum to create: ");
            String createNameKhoa1 = scanner.next();

            System.out.println("Enter khoaID 3 colum to create: ");
            String createKhoaID2 = scanner.next();
            System.out.println("Enter nameKhoa 3 colum to create: ");
            String createNameKhoa2 = scanner.next();

            if (createKhoaID != null || createKhoaID !=""){
                preparedStatement.setString(1,createKhoaID);
                preparedStatement.setString(2,createNameKhoa);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai khoaID va nameKhoa");
            }

            if (createKhoaID1 != null || createKhoaID1 !=""){
                preparedStatement.setString(1,createKhoaID1);
                preparedStatement.setString(2,createNameKhoa1);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai khoaID va nameKhoa");
            }

            if (createKhoaID2 != null || createKhoaID2 !=""){
                preparedStatement.setString(1,createKhoaID2);
                preparedStatement.setString(2,createNameKhoa2);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai khoaID va nameKhoa");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
