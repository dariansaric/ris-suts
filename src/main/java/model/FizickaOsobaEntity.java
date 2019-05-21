package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "FizickaOsoba", schema = "public", catalog = "suts")
public class FizickaOsobaEntity {
    private String oib;
    private String ime;
    private String prezime;
    private Date datumRodjenja;

    @Id
    @Column(name = "oib", nullable = false, length = 255)
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
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
    @Column(name = "datumRodjenja", nullable = false)
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FizickaOsobaEntity that = (FizickaOsobaEntity) o;
        return Objects.equals(oib, that.oib) &&
                Objects.equals(ime, that.ime) &&
                Objects.equals(prezime, that.prezime) &&
                Objects.equals(datumRodjenja, that.datumRodjenja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, ime, prezime, datumRodjenja);
    }
}
