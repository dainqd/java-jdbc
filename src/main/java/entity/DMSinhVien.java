package entity;

import dao.DMSinhVienDAO;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.out;

public class DMSinhVien implements DMSinhVienDAO {
    @Override
    public void createSinhVien() {
        String sqlInsert = "INSERT INTO DMKHOA VALUES(?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);) {

            Scanner scanner = new Scanner(System.in);
            out.println("Enter Sinh Vien colum to create: ");
            String createSinhVienID = scanner.next();
            out.println("Enter SinhVienID colum to create: ");
            String createHoSinhVien = scanner.next();
            out.println("Enter HoSinhVien colum to create: ");
            String createNameSinhVien = scanner.next();
            out.println("Enter NameSinhVien colum to create: ");
            String createGenderSinhVien = scanner.next();
            out.println("Enter GenderSinhVien colum to create: ");
            Date createBirthdaySinhVien = new Date();
            out.println("Enter BirthDaySinhVien colum to create: ");
            String createNoisinhSinhVien = scanner.next();
            out.println("Enter NoisinhSinhVien colum to create: ");
            String createMaKhoaSinhVien = scanner.next();
            out.println("Enter MakhoaSinhVien colum to create: ");
            String createHocBongSinhVien = scanner.next();
            out.println("Enter HocBongSinhVien colum to create: ");

            if (createSinhVienID != null || createSinhVienID != "") {
                preparedStatement.setString(1, createSinhVienID);
                preparedStatement.setString(2, createHoSinhVien);
                preparedStatement.setString(3, createNameSinhVien);
                preparedStatement.setString(4, createGenderSinhVien);
                preparedStatement.setDate(5, (java.sql.Date) createBirthdaySinhVien);
                preparedStatement.setString(6, createNoisinhSinhVien);

                preparedStatement.setString(7, createMaKhoaSinhVien);
                preparedStatement.setString(8, createHocBongSinhVien);
                int rowInsert = preparedStatement.executeUpdate();
                out.println(rowInsert + " Colum create done");
            } else {
                out.printf("Vui long nhap lai Sinh Vien ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSinhVien() {
        String sqlUpdate = "UPDATE DMKHOA SET nameKhoa = ? WHERE khoaID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", ""); PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Sinh Vien colum to create: ");
            String createSinhVienID = scanner.next();
            System.out.println("Enter SinhVienID colum to create: ");
            String createHoSinhVien = scanner.next();
            System.out.println("Enter HoSinhVien colum to create: ");
            String createNameSinhVien = scanner.next();
            System.out.println("Enter NameSinhVien colum to create: ");
            String createGenderSinhVien = scanner.next();
            System.out.println("Enter GenderSinhVien colum to create: ");
            Date createBirthdaySinhVien = new Date();
            System.out.println("Enter BirthDaySinhVien colum to create: ");
            String createNoisinhSinhVien = scanner.next();
            System.out.println("Enter NoisinhSinhVien colum to create: ");
            String createMaKhoaSinhVien = scanner.next();
            System.out.println("Enter MakhoaSinhVien colum to create: ");
            String createHocBongSinhVien = scanner.next();
            System.out.println("Enter HocBongSinhVien colum to create: ");
            preparedStatement.setString(1, createSinhVienID);
            preparedStatement.setString(2, createHoSinhVien);
            preparedStatement.setString(3, createNameSinhVien);
            preparedStatement.setString(4, createGenderSinhVien);
            preparedStatement.setDate(5, (java.sql.Date) createBirthdaySinhVien);
            preparedStatement.setString(6, createNoisinhSinhVien);
            preparedStatement.setString(7, createMaKhoaSinhVien);
            preparedStatement.setString(8, createHocBongSinhVien);

            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum update done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSinhVien() {
        String sqlDelete = "delete from dmSV where maSV = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);) {
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
    public void readSinhVien() {
        String sqlPrint = "select * from dmSV";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlPrint);) {
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
    public void createManySinhVien() {
        String sqlInsert = "INSERT INTO DMKHOA VALUES(?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);) {

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

            if (createKhoaID != null || createKhoaID != "") {
                preparedStatement.setString(1, createKhoaID);
                preparedStatement.setString(2, createNameKhoa);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai khoaID va nameKhoa");
            }

            if (createKhoaID1 != null || createKhoaID1 != "") {
                preparedStatement.setString(1, createKhoaID1);
                preparedStatement.setString(2, createNameKhoa1);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai khoaID va nameKhoa");
            }

            if (createKhoaID2 != null || createKhoaID2 != "") {
                preparedStatement.setString(1, createKhoaID2);
                preparedStatement.setString(2, createNameKhoa2);
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
