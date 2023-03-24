package sn.esmt.httpclientemploi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/* Cette classe liée au layout activity_main représente l'accueil de l'application.
* Les deux boutons qui y sont intanciés  permettent de :
* Afficher la liste de tous les cvs.
* Afficher la liste des cvs par specialite.*/
public class MainActivity extends AppCompatActivity {
    // Déclaration des widgets
    private Button tousCvsBt;
    private Button listeCvsSpe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison des widgets avec leurs correspondants dans les fichiers layout.
        tousCvsBt = (Button) findViewById(R.id.tousCvsBt);
        listeCvsSpe = (Button) findViewById(R.id.listeCvsSpeBt);

        // Gestion de l'évènement associé au bouton de lister tous les cvs.
        tousCvsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListeCvsActivity.class);
                startActivity(intent);
            }
        });

        // Gestion de l'évènement associé au bouton de lister les cvs par specialite.
        listeCvsSpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SpecialiteActivity.class);
                startActivity(intent);
            }
        });

    }
}