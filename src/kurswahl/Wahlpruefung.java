package kurswahl;

public class Wahlpruefung {

    private Funktionalitaet funktionalitaet;

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


    public void setFunktionalitaet(Funktionalitaet funktionalitaet) {
        this.funktionalitaet = funktionalitaet;
    }

    /**
     * Es werden alle Kriterien (Attribute) überprüft, ob sie als erfüllt gespeichert sind (=true).
     * @return sind alle Kriterien als efüllt gespeichert
     */
    public boolean ueberpruefung()
    {
        boolean kriterienErfuellt = true;

        if(einLKHFoNW == false || zweiLKgewaehlt == false || drittesPFgewaehlt == false || viertesPFgewaehlt == false){kriterienErfuellt = false;}

        if(fuenftesPFgewaehlt == false || zweiPFHP == false || AFvertreterInPF == false || einPFCheck == false){kriterienErfuellt = false;}

        if(vierMalFS == false || vierMalNW == false || vierMal2AF == false || zweiRichtigeNW == false){kriterienErfuellt = false;}

        if(SechsMal2AF == false || GEistPFCheck == false || SPals4o5PK == false || zweiSemKuenstFaecher == false){kriterienErfuellt = false;}

        if(zweiSemBelegung == false || vierzigKurseBelegt == false || ASchieneEinLK == false || BSchieneEinLK == false){kriterienErfuellt = false;}

        if(SpracheAbBeginn == false || kuenstWerkMitKULK == false || DSmin4Sem == false){kriterienErfuellt = false;}

        return kriterienErfuellt;
    }

    /**
     * Das Kriterium einLKHFoNW wird überprüft und entsprechend aktualisiert
     */
    private void meinLKHFoNW()
     {
        einLKHFoNW = false;
        if (funktionalitaet.getKursListeElement(0).getPruefungsfach() == 2) {einLKHFoNW = true;} //Deutsch
        if (funktionalitaet.getKursListeElement(1).getPruefungsfach() == 2) {einLKHFoNW = true;} //Englisch
        if (funktionalitaet.getKursListeElement(2).getPruefungsfach() == 2) {einLKHFoNW = true;} //Französisch
        if (funktionalitaet.getKursListeElement(19).getPruefungsfach() == 2) {einLKHFoNW = true;} //Mathematik

        if (funktionalitaet.getKursListeElement(20).getPruefungsfach() == 2) {einLKHFoNW = true;} //Physik
        if (funktionalitaet.getKursListeElement(21).getPruefungsfach() == 2) {einLKHFoNW = true;} //Chemie
        if (funktionalitaet.getKursListeElement(22).getPruefungsfach() == 2) {einLKHFoNW = true;} //Biologie
    }

    private void mzweiLKgewaehlt()
    {

    }

    private void mdrittesPFgewaehlt()
    {

    }

    private void mviertesPFgewaehlt()
    {

    }

    private void mfuenftesPFgewaehlt()
    {

    }

    private void mzweiPFHP()
    {

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

    }

}
