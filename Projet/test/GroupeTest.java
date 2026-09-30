import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupeTest {

    private Formation formation;
    private Formation autreFormation;

    private Groupe groupe;

    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @BeforeEach
    public void setUp() {

        formation = new Formation("BUT2");
        autreFormation = new Formation("BUT1");

        Identite identite1 =
                new Identite("123", "Beylik", "Denis");

        Identite identite2 =
                new Identite("456", "Dupont", "Lucas");

        etudiant1 = new Etudiant(identite1, formation);
        etudiant2 = new Etudiant(identite2, autreFormation);

        groupe = new Groupe(formation);
    }

    @Test
    public void testAjouterEtudiantMemeFormation() {

        boolean resultat = groupe.ajouterEtudiant(etudiant1);

        assertTrue(resultat);
        assertEquals(1, groupe.getEtudiants().size());
    }

    @Test
    public void testAjouterEtudiantAutreFormation() {

        boolean resultat = groupe.ajouterEtudiant(etudiant2);

        assertFalse(resultat);
        assertEquals(0, groupe.getEtudiants().size());
    }

    @Test
    public void testSupprimerEtudiant() {

        groupe.ajouterEtudiant(etudiant1);

        boolean resultat =
                groupe.supprimerEtudiant(etudiant1);

        assertTrue(resultat);
        assertEquals(0, groupe.getEtudiants().size());
    }

    @Test
    public void testSupprimerEtudiantAbsent() {

        boolean resultat =
                groupe.supprimerEtudiant(etudiant1);

        assertFalse(resultat);
    }
}