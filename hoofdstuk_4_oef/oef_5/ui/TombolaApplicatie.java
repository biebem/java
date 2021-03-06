
package ui;

import domein.Tombola;
import java.util.Scanner;

public class TombolaApplicatie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Wat is de naam van je vereniging die de tombola organiseert: ");
        String vereniging = sc.nextLine();
        System.out.print("Geef het aantal beschikbare lotjes: ");
        int aantalLotjes = sc.nextInt();
        System.out.print("Geef de prijs in van 1 lotje: ");
        double prijsPerLot = sc.nextDouble();
        Tombola tombola = new Tombola(vereniging,aantalLotjes,prijsPerLot);
        System.out.printf("Wij verkopen lotjes, prijs per lotje bedraagt : %.2f voor 1 lotje, %.2f vanaf 5 lotjes en %.2f vanaf 10 lotjes%n",tombola.getPrijsPerLot(),tombola.geefPrijsVanaf5Lotjes(),tombola.geefPrijsVanaf10Lotjes());
        int aantalLotjes2;
        double totaal=0;
        double prijs2=0;
        do{
            System.out.printf("Hoeveel lotjes wil je kopen? (max = %d , -1 om te stoppen)",tombola.getAantalLotjes());
            aantalLotjes2 = sc.nextInt();
            if(aantalLotjes2 > 0 && aantalLotjes2 <= tombola.getAantalLotjes()){
                if(aantalLotjes2 >= 5 && aantalLotjes2 < 10){
                prijs2 = aantalLotjes2 * tombola.geefPrijsVanaf5Lotjes();
                tombola.setAantalLotjes(tombola.getAantalLotjes()-aantalLotjes2);
                }else if (aantalLotjes2 < 5){
                prijs2 = aantalLotjes2 * tombola.getPrijsPerLot();
                tombola.setAantalLotjes(tombola.getAantalLotjes()-aantalLotjes2);
                }
                else if(aantalLotjes2 >=10){
                prijs2 = aantalLotjes2 * tombola.geefPrijsVanaf10Lotjes();
                tombola.setAantalLotjes(tombola.getAantalLotjes()-aantalLotjes2);
                } 
            System.out.printf("%d %s %.2f%n",aantalLotjes2,(aantalLotjes2>1)?"lotjes kosten":"lot kost",prijs2);  
            totaal += prijs2;
            }else{System.out.println("Geen geldig getal");}
        }while (aantalLotjes2 != -1 && tombola.getAantalLotjes() != 0);
        System.out.printf("Bij de tombola van %s werden in het totaal voor %.2f euro lotjes verkocht%n",tombola.getVerenigingnaam(),totaal);
    }
    
}
