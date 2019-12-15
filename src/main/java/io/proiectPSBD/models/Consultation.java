package io.proiectPSBD.models;


public class Consultation {

    private String nume_pacient;
    private String diagnostic;
    private Detalii_pacient detalii_pacient;
    private static int counter=0;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Consultation.counter = counter;
    }

    public Consultation(){
        counter++;
    }
    public Detalii_pacient getDetalii_pacient() {
        return detalii_pacient;
    }

    public void setDetalii_pacient(Detalii_pacient detalii_pacient) {
        this.detalii_pacient = detalii_pacient;
    }
    public String getNume_pacient() {
        return nume_pacient;
    }

    public void setNume_pacient(String nume_pacient) {
        this.nume_pacient = nume_pacient;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

}
