// Klasa Menaxher që trashegon nga Punonjes1
public class Menaxher extends Punonjes {
    private String departamenti;

    public Menaxher() {
        super("", 0); // Mund të inicializoni vlerat default të klasës bazë
        this.departamenti = "";
    }


    public Menaxher(String emri, double paga, String departamenti) {
        super(emri, paga);
        this.departamenti = departamenti;
    }

    public String getDepartamenti() {
        return departamenti;
    }

    public void setDepartamenti(String departamenti) {
        this.departamenti = departamenti;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Emri: " + getEmri() + ", Departamenti: " + departamenti + ", Paga: " + getPaga();
    }

    public static void main(String[] args) {
        // Për të testuar klasën Menaxher
        Menaxher menaxheri = new Menaxher("EmriMenaxherit", 70000, "DepartamentiXYZ");
        System.out.println("Informacioni i menaxherit: " + menaxheri.toString());

        menaxheri.raiseSalary(10); // Rritja e pagës për 10%
        System.out.println("Pas rritjes së pagës: " + menaxheri.toString());
    }
}

