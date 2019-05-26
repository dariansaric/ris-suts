package service;

import dao.DAOProvider;
import model.TuristickiObjektEntity;
import model.repository.TuristickiObjekt;

import java.util.ArrayList;
import java.util.List;

public class TuristickiObjektService {
    private static TuristickiObjekt convertToObject(TuristickiObjektEntity e) {
        TuristickiObjekt o = new TuristickiObjekt();

        o.setSifraObjekt(e.getSifraObjekt());
        o.setOib(e.getOib());
        o.setNaziv(e.getNaziv());
        o.setSifraVrsta(e.getSifraVrsta());

        return o;
    }

    public static List<TuristickiObjekt> dohvatiObjekte(String oib) {
        List<TuristickiObjektEntity> le = DAOProvider.getDAO().dohvatiSveObjekte(oib);
        List<TuristickiObjekt> lo = new ArrayList<>(le.size());

        le.forEach(e -> lo.add(convertToObject(e)));

        return lo;
    }

//    public static boolean pohraniTuristickiObjekt(TuristickiObjekt o) {
//        return DAOProvider.getDAO().pohraniTuristickiObjekt(o);
//    }

    public static boolean azurirajObjekt(TuristickiObjekt o) {
        return DAOProvider.getDAO().azurirajTuristickiObjekt(o);
    }

    public static boolean pohraniObjekt(TuristickiObjekt o) {
        return DAOProvider.getDAO().pohraniTuristickiObjekt(o);
    }
}
