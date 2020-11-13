package ben.study.model;

public class KhoModel {
    private String maHang;
    private String tenHang;
    private String maTheLoai;
    private int soLuong;
    private String ngayNhap;
    private String ngayXuat;

    public KhoModel() {
    }

    public KhoModel(String maHang, String tenHang, String maTheLoai, int soLuong, String ngayNhap, String ngayXuat) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.maTheLoai = maTheLoai;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngayXuat = ngayXuat;
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

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
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
}
