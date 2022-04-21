package proje3;

import java.util.Scanner;

/**
 * Proje3
 * Kullanicilarin metin tabanli paylasim yapabilmesi, diger kullanicilari arkadas ekleyebilmesi onlara mesaj atabilmesi.
 * 3.odev
 * 30.01.2020
 * @author beyza sahingoz - beyza.sahingoz@stu.fsm.edu.tr
 */
public class DM {

    public String[] getMesajListesi() {
        return mesajListesi;
    }

    public void setMesajListesi(String[] mesajListesi) {
        this.mesajListesi = mesajListesi;
    }

    private String[] mesajListesi;

    public DM() {
        this.mesajListesi = new String[100];
    }
//Kullanicilarin mesajlarini mesaj listele arrayi üstünde gezerek listeledim.

    public void mesajListele(Kullanici kullanici, Kullanici kullanici1) {
        System.out.println("Mesajlar: ");
        for (int i = 0; i < kullanici.getMesajListesi().length; i++) {
            if (kullanici.getMesajListesi()[i] != null) {
                System.out.println(kullanici.getAdSoyad() + ": " + kullanici.getMesajListesi()[i]);
            }
        }
        for (int i = 0; i < kullanici1.getMesajListesi().length; i++) {
            if (kullanici1.getMesajListesi()[i] != null) {
                System.out.println(kullanici1.getAdSoyad() + ": " + kullanici1.getMesajListesi()[i]);
            }

        }
    }
//Kullanicilarin mesajlarini mesaj listele arrayi üstünde gezerek listeye ekliyorum.

    public void mesajEkle(String mesaj, Kullanici k) {
        for (int i = 0; i < k.getMesajListesi().length; i++) {
            if (k.getMesajListesi()[i] == null) {
                k.getMesajListesi()[i] = mesaj;
                break;
            }
        }
    }
}
