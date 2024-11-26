package tr.com.huseyinaydin;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Android
 * @since 1994
 */

public class _006_ParametreliMetodlar {
    static double sonuc = 0;
    static double sayi1 = 3;
    static double sayi2 = 2;

    public static void main(String[] args) {
        sonuc = sayi1 + sayi2;
        System.out.println("Toplama + operatoru : " + sonuc);

        System.out.println("Toplama + operatoru sayi1 + sayi2 : " + sayi1 + sayi2);

        System.out.println("Toplama + operatoru parametresiz metod toplamaYap1() : " + toplamaYap1());
        System.out.println("Toplama + operatoru parametreli  metod toplamaYap2(sayi1, sayi2): " + toplamaYap2(sayi1, sayi2));

        System.out.println("Toplama + operatoru parametresiz metod (int) toplamaYap1() : " + (int) toplamaYap1());
        System.out.println("Toplama + operatoru parametreli  metod (int) toplamaYap2(sayi1, sayi2) : " + (int) toplamaYap2(sayi1, sayi2));
        System.out.println("Toplama + operatoru parametreli  metod toplamaYap2((int) sayi1, (int) sayi2) : " + toplamaYap2((int) sayi1, (int) sayi2));
        System.out.println("Toplama + operatoru parametreli  metod (int) toplamaYap2((int) sayi1, (int) sayi2) : " + (int) toplamaYap2((int) sayi1, (int) sayi2));
        System.out.println("Toplama + operatoru parametreli  metod (int) toplamaYap2((int) sayi1, sayi2) : " + (int) toplamaYap2((int) sayi1, sayi2));
        System.out.println("Toplama + operatoru parametreli  metod (int) toplamaYap2(sayi1, (int) sayi2) : " + (int) toplamaYap2(sayi1, (int) sayi2));

        sonuc = sayi1 - sayi2;
        System.out.println("Cikarma - operatoru : " + sonuc);

        sonuc = sayi1 * sayi2;
        System.out.println("Carpma * operatoru : " + sonuc);

        sonuc = sayi1 / sayi2;
        System.out.println("Bolme / operatoru : " + sonuc);

        sonuc = sayi1 % sayi2;
        System.out.println("Mod alma % operatoru : " + sonuc);
    }

    private static double toplamaYap1() {
        sonuc = sayi1 + sayi2;
        return sonuc;
    }

    private static double toplamaYap2(double parametre_sayi1, double parametre_sayi2) {
        sonuc = parametre_sayi1 + parametre_sayi2;
        return sonuc;
    }
}