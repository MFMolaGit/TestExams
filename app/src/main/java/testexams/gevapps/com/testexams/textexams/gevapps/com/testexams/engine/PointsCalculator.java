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
    private ShowOption showOption;

    public PointsCalculator() {}

    public PointsCalculator(final int total, final float decrement, final ShowOption showOption) {
        this.total = total;
        this.decrement = decrement;
        this.showOption = showOption;
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

				boolean addResult = false;
				
				switch(showOption) {
					case ALL:
						if (responses <= total) {
							addResult = true;
						}
						break;
					
					case ONLYPASS:
						if (finalNote == 5 && responses <= total) {
							addResult = true;
						}
						break;
						
					case PASS:
						if (finalNote >= 5 && responses <= total) {
							addResult = true;
						}
						break;	
				}
				
                if (addResult) {
                   cases.add(new Case(numCorrects, numFails, finalNote, responses));
                }
            }
        }
        return cases;
    }

}
