package model.repository;

import model.entity.TuristickiObjektEntity;

import java.util.Objects;

public class TuristickiObjekt implements Service<TuristickiObjektEntity> {
    private long sifraObjekt;
    private String oib;
    private String naziv;
    private long sifraVrsta;

    public TuristickiObjekt(long sifraObjekt, String oib, String naziv, long sifraVrsta) {
        this.sifraObjekt = sifraObjekt;
        this.oib = oib;
        this.naziv = naziv;
        this.sifraVrsta = sifraVrsta;
    }

    public TuristickiObjekt() {
    }

    public long getSifraObjekt() {
        return sifraObjekt;
    }

    public void setSifraObjekt(long sifraObjekt) {
        this.sifraObjekt = sifraObjekt;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

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
        TuristickiObjekt that = (TuristickiObjekt) o;
        return sifraObjekt == that.sifraObjekt &&
                sifraVrsta == that.sifraVrsta &&
                Objects.equals(oib, that.oib) &&
                Objects.equals(naziv, that.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifraObjekt, oib, naziv, sifraVrsta);
    }

    @Override
    public TuristickiObjektEntity convertToEntity() {
        TuristickiObjektEntity o = new TuristickiObjektEntity();
        convertToEntity(o);

        return o;
    }

    @Override
    public void convertToEntity(TuristickiObjektEntity o) {
        o.setOib(oib);
        o.setSifraObjekt(sifraObjekt);
        o.setNaziv(naziv);
        o.setSifraVrsta(sifraVrsta);
    }
}
