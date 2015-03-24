package testexams.gevapps.com.testexams.textexams.gevapps.com.testexams.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Geva on 23/03/2015.
 */
public class PointsCalculator {

    private int total;
    private float decrement;
    private boolean showAll;

    public PointsCalculator() {}

    public PointsCalculator(final int total, final float decrement, final boolean showAll) {
        this.total = total;
        this.decrement = decrement;
        this.showAll = showAll;
    }

    public List<Case> calculateResultsTable() {
        int numCorrects, numFails;
        List<Case> cases = new ArrayList<>();

        for(numFails = 0; numFails <= total; numFails++) {

            //10 * 0.25 = 2.5
            float negativeNote = numFails * decrement;

            for(numCorrects = total; numCorrects >= 0; numCorrects--) { //numCorrects = total; numCorrects >= numFails; numCorrects--
                /*40 <-> 10
                  30 <-> X*/

                float positiveNote = ((float)(numCorrects * 10))/total;
                float finalNote = positiveNote - negativeNote;
                int responses = numCorrects + numFails;

                if(showAll) {
                    if (responses <= total) {
                        cases.add(new Case(numCorrects, numFails, finalNote, responses));
                    }
                } else {
                    if (finalNote == 5 && responses <= total) {
                        cases.add(new Case(numCorrects, numFails, finalNote, responses));
                    }
                }
            }
        }
        return cases;
    }

}
