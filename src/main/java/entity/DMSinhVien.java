package entity;

import dao.DMSinhVienDAO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.out;

public class DMSinhVien implements DMSinhVienDAO {
    @Override
    public void createSinhVien() {
        String sqlInsert = "INSERT INTO dmsv VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");

             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);) {

            Scanner scanner = new Scanner(System.in);
            out.println("Enter SinhVienID colum to create: ");
            String createSinhVienID = scanner.next();

            out.println("Enter HoSinhVien colum to create: ");
            String createHoSinhVien = scanner.next();

            out.println("Enter NameSinhVien colum to create: ");
            String createNameSinhVien = scanner.next();

            out.println("Enter GenderSinhVien colum to create: ");
            String createGenderSinhVien = scanner.next();

            out.println("Enter BirthDaySinhVien colum to create: ");
            String createBirthdaySinhVien = scanner.next();

            out.println("Enter NoisinhSinhVien colum to create: ");
            String createNoisinhSinhVien = scanner.next();

            out.println("Enter MakhoaSinhVien colum to create: ");
            String createMaKhoaSinhVien = scanner.next();

            out.println("Enter HocBongSinhVien colum to create: ");
            String createHocBongSinhVien = scanner.next();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(createBirthdaySinhVien);
            java.sql.Date datesql = new java.sql.Date(date.getTime());

            if (createSinhVienID != null || createSinhVienID != "") {
                preparedStatement.setString(1, createSinhVienID);
                preparedStatement.setString(2, createHoSinhVien);
                preparedStatement.setString(3, createNameSinhVien);
                preparedStatement.setString(4, createGenderSinhVien);
                preparedStatement.setDate(5, datesql);
                preparedStatement.setString(6, createNoisinhSinhVien);
                preparedStatement.setString(7, createMaKhoaSinhVien);
                preparedStatement.setString(8, createHocBongSinhVien);
                int rowInsert = preparedStatement.executeUpdate();
                out.println(rowInsert + " Colum create done");
            } else {
                out.printf("Vui long nhap lai  ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSinhVien() {
        String sqlUpdate = "UPDATE DMKHOA SET nameKhoa = ? WHERE khoaID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", ""); PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);) {
            System.out.println("Enter Sinh Vien colum to create: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter SinhVienID colum to create: ");
            String createSinhVienID = scanner.next();
            System.out.println("Enter HoSinhVien colum to create: ");
            String createHoSinhVien = scanner.next();
            System.out.println("Enter NameSinhVien colum to create: ");
            String createNameSinhVien = scanner.next();
            System.out.println("Enter GenderSinhVien colum to create: ");
            String createGenderSinhVien = scanner.next();
            System.out.println("Enter BirthDaySinhVien colum to create: ");
            String createBirthdaySinhVien = scanner.next();
            System.out.println("Enter NoisinhSinhVien colum to create: ");
            String createNoisinhSinhVien = scanner.next();
            System.out.println("Enter MakhoaSinhVien colum to create: ");
            String createMaKhoaSinhVien = scanner.next();
            System.out.println("Enter HocBongSinhVien colum to create: ");
            String createHocBongSinhVien = scanner.next();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(createBirthdaySinhVien);
            java.sql.Date datesql = new java.sql.Date(date.getTime());


            preparedStatement.setString(1, createSinhVienID);
            preparedStatement.setString(2, createHoSinhVien);
            preparedStatement.setString(3, createNameSinhVien);
            preparedStatement.setString(4, createGenderSinhVien);
            preparedStatement.setDate(5, datesql);
            preparedStatement.setString(6, createNoisinhSinhVien);
            preparedStatement.setString(7, createMaKhoaSinhVien);
            preparedStatement.setString(8, createHocBongSinhVien);

            int rowDelete = preparedStatement.executeUpdate();
            System.out.println(rowDelete + " Colum update done");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSinhVien() {
        String sqlDelete = "delete from dmSV where maSV = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sinhVienID colum to delete: ");
            String idDelete = scanner.next();
            System.out.println("sinhVienID to delete is: " + idDelete);

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
                String SinhVienID = resultset.getString("maSV");
                String HoSinhVien = resultset.getString("hoSV");
                String NameSinhVien = resultset.getString("TenSV");
                String GenderSinhVien = resultset.getString("Gender");
                Date BirthdaySinhVien = resultset.getDate("NgaySinh");
                String NoisinhSinhVien = resultset.getString("NoiSinh");
                String MaKhoaSinhVien = resultset.getString("MaKhoa");
                String HocBongSinhVien = resultset.getString("HocBong");
                System.out.println("dmSV:" + SinhVienID + ", " + HoSinhVien + "," + NameSinhVien + "," + GenderSinhVien + "," + BirthdaySinhVien + "," + NoisinhSinhVien + "," + MaKhoaSinhVien + "," + HocBongSinhVien);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createManySinhVien() {
        String sqlInsert = "INSERT INTO dmSV VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);) {
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
            String createBirthdaySinhVien = scanner.next();
            System.out.println("Enter BirthDaySinhVien colum to create: ");
            String createNoisinhSinhVien = scanner.next();
            System.out.println("Enter NoisinhSinhVien colum to create: ");
            String createMaKhoaSinhVien = scanner.next();
            System.out.println("Enter MakhoaSinhVien colum to create: ");
            String createHocBongSinhVien = scanner.next();
            System.out.println("Enter HocBongSinhVien colum to create: ");


            System.out.println("Enter Sinh Vien colum to create: ");
            String createSinhVienID1 = scanner.next();
            System.out.println("Enter SinhVienID colum to create: ");
            String createHoSinhVien1 = scanner.next();
            System.out.println("Enter HoSinhVien colum to create: ");
            String createNameSinhVien1 = scanner.next();
            System.out.println("Enter NameSinhVien colum to create: ");
            String createGenderSinhVien1 = scanner.next();
            System.out.println("Enter GenderSinhVien colum to create: ");
            String createBirthdaySinhVien1 = scanner.next();
            System.out.println("Enter BirthDaySinhVien colum to create: ");
            String createNoisinhSinhVien1 = scanner.next();
            System.out.println("Enter NoisinhSinhVien colum to create: ");
            String createMaKhoaSinhVien1 = scanner.next();
            System.out.println("Enter MakhoaSinhVien colum to create: ");
            String createHocBongSinhVien1 = scanner.next();
            System.out.println("Enter HocBongSinhVien colum to create: ");

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(createBirthdaySinhVien);
            java.sql.Date datesql = new java.sql.Date(date.getTime());

            Date date1 = format.parse(createBirthdaySinhVien1);
            java.sql.Date datesql1 = new java.sql.Date(date1.getTime());


            if (createSinhVienID != null || createSinhVienID != "") {
                preparedStatement.setString(1, createSinhVienID);
                preparedStatement.setString(2, createNameSinhVien);
                preparedStatement.setString(3, createHoSinhVien);
                preparedStatement.setString(4, createGenderSinhVien);
                preparedStatement.setDate(5, datesql);
                preparedStatement.setString(6, createNoisinhSinhVien);
                preparedStatement.setString(7, createMaKhoaSinhVien);
                preparedStatement.setString(8, createHocBongSinhVien);

                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai ");
            }

            if (createSinhVienID1 != null || createHoSinhVien1 != "") {
                preparedStatement.setString(1, createSinhVienID1);
                preparedStatement.setString(2, createNameSinhVien1);
                preparedStatement.setString(3, createHoSinhVien1);
                preparedStatement.setString(4, createGenderSinhVien1);
                preparedStatement.setDate(5, datesql1);
                preparedStatement.setString(6, createNoisinhSinhVien1);
                preparedStatement.setString(7, createMaKhoaSinhVien1);
                preparedStatement.setString(8, createHocBongSinhVien1);
                int rowInsert = preparedStatement.executeUpdate();
                System.out.println(rowInsert + " Colum create done");
            } else {
                System.out.printf("Vui long nhap lai ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
