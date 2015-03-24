package testexams.gevapps.com.testexams.textexams.gevapps.com.testexams.engine;

/**
 * Created by Geva on 23/03/2015.
 */
public class Case {

    private int numResponses;
    private int numCorrects;
    private int numFails;
    private float note;

    public Case(final int numCorrects, final int numFails, final float note, final int numResponses) {
        this.numCorrects = numCorrects;
        this.numFails = numFails;
        this.note = note;
        this.numResponses = numResponses;
    }

    public int getNumCorrects() {
        return numCorrects;
    }

    public void setNumCorrects(int numCorrects) {
        this.numCorrects = numCorrects;
    }

    public int getNumFails() {
        return numFails;
    }

    public void setNumFails(int numFails) {
        this.numFails = numFails;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getNumResponses() {
        return numResponses;
    }

    public void setNumResponses(int numResponses) {
        this.numResponses = numResponses;
    }
}
