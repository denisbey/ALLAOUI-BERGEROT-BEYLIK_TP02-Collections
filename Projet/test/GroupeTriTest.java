import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupeTriTest {

    private Formation formation;
    private Groupe groupe;

    private Etudiant etudiant1;
    private Etudiant etudiant2;
    private Etudiant etudiant3;

    @BeforeEach
    public void setUp() {

        formation = new Formation("BUT2");

        Identite identite1 =
                new Identite("1", "Zola", "Emile");

        Identite identite2 =
                new Identite("2", "Beylik", "Denis");

        Identite identite3 =
                new Identite("3", "Martin", "Lucas");

        etudiant1 = new Etudiant(identite1, formation);
        etudiant2 = new Etudiant(identite2, formation);
        etudiant3 = new Etudiant(identite3, formation);

        groupe = new Groupe(formation);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant3);
    }

    @Test
    public void testTriAlpha() {

        groupe.triAlpha();

        assertEquals("Beylik",
                groupe.getEtudiants().get(0)
                        .getIdentite().getNom());

        assertEquals("Martin",
                groupe.getEtudiants().get(1)
                        .getIdentite().getNom());

        assertEquals("Zola",
                groupe.getEtudiants().get(2)
                        .getIdentite().getNom());
    }

    @Test
    public void testTriAntiAlpha() {

        groupe.triAntiAlpha();

        assertEquals("Zola",
                groupe.getEtudiants().get(0)
                        .getIdentite().getNom());

        assertEquals("Martin",
                groupe.getEtudiants().get(1)
                        .getIdentite().getNom());

        assertEquals("Beylik",
                groupe.getEtudiants().get(2)
                        .getIdentite().getNom());
    }
}