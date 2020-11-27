package ben.study.model;

public class TheLoaiModel {
    private String maTheLoai;
    private String tenTheLoai;
    private int viTri;

    public TheLoaiModel() {
    }

    public TheLoaiModel(String maTheLoai, String tenTheLoai, int viTri) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.viTri = viTri;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    @Override
    public String toString() {
        return "TheLoaiModel{" +
                "maTheLoai='" + maTheLoai + '\'' +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                ", viTri=" + viTri +
                '}';
    }
}
