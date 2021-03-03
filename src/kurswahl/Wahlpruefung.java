package kurswahl;

import kurswahl.models.Kurs;

public class Wahlpruefung {

    private boolean einLKHFoNW; //ein LK ist ein Hauptfach oder eine Naturwissenschaft;
    private boolean zweiLKgewaehlt; //es wurden zwei LKs gewaehlt
    private boolean drittesPFgewaehlt; //ein Kurs wurde als 3. PF ausgewaehlt
    private boolean viertesPFgewaehlt; //ein Kurs wurde als 4. PF ausgewaehlt

    private boolean fuenftesPFgewaehlt; //ein Kurs wurde als 5. PF ausgewaehlt
    private boolean zweiPFHP; //zwei der Pruefungsfaecher sind Hauptfaecher
    private boolean aFvertreterInPF; //alle drei Aufgabenfelder sind vertreten unter den PF
    private boolean einPFCheck; //hoechstens ein PF ist MU, KU, DS oder SP

    private boolean vierMalFS; //es sind 4 Semester lang eine FS belegt
    private boolean vierMalNW; //es sind 4 Semester lang eine NW belegt
    private boolean vierMal2AF; //es ist 4 Semester lang ein Fach des 2. AF belegt
    private boolean zweiRichtigeNW; //es sind min. 2 Semester PH oder CH belegt

    private boolean sechsMal2AF; //es sind 6 Semester des 2. Aufgabenfeldes belegt
    private boolean gEistPFCheck; //wenn GE ein PF ist, sind das 3. und 4. Semester PW belegt oder 4 Semester eines anderen Faches des 2. AF
    private boolean sPals4o5PK; //sind 2 Semester SP-T belegt, wenn SP-P als 4. oder 5. PF gewaehlt wurden
    private boolean zweiSemKuenstFaecher; //sind 2 Semester eines kuenstlerischen Faches (MU,KU,DS) belegt

    private boolean zweiSemBelegung; //sind alle Kurse im Paket von 2 Semestern belegt
    private boolean vierzigKurseBelegt; //sind insgesamt vierzig Kurse belegt worden
    private boolean aSchieneEinLK; //ist ein LK aus der A-Schiene gewaehlt worden (De, Eng, Fr, Ku, (Pw), Ma, Bi)
    private boolean bSchieneEinLK; //ist ein LK aus der B-Schiene gewaehlt worden (En, Ku, Mu, Ge, Pw, (Ma), Bi, Ch, Ph, Inf)

    private boolean spracheAbBeginn; //sind die gewaehlten Sprachen nicht nur in der 12. Kl. gewaehlt worden
    private boolean kuenstWerkMitKULK; //ist der LK KU gewaehlt worden, wenn die kuenstlerischen Werkstaetten belegt wurden
    private boolean dSmin4Sem; //ist DS 0 oder 4 Semester lang gewaehlt worden

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

        if(!einLKHFoNW || !zweiLKgewaehlt || !drittesPFgewaehlt || !viertesPFgewaehlt){attributeTrue = false;}

        if(!fuenftesPFgewaehlt || !zweiPFHP || !aFvertreterInPF || !einPFCheck){attributeTrue = false;}

        if(!vierMalFS || !vierMalNW || !vierMal2AF || !zweiRichtigeNW){attributeTrue = false;}

        if(!sechsMal2AF || !gEistPFCheck || !sPals4o5PK || !zweiSemKuenstFaecher){attributeTrue = false;}

        if(!zweiSemBelegung || !vierzigKurseBelegt || !aSchieneEinLK || !bSchieneEinLK){attributeTrue = false;}

        if(!spracheAbBeginn || !kuenstWerkMitKULK || !dSmin4Sem){attributeTrue = false;}

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
        maFvertreterInPF();
        meinPFCheck();
        mvierMalFS();
        mvierMalNW();
        mvierMal2AF();
        mvierMal2AF();
        mzweiRichtigeNW();
        msechsMal2AF();
        mgEistPFCheck();
        msPals4o5PK();
        mzweiSemKuenstFaecher();
        mzweiSemBelegung();
        mvierzigKurseBelegt();
        maSchieneEinLK();
        mbSchieneEinLK();
        mspracheAbBeginn();
        mkuenstWerkMitKULK();
        mdSmin4Sem();
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

