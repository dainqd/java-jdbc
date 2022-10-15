package entity;

import dao.KetQuaDao;

import java.sql.*;
import java.util.Scanner;

public class KetQua implements KetQuaDao {
    @Override
    public void createKetQua() {
        String sqlInsert = "INSERT INTO dmketqua VALUES(?, ? , ?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter SinhVienID colum to create: ");
            String createSinhVienID = scanner.next();
            System.out.println("Enter TenSV colum to create: ");
            String TenSV = scanner.next();
            System.out.println("Enter TenMonHoc colum to create: ");
            String TenMonHoc = scanner.next();
            System.out.println("Enter Ketqua colum to create: ");
            String Ketqua = scanner.next();


            if (createSinhVienID != null || createSinhVienID != "") {
                preparedStatement.setString(1, createSinhVienID);
                preparedStatement.setString(2, TenSV);
                preparedStatement.setString(3, TenMonHoc);
                preparedStatement.setString(4, Ketqua);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateKetQua() {
        String sqlUpdate = "UPDATE dmketqua SET Ketqua = ? WHERE KetquaID = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter idKetQua colum to update: ");
            String idSinhvien = scanner.next();
            System.out.println("Enter updateKetqua colum to update: ");
            String updateKetqua = scanner.next();

            System.out.println("Enter updateKetqua colum to update: ");
            String updateTenMonHoc = scanner.next();

            System.out.println("Enter updateKetqua colum to update: ");
            String updateTenSV = scanner.next();


            preparedStatement.setString(1, updateKetqua);
            preparedStatement.setString(2, idSinhvien);
            preparedStatement.setString(3, updateTenMonHoc);
            preparedStatement.setString(4, updateTenSV);


            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum update done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteKetQua() {
        String sqlDelete = "delete from dmketqua where KetquaID = ?";
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
            System.out.println("Ketqua to delete is: " + idDelete);

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
                String sinhvienID = resultset.getString("SinhVienID");
                String tenSV = resultset.getString("TenSV");
                String tenMonHoc = resultset.getString("TenMonHoc");
                String ketqua = resultset.getString("Ketqua");

                System.out.println("dmketqua:" + sinhvienID + ", " + tenSV + "," + tenMonHoc + "," + ketqua);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createManyKetQua() {
        String sqlInsert = "INSERT INTO dmketqua VALUES(?, ?)";
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student",
                        "root", ""
                );

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        ) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter SinhVienID colum to create: ");
            String createSinhVienID = scanner.next();
            System.out.println("Enter TenSV colum to create: ");
            String createTenSV = scanner.next();
            System.out.println("Enter TenMonHoc colum to create: ");
            String createTenMonHoc = scanner.next();
            System.out.println("Enter Ketqua colum to create: ");
            String createKetqua = scanner.next();


            System.out.println("Enter SinhVienID colum to create: ");
            String createSinhVienID1 = scanner.next();
            System.out.println("Enter TenSV colum to create: ");
            String createTenSV1 = scanner.next();
            System.out.println("Enter TenMonHoc colum to create: ");
            String createTenMonHoc1 = scanner.next();
            System.out.println("Enter Ketqua colum to create: ");
            String createKetqua1 = scanner.next();

            System.out.println("Enter SinhVienID colum to create: ");
            String createSinhVienID2 = scanner.next();
            System.out.println("Enter TenSV colum to create: ");
            String createTenSV2 = scanner.next();
            System.out.println("Enter TenMonHoc colum to create: ");
            String createTenMonHoc2 = scanner.next();
            System.out.println("Enter Ketqua colum to create: ");
            String createKetqua2 = scanner.next();
            if (createSinhVienID != null || createSinhVienID != "") {
                preparedStatement.setString(1, createSinhVienID);
                preparedStatement.setString(2, createTenSV);
                preparedStatement.setString(3, createTenMonHoc);
                preparedStatement.setString(4, createKetqua);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai ");
            }

            if (createSinhVienID1 != null || createSinhVienID1 != "") {
                preparedStatement.setString(1, createSinhVienID1);
                preparedStatement.setString(2, createTenSV1);
                preparedStatement.setString(3, createTenMonHoc1);
                preparedStatement.setString(4, createKetqua1);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai ");
            }


            if (createSinhVienID2 != null || createSinhVienID2 != "") {
                preparedStatement.setString(1, createSinhVienID2);
                preparedStatement.setString(2, createTenSV2);
                preparedStatement.setString(3, createTenMonHoc2);
                preparedStatement.setString(4, createKetqua2);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
