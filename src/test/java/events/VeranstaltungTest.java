package events;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class VeranstaltungTest
{
    @Test
    void gesamtpreisSeminar()
    {
        Veranstaltung s = new Seminar("Java", 20, 100.00);
        assertEquals(2000.0, s.gesamtpreis());
    }
    @Test
    void gesamtpreisKonzertMitZuschlag()
    {
        Veranstaltung k = new Konzert("Rock", 100, 50.00, "Band");
        assertEquals(6000.0, k.gesamtpreis());

    }
    @Test
    void ausverkauftBeiNullPlaetzen()
    {
        Veranstaltung leer = new Seminar("Leer", 0, 50.00);
        assertTrue(leer.istAusverkauft());
    }
    @Test
    void nichtAusverkauftBeiPlaetzen()
    {
        Veranstaltung s = new Seminar("Voll da", 20, 50.00);
        assertFalse(s.istAusverkauft());
    }
    @Test
    void gueltigePlaetzeWerdenGespeichert()
    {
        Veranstaltung s = new Seminar("Test", 50, 10.00);
        assertEquals(50, s.getPlaetze());
    }
    @Test
    void negativePlaetzeWerfenException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Seminar("Test", -5, 10.00);

        });
    }
    @Test
    void grenzwertMinusEinsWirftException()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Seminar("Test", -1, 10.00);
        });
    }

    @Test
    void grenzwertNullIstErlaubt()
    {
        Veranstaltung s = new Seminar("Test", 0, 10.00);
        assertEquals(0, s.getPlaetze());

    }

    @Test
    void grenzwertEinsIstErlaubt()
    {
        Veranstaltung s = new Seminar("Test", 1, 10.00);
        assertEquals(1, s.getPlaetze());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 51, 1000})
    void gueltigePlaetzeWerdenGespeichert(int plaetze)
    {
        Veranstaltung s = new Seminar("Test", plaetze, 10.00);
        assertEquals(plaetze, s.getPlaetze());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100})
    void ungueltigePlaetzeWerfenException(int plaetze)
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            new Seminar("Test", plaetze, 10.00);
        });
    }

    @Test
    void typKonzert()
    {
        Veranstaltung k = new Konzert("Rock", 10, 50.00, "Band");
        assertEquals("Konzert", k.getTyp());
    }
    @Test
    void typSeminar()
    {
        Seminar x = new Seminar("Python", 20,36.99);
        assertEquals("Seminar", x.getTyp());
    }

    @Test
    void gesamtsummeUeberMehrereVeranstaltungen()
    {
        ArrayList<Veranstaltung> liste =new ArrayList<Veranstaltung>();
        liste.add(new Seminar("Java", 20, 100.00));
        liste.add(new Konzert("Rock", 100, 50.00, "Band"));

        double summe = 0;
        for (Veranstaltung v : liste)
        {
            summe = summe + v.gesamtpreis();
        }

        assertEquals(8000.0, summe);
    }

}

//Das hier ist ein Test

