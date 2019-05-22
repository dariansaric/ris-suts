package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Gost", schema = "public", catalog = "suts")
public class GostEntity {
    private long sifraGost;
    private long sifraObjekt;

    @Id
    @Column(name = "sifraGost", nullable = false)
    public long getSifraGost() {
        return sifraGost;
    }

    public void setSifraGost(long sifraGost) {
        this.sifraGost = sifraGost;
    }

    @Basic
    @Column(name = "sifraObjekt", nullable = false)
    public long getSifraObjekt() {
        return sifraObjekt;
    }

    public void setSifraObjekt(long sifraObjekt) {
        this.sifraObjekt = sifraObjekt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GostEntity that = (GostEntity) o;
        return sifraGost == that.sifraGost &&
                sifraObjekt == that.sifraObjekt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraGost, sifraObjekt);
    }
}
