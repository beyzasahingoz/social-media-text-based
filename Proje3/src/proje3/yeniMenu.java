package proje3;

import java.util.Scanner;

/**
 * Proje3
 * Kullanicilarin metin tabanli paylasim yapabilmesi, diger kullanicilari
 * arkadas ekleyebilmesi onlara mesaj atabilmesi. 
 * 3.odev 
 * 30.01.2020
 * @author beyza sahingoz - beyza.sahingoz@stu.fsm.edu.tr
 */
public class yeniMenu {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
//Kullanicilari tanimlayip paylasim1e ekledim.
        Kullanici standart1 = new Standart("Ali Atahan", "aatahan", 240109, 0);
        Kullanici standart2 = new Standart("Eylul Yazici", "eylulyazicii", 180803, 0);
        Kullanici premium1 = new Premium("Yaman Atahan", "y.atahan", 117707, 0);
        Paylasim paylasim1 = new Paylasim();
        paylasim1.kullaniciEkle(premium1);
        paylasim1.kullaniciEkle(standart1);
        paylasim1.kullaniciEkle(standart2);

        System.out.println("*Uygulamaya hos geldiniz*");
        boolean kontrol = true;

        System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
        System.out.println("2-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
        System.out.println("3-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
        System.out.print("Kullanici seciniz: ");
        String kullanicisec = s.next();
//Kullanici secmenin kontrollerini yapiyorum.
        boolean kontrolsec = true;
        while (kontrolsec) {
            if (IntegeraDonustur(kullanicisec) > 3 || IntegeraDonustur(kullanicisec) < 1) {
                System.out.println("Kullanici numarasini yanlis girdiniz. Tekrar deneyiniz.");
                System.out.print("Kullanici seciniz: ");
                kullanicisec = s.next();
                kontrolsec = false;
            } else {
                break;
            }
        }
        //Menu kontrollerine menuyu yazdirarak basliyorum.
        while (kontrol) {
            System.out.println("");
            System.out.println("Kullanici degistirmek icin 1'e basiniz.");
            System.out.println("Paylasim islemleri icin 2'ye basiniz.");
            System.out.println("Mesaj islemleri icin 3'e basiniz.");
            System.out.println("Arkadas islemleri icin 4'e basiniz.");
            System.out.println("Uygulamadan cikmak icin 5'e basiniz.");
            System.out.print("Seceneginizi giriniz: ");
            String secenek = s.next();
            System.out.println("");
//Secenek 1e esit olursa program sonlaniyor.
            if (IntegeraDonustur(kullanicisec) == 1) {
                if (IntegeraDonustur(secenek) == 5) {
                    kontrol = false;
                    System.out.println("İyi gunler..");
                    //Secenek 2 olursa paylasima dair bilgiler icin menu yazdiriyorum.
                } else if (IntegeraDonustur(secenek) == 2) {
                    System.out.println("Paylasimlarinizi goruntulemek icin 1'e tiklayiniz.");
                    System.out.println("Arkadaslarinizin paylasimlarini goruntulemek icin 2'ye tiklayiniz.");
                    System.out.println("Yeni paylasim eklemek icin 3'e tiklayiniz.");
                    System.out.println("Paylasim silmek icin 4'e tiklayiniz.");
                    System.out.println("En cok ve az begeni ve yorum alan paylasimlar icin 5'e tiklayiniz.");
                    System.out.println("Menu icin 6'ya tiklayiniz.");
                    String paylassec = s.next();
                    //Kullanicinin paylasimlarini goruntuluyorum.
                    if (IntegeraDonustur(paylassec) == 1) {
                        standart1.paylasimBilgileri(standart1);
                        //Kullanicinin arkadaslarinin paylasimlarini yazdiriyorum.
                    } else if (IntegeraDonustur(paylassec) == 2) {
                        for (int i = 0; i < standart1.getArkadasListesi().length; i++) {
                            if (standart1.getArkadasListesi()[i] == premium1) {
                                premium1.paylasimBilgileri(premium1);
                                System.out.println("Paylasimi begenmek icin 1'e, yorum yapmak icin 2'ye tiklayiniz, yorumunuzu silmek için 3'e tiklayiniz.");
                                String arkpaysec = s.next();
                                if (IntegeraDonustur(arkpaysec) == 1) {
                                    //Paylasimlari goruntuleyip kulalnici begenmek istediyse paylasim numarasi girdiyorum ve begendiriyorum.
                                    premium1.goruntule();
                                    System.out.print("Begenmek istediginiz paylasimin numarasini giriniz: ");
                                    String payBegen = s.next();
                                    premium1.begen(payBegen);
                                    for (int j = 0; j < premium1.getPaylasimListesi().length; j++) {
                                        if (premium1.getPaylasimListesi()[j] != null && IntegeraDonustur(payBegen) == j + 1) {
                                            premium1.begen(premium1.getPaylasimListesi()[j]);
                                        }
                                    }
                                } else if (IntegeraDonustur(arkpaysec) == 2) {
                                    //Kullanicinin yorum girmek istemesi durumunda kullanicidan yorum girmesini istiyorum.
                                    System.out.print("Yorumunuzu giriniz: ");
                                    String yorum = s.next();
                                    premium1.yorumYap(yorum);
                                    System.out.println("Yorum yapan kullanici: "+standart1.getAdSoyad());
                                } else if (IntegeraDonustur(arkpaysec) == 3) {
                                    //Yorumlari listeleyip kullanicidan silmek istedigi yorumun numarasini yazmasini istiyorum.
                                    premium1.yorumListele(premium1);
                                    System.out.println("Silmek istediginiz yorumun numarasini yaziniz: ");
                                    String yorumNo = s.next();
                                    for (int j = 0; j < premium1.getYorumListesi().length; j++) {
                                        if (premium1.getYorumListesi()[j] != null) {
                                            if (j + 1 == IntegeraDonustur(yorumNo)) {
                                                premium1.yorumSil(premium1.getYorumListesi()[i]);
                                            }
                                        }
                                    }
                                }
                                //Ayni islemleri standart2 kullanicisi icin yapiyorum.
                            } else if (standart1.getArkadasListesi()[i] == standart2) {
                                standart2.paylasimBilgileri(standart2);
                                System.out.println("Paylasimi begenmek icin 1'e, yorum yapmak icin 2'ye tiklayiniz, yorumunuzu silmek için 3'e tiklayiniz.");
                                String arkpaysec = s.next();
                                if (IntegeraDonustur(arkpaysec) == 1) {
                                    standart2.goruntule();
                                    System.out.print("Begenmek istediginiz paylasimin numarasini giriniz: ");
                                    String payBegen = s.next();
                                    standart2.begen(payBegen);
                                    for (int j = 0; j < standart2.getPaylasimListesi().length; j++) {
                                        if (standart2.getPaylasimListesi()[j] != null && IntegeraDonustur(payBegen) == j + 1) {
                                            standart2.begen(standart2.getPaylasimListesi()[j]);
                                        }
                                    }
                                } else if (IntegeraDonustur(arkpaysec) == 2) {
                                    System.out.println("Yorumunuzu giriniz: ");
                                    String yorum = s.next();
                                    standart2.yorumYap(yorum);
                                    System.out.println("Yorum yapan kullanici: "+standart1.getAdSoyad());
                                } else if (IntegeraDonustur(arkpaysec) == 3) {
                                    standart2.yorumListele(standart2);
                                    System.out.println("Silmek istediginiz yorumun numarasini yaziniz: ");
                                    String yorumNo = s.next();
                                    for (int j = 0; j < standart2.getYorumListesi().length; j++) {
                                        if (standart2.getYorumListesi()[j] != null) {
                                            if (j + 1 == IntegeraDonustur(yorumNo)) {
                                                standart2.yorumSil(standart2.getYorumListesi()[j]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //Paylasim eklenmek istenirse kullanicidan paylasimini girmesini istiyorum ve ekle methoduyla listeye ekliyorum ve sonra yazdiriyorum.
                    } else if (IntegeraDonustur(paylassec) == 3) {
                        System.out.print("Paylasiminizi giriniz: ");
                        String paylas = s.next();
                        standart1.paylasimiEkle(paylas);
                        standart1.paylasimBilgileri(standart1);
                        //Paylasim duzenlenmek istenirse diye secenek sunuyorum.
                        System.out.println("Paylasimi duzenlemek icin 1'e tiklayin.");
                        System.out.println("Menuye donmek icin 2'ye tiklayiniz.");
                        System.out.print("Seceneginizi giriniz: ");
                        String sec = s.next();
                        //Paylasimi duzenlemek isterse diye paylasimlari yazdirip sectiriyorum ve yenisini girmesini istiyorum.
                        if (IntegeraDonustur(sec) == 1) {
                            standart1.goruntule();
                            System.out.println("Degistirmek istediginiz paylasimin numarasini giriniz.");
                            String no = s.next();
                            System.out.println("Yeni iceriginizi girin.");
                            String yeniIcerik = s.next();
                            for (int i = 0; i < standart1.getPaylasimListesi().length; i++) {
                                if (standart1.getPaylasimListesi()[i] != null) {
                                    if (i + 1 == IntegeraDonustur(no)) {
                                        standart1.getPaylasimListesi()[i] = yeniIcerik;

                                    }
                                }
                            }
                        } else if (IntegeraDonustur(sec) == 2) {
                            System.out.println("Menuye dondunuz.");
                            System.out.print("Seceneginizi giriniz: ");
                            secenek = s.next();
                        } else {
                            System.out.println("Yanlis giris yaptiniz. Tekrar deneyiniz");
                            System.out.println("Seceneginizi giriniz: ");
                            sec = s.next();
                        }
                        //Paylasim silinmek istendiginde paylasimlari goruntuleyip istenen paylasimi sectirip sildiriyorum.
                    } else if (IntegeraDonustur(paylassec) == 4) {
                        standart1.goruntule();
                        System.out.println("Silmek istediginiz paylasimin numarasini yaziniz: ");
                        String payNo = s.next();
                        for (int i = 0; i < standart1.getPaylasimListesi().length; i++) {
                            if (standart1.getPaylasimListesi()[i] != null) {
                                if (i + 1 == IntegeraDonustur(payNo)) {
                                    standart1.paylasimSil(standart1.getPaylasimListesi()[i]);
                                }
                            }
                        }
                        //En cok ve en az begeni yorum alan paylasimlari yazdiriyorum.
                    } else if (IntegeraDonustur(paylassec) == 5) {
                        paylasim1.encokBegeni();
                        paylasim1.enazBegeni();
                        paylasim1.enazYorum();
                        paylasim1.encokYorum();
                    } else if (IntegeraDonustur(paylassec) == 6) {
                        System.out.println("Menuye dondunuz..");
                    }
                    //Kullanici mesaj atmayi secerse mesaj girmesini isteyip gerekli kullaniciyi sectirip mesaji o kullaniciya yolluyorum.
                } else if (IntegeraDonustur(secenek) == 3) {
                    System.out.print("Mesajinizi giriniz: ");
                    String mesaj = s.next();
                    DM mesaj1 = new DM();
                    System.out.println("Kullanicinin numarasini giriniz.");
                    String user = s.next();
                    if (IntegeraDonustur(user) == 2) {
                        mesaj1.mesajEkle(mesaj, standart1);
                        mesaj1.mesajListele(standart1, standart2);
                    } else if (IntegeraDonustur(user) == 3) {
                        mesaj1.mesajEkle(mesaj, standart1);
                        mesaj1.mesajListele(standart1, premium1);
                    } else {
                        System.out.println("Boyle bir kullanici bulunmamakta.");
                        System.out.print("Tekrar kullanici numarasi giriniz: ");
                        user = s.next();
                    }
                    //Arkadaslik islemleri menusunu yazdiriyorum.
                } else if (IntegeraDonustur(secenek) == 4) {
                    System.out.println("Arkadas eklemek icin 1'i tiklayiniz.");
                    System.out.println("Arkadas silmek icin 2'yi tiklayiniz.");
                    System.out.println("Arkadaslik isteklerini goruntulemek icin 3'e tiklayiniz.");
                    System.out.println("Arkadaslarinizi goruntulemek icin 4'e tiklayiniz.");
                    System.out.println("Menuye donmek icin 5'e tiklayiniz.");
                    String arksec = s.next();
                    //Arkadas eklemek isterse diye kullanciilari yazdirip sectiriyorum ve sectigi kullaniciyi arkadaslistesine ekliyorum.
                    if (IntegeraDonustur(arksec) == 1) {
                        System.out.println("Arkadas eklemek istediginiz kullanicinin numarasini giriniz: ");
                        System.out.println("1-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
                        System.out.println("2-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                        String ekle = s.next();
                        if (IntegeraDonustur(ekle) == 1) {
                            standart2.istekGonder(standart2, standart1);
                        } else if (IntegeraDonustur(ekle) == 2) {
                            premium1.istekGonder(premium1, standart1);
                        } else {
                            System.out.println("Boyle bir kullanici bulunmamaktadir. Tekrar deneyiniz");
                            System.out.println("Arkadas eklemek istediginiz kullanicinin numarasini giriniz: ");
                            ekle = s.next();
                        }
                        //Kullaniciyi sectirip arkadas listesinden siliyorum.
                    } else if (IntegeraDonustur(arksec) == 2) {
                        System.out.println("Silmek istediginiz kullanicinin numarasini giriniz: ");
                        System.out.println("1-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
                        System.out.println("2-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                        String sil = s.next();
                        if (IntegeraDonustur(sil) == 1) {
                            standart1.sil(standart2);
                            System.out.println("Arkadas silindi.");
                        } else if (IntegeraDonustur(sil) == 2) {
                            standart1.sil(premium1);
                            System.out.println("Arkadas silindi.");
                        } else {
                            System.out.println("Boyle bir kullanici bulunmamaktadir. Tekrar deneyiniz");
                            System.out.print("Silmek istediginiz kullanicinin numarasini giriniz: ");
                            sil = s.next();
                        }
                        //Gelen arkadaslik isteklerini goruntuleyip eklemek isteyip istemem durumlarinda kullanici idsine gore islem yapiyorum.
                    } else if (IntegeraDonustur(arksec) == 3) {
                        standart1.istekListele();
                        System.out.println("Arkadas eklemek istiyorsanız 1'e, istemiyorsaniz 2'ye tiklayiniz.");
                        String sec = s.next();
                        if (IntegeraDonustur(sec) == 1) {
                            for (int i = 0; i < standart1.getIstekListesi().length; i++) {
                                if (standart1.getIstekListesi()[i] != null) {
                                    if (standart1.getIstekListesi()[i].getID() == 180803) {
                                        standart1.arkadasEkle(standart2);
                                    } else if (standart1.getIstekListesi()[i].getID() == 117707) {
                                        standart1.arkadasEkle(premium1);
                                    }
                                }
                            }
                        } else if (IntegeraDonustur(sec) == 2) {
                            System.out.println("Arkadaslik istegi kabul edilmedi.");
                        }
                        //Arkadaslari listeliyorum.
                    } else if (IntegeraDonustur(arksec) == 4) {
                        standart1.arkadasListele();
                    } else if (IntegeraDonustur(arksec) == 5) {
                        System.out.println("Menuye dondunuz..");
                    }
                    //Kullanici degistirmek istenmesi durumunda kullanicilari yazdirip degistirmek istenen kullanciiyi yazdirtiyorum.
                } else if (IntegeraDonustur(secenek) == 1) {
                    System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
                    System.out.println("2-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
                    System.out.println("3-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                    String yeniUser = s.next();
                    if (IntegeraDonustur(yeniUser) == 1) {
                        kullanicisec = "1";
                    } else if (IntegeraDonustur(yeniUser) == 2) {
                        kullanicisec = "2";
                    } else if (IntegeraDonustur(yeniUser) == 3) {
                        kullanicisec = "3";
                    }
                    System.out.println("Kullanici degisti.");

                } else {
                    if (IntegeraDonustur(secenek) < 1 || IntegeraDonustur(secenek) > 5) {
                        System.out.println("Yanlis giris yaptiniz.. tekrar deneyiniz");
                        secenek = s.next();
                    }
                }
            }
//Ayni durumlari kullanici 2 icin yapiyorum.
            if (IntegeraDonustur(kullanicisec) == 2) {
                if (IntegeraDonustur(secenek) == 5) {
                    kontrol = false;
                    System.out.println("İyi gunler..");
                } else if (IntegeraDonustur(secenek) == 2) {
                    System.out.println("Paylasimlarinizi goruntulemek icin 1'e tiklayiniz.");
                    System.out.println("Arkadaslarinizin paylasimlarini goruntulemek icin 2'ye tiklayiniz.");
                    System.out.println("Yeni paylasim eklemek icin 3'e tiklayiniz.");
                    System.out.println("Paylasim silmek icin 4'e tiklayiniz.");
                    System.out.println("En cok ve az begeni ve yorum alan paylasimlar icin 5'e tiklayiniz.");
                    System.out.println("Menu icin 6'ya tiklayiniz.");
                    String paylassec = s.next();
                    if (IntegeraDonustur(paylassec) == 1) {
                        standart2.paylasimBilgileri(standart2);
                    }
                    if (IntegeraDonustur(paylassec) == 2) {
                        for (int i = 0; i < standart2.getArkadasListesi().length; i++) {
                            if (standart2.getArkadasListesi()[i] == premium1) {
                                premium1.paylasimBilgileri(premium1);
                                System.out.println("Paylasimi begenmek icin 1'e, yorum yapmak icin 2'ye tiklayiniz, yorumunuzu silmek için 3'e tiklayiniz.");
                                String arkpaysec = s.next();
                                if (IntegeraDonustur(arkpaysec) == 1) {
                                    premium1.goruntule();
                                    System.out.print("Begenmek istediginiz paylasimin numarasini giriniz: ");
                                    String payBegen = s.next();
                                    premium1.begen(payBegen);
                                    for (int j = 0; j < premium1.getPaylasimListesi().length; j++) {
                                        if (premium1.getPaylasimListesi()[j] != null && IntegeraDonustur(payBegen) == j + 1) {
                                            premium1.begen(premium1.getPaylasimListesi()[j]);
                                        }
                                    }
                                } else if (IntegeraDonustur(arkpaysec) == 2) {
                                    System.out.println("Yorumunuzu giriniz: ");
                                    String yorum = s.next();
                                    premium1.yorumYap(yorum);
                                    System.out.println("Yorum yapan kullanici: "+standart2.getAdSoyad());
                                } else if (IntegeraDonustur(arkpaysec) == 3) {
                                    premium1.yorumListele(premium1);
                                    System.out.println("Silmek istediginiz yorumun numarasini yaziniz: ");
                                    String yorumNo = s.next();
                                    for (int j = 0; j < premium1.getYorumListesi().length; j++) {
                                        if (premium1.getYorumListesi()[j] != null) {
                                            if (j + 1 == IntegeraDonustur(yorumNo)) {
                                                premium1.yorumSil(premium1.getYorumListesi()[j]);
                                            }
                                        }
                                    }
                                }
                            } else if (standart2.getArkadasListesi()[i] == standart1) {
                                standart1.paylasimBilgileri(standart1);
                                System.out.println("Paylasimi begenmek icin 1'e, yorum yapmak icin 2'ye tiklayiniz, yorumunuzu silmek için 3'e tiklayiniz.");
                                String arkpaysec = s.next();
                                if (IntegeraDonustur(arkpaysec) == 1) {
                                    standart1.goruntule();
                                    System.out.print("Begenmek istediginiz paylasimin numarasini giriniz: ");
                                    String payBegen = s.next();
                                    standart1.begen(payBegen);
                                    for (int j = 0; j < standart1.getPaylasimListesi().length; j++) {
                                        if (standart1.getPaylasimListesi()[j] != null && IntegeraDonustur(payBegen) == j + 1) {
                                            standart1.begen(standart1.getPaylasimListesi()[j]);
                                        }
                                    }
                                } else if (IntegeraDonustur(arkpaysec) == 2) {
                                    System.out.print("Yorumunuzu giriniz: ");
                                    String yorum = s.next();
                                    standart1.yorumYap(yorum);
                                    System.out.println("Yorum yapan kullanici: "+standart2.getAdSoyad());
                                } else if (IntegeraDonustur(arkpaysec) == 3) {
                                    standart1.yorumListele(standart1);
                                    System.out.println("Silmek istediginiz yorumun numarasini yaziniz: ");
                                    String yorumNo = s.next();
                                    for (int j = 0; j < standart1.getYorumListesi().length; j++) {
                                        if (standart1.getYorumListesi()[j] != null) {
                                            if (j + 1 == IntegeraDonustur(yorumNo)) {
                                                standart1.yorumSil(standart1.getYorumListesi()[j]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (IntegeraDonustur(paylassec) == 3) {
                        System.out.print("Paylasiminizi giriniz: ");
                        String paylas = s.next();
                        standart2.paylasimiEkle(paylas);
                        standart2.paylasimBilgileri(standart2);
                        System.out.println("Paylasimin icerigini duzenlemek icin 1'e tiklayin.");
                        System.out.println("Menuye donmek icin 2'ye tiklayiniz.");
                        System.out.print("Seceneginizi giriniz: ");
                        String sec = s.next();
                        if (IntegeraDonustur(sec) == 1) {
                            standart2.goruntule();
                            System.out.println("Degistirmek istediginiz paylasimin numarasini giriniz.");
                            String no = s.next();
                            System.out.println("Yeni iceriginizi girin.");
                            String yeniIcerik = s.next();
                            for (int i = 0; i < standart2.getPaylasimListesi().length; i++) {
                                if (standart2.getPaylasimListesi()[i] != null) {
                                    if (i + 1 == IntegeraDonustur(no)) {
                                        standart2.getPaylasimListesi()[i] = yeniIcerik;

                                    }
                                }
                            }
                        } else if (IntegeraDonustur(sec) == 2) {
                            System.out.println("Menuye dondunuz.");
                        } else {
                            System.out.println("Yanlis giris yaptiniz. Tekrar deneyiniz");
                            System.out.println("Seceneginizi giriniz: ");
                            sec = s.next();
                        }
                    } else if (IntegeraDonustur(paylassec) == 4) {
                        standart2.goruntule();
                        System.out.println("Silmek istediginiz paylasimin numarasini yaziniz: ");
                        String payNo = s.next();
                        for (int i = 0; i < standart2.getPaylasimListesi().length; i++) {
                            if (standart2.getPaylasimListesi()[i] != null) {
                                if (i + 1 == IntegeraDonustur(payNo)) {
                                    standart2.paylasimSil(standart2.getPaylasimListesi()[i]);
                                }
                            }
                        }
                    } else if (IntegeraDonustur(paylassec) == 5) {
                        paylasim1.encokBegeni();
                        paylasim1.enazBegeni();
                        paylasim1.enazYorum();
                        paylasim1.encokYorum();
                    } else if (IntegeraDonustur(paylassec) == 6) {
                        System.out.println("Menuye dondunuz..");
                    }
                } else if (IntegeraDonustur(secenek) == 3) {
                    System.out.print("Mesajinizi giriniz: ");
                    String mesaj = s.next();
                    DM mesaj1 = new DM();
                    System.out.println("Kullanicinin numarasini giriniz.");
                    String user = s.next();
                    if (IntegeraDonustur(user) == 1) {
                        mesaj1.mesajEkle(mesaj, standart2);
                        mesaj1.mesajListele(standart2, standart1);
                    } else if (IntegeraDonustur(user) == 3) {
                        mesaj1.mesajEkle(mesaj, standart2);
                        mesaj1.mesajListele(standart2, premium1);
                    } else {
                        System.out.println("Boyle bir kullanici bulunmamakta.");
                        System.out.print("Tekrar kullanici numarasi giriniz: ");
                        user = s.next();
                    }
                } else if (IntegeraDonustur(secenek) == 4) {
                    System.out.println("Arkadas eklemek icin 1'i tiklayiniz.");
                    System.out.println("Arkadas silmek icin 2'yi tiklayiniz.");
                    System.out.println("Arkadas istekleri icin 3'e tiklayiniz.");
                    System.out.println("Arkadaslarinizi goruntulemek icin 4'e tiklayiniz.");
                    System.out.println("Menuye donmek icin 5'e tiklayiniz.");
                    String arksec = s.next();
                    if (IntegeraDonustur(arksec) == 1) {
                        System.out.println("Arkadas eklemek istediginiz kullanicinin numarasini giriniz: ");
                        System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
                        System.out.println("2-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                        String ekle = s.next();
                        if (IntegeraDonustur(ekle) == 1) {
                            standart1.istekGonder(standart1, standart2);
                        } else if (IntegeraDonustur(ekle) == 2) {
                            premium1.istekGonder(premium1, standart2);
                        } else {
                            System.out.println("Boyle bir kullanici bulunmamaktadir. Tekrar deneyiniz");
                            System.out.println("Arkadas eklemek istediginiz kullanicinin numarasini giriniz: ");
                            ekle = s.next();
                        }
                    } else if (IntegeraDonustur(arksec) == 2) {
                        System.out.println("Silmek istediginiz kullanicinin numarasini giriniz: ");
                        System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
                        System.out.println("2-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                        String sil = s.next();
                        if (IntegeraDonustur(sil) == 1) {
                            standart2.sil(standart1);
                        } else if (IntegeraDonustur(sil) == 2) {
                            standart2.sil(premium1);
                        } else {
                            System.out.println("Boyle bir kullanici bulunmamaktadir. Tekrar deneyiniz");
                            System.out.println("Silmek istediginiz kullanicinin numarasini giriniz: ");
                            sil = s.next();
                        }
                    } else if (IntegeraDonustur(arksec) == 3) {
                        standart2.istekListele();
                        System.out.println("Arkadas eklemek istiyorsanız 1'e, istemiyorsaniz 2'ye tiklayiniz.");
                        String sec = s.next();
                        if (IntegeraDonustur(sec) == 1) {
                            for (int i = 0; i < standart2.getIstekListesi().length; i++) {
                                if (standart2.getIstekListesi()[i] != null) {
                                    if (standart2.getIstekListesi()[i].getID() == 240109) {
                                        standart2.arkadasEkle(standart1);
                                    } else if (standart2.getIstekListesi()[i].getID() == 117707) {
                                        standart2.arkadasEkle(premium1);
                                    }
                                }
                            }
                        } else if (IntegeraDonustur(sec) == 2) {
                            System.out.println("Arkadaslik istegi kaldirildi.");
                        }

                    } else if (IntegeraDonustur(arksec) == 4) {
                        standart2.arkadasListele();
                    } else if (IntegeraDonustur(arksec) == 5) {
                        System.out.println("Menuye dondunuz..");
                    }
                } else if (IntegeraDonustur(secenek) == 1) {
                    System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
                    System.out.println("2-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
                    System.out.println("3-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                    String yeniUser = s.next();
                    if (IntegeraDonustur(yeniUser) == 1) {
                        kullanicisec = "1";
                    } else if (IntegeraDonustur(yeniUser) == 2) {
                        kullanicisec = "2";
                    } else if (IntegeraDonustur(yeniUser) == 3) {
                        kullanicisec = "3";
                    }
                    System.out.println("Kullanici degisti.");

                } else {
                    if (IntegeraDonustur(secenek) < 1 || IntegeraDonustur(secenek) > 5) {
                        System.out.println("Yanlis giris yaptiniz.. tekrar deneyiniz");
                        secenek = s.next();
                    }
                }
            }
            //Ayni durumlari kullanici 3 icin de yaptiriyorum.
            if (IntegeraDonustur(kullanicisec) == 3) {
                if (IntegeraDonustur(secenek) == 5) {
                    kontrol = false;
                    System.out.println("İyi gunler..");
                } else if (IntegeraDonustur(secenek) == 2) {
                    System.out.println("Paylasimlarinizi goruntulemek icin 1'e tiklayiniz.");
                    System.out.println("Arkadaslarinizin paylasimlarini goruntulemek icin 2'ye tiklayiniz.");
                    System.out.println("Yeni paylasim eklemek icin 3'e tiklayiniz.");
                    System.out.println("Paylasim silmek icin 4'e tiklayiniz.");
                    System.out.println("En cok ve az begeni ve yorum alan paylasimlar icin 5'e tiklayiniz.");
                    System.out.println("Menu icin 6'ya tiklayiniz.");
                    String paylassec = s.next();
                    if (IntegeraDonustur(paylassec) == 1) {
                        premium1.paylasimBilgileri(premium1);
                    }
                    if (IntegeraDonustur(paylassec) == 2) {
                        for (int i = 0; i < premium1.getArkadasListesi().length; i++) {
                            if (premium1.getArkadasListesi()[i] == standart1) {
                                standart1.paylasimBilgileri(standart1);
                                System.out.println("Paylasimi begenmek icin 1'e, yorum yapmak icin 2'ye tiklayiniz, yorumunuzu silmek için 3'e tiklayiniz.");
                                String arkpaysec = s.next();
                                if (IntegeraDonustur(arkpaysec) == 1) {
                                    standart1.goruntule();
                                    System.out.print("Begenmek istediginiz paylasimin numarasini giriniz: ");
                                    String payBegen = s.next();
                                    standart1.begen(payBegen);
                                    for (int j = 0; j < standart1.getPaylasimListesi().length; j++) {
                                        if (standart1.getPaylasimListesi()[j] != null && IntegeraDonustur(payBegen) == j + 1) {
                                            standart1.begen(standart1.getPaylasimListesi()[j]);
                                        }
                                    }
                                } else if (IntegeraDonustur(arkpaysec) == 2) {
                                    System.out.print("Yorumunuzu gririniz: ");
                                    String yorum = s.next();
                                    standart1.yorumYap(yorum);
                                    System.out.println("Yorum yapan kullanici: "+premium1.getAdSoyad());
                                } else if (IntegeraDonustur(arkpaysec) == 3) {
                                    standart1.yorumListele(standart1);
                                    System.out.println("Silmek istediginiz yorumun numarasini yaziniz: ");
                                    String yorumNo = s.next();
                                    for (int j = 0; j < standart1.getYorumListesi().length; j++) {
                                        if (standart1.getYorumListesi()[j] != null) {
                                            if (j + 1 == IntegeraDonustur(yorumNo)) {
                                                standart1.yorumSil(standart1.getYorumListesi()[j]);
                                            }
                                        }
                                    }
                                }
                            } else if (premium1.getArkadasListesi()[i] == standart2) {
                                standart2.paylasimBilgileri(standart2);
                                System.out.println("Paylasimi begenmek icin 1'e, yorum yapmak icin 2'ye tiklayiniz, yorumunuzu silmek için 3'e tiklayiniz.");
                                String arkpaysec = s.next();
                                if (IntegeraDonustur(arkpaysec) == 1) {
                                    standart2.goruntule();
                                    System.out.print("Begenmek istediginiz paylasimin numarasini giriniz: ");
                                    String payBegen = s.next();
                                    standart2.begen(payBegen);
                                    for (int j = 0; j < standart2.getPaylasimListesi().length; j++) {
                                        if (standart2.getPaylasimListesi()[j] != null && IntegeraDonustur(payBegen) == j + 1) {
                                            standart2.begen(standart2.getPaylasimListesi()[j]);
                                        }
                                    }
                                } else if (IntegeraDonustur(arkpaysec) == 2) {
                                    System.out.print("Yorumunuzu giriniz: ");
                                    String yorum = s.next();
                                    standart2.yorumYap(yorum);
                                    System.out.println("Yorum yapan kullanici: "+premium1.getAdSoyad());
                                } else if (IntegeraDonustur(arkpaysec) == 3) {
                                    standart2.yorumListele(standart2);
                                    System.out.println("Silmek istediginiz yorumun numarasini yaziniz: ");
                                    String yorumNo = s.next();
                                    for (int j = 0; j < standart2.getYorumListesi().length; j++) {
                                        if (standart2.getYorumListesi()[j] != null) {
                                            if (j + 1 == IntegeraDonustur(yorumNo)) {
                                                standart2.yorumSil(standart2.getYorumListesi()[j]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (IntegeraDonustur(paylassec) == 3) {
                        System.out.print("Paylasiminizi giriniz: ");
                        String paylas = s.next();
                        premium1.paylasimiEkle(paylas);
                        premium1.paylasimBilgileri(premium1);
                        System.out.println("Paylasimi duzenlemek icin 1'e tiklayin.");
                        System.out.println("Menuye donmek icin 2'ye tiklayiniz.");
                        System.out.print("Seceneginizi giriniz: ");
                        String sec = s.next();
                        if (IntegeraDonustur(sec) == 1) {
                            premium1.goruntule();
                            System.out.println("Degistirmek istediginiz paylasimin numarasini giriniz.");
                            String no = s.next();
                            System.out.println("Yeni iceriginizi girin.");
                            String yeniIcerik = s.next();
                            for (int i = 0; i < premium1.getPaylasimListesi().length; i++) {
                                if (premium1.getPaylasimListesi()[i] != null) {
                                    if (i + 1 == IntegeraDonustur(no)) {
                                        premium1.getPaylasimListesi()[i] = yeniIcerik;

                                    }
                                }
                            }
                        } else if (IntegeraDonustur(sec) == 2) {
                            System.out.println("Menuye dondunuz.");
                        } else {
                            System.out.println("Yanlis giris yaptiniz. Tekrar deneyiniz");
                            System.out.println("Seceneginizi giriniz: ");
                            sec = s.next();
                        }
                    } else if (IntegeraDonustur(paylassec) == 4) {
                        premium1.goruntule();
                        System.out.println("Silmek istediginiz paylasimin numarasini yaziniz: ");
                        String payNo = s.next();
                        for (int i = 0; i < premium1.getPaylasimListesi().length; i++) {
                            if (premium1.getPaylasimListesi()[i] != null) {
                                if (i + 1 == IntegeraDonustur(payNo)) {
                                    premium1.paylasimSil(premium1.getPaylasimListesi()[i]);
                                }
                            }
                        }
                    } else if (IntegeraDonustur(paylassec) == 5) {
                        paylasim1.encokBegeni();
                        paylasim1.enazBegeni();
                        paylasim1.enazYorum();
                        paylasim1.encokYorum();
                    } else if (IntegeraDonustur(paylassec) == 6) {
                        System.out.println("Menuye dondunuz..");

                    }
                } else if (IntegeraDonustur(secenek) == 3) {
                    System.out.print("Mesajinizi giriniz: ");
                    String mesaj = s.next();
                    DM mesaj1 = new DM();
                    System.out.println("Kullanicinin numarasini giriniz.");
                    String user = s.next();
                    if (IntegeraDonustur(user) == 2) {
                        mesaj1.mesajEkle(mesaj, premium1);
                        mesaj1.mesajListele(premium1, standart2);
                    } else if (IntegeraDonustur(user) == 1) {
                        mesaj1.mesajEkle(mesaj, premium1);
                        mesaj1.mesajListele(premium1, standart1);
                    } else {
                        System.out.println("Boyle bir kullanici bulunmamakta.");
                        System.out.print("Tekrar kullanici numarasi giriniz: ");
                        user = s.next();
                    }
                } else if (IntegeraDonustur(secenek) == 4) {
                    System.out.println("Arkadas eklemek icin 1'i tiklayiniz.");
                    System.out.println("Arkadas silmek icin 2'yi tiklayiniz.");
                    System.out.println("Arkadaslik isteklerini goruntulemek icin 3'e tiklayiniz.");
                    System.out.println("Arkadaslarinizi goruntulemek icin 4'e tiklayiniz.");
                    System.out.println("Menuye donmek icin 5'e tiklayiniz.");
                    String arksec = s.next();
                    if (IntegeraDonustur(arksec) == 1) {
                        System.out.println("Arkadas eklemek istediginiz kullanicinin numarasini giriniz: ");
                        System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
                        System.out.println("2-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
                        String ekle = s.next();
                        if (IntegeraDonustur(ekle) == 1) {
                            standart1.istekGonder(standart1, premium1);
                        } else if (IntegeraDonustur(ekle) == 2) {
                            standart2.istekGonder(standart2, premium1);
                        } else {
                            System.out.println("Boyle bir kullanici bulunmamaktadir. Tekrar deneyiniz");
                            System.out.println("Arkadas eklemek istediginiz kullanicinin numarasini giriniz: ");
                            ekle = s.next();
                        }
                    } else if (IntegeraDonustur(arksec) == 2) {
                        System.out.print("Silmek istediginiz kullanicinin numarasini giriniz: ");
                        String sil = s.next();
                        if (IntegeraDonustur(sil) == 1) {
                            premium1.sil(standart1);
                        } else if (IntegeraDonustur(sil) == 2) {
                            premium1.sil(standart2);
                        } else {
                            System.out.println("Boyle bir kullanici bulunmamaktadir. Tekrar deneyiniz");
                            System.out.println("Silmek istediginiz kullanicinin numarasini giriniz: ");
                            sil = s.next();
                        }
                    } else if (IntegeraDonustur(arksec) == 3) {
                        premium1.istekListele();
                        System.out.println("Arkadas eklemek istiyorsanız 1'e, istemiyorsaniz 2'ye tiklayiniz.");
                        String sec = s.next();
                        if (IntegeraDonustur(sec) == 1) {
                            for (int i = 0; i < premium1.getIstekListesi().length; i++) {
                                if (premium1.getIstekListesi()[i] != null) {
                                    if (premium1.getIstekListesi()[i].getID() == 240109) {
                                        premium1.arkadasEkle(standart1);
                                    } else if (premium1.getIstekListesi()[i].getID() == 180803) {
                                        premium1.arkadasEkle(standart2);
                                    }
                                }
                            }
                        } else if (IntegeraDonustur(sec) == 2) {
                            System.out.println("Arkadaslik istegi kaldirildi.");
                        }
                    } else if (IntegeraDonustur(arksec) == 4) {
                        premium1.arkadasListele();
                    } else if (IntegeraDonustur(arksec) == 5) {
                        System.out.println("Menuye dondunuz..");
                    }
                } else if (IntegeraDonustur(secenek) == 1) {
                    System.out.println("1-)standart1 = \"Ali Atahan\", \"aatahan\", 240109");
                    System.out.println("2-)standart2 = \"Eylul Yazici\", \"eylulyazicii\", 180803");
                    System.out.println("3-)premium1 = \"Yaman Atahan\", \"y.atahan\", 117707");
                    String yeniUser = s.next();
                    if (IntegeraDonustur(yeniUser) == 1) {
                        kullanicisec = "1";
                    } else if (IntegeraDonustur(yeniUser) == 2) {
                        kullanicisec = "2";
                    } else if (IntegeraDonustur(yeniUser) == 3) {
                        kullanicisec = "3";
                    }
                    System.out.println("Kullanici degisti.");

                } else {
                    if (IntegeraDonustur(secenek) < 1 || IntegeraDonustur(secenek) > 5) {
                        System.out.println("Yanlis giris yaptiniz.. tekrar deneyiniz");
                        secenek = s.next();
                    }
                }
            }
        }
    }
    //String degiskenleri integera ceviriyorum.

    public static int IntegeraDonustur(String temp) {
        int i = 0;
        int sayi = 0;
        int uzunluk = temp.length();
        while (i < uzunluk) {
            sayi = sayi * 10;
            sayi = sayi + (temp.charAt(i++) - '0');
        }
        return sayi;
    }
}
