package kurswahl;

import kurswahl.models.Kurs;
import kurswahl.models.Schiene;

/**
 * Die Klasse Wahlpruefung repräsentiert die Funktionalität hinter der Kurswahl-Anwendung.
 * Sie ist zum einen für die Datenspeicherung, durch die Erstellung und Initialisierung der Kurs-Objekte,
 * sowie die Prüfung der Eingaben zuständig.
 * Um letztere Aufgabe wahrnehmen zu können, speichert sie ebenfalls die Kriterien,
 * ob sie erfüllt sind oder nicht und stellt Methoden zur Überprüdung dieser bereit.
 *
 * @main-author Romy Karbstein, Glenn Grubert, Tomás Wagner
 */

public class Wahlpruefung {

    // Attribute für die Kriterien:
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
    private boolean gEistPFCheck; //wenn GE ein PF ist, sind das 3. und 4. Semester PW belegt oder 4 Semester
    // eines anderen Faches des 2. AF
    private boolean sPals4o5PK; //sind 2 Semester SP-T belegt, wenn SP-P als 4. oder 5. PF gewaehlt wurden
    private boolean zweiSemKuenstFaecher; //sind 2 Semester eines kuenstlerischen Faches (MU,KU,DS) belegt

    private boolean zweiSemBelegung; //sind alle Kurse im Paket von 2 Semestern belegt
    private boolean vierzigKurseBelegt; //es sind insgesamt vierzig Kurse belegt worden
    private boolean aSchieneEinLK; //ist ein LK aus der A-Schiene gewaehlt worden (De, Eng, Fr, Ku, (Pw), Ma, Bi)
    private boolean bSchieneEinLK; //ist ein LK aus der B-Schiene gewaehlt worden (En, Ku, Mu, Ge, Pw, (Ma), Bi, Ch, Ph, Inf)

    private boolean spracheAbBeginn; //sind die gewaehlten Fremdsprachen nicht nur in der 12. Kl. gewaehlt worden
    private boolean kuenstWerkMitKULK; //ist der LK KU gewaehlt worden, wenn die kuenstlerischen Werkstaetten belegt wurden
    private boolean dSmin4Sem; //ist DS 0 oder 4 Semester lang gewaehlt worden

    private Kurs[] kursListe;
    private Schiene[] schienen;
    private Schiene[] passendeSchienen;

    /**
     * Konstruktor der Klasse Wahlpruefung
     * @author Glenn Grubert
     */
    public Wahlpruefung()
    {
        kursListe = new Kurs[26];
        schienen = new Schiene[48];// Attribut für alle Schienen
        passendeSchienen = new Schiene[3];// Attribut für passende Schienen
        kurseInstanziieren();
        schienenErzeugen();
    }

