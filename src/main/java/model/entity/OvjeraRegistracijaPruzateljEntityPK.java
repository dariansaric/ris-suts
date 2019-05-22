package model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OvjeraRegistracijaPruzateljEntityPK implements Serializable {
    private long sifraRegistracija;
    private long sifraDuznosnik;

    @Column(name = "sifraRegistracija", nullable = false)
    @Id
    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    @Column(name = "sifraDuznosnik", nullable = false)
    @Id
    public long getSifraDuznosnik() {
        return sifraDuznosnik;
    }

    public void setSifraDuznosnik(long sifraDuznosnik) {
        this.sifraDuznosnik = sifraDuznosnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OvjeraRegistracijaPruzateljEntityPK that = (OvjeraRegistracijaPruzateljEntityPK) o;
        return sifraRegistracija == that.sifraRegistracija &&
                sifraDuznosnik == that.sifraDuznosnik;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, sifraDuznosnik);
    }
}
