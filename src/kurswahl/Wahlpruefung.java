package kurswahl;

import kurswahl.models.Kurs;

public class Wahlpruefung {

    private boolean einLKHFoNW; //ein LK ist ein Hauptfach oder eine Naturwissenschaft;
    private boolean zweiLKgewaehlt; //es wurden zwei LKs gewaehlt
    private boolean drittesPFgewaehlt; //ein Kurs wurde als 3. PF ausgewaehlt
    private boolean viertesPFgewaehlt; //ein Kurs wurde als 4. PF ausgewaehlt

    private boolean fuenftesPFgewaehlt; //ein Kurs wurde als 5. PF ausgewaehlt
    private boolean zweiPFHP; //zwei der Pruefungsfaecher sind Hauptfaecher
    private boolean AFvertreterInPF; //alle drei Aufgabenfelder sind vertreten unter den PF
    private boolean einPFCheck; //ein PF ist MU, KU, DS oder SP

    private boolean vierMalFS; //es sind 4 Semester lang eine FS belegt
    private boolean vierMalNW; ///es sind 4 Semester lang eine NW belegt
    private boolean vierMal2AF; ///es ist 4 Semester lang ein Fach des 2. AF belegt
    private boolean zweiRichtigeNW; //es sind min. 2 Semester PH oder CH belegt

    private boolean SechsMal2AF; //es sind 6 Semester des 2. Aufgabenfeldes belegt
    private boolean GEistPFCheck; //wenn GE ein PF ist, sind das 3. und 4. Semester PW belegt oder 4 Semester eines anderen Faches des 2. AF
    private boolean SPals4o5PK; //sind 2 Semester SP-T belegt, wenn SP-P als 4. oder 5. PF gewaehlt wurden
    private boolean zweiSemKuenstFaecher; //sind 2 Semester eines kuenstlerischen Faches (MU,KU,DS) belegt

    private boolean zweiSemBelegung; //sind alle Kurse im Paket von 2 Semestern belegt
    private boolean vierzigKurseBelegt; //sind insgesamt vierzig Kurse belegt worden
    private boolean ASchieneEinLK; //ist ein LK aus der A-Schiene gewaehlt worden (De, Eng, Fr, Ku, (Pw), Ma, Bi)
    private boolean BSchieneEinLK; //ist ein LK aus der B-Schiene gewaehlt worden (En, Ku, Mu, Ge, Pw, (Ma), Bi, Ch, Ph, Inf)

    private boolean SpracheAbBeginn; //sind die gewaehlten Sprachen nicht nur in der 12. Kl. gewaehlt worden
    private boolean kuenstWerkMitKULK; //ist der LK KU gewaehlt worden, wenn die kuenstlerischen Werkstaetten belegt wurden
    private boolean DSmin4Sem; //ist DS 0 oder 4 Semester lang gewaehlt worden

    private Kurs[] kursListe;

    /**
     * Konstruktor der Klasse Wahlpruefung
     */
    public Wahlpruefung()
    {
        kursListe = new Kurs[26];
        kurseInstanziieren();
    }

