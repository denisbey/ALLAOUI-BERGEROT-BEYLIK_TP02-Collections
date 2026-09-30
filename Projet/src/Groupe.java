import java.util.ArrayList;
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

        if (!this.formation.getIdentifiant()
                .equals(etudiant.getFormation().getIdentifiant())) {
            return false;
        }

        this.etudiants.add(etudiant);
        return true;
    }

    public boolean supprimerEtudiant(Etudiant etudiant) {
        return this.etudiants.remove(etudiant);
    }
}