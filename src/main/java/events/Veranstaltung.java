package events;

public abstract class Veranstaltung implements Buchbar {
    private String titel;
    private int plaetze;
    private double preisProPlatz;

    public Veranstaltung(String titel, int plaetze, double preisProPlatz)
    {
        this.titel = titel;
        setPlaetze(plaetze);
        this.preisProPlatz = preisProPlatz;
    }

    public void setPlaetze(int plaetze)
    {
        if (plaetze < 0)
        {
            throw new IllegalArgumentException("Wert kann nicht negativ sein! " + plaetze);
        }
        this.plaetze = plaetze;
    }

    public String getTitel()
    {
        return titel;
    }
    public int getPlaetze()
    {
        return plaetze;
    }
    @Override
    public double getGesamtpreis()
    {
        return plaetze * preisProPlatz;
    }
    @Override
    public boolean istAusverkauft()
    {
        return plaetze == 0;
    }
    public abstract String getTyp();

    public void zeigeInfo()
    {

        System.out.println(getTyp() + ": " + titel + " | " + plaetze + " Plaetze | " + preisProPlatz + " EUR");
    }
}