    /**
     * Instanziiert die Kurse und fügt sie in die Liste der Kurse in korrekter Reihenfolge ein.
     * @author Glenn Grubert, Romy Karbstein
     */
    private void kurseInstanziieren()
    {
        kursListe[0] = new Kurs("Deutsch", 1, 0, true, true, true, true, 4, 0);
        kursListe[1] = new Kurs("Englisch", 1, 2, false, false, false, false, 0, 0);
        kursListe[2] = new Kurs("Französisch", 1, 2, false, false, false, false, 0, 0);
        kursListe[3] = new Kurs("Latein", 1, 2, false, false, false, false, 0, 0);
        kursListe[4] = new Kurs("Musik", 1, 3, false, false, false, false, 0, 0);
        kursListe[5] = new Kurs("Bildende Kunst", 1, 3, false, false, false, false, 0, 0);
        kursListe[6] = new Kurs("Darstellendes Spiel", 1, 3, false, false, false, false, 0, 0);
        kursListe[7] = new Kurs("Seminarkurs Debating", 1, 4, false, false, false, false, 0, 0);
        kursListe[8] = new Kurs("ZK Cambridge-Prüfungen", 1, 4, false, false, false, false, 0, 0);
        kursListe[9] = new Kurs("ZK Künstlerische Werkstätte", 1, 4, false, false, false, false, 0, 0);
        kursListe[10] = new Kurs("Ensemblekurs Bläser", 1, 4, false, false, false, false, 0, 0);
        kursListe[11] = new Kurs("Ensemblekurs Chor", 1, 4, false, false, false, false, 0, 0);
        kursListe[12] = new Kurs("Ensemblekurs Orchester", 1, 4, false, false, false, false, 0, 0);
        kursListe[13] = new Kurs("Politikwissenschaften", 2, 0, false, false, false, false, 0, 0);
        kursListe[14] = new Kurs("Geschichte", 2, 0, false, false, true, true, 2, 0);
        kursListe[15] = new Kurs("Geographie", 2, 0, false, false, false, false, 0, 0);
        kursListe[16] = new Kurs("Philosophie", 2, 0, false, false, false, false, 0, 0);
        kursListe[17] = new Kurs("ZK Political Science", 2, 4, false, false, false, false, 0, 0);
        kursListe[18] = new Kurs("ZK Studium und Beruf", 2, 4, false, false, false, false, 0, 0);
        kursListe[19] = new Kurs("Mathematik", 3, 0, true, true, true, true, 4, 0);
        kursListe[20] = new Kurs("Physik", 3, 1, false, false, false, false, 0, 0);
        kursListe[21] = new Kurs("Chemie", 3, 1, false, false, false, false, 0, 0);
        kursListe[22] = new Kurs("Biologie", 3, 1, false, false, false, false, 0, 0);
        kursListe[23] = new Kurs("Informatik", 3, 0, false, false, false, false, 0, 0);
        kursListe[24] = new Kurs("Sport Praxiskurs", 0, 0, true, true, true, true, 4, 0);
        kursListe[25] = new Kurs("Sporttheorie", 0, 0, false, false, false, false, 0, 0);

    }

    /**
     * Es werden alle Kriterien (Attribute) überprüft, ob sie als erfüllt gespeichert sind (=true).
     * @return sind alle Kriterien als erfüllt gespeichert
     * @author Tomás Wagner
     */
    public boolean wahlpruefung()
    {
        boolean attributeTrue = true;

        attributeAktualisieren();

        if(!einLKHFoNW || !zweiLKgewaehlt || !drittesPFgewaehlt || !viertesPFgewaehlt){attributeTrue = false;}

        if(!fuenftesPFgewaehlt || !zweiPFHP || !aFvertreterInPF || !einPFCheck){attributeTrue = false;}

        if(!vierMalFS || !vierMalNW || !vierMal2AF || !zweiRichtigeNW){attributeTrue = false;}

        if(!sechsMal2AF || !gEistPFCheck || !sPals4o5PK || !zweiSemKuenstFaecher){attributeTrue = false;}

        if(!zweiSemBelegung || !vierzigKurseBelegt || !aSchieneEinLK || !bSchieneEinLK){attributeTrue = false;}

        if(!spracheAbBeginn || !kuenstWerkMitKULK || !dSmin4Sem){attributeTrue = false;}


        System.out.println();
        System.out.println("einLKHFoNW " + einLKHFoNW);
        System.out.println("zweiLKgewaehlt " + zweiLKgewaehlt);
        System.out.println("drittesPFgewaehlt " + drittesPFgewaehlt);
        System.out.println("viertesPFgewaehlt " + viertesPFgewaehlt);

        System.out.println("fuenftesPFgewaehlt " + fuenftesPFgewaehlt);
        System.out.println("zweiPFHP " + zweiPFHP);
        System.out.println("aFvertreterInPF " + aFvertreterInPF);
        System.out.println("einPFCheck " + einPFCheck);

        System.out.println("vierMalFS " + vierMalFS);
        System.out.println("vierMalNW " + vierMalNW);
        System.out.println("vierMal2AF " + vierMal2AF);
        System.out.println("zweiRichtigeNW " + zweiRichtigeNW);

        System.out.println("sechsMal2AF " + sechsMal2AF);
        System.out.println("gEistPFCheck " + gEistPFCheck);
        System.out.println("sPals4o5PK " + sPals4o5PK);
        System.out.println("zweiSemKuenstFaecher " + zweiSemKuenstFaecher);

        System.out.println("zweiSemBelegung " + zweiSemBelegung);
        System.out.println("vierzigKurseBelegt " + vierzigKurseBelegt);
        System.out.println("aSchieneEinLK " + aSchieneEinLK);
        System.out.println("bSchieneEinLK " + bSchieneEinLK);

        System.out.println("spracheAbBeginn" + spracheAbBeginn);
        System.out.println("kuenstWerkMitKULK " + kuenstWerkMitKULK);
        System.out.println("dSmin4Sem " + dSmin4Sem);

        return attributeTrue;
    }

