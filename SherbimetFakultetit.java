import java.util.Scanner;

public class SherbimetFakultetit {

    // Opsioni 1: Kontrolli i pranimit per nje fakultet
    public static void kontrolloPranimin(Nxenesi nxenesi, Scanner scanner) {
        System.out.println("\nZgjidh fakultetin:");
        System.out.println("1. Mjekesi (Pragu: 4.80)");
        System.out.println("2. Shkenca Kompjuterike (Pragu: 4.30)");
        System.out.println("3. Ekonomik (Pragu: 3.80)");
        System.out.println("4. Juridik (Pragu: 3.70)");
        System.out.println("5. Filologjik (Pragu: 3.20)");
        System.out.print("Zgjedhja (1-5): ");
        int fak = scanner.nextInt();

        double pragu = 0;
        if (fak == 1) pragu = 4.80;
        else if (fak == 2) pragu = 4.30;
        else if (fak == 3) pragu = 3.80;
        else if (fak == 4) pragu = 3.70;
        else if (fak == 5) pragu = 3.20;
        else {
            System.out.println("Zgjedhje e gabuar!");
            return;
        }

        double mesatarja = nxenesi.getMesatarja();
        if (mesatarja >= pragu) {
            System.out.println("REZULTATI: URIME! Pranohesh ne kete fakultet.");
        } else {
            System.out.printf("REZULTATI: JO. Te mungojne edhe %.2f nota.\n", (pragu - mesatarja));
        }
    }

    // Opsioni 3: Lista e te gjitha fakulteteve
    public static void shfaqTeGjithaFakultetet(Nxenesi nxenesi) {
        double mesatarja = nxenesi.getMesatarja();
        System.out.println("\n--- FAKULTETET KU PLOTESON KUSHTET (Mesatarja jote: " + String.format("%.2f", mesatarja) + ") ---");
        
        String[] fakultetet = {
            "Fakulteti i Mjekesise", 
            "Shkenca Kompjuterike / Inxhinieri", 
            "Fakulteti Ekonomik", 
            "Fakulteti Juridik", 
            "Fakulteti Filologjik"
        };
        double[] pragjet = {4.80, 4.30, 3.80, 3.70, 3.20};

        for (int i = 0; i < fakultetet.length; i++) {
            if (mesatarja >= pragjet[i]) {
                System.out.println("[PO]  " + fakultetet[i] + " (Pragu: " + pragjet[i] + ")");
            } else {
                double mungesa = pragjet[i] - mesatarja;
                System.out.printf("[JO]  %s (Pragu: %.2f - te mungojne %.2f nota)\n", fakultetet[i], pragjet[i], mungesa);
            }
        }
    }

    // Opsioni 4: Kalkulatori me Matura dhe Provim Pranues
    public static void llogaritPiketTotale(Nxenesi nxenesi, Scanner scanner) {
        System.out.println("\n--- LLOGARITESI REAL I PIKEVE (MAX 100 PIKE) ---");
        double piketShkolla = (nxenesi.getMesatarja() / 5.0) * 30.0;

        System.out.print("Shkruaj piket e Testit te Matures (0 - 100): ");
        double matura = scanner.nextDouble();
        double piketMatura = (matura / 100.0) * 30.0;

        System.out.print("Shkruaj piket e Provimit Pranues (0 - 100): ");
        double provimi = scanner.nextDouble();
        double piketProvimi = (provimi / 100.0) * 40.0;

        double totali = piketShkolla + piketMatura + piketProvimi;

        System.out.printf("\nPiket nga shkolla e mesme (30%%): %.2f\n", piketShkolla);
        System.out.printf("Piket nga Testi i Matures (30%%): %.2f\n", piketMatura);
        System.out.printf("Piket nga Provimi Pranues (40%%): %.2f\n", piketProvimi);
        System.out.printf("-> TOTALI YT ESHTE: %.2f / 100 pike\n", totali);

        if (totali >= 80) {
            System.out.println("Statusi: Shkelqyeshem! Ke shanse shume te larta edhe per drejtimet me te kerkuara.");
        } else if (totali >= 60) {
            System.out.println("Statusi: Mire! Ke gjasa te mira ne shumicen e fakulteteve.");
        } else {
            System.out.println("Statusi: Rezultat i ulet, kerkohet me shume pergatitje per provimin pranues.");
        }
    }

    // Opsioni 5: Kontrolli per burse studimi
    public static void kontrolloBursen(Nxenesi nxenesi, Scanner scanner) {
        System.out.println("\n--- KONTROLLI PER BURSE STUDIMI ---");
        System.out.println("Zgjidh llojin e universitetit:");
        System.out.println("1. Universitet Publik (Tarifa baze: 50 Euro/vit)");
        System.out.println("2. Universitet Privat (Tarifa baze: 1500 Euro/vit)");
        System.out.print("Zgjedhja (1-2): ");
        int uni = scanner.nextInt();

        double tarifaBaze = (uni == 1) ? 50.0 : 1500.0;
        double zbritja = 0.0;
        double mesatarja = nxenesi.getMesatarja();

        if (mesatarja >= 4.80) {
            zbritja = 1.00;
            System.out.println("URIME! Me mesataren " + String.format("%.2f", mesatarja) + " fiton BURSE TE PLOTE (100%)!");
        } else if (mesatarja >= 4.50) {
            zbritja = 0.50;
            System.out.println("URIME! Me mesataren " + String.format("%.2f", mesatarja) + " fiton BURSE 50%!");
        } else {
            System.out.println("Nuk kualifikohesh per burse ekselence (kerkohet mesatare minimum 4.50).");
        }

        double pagesaPerfundimtare = tarifaBaze - (tarifaBaze * zbritja);
        System.out.printf("Pagesa jote vjetore per studime do te jete: %.2f Euro\n", pagesaPerfundimtare);
    }
}
