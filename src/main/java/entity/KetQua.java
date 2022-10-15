package entity;

import dao.KetQuaDao;

import java.sql.*;
import java.util.Scanner;

public class KetQua implements KetQuaDao {
    @Override
    public void createKetQua() {
        String sqlInsert = "INSERT INTO DMKETQUA VALUES(?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter KetquaID colum to create: ");
            String createKetQuaID = scanner.next();
            System.out.println("Enter nameKhoa colum to create: ");
            String createKetQua = scanner.next();

            if (createKetQuaID != null || createKetQuaID != "") {
                preparedStatement.setString(1, createKetQuaID);
                preparedStatement.setString(2, createKetQua);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai KetQuaID va Ket qua");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateKetQua() {
        String sqlUpdate = "UPDATE DMKETQUA SET nameKhoa = ? WHERE khoaID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter khoaID colum to update: ");
            String idKetQua = scanner.next();
            System.out.println("Enter nameKhoa colum to update: ");
            String updateKetqua = scanner.next();

            preparedStatement.setString(1, updateKetqua);
            preparedStatement.setString(2, idKetQua);

            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum update done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteKetQua() {
        String sqlDelete = "delete from DMKETQUA where ketquaID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter ketquaID colum to delete: ");
            String idDelete = scanner.next();
            System.out.println("ketquaID to delete is: " + idDelete);

            preparedStatement.setString(1, idDelete);
            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum delete done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readKetQua() {
        String sqlPrint = "select * from dmketqua";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlPrint);
        ) {

            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                String ketquaID = resultset.getString("ketquaID");
                String ketqua = resultset.getString("ketqua");
                System.out.println("DMKhoa:" + ketquaID + ", " + ketqua);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createManyKetQua() {
        String sqlInsert = "INSERT INTO DMKETQUA VALUES(?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter khoaID colum to create: ");
            String createKetquaID = scanner.next();
            System.out.println("Enter nameKhoa colum to create: ");
            String createKetqua = scanner.next();

            System.out.println("Enter khoaID 2 colum to create: ");
            String createKetquaID1 = scanner.next();
            System.out.println("Enter nameKhoa 2 colum to create: ");
            String createKetqua1= scanner.next();

            System.out.println("Enter khoaID 3 colum to create: ");
            String createKetquaID2 = scanner.next();
            System.out.println("Enter nameKhoa 3 colum to create: ");
            String createKetqua2 = scanner.next();

            if (createKetquaID != null || createKetquaID !=""){
                preparedStatement.setString(1,createKetquaID);
                preparedStatement.setString(2,createKetqua);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai KetquaID va ketqua");
            }

            if (createKetquaID1 != null || createKetquaID1 !=""){
                preparedStatement.setString(1,createKetquaID1);
                preparedStatement.setString(2,createKetqua1);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai KetquaID va ketqua");
            }

            if (createKetquaID2 != null || createKetquaID2 !=""){
                preparedStatement.setString(1,createKetquaID2);
                preparedStatement.setString(2,createKetqua2);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai KetquaID va ketqua");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