    /**
     * Ausführen aller Methoden zur Überprüfung der Kriterien und damit einhergehende Aktualisierung der Attributwerte.
     * @author Tomás Wagner
     */
    public void attributeAktualisieren()
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
     * @author Glenn Grubert, Romy Karbstein
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
     * @author Glenn Grubert, Romy Karbstein
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
     * @author Glenn Grubert, Romy Karbstein
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
     * @author Glenn Grubert, Romy Karbstein
     */
    private void mviertesPFgewaehlt()
    {
        int zaehler = 0;
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getPruefungsfach() == 4) { zaehler++; }
        }
        viertesPFgewaehlt = zaehler == 1;
        System.out.println(viertesPFgewaehlt);
    }

    /**
     * Das Kriterium fuenftesPFgewaehlt wird überprüft und entsprechend aktualisiert
     * @author Glenn Grubert, Romy Karbstein
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
     * @author Glenn Grubert, Romy Karbstein
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
        zweiPFHP = (deMa>0) && (zaehler >= 2);
    }

    /**
     * Das Kriterium aFvertreterInPF wird überprüft und entsprechend aktualisiert
     * @author Glenn Grubert, Romy Karbstein
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
     * @author Glenn Grubert, Romy Karbstein
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
     * @author Tomás Wagner
     */
    private void mvierMalFS() { vierMalFS = getKursListeElement(1).getAnzahlSemester() == 4 || getKursListeElement(2).getAnzahlSemester() == 4 || getKursListeElement(3).getAnzahlSemester() == 4; }

    /**
     * Das Kriterium vierMalNW wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mvierMalNW() { vierMalNW = getKursListeElement(20).getAnzahlSemester() == 4 || getKursListeElement(21).getAnzahlSemester() == 4 || getKursListeElement(22).getAnzahlSemester() == 4; }

    /**
     * Das Kriterium vierMal2AF wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mvierMal2AF() { vierMal2AF = getKursListeElement(13).getAnzahlSemester() == 4 || getKursListeElement(14).getAnzahlSemester() == 4 || getKursListeElement(15).getAnzahlSemester() == 4 || getKursListeElement(16).getAnzahlSemester() == 4; }

    /**
     * Das Kriterium zweiRichtigeNW wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mzweiRichtigeNW() { zweiRichtigeNW = getKursListeElement(20).getAnzahlSemester() >= 2 || getKursListeElement(21).getAnzahlSemester() >= 2; }

    /**
     * Das Kriterium sechsMal2AF wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
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
        sechsMal2AF = zaehler > 5; //Attribut wird auf true gesetzt, wenn mindestens 6 Semester im 2. AF belegt wurden
    }

    /**
     * Das Kriterium gEistPFCheck wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
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
     * @author Tomás Wagner
     */
    private void msPals4o5PK()
    {
        sPals4o5PK = true;
        //genauere Prüfung, wenn SP-P als 4. oder 5. PF gewählt wurde
        if (getKursListeElement(24).getPruefungsfach() == 4 || getKursListeElement(24).getPruefungsfach() == 5)
        {
            sPals4o5PK = getKursListeElement(25).getAnzahlSemester() > 0;
        }
    }

    /**
     * Das Kriterium zweiSemKuenstFaecher wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mzweiSemKuenstFaecher()
    {
        //Prüfung der Kurse Musik, Kunst und DS, ob min. einer von ihnen für min. 2 Semester belegt ist
        zweiSemKuenstFaecher = getKursListeElement(4).getAnzahlSemester() >= 2 || getKursListeElement(5).getAnzahlSemester() >= 2 || getKursListeElement(6).getAnzahlSemester() >= 2;
    }

    /**
     * Das Kriterium zweiSemBelegung wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mzweiSemBelegung()
    {
        zweiSemBelegung = true;
        //Prüfung, ob die Anzahl an belegten Semestern in jedem Kurs ohne Rest durch 2 teilbar ist
        for (int i = 0; i < 26; i++)
        {
            if  (getKursListeElement(i).getAnzahlSemester() % 2 != 0) { zweiSemBelegung = false; }
        }
    }

    /**
     * Das Kriterium vierzigKurseBelegt wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mvierzigKurseBelegt()
    {
        int zaehler = 0;
        //Berechnung der Anzahl an Kursen durch Addition aller belegten Semester, in jedem Kurs
        for (int i = 0; i < 26; i++)
        {
            zaehler = zaehler + getKursListeElement(i).getAnzahlSemester();
        }
        vierzigKurseBelegt = false;

        if (zaehler == 40)
        {
            vierzigKurseBelegt = true;
        }
        else
        {
            if (zaehler == 42)
            {
                int anzahlVollBelegterEnsemblekurse = 0;
                if (getKursListeElement(10).getAnzahlSemester() == 4){ anzahlVollBelegterEnsemblekurse ++; }
                if (getKursListeElement(11).getAnzahlSemester() == 4){ anzahlVollBelegterEnsemblekurse ++; }
                if (getKursListeElement(12).getAnzahlSemester() == 4){ anzahlVollBelegterEnsemblekurse ++; }
                if (anzahlVollBelegterEnsemblekurse >= 2){ vierzigKurseBelegt = true; }
            }
        }
    }

    /**
     * Das Kriterium aSchieneEinLK wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void maSchieneEinLK()
    {
        //Speichervariablen für die Indizes der gewählten LKs
        int ersterLK = 30;
        int zweiterLK = 30;

        //Durchgehen aller Kurse und Speicherung derer, die als LKs gewählt wurden
        for (int i = 0; i < 26; i++)
        {
            if (getKursListeElement(i).getPruefungsfach() == 2)
            {
                if (ersterLK == 30)
                {
                    ersterLK = i;
                }
                else
                {
                    zweiterLK = i;
                }
            }
        }
        //Ermittlung, ob einer der beiden LKs ein Fach der A-Schiene ist
        aSchieneEinLK = false;
        if (ersterLK == 0 || ersterLK == 1 || ersterLK == 2 || ersterLK == 5 || ersterLK == 13 || ersterLK == 19 || ersterLK == 22){ aSchieneEinLK = true; }
        if (zweiterLK == 0 || zweiterLK == 1 || zweiterLK == 2 || zweiterLK == 5 || zweiterLK == 13 || zweiterLK == 19 || zweiterLK == 22){ aSchieneEinLK = true; }
    }

    /**
     * Das Kriterium bSchieneEinLK wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mbSchieneEinLK()
    {
        //Speichervariablen für die Indizes der gewählten LKs
        int ersterLK = 30;
        int zweiterLK = 30;

        //Durchgehen aller Kurse und Speicherung derer, die als LKs gewählt wurden
        for (int i = 0; i < 26; i++)
        {
            if (getKursListeElement(i).getPruefungsfach() == 2)
            {
                if (ersterLK == 30)
                {
                    ersterLK = i;
                }
                else
                {
                    zweiterLK = i;
                }
            }
        }
        //Ermittlung, ob einer der beiden LKs ein Fach der B-Schiene ist
        bSchieneEinLK = false;
        if (ersterLK == 1 || ersterLK == 5 || ersterLK == 4 || ersterLK == 14 || ersterLK == 13 || ersterLK == 19 || ersterLK == 22 || ersterLK == 21 || ersterLK == 20 || ersterLK == 23){ bSchieneEinLK = true; }
        if (zweiterLK == 1 || zweiterLK == 5 || zweiterLK == 4 || zweiterLK == 14 || zweiterLK == 13 || zweiterLK == 19 || zweiterLK == 22 || zweiterLK == 21 || zweiterLK == 20 || zweiterLK == 23){ bSchieneEinLK = true; }
    }

    /**
     * Das Kriterium spracheAbBeginn wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
     */
    private void mspracheAbBeginn()
    {
        boolean en = false;
        boolean fr = false;
        boolean la = false;

        //Prüfung ob ENG nicht nur in der 12. KL gewählt wurde
        if (getKursListeElement(1).getAnzahlSemester() > 0 )
        {
            if (getKursListeElement(1).getQ1() && getKursListeElement(0).getQ2()){ en = true; }
        }
        else
        {
            en = true;
        }

        //Prüfung ob FR nicht nur in der 12. KL gewählt wurde
        if (getKursListeElement(2).getAnzahlSemester() > 0 )
        {
            if (getKursListeElement(2).getQ1() && getKursListeElement(0).getQ2()){ fr = true; }
        }
        else
        {
            fr = true;
        }

        //Prüfung ob LA nicht nur in der 12. KL gewählt wurde
        if (getKursListeElement(3).getAnzahlSemester() > 0 )
        {
            if (getKursListeElement(3).getQ1() && getKursListeElement(0).getQ2()){ la = true; }
        }
        else
        {
            la = true;
        }
        //abschließende Prüfung, ob alle FS das Kriterium erfüllen
        spracheAbBeginn = en && fr && la;
    }

    /**
     * Das Kriterium kuenstWerkMitKULK wird überprüft und entsprechend aktualisiert
     * @author Tomás Wagner
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
     * @author Tomás Wagner
     */
    private void mdSmin4Sem() { dSmin4Sem = getKursListeElement(6).getAnzahlSemester() == 4 || getKursListeElement(6).getAnzahlSemester() == 0; }

    //Get-Methode für die Liste aller Kurse
    public Kurs[] getKursListe()
    {
        return kursListe;
    }

    //Get-Methode für ein bestimmtes Element (mit bestimmtem Index) der Kursliste
    public Kurs getKursListeElement(int index){ return kursListe[index]; }

    //Get-Methoden aller Kriterienattribute
    public boolean getEinLKHFoNW() { return einLKHFoNW; }
    public boolean getZweiLKgewaehlt() { return zweiLKgewaehlt; }
    public boolean getDrittesPFgewaehlt() { return drittesPFgewaehlt; }
    public boolean getViertesPFgewaehlt() { return viertesPFgewaehlt; }
    public boolean getFuenftesPFgewaehlt() { return fuenftesPFgewaehlt; }
    public boolean getZweiPFHP() { return zweiPFHP; }
    public boolean getAFvertreterInPF() { return aFvertreterInPF; }
    public boolean getEinPFCheck() { return einPFCheck; }
    public boolean getVierMalFS() { return vierMalFS; }
    public boolean getVierMalNW() { return vierMalNW; }
    public boolean getVierMal2AF() { return vierMal2AF; }
    public boolean getZweiRichtigeNW() { return zweiRichtigeNW; }
    public boolean getSechsMal2AF() { return sechsMal2AF; }
    public boolean getGEistPFCheck() { return gEistPFCheck; }
    public boolean getSPals4o5PK() { return sPals4o5PK; }
    public boolean getZweiSemKuenstFaecher() { return zweiSemKuenstFaecher; }
    public boolean getZweiSemBelegung() { return zweiSemBelegung; }
    public boolean getVierzigKurseBelegt() { return vierzigKurseBelegt; }
    public boolean getASchieneEinLK() { return aSchieneEinLK; }
    public boolean getBSchieneEinLK() { return bSchieneEinLK; }
    public boolean getSpracheAbBeginn() { return spracheAbBeginn; }
    public boolean getKuenstWerkMitKULK() { return kuenstWerkMitKULK; }
    public boolean getDSmin4Sem() { return dSmin4Sem; }
    public Schiene[] getPassendeSchienen() { return passendeSchienen; }

    public void setPassendeSchienen(Schiene[] passendeSchienen) { this.passendeSchienen = passendeSchienen; }

    /**
     * Errechnet die Summe aller jeweils in q1, q2, q3 und q4 belegten Kurse und gibt diese für die jeweiligen Semester
     * als Array zurück
     * @return Array mit {Summe für q1, Summe für q2 Summe, für q3, Summe für q4}
     * @author Tomás Wagner, Glenn Grubert, Romy Karbstein
     */
    public int[] semesterGesamtanzahlBerechnen()
    {
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;

        for (int i = 0; i < 26; i++)
        {
            if (getKursListeElement(i).getQ1()) q1++;
            if (getKursListeElement(i).getQ2()) q2++;
            if (getKursListeElement(i).getQ3()) q3++;
            if (getKursListeElement(i).getQ4()) q4++;
        }
        int[] array = {q1, q2, q3, q4};
        return array;
    }

    /**
     * Errechnet die Summe aller belegter Kurse.
     * @return Gesamtanzahl belegter Kurse
     * @author Tomás Wagner
     */
    public int gesamtAnzahlKurseBerechnen()
    {
        int[] array = semesterGesamtanzahlBerechnen();
        return array[0]+ array[1] + array[2] + array[3];
    }

    /**
     * Errechnet die Summe aller Pflichtsemester.
     * @return Gesamtanzahl Pflichtsemester
     * @author Tomás Wagner
     */
    public int gesamtAnzahlPSberechnen()
    {
        int gesPS = 0;

        for (int i = 0; i < 26; i++)
        {
            gesPS += (getKursListeElement(i).getAnzahlPflichtsemester());
        }
        return gesPS;
    }

    /**
     * Sucht nach einem Kurs-Objekt, basierend auf dessen Name.
     * @param kursName: Name des zu suchenden Kurses
     * @return Kursobjekt mit angegebenen Namen (Null falls die Angabe falsch ist)
     * @author Lukas Schenkel, Glenn Grubert
     */
    public Kurs sucheKurs(String kursName)
    {
        for (int i = 0; i < 25; i++)
        {
            if ((getKursListeElement(i)).getName().equals(kursName))
            {
                return getKursListeElement(i);
            }
        }
        return null;
    }

    /**
     * Trägt die Kurse mit den angegebenen Namen als LKs ein (inklusive Belegung und Pflichtsemestern).
     * @param LK1 Name des erster LKs
     * @param LK2 Name des zweiten LKs
     * @author Glenn Grubert
     */
    public void lkWahl(String LK1, String LK2)
    {
        Kurs lkI = sucheKurs(LK1);
        Kurs lkII = sucheKurs(LK2);

        lkI.setQs(true, true, true, true);
        lkI.setAnzahlPflichtsemester(4);
        lkI.setPruefungsfach(1);
        lkII.setQs(true, true, true, true);
        lkII.setAnzahlPflichtsemester(4);
        lkII.setPruefungsfach(1);
    }

    /**
     * Erzeugung aller möglichen Schienen gemäß der Tabelle der Schule.
     * @author Romy Karbstein, Glenn Grubert
     */
    public void schienenErzeugen()
    {
        schienen[0] = new Schiene(1,"FS","DE","2. AF","MA","bel.",0,2,0,2,0,4,2, 1);
        schienen[1] = new Schiene(2,"FS","DE","2. AF","NW","bel.",0,2,0,2,4,0,2, 1);
        schienen[2] = new Schiene(3,"FS","DE","2. AF","IN","bel.",0,2,0,2,4,4,2, 1);

        schienen[3] = new Schiene(4,"FS","FS","DE","2. AF","NW",0,2,0,2,4,0,2, 2);
        schienen[4] = new Schiene(5,"FS","FS","DE","2. AF","IN",0,2,0,2,4,4,2, 2);
        schienen[5] = new Schiene(6,"FS","FS","MA","2. AF","bel.",4,2,0,2,0,4,2, 2);

        schienen[6] = new Schiene(7,"FS","MU/KU","DE","2. AF","NW",0,0,0,2,4,0,2, 2);
        schienen[7] = new Schiene(8,"FS","MU/KU","DE","2. AF","IN",0,0,0,2,4,4,2, 2);
        schienen[8] = new Schiene(9,"FS","MU/KU","MA","2. AF","bel.",4,0,0,2,0,4,2, 2);

        schienen[9] = new Schiene(10,"FS","2. AF","DE","NW","bel.",0,2,0,2,4,0,2, 2);
        schienen[10] = new Schiene(11,"FS","2. AF","DE","IN","bel.",0,2,0,2,4,4,2, 2);
        schienen[11] = new Schiene(12,"FS","2. AF","MA","bel.","bel.",4,2,0,2,0,4,2, 2);

        schienen[12] = new Schiene(13,"FS","MA","2. AF","bel.","bel.",4,2,0,2,0,4,2, 2);

        schienen[13] = new Schiene(14,"FS","NW","DE","2. AF","bel.",0,2,0,2,4,0,2, 2);
        schienen[14] = new Schiene(15,"FS","NW","MA","2. AF","bel.",4,2,0,2,0,0,2, 2);

        schienen[15] = new Schiene(16,"FS","IN","DE","2. AF","bel.",0,2,0,2,4,4,2, 2);
        schienen[16] = new Schiene(17,"FS","IN","MA","2. AF","bel.",4,2,0,2,0,4,2, 2);

        schienen[17] = new Schiene(21,"MA","DE","2. AF","bel.","bel.",0,2,4,2,0,4,2, 2);

        schienen[18] = new Schiene(22,"MA","MU/KU","DE","2. AF","bel.",0,0,4,2,0,4,2, 2);
        schienen[19] = new Schiene(23,"MA","MU/KU","FS","2. AF","bel.",4,0,0,2,0,4,2, 2);

        schienen[20] = new Schiene(24,"MA","2. AF","DE","bel.","bel.",0,2,4,2,0,4,2, 2);
        schienen[21] = new Schiene(25,"MA","2. AF","FS","bel.","bel.",4,2,0,2,0,4,2, 2);

        schienen[22] = new Schiene(26,"MA","NW","DE","2. AF","bel.",0,2,4,2,0,0,2, 2);
        schienen[23] = new Schiene(27,"MA","NW","FS","2. AF","bel.",4,2,0,2,0,0,2, 2);

        schienen[24] = new Schiene(28,"MA","IN","DE","2. AF","bel.",0,2,4,2,0,4,2, 2);
        schienen[25] = new Schiene(29,"MA","IN","FS","2. AF","bel.",4,2,0,2,0,4,2, 2);

        schienen[26] = new Schiene(32,"NW","DE","FS","2. AF","bel.",0,2,0,2,4,0,2, 2);
        schienen[27] = new Schiene(33,"NW","DE","MA","2. AF","bel.",0,2,4,2,0,0,2, 2);

        schienen[28] = new Schiene(34,"NW","MU/KU","FS","DE","2. AF",0,0,0,2,4,0,2, 3);
        schienen[29] = new Schiene(35,"NW","MU/KU","FS","MA","2. AF",4,0,0,2,0,0,2, 3);
        schienen[30] = new Schiene(36,"NW","MU/KU","MA","DE","2. AF",0,0,4,2,0,0,2, 3);

        schienen[31] = new Schiene(37,"NW","2. AF","FS","DE","bel.",0,2,0,2,4,0,2, 3);
        schienen[32] = new Schiene(38,"NW","2. AF","FS","MA","bel.",4,2,0,2,0,0,2, 3);
        schienen[33] = new Schiene(39,"NW","2. AF","MA","DE","bel.",0,2,4,2,0,0,2, 3);

        schienen[34] = new Schiene(40,"NW","NW","FS","DE","2. AF",0,2,0,2,4,0,0, 3);
        schienen[35] = new Schiene(41,"NW","NW","FS","MA","2. AF",4,2,0,2,0,0,0, 3);
        schienen[36] = new Schiene(42,"NW","NW","MA","DE","2. AF",0,2,4,2,0,0,0, 3);

        schienen[37] = new Schiene(43,"NW","IN","FS","DE","2. AF",0,2,0,2,4,0,2, 3);
        schienen[38] = new Schiene(44,"NW","IN","FS","MA","2. AF",4,2,0,2,0,0,2, 3);
        schienen[39] = new Schiene(45,"NW","IN","MA","DE","2. AF",0,2,4,2,0,0,2, 3);
        //
        schienen[40] = new Schiene(49,"DE","MU/KU","FS","2. AF","NW",0,0,0,2,4,0,2, 2);
        schienen[41] = new Schiene(50,"DE","MU/KU","FS","2. AF","IN",0,0,0,2,4,4,2, 2);
        schienen[42] = new Schiene(51,"DE","MU/KU","MA","2. AF","bel.",0,0,4,2,0,4,2, 2);

        schienen[43] = new Schiene(52,"DE","2. AF","FS","NW","bel.",0,2,0,2,4,0,2, 2);
        schienen[44] = new Schiene(53,"DE","2. AF","FS","IN","bel.",0,2,0,2,4,4,2, 2);
        schienen[45] = new Schiene(54,"DE","2. AF","MA","bel.","bel.",0,2,4,2,0,4,2, 2);

        schienen[46] = new Schiene(55,"DE","IN","FS","2. AF","bel.",0,2,0,2,4,4,2, 2);
        schienen[47] = new Schiene(56,"DE","IN","MA","2. AF","bel.",0,2,4,2,0,4,2, 2);
    }

    public Schiene getSchienenListeElement(int index){ return schienen[index]; }
    public Schiene getPassendeSchienenListeElement(int index){ return passendeSchienen[index]; }

    /**
     * Filterung aller Schienen anhand eingegebener LKs.
     * @param ersterLK erster der beiden im vorhinein zu wählenden LKs
     * @param zweiterLK zweiter der beiden im vorhinein zu wählenden LKs
     * @return Array mit Schienen, die zu den beiden gewählten LKs passen
     * @author Tomás Wagner
     */
    public void schienenFiltern(String ersterLK, String zweiterLK)
    {
        // Leerung des Arrays mit den passenden Schienen, damit keine Reste vom vorigen Vorgang übrig bleiben
        Schiene[] leeresArray = new Schiene[3];
        leeresArray[0] = null;
        leeresArray[1] = null;
        leeresArray[2] = null;
        setPassendeSchienen(leeresArray);

        // die bei zwei LKs passen können
        int zaehler = 0;
        for (int i = 0; i < 48; i++)
        {
            if ((getSchienenListeElement(i).getErsterLK().equals(ersterLK) && getSchienenListeElement(i).getZweiterLK().equals(zweiterLK)) || (getSchienenListeElement(i).getErsterLK() == zweiterLK && getSchienenListeElement(i).getZweiterLK() == ersterLK))
            {
                passendeSchienen[zaehler] = getSchienenListeElement(i);
                zaehler ++;
            }
        }
    }
}

