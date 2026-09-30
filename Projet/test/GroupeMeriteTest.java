import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupeMeriteTest {

    private Formation formation;
    private Groupe groupe;

    private Etudiant etudiant1;
    private Etudiant etudiant2;
    private Etudiant etudiant3;

    @BeforeEach
    public void setUp() {

        formation = new Formation("BUT2");

        formation.ajouterMatiere("Java", 1.0);
        formation.ajouterMatiere("Maths", 1.0);

        Identite identite1 =
                new Identite("1", "Beylik", "Denis");

        Identite identite2 =
                new Identite("2", "Martin", "Lucas");

        Identite identite3 =
                new Identite("3", "Zola", "Emile");

        etudiant1 = new Etudiant(identite1, formation);
        etudiant2 = new Etudiant(identite2, formation);
        etudiant3 = new Etudiant(identite3, formation);

        // Etudiant 1 : moyenne = 10
        etudiant1.ajouterNote("Java", 10);
        etudiant1.ajouterNote("Maths", 10);

        // Etudiant 2 : moyenne = 15
        etudiant2.ajouterNote("Java", 15);
        etudiant2.ajouterNote("Maths", 15);

        // Etudiant 3 : moyenne = 12
        etudiant3.ajouterNote("Java", 12);
        etudiant3.ajouterNote("Maths", 12);

        groupe = new Groupe(formation);

        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
        groupe.ajouterEtudiant(etudiant3);
    }

    @Test
    public void testTriParMerite() {

        groupe.triParMerite();

        assertEquals(
                "Martin",
                groupe.getEtudiants().get(0)
                        .getIdentite().getNom()
        );

        assertEquals(
                "Zola",
                groupe.getEtudiants().get(1)
                        .getIdentite().getNom()
        );

        assertEquals(
                "Beylik",
                groupe.getEtudiants().get(2)
                        .getIdentite().getNom()
        );
    }
}