package dao;


import model.*;
import model.repository.FizickaOsoba;
import model.repository.PravnaOsoba;
import model.repository.PruzateljUsluga;
import model.repository.TuristickiObjekt;

import java.util.List;

/**
 * Sučelje prema podsustavu za perzistenciju podataka.
 *
 * @author marcupic
 */
public interface DAO {
    List<PruzateljUslugaEntity> dohvatiPruzatelje();

    boolean pohraniPruzatelja(PruzateljUsluga pruzateljUsluga);

    boolean azurirajPruzatelja(PruzateljUsluga pruzateljUsluga);

    PruzateljUslugaEntity dohvatiPruzatelja(String oib);

    FizickaOsobaEntity dohvatiFizickuOsobu(String oib);

    boolean pohraniFizickuOsobu(FizickaOsoba fizickaOsoba);

    boolean azurirajFizickuOsobu(FizickaOsoba fizickaOsoba);

    PravnaOsobaEntity dohvatiPravnuOsobu(String oib);

    boolean pohraniPravnuOsobu(PravnaOsoba pravnaOsoba);

    boolean azurirajPravnuOsobu(PravnaOsoba pravnaOsoba);

    List<TuristickiObjektEntity> dohvatiSveObjekte(String oib);

    TuristickiObjektEntity dohvatiTuristickiObjekt(long sifraObjekt);

    boolean pohraniTuristickiObjekt(TuristickiObjekt objekt);

    boolean azurirajTuristickiObjekt(TuristickiObjekt objekt);

    boolean izbrisiTuristickiObjekt(long sifraObjekt);

    List<GostEntity> dohvatiGoste(long sifraObjekt);

    List<VrstaObjektEntity> dohvatiVrste();

    VrstaObjektEntity dohvatiVrstu(long sifraVrsta);
}