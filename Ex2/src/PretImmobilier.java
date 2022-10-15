public class PretImmobilier implements PretImmobilierInterface{
    final float salary;


    public PretImmobilier(float salary)
    {
        this.salary = salary;
    }
    public String MontantMax() {

        return("Le Montant Maximum du prêt immobilier sur 5 ans est : "+0.3*salary*60+
                "\n-------------"+
                "\nLe Montant Maximum du prêt immobilier sur 7 ans est : "+0.3*salary*84+
                "\n-------------"+
                "\nLe Montant Maximum du prêt immobilier sur 10 ans est : "+0.3*salary*120+
                "\n-------------"+
                "\nLe Montant mensuel remboursé pour ce prêt  est :"+0.4*salary*1.33+"\n"
        );
    }
}
