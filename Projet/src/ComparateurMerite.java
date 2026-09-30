import java.util.Comparator;

public class ComparateurMerite implements Comparator<Etudiant> {

    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        double moyenne1 = e1.moyenneGenerale();
        double moyenne2 = e2.moyenneGenerale();

        if (moyenne1 > moyenne2) {
            return -1;
        }
        if (moyenne1 < moyenne2) {
            return 1;
        }
        return 0;
    }
}
