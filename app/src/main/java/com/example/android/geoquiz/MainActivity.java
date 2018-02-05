package com.example.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int correctAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {
        String messageToast;
        correctAnswer = 0;
        int allQuestions = 5;
        int questionNumber = 0;

        /**
         * Zero question collect Check Box status
         * */
        CheckBox asiaCheckBox = findViewById(R.id.asia_check);
        CheckBox africaCheckBox = findViewById(R.id.africa_check);
        CheckBox americaCheckBox = findViewById(R.id.america_check);
        questionNumber++;
        messageToast = collectCheckBoxAnswers(questionNumber, asiaCheckBox, africaCheckBox, americaCheckBox);


        /**
         * First question collect Radio Button status
         * */
        RadioButton asiaRadio = findViewById(R.id.asia_radio);
        RadioButton europeRadio = findViewById(R.id.europe_radio);
        RadioButton americaRadio = findViewById(R.id.america_radio);
        questionNumber++;
        messageToast += checkRadioButtonAnswers(questionNumber, asiaRadio, europeRadio, americaRadio);

        /**
         * Second question collect Radio Button status
         * */
        RadioButton heraRadio = findViewById(R.id.hera_radio);
        RadioButton zeusRadio = findViewById(R.id.zeus_radio);
        RadioButton poseidonRadio = findViewById(R.id.poseidon_radio);
        questionNumber++;
        messageToast += checkRadioButtonAnswers(questionNumber, zeusRadio, poseidonRadio, heraRadio);

        /**
         * Third question collect Radio Button status
         * */
        RadioButton europeHungaryRadio = findViewById(R.id.europeHungary_radio);
        RadioButton asiaHungaryRadio = findViewById(R.id.asiaHungary_radio);
        RadioButton africaHungaryRadio = findViewById(R.id.africaHungary_radio);
        questionNumber++;
        messageToast += checkRadioButtonAnswers(questionNumber, europeHungaryRadio, asiaHungaryRadio, africaHungaryRadio);

        /**
         * Forth question collect Radio Button status
         * */
        RadioButton budapestRadio = findViewById(R.id.budapest_radio);
        RadioButton bucharestRadio = findViewById(R.id.bucharest_radio);
        RadioButton moscowRadio = findViewById(R.id.moscow_radio);
        questionNumber++;
        messageToast += checkRadioButtonAnswers(questionNumber, budapestRadio, bucharestRadio, moscowRadio);

        /**
         * Set the input name into a variable from the EditBox field
         */
        EditText nameInput = (EditText) findViewById(R.id.name_edittext);
        String name = nameInput.getText().toString();

        messageToast += "\n" + allQuestions + "/" + correctAnswer + "\n";
        messageToast += "\n" + getString(R.string.dear) + " " + name + " " + getString(R.string.thank_you);


        /**
         * Show the result in a Toast message on the screen
         * */
        Toast toast = Toast.makeText(this, messageToast, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Counts the correct answers in the Radio Buttons and
     *
     * @returns a String message with the result
     */

    public String checkRadioButtonAnswers(int questionNum, RadioButton firstRadio, RadioButton secondRadio, RadioButton thirdRadio) {

        String message = "";
        if (firstRadio.isChecked()) {
            correctAnswer++;
            message = questionNum + " " + getString(R.string.answer) + " :- OK" + "\n";
        } else if (secondRadio.isChecked()) {
            message = questionNum + " " + getString(R.string.answer) + " :- NOT OK" + "\n";
        } else if (thirdRadio.isChecked()) {
            message = questionNum + " " + getString(R.string.answer) + " answer:- NOT OK" + "\n";
        }
        return message;
    }

    /**
     * Counts the correct answers in the Check box and
     *
     * @returns a String message with the result
     */
    public String collectCheckBoxAnswers(int questionNum, CheckBox first, CheckBox second, CheckBox third) {

        String message = "";
        if ((first.isChecked() && second.isChecked())) {
            correctAnswer++;
            message = questionNum + " " + getString(R.string.answer) + " :- OK" + "\n";
        } else {
            message = questionNum + " " + getString(R.string.answer) + " :- NOT OK" + "\n";
        }
        return message;
    }


}
