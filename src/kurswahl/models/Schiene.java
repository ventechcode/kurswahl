package kurswahl.models;

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
