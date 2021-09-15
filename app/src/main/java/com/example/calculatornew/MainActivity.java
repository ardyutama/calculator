package com.example.calculatornew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatornew.databinding.ActivityMainBinding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView tampilAngka;
    TextView resultAngka;
    String workings = "";
//    Button btnOne;
//    Button btnTwo;
//    Button btnThree;
//    TextView resultAngka;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);
            initTextViews();
//        initComponent();
    }

//    private void initComponent() {
//        btnOne = (Button) findViewById(R.id.btnOne);
//    }

    private void initTextViews() {
        tampilAngka = (TextView)findViewById(R.id.hitungAngka);
        resultAngka = (TextView)findViewById(R.id.resultAngka);
    }

    public String getWorkings() {
        return workings;
    }

    public void setWorkings(String givenValue) {
        workings = workings + givenValue;
        tampilAngka.setText(workings);
    }
    public void threeZeroOnClick(View view){
        setWorkings("000");
    }
    public void zeroOnClick(View view){
        setWorkings("0");
    }

    public void oneOnClick(View view){
        setWorkings("1");
    }

    public void twoOnClick(View view){
        setWorkings("2");
    }

    public void threeOnClick(View view){
        setWorkings("3");
    }

    public void fourOnClick(View view){
        setWorkings("4");
    }
    public void fiveOnClick(View view){
        setWorkings("5");
    }
    public void sixOnClick(View view){
        setWorkings("6");
    }
    public void sevenOnClick(View view){
        setWorkings("7");
    }
    public void eightOnClick(View view){
        setWorkings("8");
    }
    public void nineOnClick(View view){
        setWorkings("9");
    }
    public void divideOnClick(View view){
        setWorkings("/");
    }
    public void plusOnClick(View view){
        setWorkings("+");
    }
    public void minusOnClick(View view){
        setWorkings("-");
    }
    public void modulusOnClick(View view){
        setWorkings("%");
    }
    public void pointOnClick(View view){
        setWorkings(".");
    }
    public void timesOnClick(View view){
        setWorkings("*");
    }
    public void zeroThreeOnClick(View view) {setWorkings("000");}

    public void clearOnClick(View view){
        tampilAngka.setText("");
        workings = "";
        resultAngka.setText("");
    }
    public void equalsOnClick(View view){
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result=(double)engine.eval(workings);
        } catch (ScriptException e){
            Toast.makeText(this,"Input tidak Sesuai",Toast.LENGTH_SHORT).show();
        }
        if(result != null)
            resultAngka.setText(String.valueOf(result.doubleValue()));
    }


    public void eraseOnClick(View view) {
        StringBuffer sb= new StringBuffer(workings);
        workings = "";
        sb.deleteCharAt(sb.length()-1);
        workings = String.valueOf(sb);
        tampilAngka.setText(workings);
    }


}