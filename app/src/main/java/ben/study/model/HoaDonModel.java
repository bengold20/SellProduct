package ben.study.model;

public class HoaDonModel {
    private String maHoaDon;
    private String tenMatHang;
    private String theLoaiMatHang;
    private int soLuongMatHang;
    private double giaBan;
    private String ngayMua;
    private double tongThanhToan;

    public HoaDonModel() {
    }

    public HoaDonModel(String maHoaDon, String tenMatHang, String theLoaiMatHang, int soLuongMatHang, double giaBan, String ngayMua, double tongThanhToan) {
        this.maHoaDon = maHoaDon;
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

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public double getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(double tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }


}
