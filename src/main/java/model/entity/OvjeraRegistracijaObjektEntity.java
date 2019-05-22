package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OvjeraRegistracijaObjekt", schema = "public", catalog = "suts")
@IdClass(OvjeraRegistracijaObjektEntityPK.class)
public class OvjeraRegistracijaObjektEntity {
    private long sifraRegistracija;
    private long sifraDuznosnik;
    private boolean status;

    @Id
    @Column(name = "sifraRegistracija", nullable = false)
    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    @Id
    @Column(name = "sifraDuznosnik", nullable = false)
    public long getSifraDuznosnik() {
        return sifraDuznosnik;
    }

    public void setSifraDuznosnik(long sifraDuznosnik) {
        this.sifraDuznosnik = sifraDuznosnik;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OvjeraRegistracijaObjektEntity that = (OvjeraRegistracijaObjektEntity) o;
        return sifraRegistracija == that.sifraRegistracija &&
                sifraDuznosnik == that.sifraDuznosnik &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, sifraDuznosnik, status);
    }
}
