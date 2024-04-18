public class Main {
    public static void main(String[] args) {
        // Krijimi i një instance të objektit Punonjes
        Punonjes punonjesi = new Punonjes("John Doe", 500.0);
        // Printimi i informacionit të punonjesit
        System.out.println("Informacioni i punonjesit: " + punonjesi);

        // Rritja e pagues
        punonjesi.raiseSalary(10.0);

        // Printimi i informacionit pas rritjes së pagues
        System.out.println("Informacioni pas rritjes së pages: " + punonjesi);
    }
}