    /**
     * Das Kriterium zweiLKgewaehlt wird überprüft und entsprechend aktualisiert
     */
    private void mzweiLKgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 2) { zaehler++; }
        }
        zweiLKgewaehlt = zaehler == 2;
    }

    /**
     * Das Kriterium drittesPFgewaehlt wird überprüft und entsprechend aktualisiert
     */
    private void mdrittesPFgewaehlt()
    {
        drittesPFgewaehlt = false; // so könnten auch mehrere 3. PF gewählt sein... stimmt
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 3) { drittesPFgewaehlt = true;}
        }
    }

    /**
     * Das Kriterium viertesPFgewaehlt wird überprüft und entsprechend aktualisiert
     */
    private void mviertesPFgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 4) { zaehler++; }
        }
        viertesPFgewaehlt = zaehler == 1;
    }

    /**
     * Das Kriterium fuenftesPFgewaehlt wird überprüft und entsprechend aktualisiert
     */
    private void mfuenftesPFgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 5) { zaehler++; }
        }
        fuenftesPFgewaehlt = zaehler == 1;
    }

    /**
     * Das Kriterium zweiPFHP wird überprüft und entsprechend aktualisiert
     */
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
        fuenftesPFgewaehlt = (deMa>0) && (zaehler >= 2);
    }

    /**
     * Das Kriterium aFvertreterInPF wird überprüft und entsprechend aktualisiert
     */
    private void maFvertreterInPF()
    {
        int af1 = 0;
        int af2 = 0;
        int af3 = 0;
        for (int i = 0; i < 26; i++)
        {
            if  ((getKursListeElement(i).getPruefungsfach() > 1) && (getKursListeElement(i).getAufgabenfeld() == 1)) { af1++; }
            if  ((getKursListeElement(i).getPruefungsfach() > 1) && (getKursListeElement(i).getAufgabenfeld() == 2)) { af2++; }
            if  ((getKursListeElement(i).getPruefungsfach() > 1) && (getKursListeElement(i).getAufgabenfeld() == 3)) { af3++; }
        }
        aFvertreterInPF = (af1>0) && (af2>0) && (af3>0);
    }

    /**
     * Das Kriterium einPFCheck wird überprüft und entsprechend aktualisiert
     */
    private void meinPFCheck()
    {
        int zaehler = 0;
        if (getKursListeElement(4).getPruefungsfach() > 1) { zaehler++;} //Musik
        if (getKursListeElement(5).getPruefungsfach() > 1) { zaehler++;} //Bildende Kunst
        if (getKursListeElement(6).getPruefungsfach() > 1) { zaehler++;} //DS
        if (getKursListeElement(24).getPruefungsfach() > 1) { zaehler++;} //Sport
        einPFCheck = (zaehler <= 1);
    }

    /**
     * Das Kriterium vierMalFS wird überprüft und entsprechend aktualisiert
     */
    private void mvierMalFS() { vierMalFS = getKursListeElement(1).getAnzahlSemester() == 4 || getKursListeElement(2).getAnzahlSemester() == 4 || getKursListeElement(3).getAnzahlSemester() == 4; }

    /**
     * Das Kriterium vierMalNW wird überprüft und entsprechend aktualisiert
     */
    private void mvierMalNW() { vierMalNW = getKursListeElement(20).getAnzahlSemester() == 4 || getKursListeElement(21).getAnzahlSemester() == 4 || getKursListeElement(22).getAnzahlSemester() == 4; }

    /**
     * Das Kriterium vierMal2AF wird überprüft und entsprechend aktualisiert
     */
    private void mvierMal2AF() { vierMal2AF = getKursListeElement(13).getAnzahlSemester() == 4 || getKursListeElement(14).getAnzahlSemester() == 4 || getKursListeElement(15).getAnzahlSemester() == 4 || getKursListeElement(16).getAnzahlSemester() == 4; }

    /**
     * Das Kriterium zweiRichtigeNW wird überprüft und entsprechend aktualisiert
     */
    private void mzweiRichtigeNW() { zweiRichtigeNW = getKursListeElement(20).getAnzahlSemester() >= 2 || getKursListeElement(21).getAnzahlSemester() >= 2; }

    /**
     * Das Kriterium sechsMal2AF wird überprüft und entsprechend aktualisiert
     */
    private void msechsMal2AF()
    {
        int zaehler = 0; //Speicher der belegten Semester im 2. AF
        //durchgehen der Attribute Q1, Q2, Q3 und Q4 aller Fächer des 2. AF, wobei die belegten Semester zusammengerechnet werden:
        for (int i = 13; i < 17; i++)
        {
            if  (getKursListeElement(i).getQ1()) { zaehler++; }
            if  (getKursListeElement(i).getQ2()) { zaehler++; }
            if  (getKursListeElement(i).getQ3()) { zaehler++; }
            if  (getKursListeElement(i).getQ4()) { zaehler++; }
        }
        if (zaehler > 5) { sechsMal2AF = true; } else { sechsMal2AF = false; } //Attribut wird auf true gesetzt, wenn mindesten 6 Semester im 2. AF belegt wurden
    }

    /**
     * Das Kriterium gEistPFCheck wird überprüft und entsprechend aktualisiert
     */
    private void mgEistPFCheck()
    {
        gEistPFCheck = false; //Vorannahme: Kriterium nicht erfüllt; Gegensätzliches wird im folgenden überprüft

        //Fallunterscheidung: Ist GE ein Prüfungsfach?
        if (getKursListeElement(14).getPruefungsfach() != 1)
        {
            //Fallunterscheidung: ist das 3. und 4. Semester PW belegt worden?
            if (getKursListeElement(13).getQ3() && getKursListeElement(13).getQ4())
            {
                gEistPFCheck = true;
            }
            else
            {
                //Prüfung, ob ein anderes Fach des 2. AF belegt ist:
                if (getKursListeElement(15).getAnzahlSemester() == 4 || getKursListeElement(16).getAnzahlSemester() == 4){ gEistPFCheck = true; }
            }
        }
        else
        {
            gEistPFCheck = true;
        }
    }

    /**
     * Das Kriterium sPals4o5PK wird überprüft und entsprechend aktualisiert
     */
    private void msPals4o5PK()
    {

    }

    /**
     * Das Kriterium zweiSemKuenstFaecher wird überprüft und entsprechend aktualisiert
     */
    private void mzweiSemKuenstFaecher()
    {

    }

    /**
     * Das Kriterium zweiSemBelegung wird überprüft und entsprechend aktualisiert
     */
    private void mzweiSemBelegung()
    {

    }

    /**
     * Das Kriterium vierzigKurseBelegt wird überprüft und entsprechend aktualisiert
     */
    private void mvierzigKurseBelegt()
    {

    }

    /**
     * Das Kriterium aSchieneEinLK wird überprüft und entsprechend aktualisiert
     */
    private void maSchieneEinLK()
    {

    }

    /**
     * Das Kriterium bSchieneEinLK wird überprüft und entsprechend aktualisiert
     */
    private void mbSchieneEinLK()
    {
        
    }

    /**
     * Das Kriterium spracheAbBeginn wird überprüft und entsprechend aktualisiert
     */
    private void mspracheAbBeginn()
    {

    }

    /**
     * Das Kriterium kuenstWerkMitKULK wird überprüft und entsprechend aktualisiert
     */
    private void mkuenstWerkMitKULK()
    {
        kuenstWerkMitKULK = false; //Vorannahme: Kriterium nicht erfüllt; Gegensätzliches wird im folgenden überprüft
        //Fallunterscheidung: Ist mindestens ein Semester Künstlerische Werkstätten belegt?
        if (getKursListeElement(9).getAnzahlSemester() > 0)
        {
            //Fallunterscheidung: Ist der KU-LK gewählt worden?
            if (getKursListeElement(5).getPruefungsfach() == 2){kuenstWerkMitKULK = true;}
        }
        else
        {
            kuenstWerkMitKULK = true;
        }
    }

    /**
     * Das Kriterium dSmin4Sem wird überprüft und entsprechend aktualisiert
     */
    private void mdSmin4Sem() { dSmin4Sem = getKursListeElement(6).getAnzahlSemester() == 4 || getKursListeElement(6).getAnzahlSemester() == 0; }

}
