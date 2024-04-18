import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMenaxher {
    public static void main(String[] args) {
        // a) Krijimi i një Menaxher dhe testimi i metodes raiseSalary
        Menaxher menaxher = new Menaxher("EmriMenaxherit", 70000, "DepartamentiXYZ");
        System.out.println("Informacioni i menaxherit para rritjes së pagës: " + menaxher.toString());
        menaxher.raiseSalary(10); // Rritja e pagës për 10%
        System.out.println("Pas rritjes së pagës: " + menaxher.toString());

        List<Menaxher> listaMenaxhereve = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Shtyp emrin e menaxherit " + (i + 1) + ": ");
            String emri = scanner.nextLine();

            System.out.println("Shtyp pagën e menaxherit " + (i + 1) + ": ");
            double paga = Double.parseDouble(scanner.nextLine());

            System.out.println("Shtyp departamentin e menaxherit " + (i + 1) + ": ");
            String departamenti = scanner.nextLine();

            Menaxher menaxheri = new Menaxher(emri, paga, departamenti);
            listaMenaxhereve.add(menaxheri);
        }

        // c) Funksioni që kthen menaxherët në departamentin "D1"
        List<Menaxher> menaxheretNeD1 = getMenaxheretNeDepartament(listaMenaxhereve, "D1");

        // Shfaqja e rezultateve
        System.out.println("Menaxherët në departamentin D1: ");
        for (Menaxher m : menaxheretNeD1) {
            System.out.println(m.toString());
        }
    }

    // Funksioni për gjetjen e menaxherëve në një departament të caktuar
    public static List<Menaxher> getMenaxheretNeDepartament(List<Menaxher> lista, String departamenti) {
        List<Menaxher> menaxheretNeDepartament = new ArrayList<>();

        for (Menaxher m : lista) {
            if (m.getDepartamenti().equalsIgnoreCase(departamenti)) {
                menaxheretNeDepartament.add(m);
            }
        }

        return menaxheretNeDepartament;
    }
}