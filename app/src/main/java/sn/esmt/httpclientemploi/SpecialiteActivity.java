package sn.esmt.httpclientemploi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
/*Cette activity liée au layout activity_specialite gère la redirection vers la liste
* des cvs selon les specialités.
* Il définit 4 boutons. Chaque bouton appuyé redirigera vers la liste des cvs de la
* spécialité.*/
public class SpecialiteActivity extends AppCompatActivity {
    private Button speMaths;
    private Button speInfo;
    private Button speMana;
    private Button speTel;
    public static String choixSpecialite;

    public static void setChoixSpecialite(String choixSpecialite) {
        SpecialiteActivity.choixSpecialite = choixSpecialite;
    }
    public static String getChoixSpecialite() {
        return choixSpecialite;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialite);

        speMaths = (Button) findViewById(R.id.speMathsBt);
        speInfo = (Button) findViewById(R.id.speInfoBt);
        speMana = (Button) findViewById(R.id.speManageBt);
        speTel = (Button) findViewById(R.id.speTelecomBt);

        speMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecialiteActivity.setChoixSpecialite("Maths");
                Intent intent = new Intent(SpecialiteActivity.this, ListeCvsSpecialiteActivity.class);
                startActivity(intent);
            }
        });

        speInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecialiteActivity.setChoixSpecialite("Informatique");
                Intent intent = new Intent(SpecialiteActivity.this, ListeCvsSpecialiteActivity.class);
                startActivity(intent);
            }
        });

        speMana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecialiteActivity.setChoixSpecialite("Management");
                Intent intent = new Intent(SpecialiteActivity.this, ListeCvsSpecialiteActivity.class);
                startActivity(intent);
            }
        });

        speTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpecialiteActivity.setChoixSpecialite("Telecom");
                Intent intent = new Intent(SpecialiteActivity.this, ListeCvsSpecialiteActivity.class);
                startActivity(intent);
            }
        });

    }
}