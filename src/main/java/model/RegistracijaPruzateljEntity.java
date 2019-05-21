package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RegistracijaPruzatelj", schema = "public", catalog = "suts")
public class RegistracijaPruzateljEntity {
    private long sifraRegistracija;
    private String oib;

    @Id
    @Column(name = "sifraRegistracija", nullable = false)
    public long getSifraRegistracija() {
        return sifraRegistracija;
    }

    public void setSifraRegistracija(long sifraRegistracija) {
        this.sifraRegistracija = sifraRegistracija;
    }

    @Basic
    @Column(name = "oib", nullable = false, length = 255)
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistracijaPruzateljEntity that = (RegistracijaPruzateljEntity) o;
        return sifraRegistracija == that.sifraRegistracija &&
                Objects.equals(oib, that.oib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraRegistracija, oib);
    }
}
