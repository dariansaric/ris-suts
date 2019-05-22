package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TuristickiObjekt", schema = "public", catalog = "suts")
@NamedQueries(value = {
        @NamedQuery(name = "TuristickiObjekt.dohvatiGoste", query = "select g from GostEntity as g where g.sifraObjekt = :sobj")
})
public class TuristickiObjektEntity {
    private long sifraObjekt;
    private String oib;
    private String naziv;
    private long sifraVrsta;

    @Id
    @Column(name = "sifraObjekt", nullable = false)
    public long getSifraObjekt() {
        return sifraObjekt;
    }

    public void setSifraObjekt(long sifraObjekt) {
        this.sifraObjekt = sifraObjekt;
    }

    @Basic
    @Column(name = "oib", nullable = false, length = 255)
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Basic
    @Column(name = "naziv", nullable = false, length = 255)
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "sifraVrsta", nullable = false)
    public long getSifraVrsta() {
        return sifraVrsta;
    }

    public void setSifraVrsta(long sifraVrsta) {
        this.sifraVrsta = sifraVrsta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TuristickiObjektEntity that = (TuristickiObjektEntity) o;
        return sifraObjekt == that.sifraObjekt &&
                sifraVrsta == that.sifraVrsta &&
                Objects.equals(oib, that.oib) &&
                Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraObjekt, oib, naziv, sifraVrsta);
    }
}
