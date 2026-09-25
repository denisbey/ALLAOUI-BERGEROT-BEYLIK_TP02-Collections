import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Formation {

    private String id;
    private Map<String, Double> matieres;

    public Formation(String id) {
        this.id = id;
        this.matieres = new HashMap<String, Double>();
    }

    public String getId() {
        return this.id;
    }

    public void ajouterMatiere(String matiere, double coefficient) {
        this.matieres.put(matiere, coefficient);
    }

    public void supprimerMatiere(String matiere) {
        this.matieres.remove(matiere);
    }

    public double getCoefficient(String matiere) {
        if (this.matieres.containsKey(matiere)) {
            return this.matieres.get(matiere);
        }

        return -1;
    }

    public boolean contientMatiere(String matiere) {
        return this.matieres.containsKey(matiere);
    }

    public Set<String> getMatieres() {
        return this.matieres.keySet();
    }
}