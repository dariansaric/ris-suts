package service;

import dao.DAOProvider;
import model.VrstaObjektEntity;
import model.repository.VrstaObjekt;

import java.util.ArrayList;
import java.util.List;

public class VrstaObjektService {
    private static VrstaObjekt convertToObject(VrstaObjektEntity e) {
        return new VrstaObjekt(
                e.getSifraVrsta(),
                e.getNazivVrsta()
        );
    }

    public static List<VrstaObjekt> dohvatiVrste() {
        List<VrstaObjektEntity> le = DAOProvider.getDAO().dohvatiVrste();
        List<VrstaObjekt> lo = new ArrayList<>(le.size());

        le.forEach(e -> lo.add(convertToObject(e)));

        return lo;
    }

    public static VrstaObjekt dohvatiVrstu(long sifraVrsta) {
        return convertToObject(DAOProvider.getDAO().dohvatiVrstu(sifraVrsta));
    }
}
