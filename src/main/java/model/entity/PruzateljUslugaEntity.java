package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PruzateljUsluga", schema = "public", catalog = "suts")
@NamedQueries(value = {
        @NamedQuery(name = "PruzateljUsluga.dohvatiObjekte", query = "select to from TuristickiObjektEntity as to where to.oib=:oib")
})
public class PruzateljUslugaEntity {
    private String oib;
    private String adresa;

    @Id
    @Column(name = "oib", nullable = false, length = 255)
    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Basic
    @Column(name = "adresa", nullable = false, length = 255)
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PruzateljUslugaEntity that = (PruzateljUslugaEntity) o;
        return Objects.equals(oib, that.oib) &&
                Objects.equals(adresa, that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, adresa);
    }
}
