package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "RegistracijaObjekt", schema = "public", catalog = "suts")
public class RegistracijaObjektEntity {
    private long sifraRegistracija;
    private long sifraObjekt;
    private Date datumPredaje;

    @Id
    @Column(name = "sifraRegistracija", nullable = false)
    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    @Basic
    @Column(name = "sifraObjekt", nullable = false)
    public long getSifraObjekt() {
        return sifraObjekt;
    }

    public void setSifraObjekt(long sifraObjekt) {
        this.sifraObjekt = sifraObjekt;
    }

    @Basic
    @Column(name = "datumPredaje", nullable = false)
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
        RegistracijaObjektEntity that = (RegistracijaObjektEntity) o;
        return sifraRegistracija == that.sifraRegistracija &&
                sifraObjekt == that.sifraObjekt &&
                Objects.equals(datumPredaje, that.datumPredaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, sifraObjekt, datumPredaje);
    }
}
