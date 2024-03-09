//hadita maulana
//20220040013-TI22E
public class App {
    public static void main(String[] args) throws Exception {
        Lingkaran lingkaran = new Lingkaran(7.0);
        Persegi persegi = new Persegi(5.0);
        SegitigaSamaSisi segitigaSamaSisi = new SegitigaSamaSisi(4.0);
        SegitigaSamaKaki segitigaSamaKaki = new SegitigaSamaKaki(3.0, 4.0);
        SegitigaSikuSiku segitigaSikuSiku = new SegitigaSikuSiku(3.0, 4.0);
        SegitigaSembarang segitigaSembarang = new SegitigaSembarang(2.0, 3.0, 4.0);

        lingkaran.getInfo();
        persegi.getInfo();
        segitigaSamaSisi.getInfo();
        segitigaSamaKaki.getInfo();
        segitigaSikuSiku.getInfo();
        segitigaSembarang.getInfo();
    }
}

class BangunDatar {
    protected double luas;
    protected double keliling;
    protected String nama;

    public double getLuas() {
        return this.luas;
    }

    public double getKeliling() {
        return this.keliling;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void getInfo() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Luas: " + this.luas);
        System.out.println("Keliling: " + this.keliling);
    }
}

class Lingkaran extends BangunDatar {
    public Lingkaran(double r) {
        super.setNama("Lingkaran");
        this.hitungLuas(r);
        this.hitungKeliling(r);
    }

    public void hitungLuas(double r) {
        super.luas = 3.14 * r * r;
    }

    public void hitungKeliling(double r) {
        super.keliling = 2 * 3.14 * r;
    }
}

class Persegi extends BangunDatar {
    public Persegi(double sisi) {
        super.setNama("Persegi");
        this.hitungLuas(sisi);
        this.hitungKeliling(sisi);
    }

    public void hitungLuas(double sisi) {
        super.luas = sisi * sisi;
    }

    public void hitungKeliling(double sisi) {
        super.keliling = 4 * sisi;
    }
}

class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggi;

    public void hitungLuas() {
        super.luas = 0.5 * this.alas * this.tinggi;
    }

    public void hitungKeliling() {
    }
}

class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(double sisi) {
        super.setNama("Segitiga Sama Sisi");
        this.alas = sisi;
        this.tinggi = Math.sqrt(3) / 2 * sisi; 
        this.hitungLuas();
        this.hitungKeliling();
    }

    public void hitungKeliling() {
        super.keliling = 3 * this.alas;
    }
}

class SegitigaSamaKaki extends Segitiga {
    protected double sisiKaki;

    public SegitigaSamaKaki(double alas, double sisiKaki) {
        super.setNama("Segitiga Sama Kaki");
        this.alas = alas;
        this.sisiKaki = sisiKaki;
        this.tinggi = Math.sqrt(sisiKaki * sisiKaki - (alas / 2) * (alas / 2));
        this.hitungLuas();
        this.hitungKeliling();
    }

    public void hitungKeliling() {
        super.keliling = 2 * sisiKaki + alas;
    }
}

class SegitigaSikuSiku extends Segitiga {
    protected double sisiMiring;

    public SegitigaSikuSiku(double alas, double tinggi) {
        super.setNama("Segitiga Siku-Siku");
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
        this.hitungLuas();
        this.hitungKeliling();
    }

    public void hitungKeliling() {
        super.keliling = alas + tinggi + sisiMiring;
    }
}

class SegitigaSembarang extends Segitiga {
    protected double sisi2;
    protected double sisi3;

    public SegitigaSembarang(double alas, double sisi2, double sisi3) {
        super.setNama("Segitiga Sembarang");
        this.alas = alas;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        double s = (alas + sisi2 + sisi3) / 2;
        this.tinggi = 2 / alas * Math.sqrt(s * (s - alas) * (s - sisi2) * (s - sisi3));
        this.hitungLuas();
        this.hitungKeliling();
    }

    public void hitungKeliling() {
        super.keliling = alas + sisi2 + sisi3;
    }
}
