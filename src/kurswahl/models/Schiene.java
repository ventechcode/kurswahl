package kurswahl.models;

/**
 * Die Klasse Schiene stellt einen Bauplan für Schienen-Objekte dar, die gemäß der Definition durch die Schule angeben,
 * welche Bedingungen bei bestimmten Kausalitäten vorliegen. Jede*r Schüler*in wählt zu Beginn deshalb eine Schiene aus,
 * nachdem er/sie sich für 2 Leistungskurse entschieden hat.
 *
 * @main-author Tomás Wagner
 */

public class Schiene
{
    private int nr;
    private String ersterLK;
    private String zweiterLK;
    private String drittesPF;
    private String viertesPF;
    private String fuenftesPF;
    private int de;
    private int kf;
    private int fs;
    private int gePw;
    private int ma;
    private int nw;
    private int phCh;
    // 1: 3.-5. PF frei tauschbar
    // 2: 3.-5. PF unter Bedingungen tauschbar (2 HF als 1.-4. & max. 1 KF)
    // 3 : nur 3. und 4. PF frei tauschbar => 5. PF fest
    private int tauschmoeglichkeiten;

    /**
     * Konstruktor der Klasse Schiene
     * @param nr Nummer der Schiene gemäß der Tabelle der Schule
     * @param ersterLK
     * @param zweiterLK
     * @param drittesPF
     * @param viertesPF
     * @param fuenftesPF
     * @param de Anzahl Pflichtsemester im Fach Deutsch
     * @param kf Anzahl Pflichtsemester im Bereich der künstlerischen Fächer
     * @param fs Anzahl Pflichtsemester im Bereich der Fremdsprachen
     * @param gePw Anzahl Pflichtsemester in den Fächern Geschichte und Politikwissenschaften
     * @param ma Anzahl Pflichtsemester im Fach Mathematik
     * @param nw Anzahl Pflichtsemester im Bereich der Naturwissenschaften
     * @param phCh Anzahl Pflichtsemester in den Fächern Physik und Chemie
     * @param tauschmoeglichkeiten Kategorie gibt an, inwiefern die Prüfungsfächer 3 - 5 getauscht werden können
     * @author Tomás Wagner
     */
    public Schiene(int nr, String ersterLK, String zweiterLK, String drittesPF, String viertesPF, String fuenftesPF,
                   int de, int kf, int fs, int gePw, int ma, int nw, int phCh, int tauschmoeglichkeiten)
    {
        this.nr = nr;
        this.ersterLK = ersterLK;
        this.zweiterLK = zweiterLK;
        this. drittesPF = drittesPF;
        this.viertesPF = viertesPF;
        this.fuenftesPF = fuenftesPF;
        this.de = de;
        this.kf = kf;
        this.fs = fs;
        this.gePw = gePw;
        this.ma = ma;
        this.nw = nw;
        this.phCh = phCh;
        this.tauschmoeglichkeiten = tauschmoeglichkeiten;
    }

    public int getNr() {
        return nr;
    }

    public String getErsterLK() {
        return ersterLK;
    }

    public String getZweiterLK() {
        return zweiterLK;
    }

    public String getDrittesPF() {
        return drittesPF;
    }

    public String getViertesPF() {
        return viertesPF;
    }

    public String getFuenftesPF() {
        return fuenftesPF;
    }

    public int getDe() {
        return de;
    }

    public int getKf() {
        return kf;
    }

    public int getFs() {
        return fs;
    }

    public int getGePw() {
        return gePw;
    }

    public int getMa() {
        return ma;
    }

    public int getNw() {
        return nw;
    }

    public int getPhCh() { return phCh; }

    public int getTauschmoeglichkeiten() { return tauschmoeglichkeiten; }
}
