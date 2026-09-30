import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroupeMoyennesTest {

    private Formation formation;
    private Groupe groupe;

    private Etudiant etudiant1;
    private Etudiant etudiant2;

    @BeforeEach
    public void setUp() {

        formation = new Formation("BUT2");
        formation.ajouterMatiere("Maths", 2);
        formation.ajouterMatiere("Java", 3);

        etudiant1 = new Etudiant(new Identite("123", "Beylik", "Denis"), formation);
        etudiant1.ajouterNote("Maths", 10);
        etudiant1.ajouterNote("Maths", 14);
        etudiant1.ajouterNote("Java", 16); 

        etudiant2 = new Etudiant(new Identite("456", "Dupont", "Lucas"), formation);
        etudiant2.ajouterNote("Maths", 8);    
        etudiant2.ajouterNote("Java", 11);    

        groupe = new Groupe(formation);
        groupe.ajouterEtudiant(etudiant1);
        groupe.ajouterEtudiant(etudiant2);
    }

    @Test
    public void testMoyenneMatiere() {

        assertEquals(10, groupe.moyenneMatiere("Maths"), 0.001); 
        assertEquals(13.5, groupe.moyenneMatiere("Java"), 0.001);
    }

    @Test
    public void testMoyenneMatiereInexistante() {

        assertEquals(-1, groupe.moyenneMatiere("Anglais"), 0.001);
    }

    @Test
    public void testMoyenneMatiereGroupeVide() {

        Groupe groupeVide = new Groupe(formation);

        assertEquals(0, groupeVide.moyenneMatiere("Maths"), 0.001);
    }

    @Test
    public void testMoyenneGenerale() {

        assertEquals(12.1, groupe.moyenneGenerale(), 0.001);
    }

    @Test
    public void testMoyenneGeneraleGroupeVide() {

        Groupe groupeVide = new Groupe(formation);

        assertEquals(0, groupeVide.moyenneGenerale(), 0.001);
    }

    @Test
    public void testMoyenneApresSuppression() {

        groupe.supprimerEtudiant(etudiant2);

        assertEquals(12, groupe.moyenneMatiere("Maths"), 0.001);
        assertEquals(14.4, groupe.moyenneGenerale(), 0.001);
    }
}