package proje3;

import java.util.Scanner;

/**
 * Proje3
 * Kullanicilarin metin tabanli paylasim yapabilmesi, diger kullanicilari arkadas ekleyebilmesi onlara mesaj atabilmesi.
 * 3.odev
 * 30.01.2020
 * @author beyza sahingoz - beyza.sahingoz@stu.fsm.edu.tr
 */
public abstract class Kullanici implements IKullaniciIslemler, IPaylasimIslemleri {

    public Kullanici[] getArkadasListesi() {
        return arkadasListesi;
    }

    public int getArkadasSayisi() {
        return arkadasSayisi;
    }

    public void setArkadasSayisi(int arkadasSayisi) {
        this.arkadasSayisi = arkadasSayisi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String adSoyad;
    private String kullaniciAdi;
    private int ID;
    private Kullanici[] arkadasListesi;
    private int arkadasSayisi;
    private String paylasim;
    private int begeniSayisi = 0;
    private String[] yorumListesi;
    private String yorum;
    private int yorumSayisi;
    private String[] paylasimListesi;
    private String paylasimIcerigi;
    private String[] mesajListesi;
    private Kullanici[] istekListesi;

    public String getPaylasimIcerigi() {
        return paylasimIcerigi;
    }

    public void setPaylasimIcerigi(String paylasimIcerigi) {
        this.paylasimIcerigi = paylasimIcerigi;
    }

    public Kullanici(String adSoyad, String kullaniciAdi, int ID, int arkadasSayisi) {
        this.adSoyad = adSoyad;
        this.kullaniciAdi = kullaniciAdi;
        this.ID = ID;
        this.arkadasListesi = new Kullanici[arkadasSayisi];
        this.paylasimListesi = new String[100];
        this.mesajListesi = new String[100];
        this.istekListesi = new Kullanici[100];
        this.yorumListesi = new String[100];
    }

    public String[] getYorumListesi() {
        return yorumListesi;
    }

    public void setYorumListesi(String[] yorumListesi) {
        this.setYorumListesi(yorumListesi);
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public String getPaylasim() {
        return paylasim;
    }

    public void setPaylasim(String paylasim) {
        this.paylasim = paylasim;
    }

    public void setArkadasListesi(Kullanici[] arkadasListesi) {
        this.setArkadasListesi(arkadasListesi);
    }

    public int getBegeniSayisi() {
        return begeniSayisi;
    }

    public void setBegeniSayisi(int begeniSayisi) {
        this.begeniSayisi = begeniSayisi;
    }

    public int getYorumSayisi() {
        return yorumSayisi;
    }

    public void setYorumSayisi(int yorumSayisi) {
        this.yorumSayisi = yorumSayisi;
    }

    public String[] getPaylasimListesi() {
        return paylasimListesi;
    }

    public void setPaylasimListesi(String[] paylasimListesi) {
        this.setPaylasimListesi(paylasimListesi);
    }

    public void paylasimiEkle(String paylasim) {

    }

    public void paylasimSil(String paylasim) {

    }

    public void arkadasEkle(Kullanici kullanici) {

    }

    public void paylasimDuzenle(String paylasim) {

    }

    public void yorumSil(String yorum) {

    }

    public void yorumYap(String yorum) {

    }

    public void begen(String paylasim) {

    }

    public void istekListele() {

    }

    public void istekGonder(Kullanici k, Kullanici k1) {

    }

    public void arkadasListele() {

    }

    public String[] getMesajListesi() {
        return mesajListesi;
    }

    public void setMesajListesi(String[] mesajListesi) {
        this.setMesajListesi(mesajListesi);
    }

    public Kullanici[] getIstekListesi() {
        return istekListesi;
    }

    public void setIstekListesi(Kullanici[] istekListesi) {
        this.istekListesi = istekListesi;
    }

    public Kullanici() {
    }

    public void yorumListele(Kullanici k) {

    }

}
