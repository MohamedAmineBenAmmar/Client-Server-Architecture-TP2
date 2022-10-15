public class PretAuto implements PretAutoInterface {
    final float salary;

    public PretAuto(float salary)
    {
        this.salary = salary;
    }
    public String MontantMax() {

        return("Le Montant Maximum du prêt auto sur 3 ans est : "+0.4*salary*36+
                "\n-------------"+
                "\nLe Montant Maximum du prêt auto sur 5 ans est : "+0.4*salary*60+
                "\n-------------"+
                "\nLe Montant mensuel remboursé pour ce prêt  est :"+0.4*salary*1.3+"\n"
        );
    }
}
