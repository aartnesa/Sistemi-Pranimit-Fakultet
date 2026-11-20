import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================================");
        System.out.println("     PLATFORMA UNIVERSITARE - ORIENTIMI & PRANIMI   ");
        System.out.println("====================================================");

        // 1. Marrja e notave dhe krijimi i objektit Nxenesi
        System.out.print("Shkruaj mesataren e klases se 10-te (1.0 - 5.0): ");
        double nota10 = scanner.nextDouble();

        System.out.print("Shkruaj mesataren e klases se 11-te (1.0 - 5.0): ");
        double nota11 = scanner.nextDouble();

        System.out.print("Shkruaj mesataren e klases se 12-te (1.0 - 5.0): ");
        double nota12 = scanner.nextDouble();

        if (nota10 < 1 || nota10 > 5 || nota11 < 1 || nota11 > 5 || nota12 < 1 || nota12 > 5) {
            System.out.println("\nGabim: Notat duhet te jene mes 1.0 dhe 5.0!");
            scanner.close();
            return;
        }

        Nxenesi nxenesi = new Nxenesi(nota10, nota11, nota12);
        System.out.printf("\n-> Suksesi yt mesatar eshte: %.2f\n", nxenesi.getMesatarja());

        // 2. Menuja kryesore qe therret klasat e tjera
        boolean vazhdo = true;
        while (vazhdo) {
            System.out.println("\n====================================================");
            System.out.println("Zgjidh nje nga sherbimet:");
            System.out.println("1. Kontrollo nese pranohesh ne nje fakultet te caktuar");
            System.out.println("2. Merr sugjerim per drejtim sipas talentit & hobit");
            System.out.println("3. Shiko te gjitha fakultetet ku pranohesh automatikisht");
            System.out.println("4. Llogarit piket totale (Mesatarja + Matura + Provimi)");
            System.out.println("5. Kontrollo a fiton burse studimi dhe shpenzimet");
            System.out.println("6. Bej nje mini-kuiz pergatitor per provim pranues");
            System.out.println("7. Ruaj rezultatin dhe raportin ne nje skedar (.txt)");
            System.out.println("8. Dil nga programi");
            System.out.print("Zgjedhja jote (1-8): ");
            
            int zgjedhjaMenu = scanner.nextInt();

            switch (zgjedhjaMenu) {
                case 1:
                    SherbimetFakultetit.kontrolloPranimin(nxenesi, scanner);
                    break;
                case 2:
                    KeshillimiDheKuizi.sugjeroDrejtimin(nxenesi, scanner);
                    break;
                case 3:
                    SherbimetFakultetit.shfaqTeGjithaFakultetet(nxenesi);
                    break;
                case 4:
                    SherbimetFakultetit.llogaritPiketTotale(nxenesi, scanner);
                    break;
                case 5:
                    SherbimetFakultetit.kontrolloBursen(nxenesi, scanner);
                    break;
                case 6:
                    KeshillimiDheKuizi.zhvilloKuizin(scanner);
                    break;
                case 7:
                    KeshillimiDheKuizi.ruajRaportin(nxenesi);
                    break;
                case 8:
                    System.out.println("\nProgrami u mbyll. Suksese ne studime!");
                    vazhdo = false;
                    break;
                default:
                    System.out.println("Zgjedhje e gabuar! Shtyp nje numer nga 1 deri ne 8.");
            }
        }

        scanner.close();
    }
}
