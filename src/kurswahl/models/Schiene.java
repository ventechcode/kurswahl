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
    private int sp;

    private Schiene[] schienen; // gehört eigentlich in die Klasse Wahlpruefung

    public Schiene(int nr, String ersterLK, String zweiterLK, String drittesPF, String viertesPF, String fuenftesPF, int de, int kf, int fs, int gePw, int ma, int nw, int phCh)
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
        this.sp = 4;
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

    public int getPhCh() {
        return phCh;
    }

    // folgendes gehört eigentlich in die Klasse Wahlpruefung:

    // import kurswahl.models.Schiene;

    public void schienenErzeugen()
    {
        // 1. Schiene (6 Kombinationsmöglichkeiten pro Fremdsprache):
        schienen[0] = new Schiene(1,"EN","DE","2. AF","MA","bel.",0,2,0,2,0,4,2);
        schienen[1] = new Schiene(2,"EN","DE","2. AF","bel.","MA",0,2,0,2,0,4,2);

        schienen[2] = new Schiene(3,"EN","DE","bel.","2. AF","MA",0,2,0,2,0,4,2);
        schienen[3] = new Schiene(4,"FS","DE","bel.","MA","2. AF",0,2,0,2,0,4,2);

        schienen[4] = new Schiene(5,"EN","DE","MA","bel.","2. AF",0,2,0,2,0,4,2);
        schienen[5] = new Schiene(6,"EN","DE","MA","2. AF","bel.",0,2,0,2,0,4,2);

        schienen[0] = new Schiene(7,"FR","DE","2. AF","MA","bel.",0,2,0,2,0,4,2);
        schienen[1] = new Schiene(8,"FR","DE","2. AF","bel.","MA",0,2,0,2,0,4,2);

        schienen[2] = new Schiene(9,"FR","DE","bel.","2. AF","MA",0,2,0,2,0,4,2);
        schienen[3] = new Schiene(10,"FR","DE","bel.","MA","2. AF",0,2,0,2,0,4,2);

        schienen[4] = new Schiene(11,"FR","DE","MA","bel.","2. AF",0,2,0,2,0,4,2);
        schienen[5] = new Schiene(12,"FR","DE","MA","2. AF","bel.",0,2,0,2,0,4,2);

        // ...
    }

    public Schiene getSchienenListeElement(int index){ return schienen[index]; }

    /**
     * Filterung aller Schienen anhand eingegebener LKs.
     * @param ersterLK erster der beiden im vorhinein zu wählenden LKs
     * @param zweiterLK zweiter der beiden im vorhinein zu wählenden LKs
     * @return Array mit Schienen, die zu den beiden gewählten LKs passen
     */
    public Schiene[] schienenFiltern(String ersterLK, String zweiterLK)
    {
        Schiene[] passendeSchienen = new Schiene[300]; // 300 ist ein Platzhalter für die max. Anzahl an Schienen, die bei zwei LK  passen können
        int zaehler = 0;
        for (int i = 0; i < 500; i++) //500 ist ein Platzhalter für die Anzahl aller Schienen
        {
            if ((getSchienenListeElement(i).getErsterLK().equals(ersterLK) && getSchienenListeElement(i).getZweiterLK().equals(zweiterLK)) || (getSchienenListeElement(i).getErsterLK() == zweiterLK && getSchienenListeElement(i).getZweiterLK() == ersterLK))
            {
                passendeSchienen[zaehler] = getSchienenListeElement(i);
                zaehler ++;
            }
        }
        return passendeSchienen;
    }

    public void eingabenDurchSchieneVornehmen(int nrDerSchiene)
    {
        // Eingaben für alle PF:
        if(getSchienenListeElement(nrDerSchiene - 1).getErsterLK().equals("MA") || getSchienenListeElement(nrDerSchiene - 1).getZweiterLK().equals("MA"))
        {
            // Simulierung der Eingabe in der Tabelle für MA als LK
        }
        // weitere IF-Abfragen für alle weiteren möglichen LKS

        if(getSchienenListeElement(nrDerSchiene - 1).getDrittesPF().equals("MA"))
        {
            // Simulierung der Eingabe in der Tabelle für MA als 3. PF
        }
        // weitere IF-Abfragen für alle weiteren möglichen Kurse als 3. PF

        if(getSchienenListeElement(nrDerSchiene - 1).getViertesPF().equals("MA"))
        {
            // Simulierung der Eingabe in der Tabelle für MA als 4. PF
        }
        // weitere IF-Abfragen für alle weiteren möglichen Kurse als 4. PF

        if(getSchienenListeElement(nrDerSchiene - 1).getFuenftesPF().equals("MA"))
        {
            // Simulierung der Eingabe in der Tabelle für MA als 5. PF
        }
        // weitere IF-Abfragen für alle weiteren möglichen Kurse als 5. PF

        // Eingaben für weitere Pflichtbelegungen:
        //
    }


}
