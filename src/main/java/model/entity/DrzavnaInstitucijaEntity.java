package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DrzavnaInstitucija", schema = "public", catalog = "suts")
public class DrzavnaInstitucijaEntity {
    private long sifraInstitucija;
    private String naziv;

    @Id
    @Column(name = "sifraInstitucija", nullable = false)
    public long getSifraInstitucija() {
        return sifraInstitucija;
    }

    public void setSifraInstitucija(long sifraInstitucija) {
        this.sifraInstitucija = sifraInstitucija;
    }

    @Basic
    @Column(name = "naziv", nullable = false, length = 255)
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
        DrzavnaInstitucijaEntity that = (DrzavnaInstitucijaEntity) o;
        return sifraInstitucija == that.sifraInstitucija &&
                Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraInstitucija, naziv);
    }
}
