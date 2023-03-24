package sn.esmt.httpclientemploi.httpconfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*Création d'une interface de service : Vous devez créer une interface Java qui
définit les méthodes pour appeler les différents endpoints du service web RESTful.
 Ces méthodes doivent inclure des annotations qui définissent la méthode HTTP
 utilisée pour chaque appel et l'URL de l'endpoint.*/
public interface Api {
    @GET("/cvs/all")
    public Call<ArrayList<CvsResponses>> all();

    @GET("/cvs/getBySpecialite/{specialite}")
    Call<ArrayList<CvsResponses>> getBySpecialite(@Path("specialite") String specialite);

}
