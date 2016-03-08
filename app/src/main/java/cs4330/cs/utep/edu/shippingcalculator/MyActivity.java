package cs4330.cs.utep.edu.shippingcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.MenuItem;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity{
    //Data Model for Ship Item
    private ShipItem shipItem;

    //View Object for layout UI reference
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstaceState){
        //Task 1: Set Activity Content
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_my);

        //Task 2: Creata a data model for storing an item to be shipped
        shipItem = new ShipItem();

        //Task 3: Establish the refeneces to input the weigtht element
        weightET = (EditText) findViewById(R.id.editText1);

        //Task 4: Establish the refences to output elements
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        //Task 5: Registe the Listener even for weight input
        weightET.addTextChangedListener(weightTextWatcher);


    }

    private TextWatcher weightTextWatcher = new TextWatcher() {

        //The input Element is attached to an editable,
        //therefore these methods are called when the text is changed

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                shipItem.setWeight((int) Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void afterTextChanged(Editable s) {}
    };

    private void displayShipping(){
        //Display the base cost, added cost, and total cost
        baseCostTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f", shipItem.getAddedCost()));
        totalCostTV.setText(("$" + String.format("%.02f", shipItem.getTotalCost())));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item click here. The action bar will
        // automatically handle clicks on the Home/Up button. so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.action_settings)
            return true;
        return super.onOptionsItemSelected(item);
    }

}
