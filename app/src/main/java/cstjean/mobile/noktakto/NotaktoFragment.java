package cstjean.mobile.noktakto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

/**
 * Classe fragement notakto.
 */
public class NotaktoFragment extends Fragment {
    /**
     * Singleton notakto.
     */
    private final SingletonNotako notakto = SingletonNotako.getInstance();
    /**
     * Liste de boutons.
     */
    private final Button[] boutons = new Button[9];

    /**
     * Bouton pour reset la partie.
     */
    private TextView texteJoueur;
    /**
     * Texte pour afficher le perdant.
     */
    private TextView textePerdant;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notakto_fragement, container, false);

        LinearLayout linearLayout1 = view.findViewById(R.id.layout_linear1);
        LinearLayout linearLayout2 = view.findViewById(R.id.layout_linear2);
        LinearLayout linearLayout3 = view.findViewById(R.id.layout_linear3);

        View.OnClickListener boutonClique = view1 -> {
            Button bouton = (Button) view1;
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
                for (Button boutonFor : boutons) {
                    boutonFor.setEnabled(false);
                }
                textePerdant.setText("Le joueur perdant est " + joueurPresent);
            }
        };

        for (int i = 0; i < 9; i++) {
            Button bouton = new Button(view.getContext());
            bouton.setTag(i);
            if (notakto.getEstCoche(i)) {
                bouton.setText("x");
                bouton.setEnabled(false);
            }
            if (i < 3) {
                linearLayout1.addView(bouton);
            } else if (i < 6) {
                linearLayout2.addView(bouton);
            } else {
                linearLayout3.addView(bouton);
            }
            bouton.setOnClickListener(boutonClique);
            boutons[i] = bouton;
        }

        final Button boutonReset = view.findViewById(R.id.btnReset);
        texteJoueur = view.findViewById(R.id.text_player);
        textePerdant = view.findViewById(R.id.text_perdant);

        boutonReset.setOnClickListener(view2 -> {
            for (Button boutonFor : boutons) {
                boutonFor.setEnabled(true);
                boutonFor.setText("");
            }

            notakto.initialiser();

            texteJoueur.setText("Joueur 1");

            textePerdant.setText("");
        });

        return view;
    }
}