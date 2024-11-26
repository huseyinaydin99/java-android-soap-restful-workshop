package tr.com.huseyinaydin;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Android
 *
 */

public class _005_TipDonusumleri {
    static double sonuc = 0;
    static double sayi1 = 3;
    static double sayi2 = 2;

    public static void main(String[] args) {
        sonuc = sayi1 / sayi2;
        System.out.println("Bolme / operatoru sayi1 / sayi2 : " + sonuc);

        System.out.println("Bolme / operatoru Tip Donusum (int) sonuc : " + (int) sonuc);

        sonuc = (int) (sayi1 / sayi2);
        System.out.println("Bolme / operatoru Tip Donusum (int)(sayi1 / sayi2) : " + sonuc);

        System.out.println("Bolme / operatoru Tip Donusum (int)(sayi1 / sayi2) : " + (int) (sayi1 / sayi2));

        sonuc = (int) sayi1 / sayi2;
        System.out.println("Bolme / operatoru Tip Donusum (int)sayi1 / sayi2 : " + sonuc);

        sonuc = sayi1 / (int) sayi2;
        System.out.println("Bolme / operatoru Tip Donusum sayi1 / (int) sayi2 : " + sonuc);

        sonuc = (int) sayi1 / (int) sayi2;
        System.out.println("Bolme / operatoru (int)sayi1 / (int) sayi2 : " + sonuc);

        sonuc = (int) ((int) sayi1 / (int) sayi2);
        System.out.println("Bolme / operatoru (int) ((int) sayi1 / (int) sayi2) : " + (int) sonuc);

        sonuc = (int) ((int) sayi1 / sayi2);
        System.out.println("Bolme / operatoru (int) ((int) sayi1 / sayi2) : " + sonuc);

        sonuc = (int) ((int) sayi1 / sayi2);
        System.out.println("Bolme / operatoru (int) ((int) sayi1 / sayi2) : " + (int) sonuc);

        sonuc = (int) (sayi1 - (int) sayi2);
        System.out.println("Bolme / operatoru (int) (sayi1 - (int) sayi2) : " + sonuc);

        sonuc = (int) (sayi1 - (int) sayi2);
        System.out.println("Bolme / operatoru (int) (sayi1 - (int) sayi2): " + (int) sonuc);

        sonuc = sayi1 - sayi2;
        System.out.println("Cikarma - operatoru Tip Donusum : " + sonuc);

        sonuc = sayi1 * sayi2;
        System.out.println("Carpma * operatoru : " + sonuc);

        sonuc = sayi1 / sayi2;
        System.out.println("Toplama + operatoru : " + sonuc);

        sonuc = sayi1 % sayi2;
        System.out.println("Mod alma % operatoru : " + sonuc);
    }
}