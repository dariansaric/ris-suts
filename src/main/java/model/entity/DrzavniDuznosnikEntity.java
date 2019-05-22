package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DrzavniDuznosnik", schema = "public", catalog = "suts")
public class DrzavniDuznosnikEntity {
    private long sifraDuznosnik;
    private String ime;
    private String prezime;
    private long sifraInstitucija;

    @Id
    @Column(name = "sifraDuznosnik", nullable = false)
    public long getSifraDuznosnik() {
        return sifraDuznosnik;
    }

    public void setSifraDuznosnik(long sifraDuznosnik) {
        this.sifraDuznosnik = sifraDuznosnik;
    }

    @Basic
    @Column(name = "ime", nullable = false, length = 255)
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "prezime", nullable = false, length = 255)
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "sifraInstitucija", nullable = false)
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
        DrzavniDuznosnikEntity that = (DrzavniDuznosnikEntity) o;
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
