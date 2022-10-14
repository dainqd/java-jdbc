import entity.DMKhoa;

public class QuanLiDiemSinhVien {
    public static void main(String[] args) {
        DMKhoa dmKhoa = new DMKhoa();
        System.out.println("");
        dmKhoa.createManyKhoa();
        dmKhoa.readKhoa();
        System.out.println();
        dmKhoa.createKhoa();
        dmKhoa.readKhoa();
        System.out.println();
        dmKhoa.updateKhoa();
        dmKhoa.readKhoa();
        System.out.println();
        dmKhoa.deleteKhoa();
        dmKhoa.readKhoa();


    }
}
