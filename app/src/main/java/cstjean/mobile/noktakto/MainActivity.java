package cstjean.mobile.noktakto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Activity: lie la logique .
 */

public class MainActivity extends AppCompatActivity {
    /**
     * Bouton 1.
     */
    private Button bouton0;
    /**
     * Bouton 1.
     */
    private Button bouton1;
    /**
     * Bouton 1.
     */
    private Button bouton2;
    /**
     * Bouton 1.
     */
    private Button bouton3;
    /**
     * Bouton 1.
     */
    private Button bouton4;
    /**
     * Bouton 1.
     */
    private Button bouton5;
    /**
     * Bouton 1.
     */
    private Button bouton6;
    /**
     * Bouton 1.
     */
    private Button bouton7;
    /**
     * Bouton 1.
     */
    private Button bouton8;
    /**
     * Bouton pour reset la partie.
     */
    private TextView texteJoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton0 = findViewById(R.id.btn0);
        bouton1 = findViewById(R.id.btn1);
        bouton2 = findViewById(R.id.btn2);
        bouton3 = findViewById(R.id.btn3);
        bouton4 = findViewById(R.id.btn4);
        bouton5 = findViewById(R.id.btn5);
        bouton6 = findViewById(R.id.btn6);
        bouton7 = findViewById(R.id.btn7);
        bouton8 = findViewById(R.id.btn8);

        final Button boutonReset = findViewById(R.id.btnReset);
        texteJoueur = findViewById(R.id.text_player);
        Notakto notakto = new Notakto();
        View.OnClickListener boutonClique = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button bouton = (Button) view;
                bouton.setText("X");
                String joueurPresent;
                if (notakto.getEstTourJoueurUn()) {
                    joueurPresent = "Joueur 1";
                } else {
                    joueurPresent = "Joueur 2";
                }
                notakto.jouerTour(Integer.parseInt(bouton.getTag().toString()));
                bouton.setEnabled(false);
                if (notakto.getEstTourJoueurUn()) {
                    texteJoueur.setText(R.string.player_one_name);
                } else {
                    texteJoueur.setText(R.string.player_two_name);
                }
                if (notakto.verifierDefaite()) {
                    bouton0.setEnabled(false);
                    bouton1.setEnabled(false);
                    bouton2.setEnabled(false);
                    bouton3.setEnabled(false);
                    bouton4.setEnabled(false);
                    bouton5.setEnabled(false);
                    bouton6.setEnabled(false);
                    bouton7.setEnabled(false);
                    bouton8.setEnabled(false);

                    Toast texteJoueurPerdant = Toast.makeText(getApplicationContext(),
                            "Le joueur perdant est " + joueurPresent, Toast.LENGTH_SHORT);
                    texteJoueurPerdant.show();
                }
            }
        };
        bouton0.setOnClickListener(boutonClique);
        bouton1.setOnClickListener(boutonClique);
        bouton2.setOnClickListener(boutonClique);
        bouton3.setOnClickListener(boutonClique);
        bouton4.setOnClickListener(boutonClique);
        bouton5.setOnClickListener(boutonClique);
        bouton6.setOnClickListener(boutonClique);
        bouton7.setOnClickListener(boutonClique);
        bouton8.setOnClickListener(boutonClique);
        boutonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bouton0.setEnabled(true);
                bouton1.setEnabled(true);
                bouton2.setEnabled(true);
                bouton3.setEnabled(true);
                bouton4.setEnabled(true);
                bouton5.setEnabled(true);
                bouton6.setEnabled(true);
                bouton7.setEnabled(true);
                bouton8.setEnabled(true);

                bouton0.setText("");
                bouton1.setText("");
                bouton2.setText("");
                bouton3.setText("");
                bouton4.setText("");
                bouton5.setText("");
                bouton6.setText("");
                bouton7.setText("");
                bouton8.setText("");

                notakto.initialiser();

                texteJoueur.setText("Joueur 1");
            }
        });
    }
}