package testexams.gevapps.com.testexams;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import testexams.gevapps.com.testexams.textexams.gevapps.com.testexams.engine.Case;
import testexams.gevapps.com.testexams.textexams.gevapps.com.testexams.engine.PointsCalculator;


public class InitialActivity extends ActionBarActivity {

    private PointsCalculator calculator;
    private TableLayout resultsTable;
    private EditText totalField, decrementField;
    private Switch switchShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        totalField = (EditText) findViewById(R.id.totalField);
        decrementField = (EditText) findViewById(R.id.decrementField);
        resultsTable = (TableLayout) findViewById(R.id.resultsTable);
        switchShow = (Switch) findViewById(R.id.switchShow);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_initial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getBaseContext(), "Creado por Manuel Fco Mola Mateos - Gevapps Home",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculatePosibilities(View view) {
        int total = Integer.parseInt(totalField.getText().toString());
        float decrement = Float.parseFloat(decrementField.getText().toString());

            calculator = new PointsCalculator(total, decrement, switchShow.isChecked());

        List<Case> posibilities = calculator.calculateResultsTable();

        Context context = getBaseContext();
        TableRow.LayoutParams baseParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        int position = 0;

            resultsTable.removeViews(1, resultsTable.getChildCount()-1);

            for(Case caseValue:posibilities) {

                TableRow row = new TableRow(context);
                         row.setGravity(Gravity.CENTER);

                TextView responses = new TextView(context);
                    responses.setText(String.valueOf(caseValue.getNumResponses()));
                    responses.setLayoutParams(baseParams);
                    responses.setGravity(Gravity.CENTER);
                    responses.setTextColor(view.getResources().getColor(R.color.black));
                    row.addView(responses);

                TextView corrects = new TextView(context);
                    corrects.setText(String.valueOf(caseValue.getNumCorrects()));
                    corrects.setLayoutParams(baseParams);
                    corrects.setGravity(Gravity.CENTER);
                    corrects.setTextColor(view.getResources().getColor(R.color.black));
                    row.addView(corrects);

                TextView fails = new TextView(context);
                    fails.setText(String.valueOf(caseValue.getNumFails()));
                    fails.setLayoutParams(baseParams);
                    fails.setGravity(Gravity.CENTER);
                    fails.setTextColor(view.getResources().getColor(R.color.black));
                    row.addView(fails);

                TextView note = new TextView(context);
                    note.setText(String.valueOf(caseValue.getNote()));
                    note.setLayoutParams(baseParams);
                    note.setGravity(Gravity.CENTER);
                    note.setTextColor(view.getResources().getColor(R.color.black));
                    row.addView(note);

                if(position++ % 2 == 0) {
                    row.setBackgroundColor(view.getResources().getColor(R.color.odd_row));
                } else {
                    row.setBackgroundColor(view.getResources().getColor(R.color.even_row));
                }

                resultsTable.addView(row);
            }

        resultsTable.setVisibility(View.VISIBLE);
    }

}
