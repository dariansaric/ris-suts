package model.repository;

import java.sql.Date;
import java.util.Objects;

public class RegistracijaObjekt {
    private long sifraRegistracija;
    private long sifraObjekt;
    private Date datumPredaje;

    public RegistracijaObjekt(long sifraRegistracija, long sifraObjekt, Date datumPredaje) {
        this.sifraRegistracija = sifraRegistracija;
        this.sifraObjekt = sifraObjekt;
        this.datumPredaje = datumPredaje;
    }

    public RegistracijaObjekt() {
    }


    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    public long getSifraObjekt() {
        return sifraObjekt;
    }

    public void setSifraObjekt(long sifraObjekt) {
        this.sifraObjekt = sifraObjekt;
    }

    public Date getDatumPredaje() {
        return datumPredaje;
    }

    public void setDatumPredaje(Date datumPredaje) {
        this.datumPredaje = datumPredaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistracijaObjekt that = (RegistracijaObjekt) o;
        return sifraRegistracija == that.sifraRegistracija &&
                sifraObjekt == that.sifraObjekt &&
                Objects.equals(datumPredaje, that.datumPredaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, sifraObjekt, datumPredaje);
    }
}
