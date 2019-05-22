package dao;


import model.entity.*;
import model.objects.FizickaOsoba;
import model.objects.PravnaOsoba;
import model.objects.PruzateljUsluga;
import model.objects.TuristickiObjekt;

import java.util.List;

/**
 * Sučelje prema podsustavu za perzistenciju podataka.
 *
 * @author marcupic
 */
public interface DAO {
//    String TFS_QUERY =
//            "select title," +
//                    "   ts_headline('english', title || '\n' || summary || '\n' || categories || '\n' || description, " +
//                    "   to_tsquery(:q)) as headline, rank" +
//                    " from " +
//                    "     (select title, " +
//                    "       summary, categories, description, " +
//                    "       ts_rank_cd(array[0.2,0.3,0.6,1.0], searchvector," +
//                    "       to_tsquery(:q), 2) as rank " +
//                    "       from movie order by rank desc limit 10) as ranks;";
//
//    String DATE_PIVOT_QUERY = "select * from " +
//            "crosstab(" +
//            "    'select upit, ''d'' || to_char(datum, ''DDMMYYYY'') as d, count(*) as br from dnevnik " +
//            "group by upit, d order by upit, d','select t from dani order by dan')" +
//            "  as pivot(upit varchar(255), %s);";
//
//    String HOUR_PIVOT_QUERY = "select * from crosstab(" +
//            "    'select upit, ''h'' || to_char(datum, ''HH24'') as d, count(*) as br from dnevnik " +
//            "group by upit, d order by upit, d', 'select t from sati order by sati')" +
//            "                  as pivot(upit varchar(255), %s)";
//    String[] HOURS = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
//            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
//
//    boolean postMovie(Movie movie) throws DAOException;
//
//    List<SearchResult> getSearchResults(String query) throws DAOException;
//
//    List<String> getSuggestions(String term) throws DAOException;
//
//    List<Util.PivotResult> getAnalysisResultsForDays(List<String> days) throws DAOException;
//
//    List<Util.PivotResult> getAnalysisResultsForHours(Date start, Date end) throws DAOException;
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
//    RegistracijaObjektEntity dohvatiRegistracijuObjekt(long sifraObjekt);
    List<GostEntity> dohvatiGoste(long sifraObjekt);
    //todo:odredi sto je najlakse prikazivati
}