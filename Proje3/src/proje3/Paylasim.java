package proje3;

import java.util.Scanner;

/**
 * Proje3
 * Kullanicilarin metin tabanli paylasim yapabilmesi, diger kullanicilari arkadas ekleyebilmesi onlara mesaj atabilmesi.
 * 3.odev
 * 30.01.2020
 * @author beyza sahingoz - beyza.sahingoz@stu.fsm.edu.tr
 */
public class Paylasim {

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

    private int begeniSayisi;
    private int yorumSayisi;
    private Kullanici[] kullaniciListesi;

    public Paylasim() {
        this.kullaniciListesi = new Kullanici[100];
    }

    //Kullanici listesinde gezerek kullaniciyi listeye ekliyorum.
    public void kullaniciEkle(Kullanici kullanici) {
        for (int i = 0; i < getKullaniciListesi().length; i++) {
            if (getKullaniciListesi()[i] == null) {
                getKullaniciListesi()[i] = kullanici;
                break;
            }
        }
    }

    //Kullanici listesinde gezerken toplamı sıfırladıktan sonra begeni sayisini suma atiyorum. Daha sonra max begeniyi bulup indexe atiyorum.
    public void encokBegeni() {
        int max = 0;
        int index = 0;

        for (int i = 0; i < kullaniciListesi.length; i++) {
            int sum = 0;
            if (kullaniciListesi[i] != null) {
                sum = kullaniciListesi[i].getBegeniSayisi();
            }
            if (sum > max) {
                max = sum;
                index = i;
            }
        }
        getKullaniciListesi()[index].paylasimBilgileri(getKullaniciListesi()[index]);
    }

    //Kullanici listesinde gezerken toplamı sıfırladıktan sonra begeni sayisini suma atiyorum. Daha sonra min begeniyi bulup indexe atiyorum.
    public void enazBegeni() {
        int min = 100;
        int index = 0;
        for (int i = 0; i < kullaniciListesi.length; i++) {
            int sum = 0;
            if (kullaniciListesi[i] != null) {
                sum = kullaniciListesi[i].getBegeniSayisi();
            }
            if (sum < min) {
                min = sum;
                index = i;
            }
        }
        getKullaniciListesi()[index].paylasimBilgileri(getKullaniciListesi()[index]);
    }

    //Kullanici listesinde gezerken toplamı sıfırladıktan sonra yorum sayisini suma atiyorum. Daha sonra max yorum sayisini bulup indexe atiyorum.
    public void encokYorum() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < kullaniciListesi.length; i++) {
            int sum = 0;
            if (kullaniciListesi[i] != null) {
                sum = kullaniciListesi[i].getYorumSayisi();
            }
            if (sum > max) {
                max = sum;
                index = i;
            }
        }
        getKullaniciListesi()[index].paylasimBilgileri(getKullaniciListesi()[index]);
    }

    //Kullanici listesinde gezerken toplamı sıfırladıktan sonra yorum sayisini suma atiyorum. Daha sonra min yorum sayisini bulup indexe atiyorum.
    public void enazYorum() {
        int min = 0;
        int index = 0;
        for (int i = 0; i < kullaniciListesi.length; i++) {
            int sum = 0;
            if (kullaniciListesi[i] != null) {
                sum = kullaniciListesi[i].getYorumSayisi();
            }
            if (sum < min) {
                min = sum;
                index = i;
            }
        }
        getKullaniciListesi()[index].paylasimBilgileri(getKullaniciListesi()[index]);
    }

    public Kullanici[] getKullaniciListesi() {
        return kullaniciListesi;
    }

    public void setKullaniciListesi(Kullanici[] kullaniciListesi) {
        this.kullaniciListesi = kullaniciListesi;
    }
}
