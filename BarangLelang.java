package lelang;

public class BarangLelang {
    String namaBarang;
    double hargaAwal;
    double penawaranTertinggi;
    Peserta pemenang;
    boolean statusLelang = false;

    public BarangLelang(String namaBarang, double hargaAwal) {
        this.namaBarang = namaBarang;
        this.hargaAwal = hargaAwal;
        this.penawaranTertinggi = hargaAwal;
    }

    public void mulaiLelang() {
        System.out.println("Lelang untuk " + namaBarang + " telah dimulai dengan harga awal Rp" + (int)hargaAwal);
        statusLelang = true;
    }

    public void terimaPenawaran(Peserta peserta, double jumlah) {
        if (!statusLelang) {
            System.out.println(peserta.getNama() + " menawar Rp" + (int)jumlah);
            System.out.println("Penawaran tidak valid! Lelang sudah ditutup");
        } else if (jumlah <= penawaranTertinggi) {
            System.out.println(peserta.getNama() + " menawar Rp" + (int)jumlah);
            System.out.println("Penawaran tidak valid! penawaran harus lebih tinggi dari Rp" + (int)penawaranTertinggi);
        } else if (peserta.getSaldo() < jumlah) {
            System.out.println(peserta.getNama() + " menawar Rp" + (int)jumlah);
            System.out.println("Penawaran tidak valid! Saldo " + peserta.getNama() + " tidak mencukupi");
        } else {
            penawaranTertinggi = jumlah;
            pemenang = peserta;
            System.out.println(peserta.getNama() + " menawar Rp" + (int)jumlah);
            System.out.println("Penawaran disetujui!");
        }
    }

    public void tutupLelang() {
        statusLelang = false;
        if (pemenang != null) {
            pemenang.setSaldo(pemenang.getSaldo() - penawaranTertinggi);
            System.out.println("Lelang ditutup! " + namaBarang + " terjual dengan harga " + (int)penawaranTertinggi + " kepada " + pemenang.getNama());
            System.out.println("Sisa saldo " + pemenang.getNama() + ": Rp" + (int)pemenang.getSaldo());
        } else {
            System.out.println("Lelang ditutup! Tidak ada pemenang.");
        }
        System.out.println("\n=====================================\n");
    }
}
