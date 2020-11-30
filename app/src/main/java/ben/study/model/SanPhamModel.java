package ben.study.model;

public class SanPhamModel {
    private  String maMatHang;
    private  String theLoaiHang;
    private  String tenHang;
    private  int soLuong;
    private  String ngayXuat;
    private  String ngayNhap;
    private double gia;

    public SanPhamModel() {
    }

    public SanPhamModel(String maMatHang, String theLoaiHang, String tenHang, int soLuong, String ngayXuat, String ngayNhap, double gia) {
        this.maMatHang = maMatHang;
        this.theLoaiHang = theLoaiHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.ngayXuat = ngayXuat;
        this.ngayNhap = ngayNhap;
        this.gia = gia;
    }

    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getTheLoaiHang() {
        return theLoaiHang;
    }

    public void setTheLoaiHang(String theLoaiHang) {
        this.theLoaiHang = theLoaiHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
