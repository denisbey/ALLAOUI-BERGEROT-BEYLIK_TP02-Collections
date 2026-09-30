import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Groupe {
    private Formation formation;
    private List<Etudiant> etudiants;

    public Groupe(Formation formation) {
        this.formation = formation;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public Formation getFormation() {
        return this.formation;
    }

    public List<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public boolean ajouterEtudiant(Etudiant etudiant) {
        if (!this.formation.getIdentifiant().equals(etudiant.getFormation().getIdentifiant())) {
            return false;
        }

        this.etudiants.add(etudiant);
        return true;
    }

    public boolean supprimerEtudiant(Etudiant etudiant) {
        return this.etudiants.remove(etudiant);
    }

    public double moyenneMatiere(String matiere) {
        if (!this.formation.contientMatiere(matiere)) {
            return -1;
        }

        if (this.etudiants.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (Etudiant etudiant : this.etudiants) {
            somme += etudiant.moyenneMatiere(matiere);
        }

        return somme / this.etudiants.size();
    }

    public double moyenneGenerale() {
        if (this.etudiants.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (Etudiant etudiant : this.etudiants) {
            somme += etudiant.moyenneGenerale();
        }

        return somme / this.etudiants.size();
    }
}