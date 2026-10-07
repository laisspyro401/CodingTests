package events;

public class Seminar extends Veranstaltung {
    public Seminar(String titel, int plaetze, double preisProPlatz)
    {
        super(titel, plaetze, preisProPlatz);
    }
    public String getTyp()
    {
        return "Seminar";
    }
}
