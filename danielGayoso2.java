public class danielGayoso2 {
    // atributos
    private double kms;
    private double litros;
    private double vmed;
    private double pgas;

    // constructores
    public danielGayoso2(double kms, double litros, double vmed, double pgas) {
        this.kms = kms;
        this.litros = litros;
        this.vmed = vmed;
        this.pgas = pgas;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getVmed() {
        return vmed;
    }

    public void setVmed(double vmed) {
        this.vmed = vmed;
    }

    public double getPgas() {
        return pgas;
    }

    public void setPgas(double pgas) {
        this.pgas = pgas;
    }

    // metodos propios de la clase
    public double dimeTiempo() {
        return kms / vmed;
    }

    public double consumoMedio() {
        double aux = litros / kms;
        return aux * 100;
    }

    public double consumoEuros() {
        double aux;
        aux = pgas * this.consumoMedio();
        return aux;
    }

    @Override
    public String toString() {
        return "Propuesto9 [kms=" + kms + ", litros=" + litros + ", vmed=" + vmed + ", pgas=" + pgas + ", dimeTiempo()="
                + dimeTiempo() + ", consumoMedio()=" + consumoMedio() + ", consumoEuros()=" + consumoEuros() + "]";
    }
}
