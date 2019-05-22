package model.repository;

import model.entity.PruzateljUslugaEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class PruzateljUsluga implements Repository<PruzateljUslugaEntity> {
    private String oib;
    private String adresa;
    private Set<TuristickiObjekt> objekti = new HashSet<>();

    public PruzateljUsluga(String oib, String adresa) {
        this.oib = oib;
        this.adresa = adresa;
    }

    public PruzateljUsluga() {
    }


    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }


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
        PruzateljUsluga that = (PruzateljUsluga) o;
        return Objects.equals(oib, that.oib) &&
                Objects.equals(adresa, that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oib, adresa);
    }

    @Override
    public PruzateljUslugaEntity convertToEntity() {
        PruzateljUslugaEntity e = new PruzateljUslugaEntity();
        e.setOib(oib);
        e.setAdresa(adresa);

        return e;
    }

    @Override
    public void convertToEntity(PruzateljUslugaEntity originalEntity) {
        originalEntity.setOib(oib);
        originalEntity.setAdresa(adresa);
    }
}
