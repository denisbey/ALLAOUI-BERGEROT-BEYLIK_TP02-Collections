import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EtudiantTest {

    private Formation formation;
    private Identite identite;
    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        formation = new Formation("BUT2");

        formation.ajouterMatiere("Java", 2.0);
        formation.ajouterMatiere("Maths", 1.0);

        identite = new Identite("123", "Beylik", "Denis");

        etudiant = new Etudiant(identite, formation);
    }

    @Test
    public void testAjouterNoteValide() {
        boolean resultat = etudiant.ajouterNote("Java", 15);

        assertTrue(resultat);
    }

    @Test
    public void testAjouterNoteTropPetite() {
        boolean resultat = etudiant.ajouterNote("Java", -1);

        assertFalse(resultat);
    }

    @Test
    public void testAjouterNoteTropGrande() {
        boolean resultat = etudiant.ajouterNote("Java", 21);

        assertFalse(resultat);
    }

    @Test
    public void testAjouterNoteMatiereInexistante() {
        boolean resultat = etudiant.ajouterNote("Reseau", 15);

        assertFalse(resultat);
    }

    @Test
    public void testMoyenneMatiere() {
        etudiant.ajouterNote("Java", 12);
        etudiant.ajouterNote("Java", 16);

        double moyenne = etudiant.moyenneMatiere("Java");

        assertEquals(14.0, moyenne, 0.001);
    }

    @Test
    public void testMoyenneMatiereSansNote() {
        double moyenne = etudiant.moyenneMatiere("Java");

        assertEquals(0.0, moyenne, 0.001);
    }

    @Test
    public void testMoyenneMatiereInexistante() {
        double moyenne = etudiant.moyenneMatiere("Reseau");

        assertEquals(-1.0, moyenne, 0.001);
    }

    @Test
    public void testMoyenneGenerale() {
        etudiant.ajouterNote("Java", 12);
        etudiant.ajouterNote("Java", 16);

        etudiant.ajouterNote("Maths", 10);

        double moyenne = etudiant.moyenneGenerale();

        assertEquals(38.0 / 3.0, moyenne, 0.001);
    }

    @Test
    public void testMoyenneGeneraleSansNote() {
        double moyenne = etudiant.moyenneGenerale();

        assertEquals(0.0, moyenne, 0.001);
    }

    @Test
    public void testGetIdentite() {
        assertEquals(identite, etudiant.getIdentite());
    }

    @Test
    public void testGetFormation() {
        assertEquals(formation, etudiant.getFormation());
    }
}