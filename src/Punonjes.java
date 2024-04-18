public class Punonjes {
    private String emri;
    private double paga;

    // Konstruktori pa parametra
    public Punonjes() {
        this.emri = "";
        this.paga = 0.0;
    }

    // Konstruktori me parametra
    public Punonjes(String emri, double paga) {
        this.emri = emri;
        this.paga = paga;
    }

    // Metodat get dhe set për emrin
    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    // Metodat get dhe set për pagen
    public double getPaga() {
        return paga;
    }

    public void setPaga(double paga) {
        this.paga = paga;
    }

    // Metoda toString për kthimin e emrit dhe pagues
    @Override
    public String toString() {
        return "Emri: " + emri + ", Paga: " + paga;
    }

    // Metoda raiseSalary për rritjen e pagues
    public void raiseSalary(double byPercent) {
        paga += (paga * byPercent / 100);
    }
}
