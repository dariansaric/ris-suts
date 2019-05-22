package model.objects;

import java.util.Objects;

public class VrstaObjekt {
    private long sifraVrsta;
    private String nazivVrsta;

    public VrstaObjekt(long sifraVrsta, String nazivVrsta) {
        this.sifraVrsta = sifraVrsta;
        this.nazivVrsta = nazivVrsta;
    }

    public VrstaObjekt() {
    }

    public long getSifraVrsta() {
        return sifraVrsta;
    }

    public void setSifraVrsta(long sifraVrsta) {
        this.sifraVrsta = sifraVrsta;
    }

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
        VrstaObjekt that = (VrstaObjekt) o;
        return sifraVrsta == that.sifraVrsta &&
                Objects.equals(nazivVrsta, that.nazivVrsta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraVrsta, nazivVrsta);
    }
}
