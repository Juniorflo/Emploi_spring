package sn.esmt.httpclientemploi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.httpclientemploi.httpconfig.Api;
import sn.esmt.httpclientemploi.httpconfig.CvsResponses;
import sn.esmt.httpclientemploi.tools.MyAdapterCvs;
/*Cette Activité liée au layout acitvity_liste_cvs_specialite, permet d'afficher la
* liste des cvs par specialite.*/
public class ListeCvsSpecialiteActivity extends AppCompatActivity {

    // Création de la ListView
    private ListView list;
    private ArrayList<CvsResponses> cvs = new ArrayList<CvsResponses>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_cvs_specialite);

        // Initialisation de la ListView
        list = (ListView) findViewById(R.id.listCvsSpecialite);

        // Chargement de la liste des utilisateurs depuis l'API
        chargerListe();
    }

    public void chargerListe(){

        //Création de l'objet Retrofit pour accéder à l'API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.7:8083") //URL de base de l'API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Crée une instance de l'interface Api,
        //qui définit les méthodes pour les appels HTTP.
        Api api = retrofit.create(Api.class);

        //creation d'un objet Call pour l'appel à la méthode all() de l'interface Api.
        Call<ArrayList<CvsResponses>> call = api.getBySpecialite(SpecialiteActivity.getChoixSpecialite());

        call.enqueue(new Callback<ArrayList<CvsResponses>>() {
            @Override
            public void onResponse(Call<ArrayList<CvsResponses>> call, Response<ArrayList<CvsResponses>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response :", response.body().get(0).getEmail());
                    response.body().stream().forEach(cvsResponse -> cvs.add(cvsResponse));
                    MyAdapterCvs adpt = new MyAdapterCvs(ListeCvsSpecialiteActivity.this,cvs);
                    Log.d("Debbugage : " , cvs.get(0).getNom());
                    list.setAdapter(adpt);
                } else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CvsResponses>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.90.167 not permitted by network security policy
                Toast.makeText(ListeCvsSpecialiteActivity.this, "Impossible d'acceder au serveur !", Toast.LENGTH_LONG).show();
            }

        });


    }
}