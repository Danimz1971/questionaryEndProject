ackage com.example.android.questionaryEndProject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int numberStar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


            /**
             * This method is called for calcualte rate star bar
             */
        public void rating_bar(View view) {
            // Check log boolean state - Question 1
            CheckBox question1 = (CheckBox) findViewById(R.id.checkOne);
            boolean markQuestion1 = question1.isChecked();

            // Check log boolean state - Question 2
            CheckBox question2 = (CheckBox) findViewById(R.id.checkTwo);
            boolean markQuestion2 = question2.isChecked();

            // Check log boolean state - Question 3
            CheckBox question3 = (CheckBox) findViewById(R.id.checkThree);
            boolean markQuestion3 = question3.isChecked();

            // Check log boolean state - Question 4
            CheckBox question4 = (CheckBox) findViewById(R.id.checkFour);
            boolean markQuestion4 = question4.isChecked();

            // Check log boolean state - Question 5
            CheckBox question5 = (CheckBox) findViewById(R.id.checkFive);
            boolean markQuestion5 = question5.isChecked();

            // Check log boolean state - Question 6
            CheckBox question6 = (CheckBox) findViewById(R.id.checkSix);
            boolean markQuestion6 = question6.isChecked();

            // Check log boolean state - Question 7
            CheckBox question7 = (CheckBox) findViewById(R.id.checkSeven);
            boolean markQuestion7 = question7.isChecked();

            // Check log boolean state - Question 8
            CheckBox question8 = (CheckBox) findViewById(R.id.checkEight);
            boolean markQuestion8 = question8.isChecked();

            // Calculate rate star bar like question mark
            int markStar = calculateRate(markQuestion1, markQuestion2, markQuestion3, markQuestion4, markQuestion5, markQuestion6,
                    markQuestion7, markQuestion8);
        }
    private int calculateRate(Boolean markQuestion1, Boolean markQuestion2, Boolean markQuestion3, Boolean markQuestion4, Boolean markQuestion5, Boolean markQuestion6,
                              Boolean markQuestion7, Boolean markQuestion8) {
        // Calculate the number star of rate bar for mark question

        // If the user mark question 1
        if (markQuestion1) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 2
        if (markQuestion2) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 3
        if (markQuestion3) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 4
        if (markQuestion4) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 5
        if (markQuestion5) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 6
        if (markQuestion6) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 7
        if (markQuestion7) {
            numberStar = numberStar + 1;
        }

        // If the user If the user mark question 8
        if (markQuestion8) {
            numberStar = numberStar + 1;
        }

        // return numberStar what pass like rate_bar for display bar into xml
        return numberStar;
    }
    /**
     * This is to be debugged, I do not think it works, the value must be passed to the xml.
     * This method pass the number of star to bar
     */
    private void displayStar(int starMark) {
        RatingBar quantityRatingBar = findViewById(R.id.rating_bar);
        quantityRatingBar.getNumStars(starMark);
    }


    /**
     * This method will be for sendEmail whith all check list complet 
     * and and some security advice or graphic
     * NOT Operative
     */

     public void sendEmail(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        // Use an intent to launch an email app.
        // Send the (order_summary) CHANGE FOR CHECK LIST COMPLETED in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

    /**
     *
     * --------------------------------------------------------------------------------------
     * OLD CODE FOR COFFEE ORDER - I DID NOT DELETE IT IF I MISSED REFERENCE
     * Calculates the price of the order.
     *
     * @param addWhippedCream is whether or not we should include whipped cream topping in the price
     * @param addChocolate    is whether or not we should include chocolate topping in the price
     * @return total price

    /**
     * THIS IS OLD PART OF COFFEE ORDER APP - NOT USE - ONLY FOR VIEW IS REFORMAT CODE
     * This method is called when the plus button is clicked.
    public void increment(View view) {
    if (quantity == 100) {
    return;
    }
    quantity = quantity + 1;
    displayQuantity(quantity);
    }
     * This method is called when the minus button is clicked.
    public void decrement(View view) {
    if (quantity == 0) {
    return;
    }
    quantity = quantity - 1;
    displayQuantity(quantity);
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // First calculate the price of one cup of coffee
        int basePrice = 5;

        // If the user wants whipped cream, add $1 per cup
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        // If the user wants chocolate, add $2 per cup
        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        // Calculate the total order price by multiplying by the quantity
        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param name            on the order
     * @param price           of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate    is whether or not to add chocolate to the coffee
     * @return text summary

    private String createOrderSummary(String name, int price, boolean addWhippedCream,
                                      boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.order_summary_whipped_cream, addWhippedCream);
        priceMessage += "\n" + getString(R.string.order_summary_chocolate, addChocolate);
        priceMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
        priceMessage += "\n" + getString(R.string.order_summary_price,
                NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.

    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    } end mainActivity original

     */