    /**
     * Instanziiert die Kurse und fügt sie in die Liste der Kurse in korrekter Reihenfolge ein.
     */
    private void kurseInstanziieren()
    {
        kursListe[0] = new Kurs("Deutsch", 1, 0, true, true, true, true, 4, 0, 4, true);
        kursListe[1] = new Kurs("Englisch", 1, 2, false, false, false, false, 0, 0, 0, true);
        kursListe[2] = new Kurs("Französisch", 1, 2, false, false, false, false, 0, 0, 0, true);
        kursListe[3] = new Kurs("Latein", 1, 2, false, false, false, false, 0, 0, 0, false);
        kursListe[4] = new Kurs("Musik", 1, 3, false, false, false, false, 0, 0, 0, false);
        kursListe[5] = new Kurs("Bildende Kunst", 1, 3, false, false, false, false, 0, 0, 0, false);
        kursListe[6] = new Kurs("Darstellendes Spiel", 1, 3, false, false, false, false, 0, 0, 0, false);
        kursListe[7] = new Kurs("Seminarkurs Debating", 1, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[8] = new Kurs("ZK Cambridge-Prüfungen", 1, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[9] = new Kurs("ZK Künstlerische Werkstätte", 1, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[10] = new Kurs("Ensemblekurs Bläser", 1, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[11] = new Kurs("Ensemblekurs Chor", 1, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[12] = new Kurs("Ensemblekurs Orchester", 1, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[13] = new Kurs("Politikwissenschaften", 2, 0, false, false, false, false, 0, 0, 0, false);
        kursListe[14] = new Kurs("Geschichte", 2, 0, false, false, true, true, 2, 0, 2, false);
        kursListe[15] = new Kurs("Geographie", 2, 0, false, false, false, false, 0, 0, 0, false);
        kursListe[16] = new Kurs("Philosophie", 2, 0, false, false, false, false, 0, 0, 0, false);
        kursListe[17] = new Kurs("ZK Political Science", 2, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[18] = new Kurs("ZK Studium und Beruf", 2, 4, false, false, false, false, 0, 0, 0, false);
        kursListe[19] = new Kurs("Mathematik", 3, 0, true, true, true, true, 4, 0, 4, true);
        kursListe[20] = new Kurs("Physik", 3, 1, false, false, false, false, 0, 0, 0, false);
        kursListe[21] = new Kurs("Chemie", 3, 1, false, false, false, false, 0, 0, 0, false);
        kursListe[22] = new Kurs("Biologie", 3, 1, false, false, false, false, 0, 0, 0, false);
        kursListe[23] = new Kurs("Informatik", 3, 0, false, false, false, false, 0, 0, 0, false);
        kursListe[24] = new Kurs("Sport Praxiskurs", 0, 0, true, true, true, true, 4, 0, 4, false);
        kursListe[25] = new Kurs("Sporttheorie", 0, 0, false, false, false, false, 0, 0, 0, false);

    }

    public Kurs[] getKursListe()
    {
        return kursListe;
    }

    public Kurs getKursListeElement(int index){ return kursListe[index]; }

    /**
     * Es werden alle Kriterien (Attribute) überprüft, ob sie als erfüllt gespeichert sind (=true).
     * @return sind alle Kriterien als erfüllt gespeichert
     */
    public boolean alleAttributeTrue()
    {
        boolean attributeTrue = true;

        if(einLKHFoNW == false || zweiLKgewaehlt == false || drittesPFgewaehlt == false || viertesPFgewaehlt == false){attributeTrue = false;}

        if(fuenftesPFgewaehlt == false || zweiPFHP == false || AFvertreterInPF == false || einPFCheck == false){attributeTrue = false;}

        if(vierMalFS == false || vierMalNW == false || vierMal2AF == false || zweiRichtigeNW == false){attributeTrue = false;}

        if(SechsMal2AF == false || GEistPFCheck == false || SPals4o5PK == false || zweiSemKuenstFaecher == false){attributeTrue = false;}

        if(zweiSemBelegung == false || vierzigKurseBelegt == false || ASchieneEinLK == false || BSchieneEinLK == false){attributeTrue = false;}

        if(SpracheAbBeginn == false || kuenstWerkMitKULK == false || DSmin4Sem == false){attributeTrue = false;}

        return attributeTrue;
    }

    public void kriterienUeberpruefen()
    {
        meinLKHFoNW();
        mzweiLKgewaehlt();
        mdrittesPFgewaehlt();
        mviertesPFgewaehlt();
        mfuenftesPFgewaehlt();
        mzweiPFHP();
        mAFvertreterInPF();
        meinPFCheck();
        mvierMalFS();
        mvierMalNW();
        mvierMal2AF();
        mvierMal2AF();
        mzweiRichtigeNW();
        mSechsMal2AF();
        mGEistPFCheck();
        mSPals4o5PK();
        mzweiSemKuenstFaecher();
        mzweiSemBelegung();
        mvierzigKurseBelegt();
        mASchieneEinLK();
        mBSchieneEinLK();
        mSpracheAbBeginn();
        mkuenstWerkMitKULK();
        mDSmin4Sem();
    }


    /**
     * Das Kriterium einLKHFoNW wird überprüft und entsprechend aktualisiert
     */
    private void meinLKHFoNW()
    {
        einLKHFoNW = false;
        if (getKursListeElement(0).getPruefungsfach() == 2) {einLKHFoNW = true;} //Deutsch
        if (getKursListeElement(1).getPruefungsfach() == 2) {einLKHFoNW = true;} //Englisch
        if (getKursListeElement(2).getPruefungsfach() == 2) {einLKHFoNW = true;} //Französisch
        if (getKursListeElement(19).getPruefungsfach() == 2) {einLKHFoNW = true;} //Mathematik

        if (getKursListeElement(20).getPruefungsfach() == 2) {einLKHFoNW = true;} //Physik
        if (getKursListeElement(21).getPruefungsfach() == 2) {einLKHFoNW = true;} //Chemie
        if (getKursListeElement(22).getPruefungsfach() == 2) {einLKHFoNW = true;} //Biologie
    }

    private void mzweiLKgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 2) { zaehler++; }
        }
        zweiLKgewaehlt = zaehler == 2;
    }

    private void mdrittesPFgewaehlt()
    {
        drittesPFgewaehlt = false; // so könnten auch mehrere 3. PF gewählt sein... stimmt
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 3) { drittesPFgewaehlt = true;}
        }

    }

    private void mviertesPFgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 4) { zaehler++; }
        }
        viertesPFgewaehlt = zaehler == 1;
    }

    private void mfuenftesPFgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 5) { zaehler++; }
        }
        fuenftesPFgewaehlt = zaehler == 1;
    }

    private void mzweiPFHP()
    {
        int zaehler = 0;
        int deMa = 0;
        for (int i = 0; i < 26; i++)
        {
            if  ((getKursListeElement(i).getPruefungsfach() > 1) && (getKursListeElement(i).getPruefungsfach() < 5) && (getKursListeElement(i).getHauptfach()))
            {
                zaehler++;
                if(getKursListeElement(i).getName()=="Deutsch" || getKursListeElement(i).getName()=="Mathematik")
                {
                    deMa++;
                }
            }
        }
        if(deMa>0)
        {
            fuenftesPFgewaehlt = (deMa>0) && (zaehler >= 2);
        }
        )
    }

    private void mAFvertreterInPF()
    {

    }

    private void meinPFCheck()
    {

    }

    private void mvierMalFS()
    {

    }

    private void mvierMalNW()
    {

    }

    private void mvierMal2AF()
    {

    }

    private void mzweiRichtigeNW()
    {

    }

    private void mSechsMal2AF()
    {

    }

    private void mGEistPFCheck()
    {

    }

    private void mSPals4o5PK()
    {

    }

    private void mzweiSemKuenstFaecher()
    {

    }

    private void mzweiSemBelegung()
    {

    }

    private void mvierzigKurseBelegt()
    {

    }

    private void mASchieneEinLK()
    {

    }

    private void mBSchieneEinLK()
    {

    }

    private void mSpracheAbBeginn()
    {

    }

    private void mkuenstWerkMitKULK()
    {

    }

    private void mDSmin4Sem()
    {
        if (getKursListeElement(6).getQ1() == true) {einLKHFoNW = true;}
    }

}
