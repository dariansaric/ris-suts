package model.repository;

import java.util.Objects;

public class Gost {
    private long sifraGost;
    private long sifraObjekt;

    public Gost() {
    }

    public Gost(long sifraGost, long sifraObjekt) {
        this.sifraGost = sifraGost;
        this.sifraObjekt = sifraObjekt;
    }

    public long getSifraGost() {
        return sifraGost;
    }

    public void setSifraGost(long sifraGost) {
        this.sifraGost = sifraGost;
    }


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
        Gost that = (Gost) o;
        return sifraGost == that.sifraGost &&
                sifraObjekt == that.sifraObjekt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraGost, sifraObjekt);
    }
}
