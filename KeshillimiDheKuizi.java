import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KeshillimiDheKuizi {

    // Opsioni 2: Sugjerimi i drejtimit sipas talentit dhe hobit
    public static void sugjeroDrejtimin(Nxenesi nxenesi, Scanner scanner) {
        System.out.println("\nCila eshte prirja / talenti yt kryesor?");
        System.out.println("1. Teknologji, matematike dhe kompjutera");
        System.out.println("2. Biologji, kimi dhe shendetesi");
        System.out.println("3. Biznes, menaxhim dhe tregti");
        System.out.println("4. Debat, drejtesi dhe letersi");
        System.out.print("Zgjedhja (1-4): ");
        int talenti = scanner.nextInt();

        System.out.println("\nCfare hobi ke ne kohen e lire?");
        System.out.println("1. Lojera, programim ose hulumtim ne internet");
        System.out.println("2. Sport, lexim per shendetin ose vullnetarizem");
        System.out.println("3. Organizim, shitblerje ose financa");
        System.out.println("4. Lexim librash, shkrim ose debat");
        System.out.print("Zgjedhja (1-4): ");
        int hobi = scanner.nextInt();

        double mesatarja = nxenesi.getMesatarja();

        System.out.println("\n--- SUGJERIMI YNE PER TY ---");
        if (talenti == 1 || hobi == 1) {
            if (mesatarja >= 4.30) {
                System.out.println("Rekomandimi: SHKENCA KOMPJUTERIKE / INXHINIERI");
            } else {
                System.out.println("Rekomandimi: TEKNOLOGJI INFORMACIONI (IT) ose DIZAJN GRAFIK");
            }
        } else if (talenti == 2 || hobi == 2) {
            if (mesatarja >= 4.80) {
                System.out.println("Rekomandimi: FAKULTETI I MJEKESISE");
            } else {
                System.out.println("Rekomandimi: INFERMIERI, FARMACI ose SHKENCA TE SPORTIT");
            }
        } else if (talenti == 3 || hobi == 3) {
            System.out.println("Rekomandimi: FAKULTETI EKONOMIK (Menaxhment ose Financa)");
        } else if (talenti == 4 || hobi == 4) {
            System.out.println("Rekomandimi: FAKULTETI JURIDIK ose FILOLOGJIK");
        } else {
            System.out.println("Zgjedhje e pavlefshme!");
        }
    }

    // Opsioni 6: Mini-kuizi pergatitor
    public static void zhvilloKuizin(Scanner scanner) {
        System.out.println("\n--- MINI-KUIZ PER PROVIMIN PRANUES ---");
        System.out.println("Zgjidh fushen qe deshiron ta testosh:");
        System.out.println("1. Shkenca Kompjuterike / Matematike");
        System.out.println("2. Mjekesi / Biologji");
        System.out.print("Zgjedhja (1-2): ");
        int fusha = scanner.nextInt();
        int pikeKuizi = 0;

        if (fusha == 1) {
            System.out.print("\nPyetja 1: Sa eshte 2 ne fuqi te 5-te? (Shkruaj numrin): ");
            if (scanner.nextInt() == 32) pikeKuizi++;

            System.out.print("Pyetja 2: Sa bit ka 1 Byte? (Shkruaj numrin): ");
            if (scanner.nextInt() == 8) pikeKuizi++;

            System.out.print("Pyetja 3: Cili numer vijon ne vargun: 2, 4, 8, 16, ...? ");
            if (scanner.nextInt() == 32) pikeKuizi++;
        } else {
            System.out.print("\nPyetja 1: Sa kromozome ka qeliza normale e njeriut? (Shkruaj numrin): ");
            if (scanner.nextInt() == 46) pikeKuizi++;

            System.out.print("Pyetja 2: Sa dhoma (zgavra) ka zemra e njeriut? (Shkruaj numrin): ");
            if (scanner.nextInt() == 4) pikeKuizi++;

            System.out.print("Pyetja 3: Ne cilen temperature (Celsius) vlon uji? (Shkruaj numrin): ");
            if (scanner.nextInt() == 100) pikeKuizi++;
        }

        System.out.println("\nRezultati yt ne kuiz: " + pikeKuizi + " / 3 te sakta!");
        if (pikeKuizi == 3) {
            System.out.println("Shkelqyeshem! Je shume i pergatitur.");
        } else {
            System.out.println("Keshille: Perseriti edhe pak njohurite baze para provimit.");
        }
    }

    // Opsioni 7: Ruajtja e raportit ne skedar .txt
    public static void ruajRaportin(Nxenesi nxenesi) {
        double mesatarja = nxenesi.getMesatarja();
        try {
            FileWriter shkruesi = new FileWriter("Plani_Im_Universitar.txt");
            shkruesi.write("=========================================\n");
            shkruesi.write("      RAPORTI YNE PER UNIVERSITET        \n");
            shkruesi.write("=========================================\n");
            shkruesi.write("Nota klasa 10: " + nxenesi.getNota10() + "\n");
            shkruesi.write("Nota klasa 11: " + nxenesi.getNota11() + "\n");
            shkruesi.write("Nota klasa 12: " + nxenesi.getNota12() + "\n");
            shkruesi.write("Mesatarja perfundimtare: " + String.format("%.2f", mesatarja) + "\n\n");
            
            if (mesatarja >= 4.80) {
                shkruesi.write("Statusi: Kualifikohesh per TE GJITHA fakultetet (perfshire Mjekesine).\n");
            } else if (mesatarja >= 4.30) {
                shkruesi.write("Statusi: Kualifikohesh per Inxhinieri, Ekonomik, Juridik dhe Filologjik.\n");
            } else if (mesatarja >= 3.70) {
                shkruesi.write("Statusi: Kualifikohesh per Ekonomik, Juridik dhe Filologjik.\n");
            } else {
                shkruesi.write("Statusi: Kualifikohesh per drejtimet me prag me te ulet (psh. Filologjik).\n");
            }
            
            shkruesi.close();
            System.out.println("\nSukses! Raporti u ruajt ne skedarin 'Plani_Im_Universitar.txt' ne folderin e projektit.");
        } catch (IOException e) {
            System.out.println("\nNdodhi nje gabim gjate ruajtjes se skedarit.");
        }
    }
}
