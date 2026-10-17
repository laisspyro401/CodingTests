package events;

public class Konzert extends Veranstaltung{
    private String band;

    public Konzert(String titel, int plaetze, double preisProPlatz, String band)
    {
        super(titel, plaetze, preisProPlatz);
        this.band = band;
    }

    public String getTyp()
    {
        return "Konzert";
    }

    @Override
    public double getGesamtpreis()
    {
        return super.getGesamtpreis() * 1.2;
    }
    @Override
    public void infoZeigen()
    {
        super.infoZeigen();
        System.out.println(" Band: " + band);
    }
}
