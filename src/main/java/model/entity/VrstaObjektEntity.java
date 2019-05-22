package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VrstaObjekt", schema = "public", catalog = "suts")
public class VrstaObjektEntity {
    private long sifraVrsta;
    private String nazivVrsta;

    @Id
    @Column(name = "sifraVrsta", nullable = false)
    public long getSifraVrsta() {
        return sifraVrsta;
    }

    public void setSifraVrsta(long sifraVrsta) {
        this.sifraVrsta = sifraVrsta;
    }

    @Basic
    @Column(name = "nazivVrsta", nullable = false, length = 255)
    public String getNazivVrsta() {
        return nazivVrsta;
    }

    public void setNazivVrsta(String nazivVrsta) {
        this.nazivVrsta = nazivVrsta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VrstaObjektEntity that = (VrstaObjektEntity) o;
        return sifraVrsta == that.sifraVrsta &&
                Objects.equals(nazivVrsta, that.nazivVrsta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraVrsta, nazivVrsta);
    }
}
