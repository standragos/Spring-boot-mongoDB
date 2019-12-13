package io.codementor.gtommee.rest_tutorial.models;

import java.util.List;

public class Consultation {

    private String nume_pacient;
    private String diagnostic;
    private Detalii_pacient detalii_pacient;

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
