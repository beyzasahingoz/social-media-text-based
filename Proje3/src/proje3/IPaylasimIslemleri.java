package proje3;

/**
 * Proje3
 * Kullanicilarin metin tabanli paylasim yapabilmesi, diger kullanicilari arkadas ekleyebilmesi onlara mesaj atabilmesi.
 * 3.odev
 * 30.01.2020
 * @author beyza sahingoz - beyza.sahingoz@stu.fsm.edu.tr
 */
public interface IPaylasimIslemleri {

    void begen(String paylasim);

    void yorumYap(String yorum);

    void goruntule();

    void paylasimBilgileri(Kullanici kullanici);

    void yorumListele(Kullanici k);
}
