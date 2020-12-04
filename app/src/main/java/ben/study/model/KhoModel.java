package ben.study.model;

public class KhoModel {
    private String maHang;
    private String tenHang;
    private String theloaihang;
    private int soLuong;
    private String ngayNhap;
    private String ngayXuat;
    private double gia;

    public KhoModel() {
    }

    public KhoModel(String maHang, String tenHang, String theloaihang, int soLuong, String ngayNhap, String ngayXuat, double gia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.theloaihang = theloaihang;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
        this.gia = gia;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getTheloaihang() {
        return theloaihang;
    }

    public void setTheloaihang(String theloaihang) {
        this.theloaihang = theloaihang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "KhoModel{" +
                "maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", theloaihang='" + theloaihang + '\'' +
                ", soLuong=" + soLuong +
                ", ngayNhap='" + ngayNhap + '\'' +
                ", ngayXuat='" + ngayXuat + '\'' +
                ", gia=" + gia +
                '}';
    }
}
