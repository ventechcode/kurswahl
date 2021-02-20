package kurswahl;

public class Funktionalitaet
{
    private Kurs[] kursListe;

    /**
     * Konstruktor der Klasse Funktionalitaet
     */
    public Funktionalitaet()
    {
        kursListe = new Kurs[26];
        kurseInstanziieren();
    }

    /**
     * Instanziiert die Kurse und fügt sie in die Liste der Kurse in korrekter Reihenfolge ein.
     */
    private void kurseInstanziieren()
    {
        kursListe[0] = new Kurs("Deutsch", 1, 0, true, true, true, true, 4, 0, 4);
        kursListe[1] = new Kurs("Englisch", 1, 2, false, false, false, false, 0, 0, 0);
        kursListe[2] = new Kurs("Französisch", 1, 2, false, false, false, false, 0, 0, 0);
        kursListe[3] = new Kurs("Latein", 1, 2, false, false, false, false, 0, 0, 0);
        kursListe[4] = new Kurs("Musik", 1, 3, false, false, false, false, 0, 0, 0);
        kursListe[5] = new Kurs("Bildende Kunst", 1, 3, false, false, false, false, 0, 0, 0);
        kursListe[6] = new Kurs("Darstellendes Spiel", 1, 3, false, false, false, false, 0, 0, 0);
        kursListe[7] = new Kurs("Seminarkurs Debating", 1, 4, false, false, false, false, 0, 0, 0);
        kursListe[8] = new Kurs("ZK Cambridge-Prüfungen", 1, 4, false, false, false, false, 0, 0, 0);
        kursListe[9] = new Kurs("ZK Künstlerische Werkstätte", 1, 4, false, false, false, false, 0, 0, 0);
        kursListe[11] = new Kurs("Ensemblekurs Bläser", 1, 4, false, false, false, false, 0, 0, 0);
        kursListe[12] = new Kurs("Ensemblekurs Chor", 1, 4, true, true, true, true, 4, 0, 4);
        kursListe[13] = new Kurs("Ensemblekurs Orchester", 1, 4, false, false, false, false, 0, 0, 0);
        kursListe[14] = new Kurs("Politikwissenschaften", 2, 2, false, false, false, false, 0, 0, 0);
        kursListe[15] = new Kurs("Geschichte", 2, 0, false, false, true, true, 2, 0, 2);
        kursListe[16] = new Kurs("Geographie", 2, 0, false, false, false, false, 0, 0, 0);
        kursListe[17] = new Kurs("Philosophie", 2, 0, false, false, false, false, 0, 0, 0);
        kursListe[18] = new Kurs("ZK Political Science", 2, 4, false, false, false, false, 0, 0, 0);
        kursListe[19] = new Kurs("ZK Studium und Beruf", 2, 4, false, false, false, false, 0, 0, 0);
        kursListe[20] = new Kurs("Mathematik", 3, 0, true, true, true, true, 4, 0, 4);
        kursListe[21] = new Kurs("Physik", 3, 2, false, false, false, false, 0, 0, 0);
        kursListe[22] = new Kurs("Chemie", 3, 2, false, false, false, false, 0, 0, 0);
        kursListe[23] = new Kurs("Biologie", 3, 2, false, false, false, false, 0, 0, 0);
        kursListe[24] = new Kurs("Sport Praxiskurs", 0, 0, true, true, true, true, 4, 0, 4);
        kursListe[25] = new Kurs("Sporttheorie", 0, 0, false, false, false, false, 0, 0, 0);


    }
}

