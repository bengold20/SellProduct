package ben.study.model;

import java.util.Date;

public class HoaDonModel {
    private String maHoaDon;
    private String maHang;
    private String tenMatHang;
    private String theLoaiMatHang;
    private int soLuongMatHang;
    private double giaBan;
    private Date ngayMua;
    private double tongThanhToan;

    public HoaDonModel() {
    }

    public HoaDonModel(String maHoaDon, String maHang, String tenMatHang, String theLoaiMatHang, int soLuongMatHang, double giaBan, Date ngayMua, double tongThanhToan) {
        this.maHoaDon = maHoaDon;
        this.maHang = maHang;
        this.tenMatHang = tenMatHang;
        this.theLoaiMatHang = theLoaiMatHang;
        this.soLuongMatHang = soLuongMatHang;
        this.giaBan = giaBan;
        this.ngayMua = ngayMua;
        this.tongThanhToan = tongThanhToan;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public String getTheLoaiMatHang() {
        return theLoaiMatHang;
    }

    public void setTheLoaiMatHang(String theLoaiMatHang) {
        this.theLoaiMatHang = theLoaiMatHang;
    }

    public int getSoLuongMatHang() {
        return soLuongMatHang;
    }

    public void setSoLuongMatHang(int soLuongMatHang) {
        this.soLuongMatHang = soLuongMatHang;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public double getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(double tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maHang='" + maHang + '\'' +
                ", tenMatHang='" + tenMatHang + '\'' +
                ", theLoaiMatHang='" + theLoaiMatHang + '\'' +
                ", soLuongMatHang=" + soLuongMatHang +
                ", giaBan=" + giaBan +
                ", ngayMua=" + ngayMua +
                ", tongThanhToan=" + tongThanhToan +
                '}';
    }
}
