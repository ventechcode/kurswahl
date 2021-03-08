package kurswahl.models;

public class Kurs
{
    private String name; // z.B. Englisch
    private int aufgabenfeld; // z.B. 1. AF
    private int speziell; // z.B.FS
    private boolean q1; // jeweils belegt oder halt nicht
    private boolean q2;
    private boolean q3;
    private boolean q4;
    private int anzahlSemester; // z.B. 4 Semester
    private int pruefungsfach; // z.B. 5. PK oder LK
    private int anzahlPflichtsemester; // z.B. 4 Semester
    private boolean hauptfach; // ist ein Hauptfach (MA, DE, ENG, FR)

    // Verschiedene Varianten von aufgabenfeld
    // 1 => 1. Aufgabenfeld (Sprachliche und künstlerische Fächer)
    // 2 => 2. Aufgabenfeld (Gesellschaftswissenschaftliche Fächer)
    // 3 => 3. Aufgabenfeld (Naturwissenschaftliche Fächer)

    // Verschiedene Varianten von speziell
    // 0 => Keines
    // 1 => Naturwissenschaftliches Fach (NW)
    // 2 => Fremdsprache (FS)
    // 3 => Künstlerisches Fach (KF)
    // 4 => Zusatzkurs

    // Verschiedene Varianten von pruefungsfach
    // 1 => Kein PF
    // 2 => LK
    // 3 => 3. PF
    // 4 => 4. PF
    // 5 => 5. PK

     /**
     * Erweiterter Konstruktor der Klasse Kurs
     * @param name - Name des Kurses
     * @param aufgabenfeld - Offizielles Aufgabenfeld des Kurses
     * @param speziell - Spezielleres Aufgabenfeld des Kurses
     * @param q1 - Im 1. Semester belegt?
     * @param q2 - Im 2. Semester belegt?
     * @param q3 - Im 3. Semester belegt?
     * @param q4 - Im 4. Semester belegt?
     * @param anzahlSemester - Anzahl insgesamt belegter Semester
     * @param pruefungsfach - Art des Prüfungsfaches
     * @param anzahlPflichtsemester - Anzahl der pflichtmäßig zu belegenden Semester
     * @param hauptfach - ist das Fach ein Hauptfach?
     */
    public Kurs(String name, int aufgabenfeld, int speziell, boolean q1, boolean q2, boolean q3, boolean q4, int anzahlSemester, int pruefungsfach, int anzahlPflichtsemester, boolean hauptfach)
    {
        this.name = name;
        this.aufgabenfeld = aufgabenfeld;
        this.speziell = speziell;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.anzahlSemester = anzahlSemester;
        this.pruefungsfach = pruefungsfach;
        this.anzahlPflichtsemester = anzahlPflichtsemester;
        this.hauptfach = hauptfach;
    }

//    /**
//     * Standardkonstruktor der Klasse Kurs
//     * @param name - Name des Kurses
//     * @param aufgabenfeld - Aufgabenfeld des Kurses
//     * @param speziell - Spezielleres Aufgabenfeld des Kurses
//     */
//    public void Kurs(String name, int aufgabenfeld, int speziell)
//    {
//        Kurs(name, aufgabenfeld, speziell, false, false, false, false, 0, 0, 0);
//    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAufgabenfeld()
    {
        return aufgabenfeld;
    }

    public void setAufgabenfeld(int aufgabenfeld)
    {
        this.aufgabenfeld = aufgabenfeld;
    }

    public int getSpeziell()
    {
        return speziell;
    }

    public void setSpeziell(int speziell)
    {
        this.speziell = speziell;
    }

    public boolean getQ1()
    {
        return q1;
    }

    public void setQ1(boolean q1)
    {
        this.q1 = q1;
    }

    public boolean getQ2()
    {
        return q2;
    }

    public void setQ2(boolean q2)
    {
        this.q2 = q2;
    }

    public boolean getQ3()
    {
        return q3;
    }

    public void setQ3(boolean q3)
    {
        this.q3 = q3;
    }

    public boolean getQ4()
    {
        return q4;
    }

    public void setQ4(boolean q4)
    {
        this.q4 = q4;
    }

    public int getAnzahlSemester()
    {
        semesterAnzahlBerechnen();
        return anzahlSemester;
    }

    public void setAnzahlSemester(int anzahlSemester)
    {
        this.anzahlSemester = anzahlSemester;
    }

    public int getPruefungsfach()
    {
        return pruefungsfach;
    }

    public void setPruefungsfach(int pruefungsfach)
    {
        this.pruefungsfach = pruefungsfach;
    }

    public int getAnzahlPflichtsemester()
    {
        return anzahlPflichtsemester;
    }

    public void setAnzahlPflichtsemester(int anzahlPflichtsemester) { this.anzahlPflichtsemester = anzahlPflichtsemester; }

    public boolean getHauptfach()
    {
        return hauptfach;
    }

    public void setHauptfach(boolean hauptfach)
    {
        this.hauptfach = hauptfach;
    }

    /**
     * Berechnung der Anzahl an belegten Semestern im Kurs.
     */
    public void semesterAnzahlBerechnen()
    {
        anzahlSemester = 0; //Startwert in der Berechnung = 0

        //Addition +1 für jedes belegte Semester
        if(getQ1()){ anzahlSemester ++;}
        if(getQ2()){ anzahlSemester ++;}
        if(getQ3()){ anzahlSemester ++;}
        if(getQ4()){ anzahlSemester ++;}
    }

    @Override
    public String toString() {
        return getName() + ": " + getPruefungsfach() + ", " + getAnzahlPflichtsemester() + ", " + getQ1() + ", " + getQ2() + ", " + getQ3() + ", " + getQ4() + ", " + getAnzahlSemester();
    }
}