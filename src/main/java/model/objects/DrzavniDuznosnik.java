package model.objects;

import java.util.Objects;


public class DrzavniDuznosnik {
    private long sifraDuznosnik;
    private String ime;
    private String prezime;
    private long sifraInstitucija;

    public DrzavniDuznosnik() {
    }

    public DrzavniDuznosnik(long sifraDuznosnik, String ime, String prezime, long sifraInstitucija) {
        this.sifraDuznosnik = sifraDuznosnik;
        this.ime = ime;
        this.prezime = prezime;
        this.sifraInstitucija = sifraInstitucija;
    }

    public long getSifraDuznosnik() {
        return sifraDuznosnik;
    }

    public void setSifraDuznosnik(long sifraDuznosnik) {
        this.sifraDuznosnik = sifraDuznosnik;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }


    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public long getSifraInstitucija() {
        return sifraInstitucija;
    }

    public void setSifraInstitucija(long sifraInstitucija) {
        this.sifraInstitucija = sifraInstitucija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrzavniDuznosnik that = (DrzavniDuznosnik) o;
        return sifraDuznosnik == that.sifraDuznosnik &&
                sifraInstitucija == that.sifraInstitucija &&
                Objects.equals(ime, that.ime) &&
                Objects.equals(prezime, that.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraDuznosnik, ime, prezime, sifraInstitucija);
    }
}
