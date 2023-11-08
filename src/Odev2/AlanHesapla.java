package Odev2;

import java.util.Scanner;

interface Sekil {
 double hesaplaAlan();
 double hesaplaKütle(double yogunluk);
}

class Nokta {
 int x;
 int y;

 public Nokta(int x, int y) {
     this.x = x;
     this.y = y;
 }
}

class Kare implements Sekil {
 Nokta nokta;

 public Kare(Nokta nokta) {
     this.nokta = nokta;
 }

 public double hesaplaAlan() {
     return Math.pow(2 * nokta.x, 2);
 }

 public double hesaplaKütle(double yogunluk) {
     return hesaplaAlan() * yogunluk;
 }
}

class Dikdortgen implements Sekil {
 Nokta nokta;
 int uzunKenar;

 public Dikdortgen(Nokta nokta, int uzunKenar) {
     this.nokta = nokta;
     this.uzunKenar = uzunKenar;
 }

 public double hesaplaAlan() {
     return uzunKenar * (nokta.y - nokta.x);
 }

 public double hesaplaKütle(double yogunluk) {
     return hesaplaAlan() * yogunluk;
 }
}

class Yamuk implements Sekil {
 Nokta nokta;

 public Yamuk(Nokta nokta) {
     this.nokta = nokta;
 }

 public double hesaplaAlan() {
     return 0; 
 }

 public double hesaplaKütle(double yogunluk) {
     return 0; 
 }
}

class Paralelkenar implements Sekil {
 Nokta nokta;

 public Paralelkenar(Nokta nokta) {
     this.nokta = nokta;
 }
 
 public double hesaplaAlan() {
     return 0; 
 }

 public double hesaplaKütle(double yogunluk) {
     return 0; 
 }
}

public class AlanHesapla {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int secim;
     Nokta nokta;
     Sekil[] sekiller = new Sekil[10];

     for (int i = 0; i < sekiller.length; i++) {
         System.out.println("Hangi şekli tanımlamak istersiniz? (1: Kare, 2: Dikdörtgen, 3: Yamuk, 4: Paralelkenar)");
         secim = scanner.nextInt();
         System.out.println("Noktanın x koordinatını girin: ");
         int x = scanner.nextInt();
         System.out.println("Noktanın y koordinatını girin: ");
         int y = scanner.nextInt();
         nokta = new Nokta(x, y);

         switch (secim) {
             case 1:
                 sekiller[i] = new Kare(nokta);
                 break;
             case 2:
                 System.out.println("Dikdörtgenin uzun kenarını girin: ");
                 int uzunKenar = scanner.nextInt();
                 sekiller[i] = new Dikdortgen(nokta, uzunKenar);
                 break;
             case 3:
                 sekiller[i] = new Yamuk(nokta);
                 break;
             case 4:
                 sekiller[i] = new Paralelkenar(nokta);
                 break;
             default:
                 System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                 i--;
         }
     }

     double yogunluk = 1;
     for (Sekil sekil : sekiller) {
         if (sekil != null) {
             double alan = sekil.hesaplaAlan();
             double kütle = sekil.hesaplaKütle(yogunluk);
             System.out.println("Şeklin alanı: " + alan);
             System.out.println("Şeklin kütle: " + kütle);
         }
     }
 }
}