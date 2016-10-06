package com.example.brain.vectorcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

import static java.lang.StrictMath.sqrt;


public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.brain.vectorcalculator.MESSAGE";

    Button button1, button2, button3, button4, button5;

    EditText A1, A2, A3, B1, B2, B3;

    TextView result;

    double[] vectorA = new double[3];
    double[] vectorB = new double[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        A1 = (EditText) findViewById(R.id.A1);
        A2 = (EditText) findViewById(R.id.A2);
        A3 = (EditText) findViewById(R.id.A3);
        B1 = (EditText) findViewById(R.id.B1);
        B2 = (EditText) findViewById(R.id.B2);
        B3 = (EditText) findViewById(R.id.B3);
        result = (TextView) findViewById(R.id.txtResult);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean fieldsOK = validate(new EditText[]{A1,A2,A3,B1,B2,B3});

                if(fieldsOK) {

                    setVectors();

                    result.setText("");

                    addVectors(vectorA, vectorB);
                }

                else {
                    result.setText("Some of the fields are empty");
                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean fieldsOK = validate(new EditText[]{A1,A2,A3,B1,B2,B3});

                if(fieldsOK) {

                    setVectors();

                    result.setText("");

                    subVectors(vectorA, vectorB);
                }

                else {
                    result.setText("Some of the fields are empty");
                }
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean fieldsOK = validate(new EditText[]{A1,A2,A3,B1,B2,B3});

                if(fieldsOK) {

                    setVectors();

                    result.setText("");

                    dotVectors(vectorA, vectorB);
                }

                else {
                    result.setText("Some of the fields are empty");
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean fieldsOK = validate(new EditText[]{A1,A2,A3,B1,B2,B3});

                if(fieldsOK) {

                    setVectors();

                    result.setText("");

                    crossVectors(vectorA, vectorB);
                }

                else {
                    result.setText("Some of the fields are empty");
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean fieldsOK = validate(new EditText[]{A1,A2,A3,B1,B2,B3});

                if(fieldsOK) {

                    setVectors();

                    result.setText("");

                    vectorsLength(vectorA, vectorB);
                }

                else {
                    result.setText("Some of the fields are empty");
                }
            }
        });

    }

    private void setVectors() {

        vectorA[0] = Double.parseDouble(A1.getText().toString());
        vectorA[1] = Double.parseDouble(A2.getText().toString());
        vectorA[2] = Double.parseDouble(A3.getText().toString());
        vectorB[0] = Double.parseDouble(B1.getText().toString());
        vectorB[1] = Double.parseDouble(B2.getText().toString());
        vectorB[2] = Double.parseDouble(B3.getText().toString());

    }

    private boolean validate(EditText[] fields) {

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().toString().length() == 0) {
                return false;
            }
        }
        return true;
    }


    private void addVectors(double[] x, double[] y) {

        double[] addResult = new double[3];

        for (int i = 0; i < 3; i++)
        {
            addResult[i] = x[i] + y[i];
        }

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String oper_result = Arrays.toString(addResult);
        intent.putExtra(EXTRA_MESSAGE, oper_result);
        startActivity(intent);

    }

    private void subVectors(double[] x, double[] y)
    {
        double[] subResult = new double[3];
        for (int i = 0; i < 3; i++)
        {
            subResult[i] = x[i] - y[i];
        }

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String oper_result = Arrays.toString(subResult);
        intent.putExtra(EXTRA_MESSAGE, oper_result);
        startActivity(intent);

    }


    void dotVectors(double[] x, double[] y)
    {
        double dotResult = 0;

        for (int i = 0; i < 3; i++)
        {
            dotResult = dotResult + (x[i] * y[i]);
        }

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String oper_result = Double.toString(dotResult);
        intent.putExtra(EXTRA_MESSAGE, oper_result);
        startActivity(intent);

    }

    void crossVectors(double[] x, double[] y)
    {
        double[] crossResult = new double[3];

        crossResult[0] = (x[1] * y[2]) - (x[2] * y[1]);
        crossResult[1] = (x[2] * y[0]) - (x[0] * y[2]);
        crossResult[2] = (x[0] * y[1]) - (x[1] * y[0]);

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String oper_result = Arrays.toString(crossResult);
        intent.putExtra(EXTRA_MESSAGE, oper_result);
        startActivity(intent);
    }

    void vectorsLength(double[] x, double[] y)
    {
        double[] Lengths = new double[2];
        String Length_A;
        String Length_B;

        Lengths[0] = sqrt(Math.pow(x[0], 2) + Math.pow(x[1], 2) + Math.pow(x[2], 2));
        Lengths[1] = sqrt(Math.pow(y[0], 2) + Math.pow(y[1], 2) + Math.pow(y[2], 2));

        Length_A = "Length of A: " + Double.toString(Lengths[0]);
        Length_B = "Length of B: " + Double.toString(Lengths[1]);


        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String oper_result = Length_A + "\n\n" + Length_B;
        intent.putExtra(EXTRA_MESSAGE, oper_result);
        startActivity(intent);
    }

}
