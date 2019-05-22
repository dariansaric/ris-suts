package model.objects;

import java.util.Objects;

public class DrzavnaInstitucija {
    private long sifraInstitucija;
    private String naziv;

    public DrzavnaInstitucija(long sifraInstitucija, String naziv) {
        this.sifraInstitucija = sifraInstitucija;
        this.naziv = naziv;
    }

    public DrzavnaInstitucija() {
    }

    public long getSifraInstitucija() {
        return sifraInstitucija;
    }

    public void setSifraInstitucija(long sifraInstitucija) {
        this.sifraInstitucija = sifraInstitucija;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrzavnaInstitucija that = (DrzavnaInstitucija) o;
        return sifraInstitucija == that.sifraInstitucija &&
                Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraInstitucija, naziv);
    }
}
