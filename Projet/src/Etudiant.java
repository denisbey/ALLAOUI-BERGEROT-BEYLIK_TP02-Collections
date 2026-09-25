import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiant {
    private Identite identite;
    private Formation formation;
    private Map<String, List<Double>> resultats;

    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.resultats = new HashMap<String, List<Double>>();
    }

    public Identite getIdentite() {
        return this.identite;
    }

    public Formation getFormation() {
        return this.formation;
    }

    public boolean ajouterNote(String matiere, double note) {
        if (note < 0 || note > 20) {
            return false;
        }

        if (!this.formation.contientMatiere(matiere)) {
            return false;
        }

        if (!this.resultats.containsKey(matiere)) {
            this.resultats.put(matiere, new ArrayList<Double>());
        }

        this.resultats.get(matiere).add(note);
        return true;
    }

    public double moyenneMatiere(String matiere) {
        if (!this.formation.contientMatiere(matiere)) {
            return -1;
        }

        if (!this.resultats.containsKey(matiere) || this.resultats.get(matiere).isEmpty()) {
            return 0;
        }

        double somme = 0;
        List<Double> notes = this.resultats.get(matiere);

        for (Double note : notes) {
            somme += note;
        }

        return somme / notes.size();
    }

    public double moyenneGenerale() {
        double somme = 0;
        double sommeCoefficients = 0;

        for (String matiere : this.formation.getMatieres()) {
            if (this.resultats.containsKey(matiere) && !this.resultats.get(matiere).isEmpty()) {
                double moyenne = this.moyenneMatiere(matiere);
                double coefficient = this.formation.getCoefficient(matiere);

                somme += moyenne * coefficient;
                sommeCoefficients += coefficient;
            }
        }

        if (sommeCoefficients == 0) {
            return 0;
        }

        return somme / sommeCoefficients;
    }

    @Override
    public String toString() {
        return this.identite.toString();
    }
}
