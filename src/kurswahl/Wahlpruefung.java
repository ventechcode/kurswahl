package kurswahl;

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

    public Wahlpruefung()
    {
        //
    }

}
