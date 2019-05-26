package dao.jpa;


import dao.DAO;
import model.*;
import model.repository.FizickaOsoba;
import model.repository.PravnaOsoba;
import model.repository.PruzateljUsluga;
import model.repository.TuristickiObjekt;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JPADAOImpl implements DAO {
    @Override
    public List<PruzateljUslugaEntity> dohvatiPruzatelje() {
        return JPAEMProvider.getEntityManager()
                .createNamedQuery("PruzateljUsluga.dohvatiSve", PruzateljUslugaEntity.class)
                .getResultList();
    }

    @Override
    public boolean pohraniPruzatelja(PruzateljUsluga pruzateljUsluga) {
        try {
            EntityManager em = JPAEMProvider.getEntityManager();
            PruzateljUslugaEntity p = new PruzateljUslugaEntity();
            p.setOib(pruzateljUsluga.getOib());
            p.setAdresa(pruzateljUsluga.getAdresa());
            em.persist(p);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean azurirajPruzatelja(PruzateljUsluga pruzateljUsluga) {
        try {
            PruzateljUslugaEntity o = JPAEMProvider.getEntityManager().find(PruzateljUslugaEntity.class, pruzateljUsluga.getOib());
            o.setOib(pruzateljUsluga.getOib());
            o.setAdresa(pruzateljUsluga.getAdresa());

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public PruzateljUslugaEntity dohvatiPruzatelja(String oib) {
        try {
            EntityManager em = JPAEMProvider.getEntityManager();
            PruzateljUslugaEntity e = em.find(PruzateljUslugaEntity.class, oib);
            return e;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public FizickaOsobaEntity dohvatiFizickuOsobu(String oib) {
        return JPAEMProvider.getEntityManager().find(FizickaOsobaEntity.class, oib);
    }

    @Override
    public boolean pohraniFizickuOsobu(FizickaOsoba fizickaOsoba) {
        try {
            FizickaOsobaEntity e = fizickaOsoba.convertToEntity();
            JPAEMProvider.getEntityManager().persist(e);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean azurirajFizickuOsobu(FizickaOsoba fizickaOsoba) {
        try {
            FizickaOsobaEntity e = JPAEMProvider.getEntityManager().find(FizickaOsobaEntity.class, fizickaOsoba.getOib());
            fizickaOsoba.convertToEntity(e);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public PravnaOsobaEntity dohvatiPravnuOsobu(String oib) {
        return JPAEMProvider.getEntityManager().find(PravnaOsobaEntity.class, oib);
    }

    @Override
    public boolean pohraniPravnuOsobu(PravnaOsoba pravnaOsoba) {
        try {
            PravnaOsobaEntity e = pravnaOsoba.convertToEntity();
            JPAEMProvider.getEntityManager().persist(e);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean azurirajPravnuOsobu(PravnaOsoba pravnaOsoba) {
        try {
            PravnaOsobaEntity e = JPAEMProvider.getEntityManager().find(PravnaOsobaEntity.class, pravnaOsoba.getOib());
            pravnaOsoba.convertToEntity(e);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<TuristickiObjektEntity> dohvatiSveObjekte(String oib) {
        return JPAEMProvider.getEntityManager()
                .createNamedQuery("PruzateljUsluga.dohvatiObjekte", TuristickiObjektEntity.class)
                .setParameter("o", oib)
                .getResultList();
    }

    @Override
    public TuristickiObjektEntity dohvatiTuristickiObjekt(long sifraObjekt) {
        return JPAEMProvider.getEntityManager().find(TuristickiObjektEntity.class, sifraObjekt);
    }

    @Override
    public boolean pohraniTuristickiObjekt(TuristickiObjekt objekt) {
        try {
            EntityManager em = JPAEMProvider.getEntityManager();
            Optional<Long> id = em.createNamedQuery("TuristickiObjekt.dohvatiSve", TuristickiObjektEntity.class)
                    .getResultList().stream().map(TuristickiObjektEntity::getSifraObjekt).max(Long::compare);
            long max = id.isPresent() ? id.get() : -1;

            objekt.setSifraObjekt(max + 1);
            TuristickiObjektEntity e = objekt.convertToEntity();
            em.persist(e);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean azurirajTuristickiObjekt(TuristickiObjekt objekt) {
        try {
            TuristickiObjektEntity e = JPAEMProvider.getEntityManager().find(TuristickiObjektEntity.class, objekt.getSifraObjekt());
            objekt.convertToEntity(e);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<GostEntity> dohvatiGoste(long sifraObjekt) {
        return JPAEMProvider.getEntityManager()
                .createNamedQuery("TuristickiObjekt.dohvatiGoste", GostEntity.class)
                .setParameter("sobj", sifraObjekt)
                .getResultList();
    }

    @Override
    public List<VrstaObjektEntity> dohvatiVrste() {
        return JPAEMProvider.getEntityManager()
                .createNamedQuery("vrstaObjekt.dohvatiSve", VrstaObjektEntity.class)
                .getResultList();
    }

    @Override
    public VrstaObjektEntity dohvatiVrstu(long sifraVrsta) {
        return JPAEMProvider.getEntityManager().find(VrstaObjektEntity.class, sifraVrsta);
    }

}
