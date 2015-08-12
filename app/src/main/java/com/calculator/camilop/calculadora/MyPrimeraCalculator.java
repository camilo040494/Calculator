package com.calculator.camilop.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ArbolOperaciones.Arbol;


public class MyPrimeraCalculator extends Activity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnEq,btnSum,btnMult,btnSub,btnDiv,btnAc,btnCe;
    private TextView lastOperation;
    private EditText operation;
    private String funcion;
    private boolean terminaOperador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_primera_calculator);
        terminaOperador = false;
        initializer();
        eventitializer();
    }

    public void initializer(){
        terminaOperador = false;
        btn0=(Button)findViewById(R.id.btn_0);
        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);
        btn3=(Button)findViewById(R.id.btn_3);
        btn4=(Button)findViewById(R.id.btn_4);
        btn5=(Button)findViewById(R.id.btn_5);
        btn6=(Button)findViewById(R.id.btn_6);
        btn7=(Button)findViewById(R.id.btn_7);
        btn8=(Button)findViewById(R.id.btn_8);
        btn9=(Button)findViewById(R.id.btn_9);
        btnEq=(Button)findViewById(R.id.btn_eq);
        btnSum=(Button)findViewById(R.id.btn_sum);
        btnMult=(Button)findViewById(R.id.btn_mult);
        btnSub=(Button)findViewById(R.id.btn_sub);
        btnDiv=(Button)findViewById(R.id.btn_div);
        btnAc=(Button)findViewById(R.id.btn_ac);
        btnCe=(Button)findViewById(R.id.btn_ce);

        lastOperation=(TextView)findViewById(R.id.text_last_operation);

        operation=(EditText)findViewById(R.id.edit_operation);
    }


    private void eventitializer() {
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText(operation.getText().toString()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if (terminaOperador)
                terminaOperador = false;
                operation.setText(operation.getText().toString()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador)
                    terminaOperador = false;
                operation.setText(operation.getText().toString()+"9");
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador && operation.getText().length()!=0){
                    String temp = operation.getText().toString().substring(0, operation.getText().toString().length() - 1);
                    operation.setText(temp+"+");
                }else if (operation.getText().length()==0){
                    operation.setText("0+");
                }else{
                    operation.setText(operation.getText().toString()+"+");
                    terminaOperador =true;
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador && operation.getText().length()!=0){
                    String temp = operation.getText().toString().substring(0, operation.getText().toString().length() - 1);
                    operation.setText(temp+"-");
                }else if (operation.getText().length()==0){
                    operation.setText("0-");
                }else{
                    operation.setText(operation.getText().toString()+"-");
                    terminaOperador =true;
                }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador && operation.getText().length()!=0){
                    String temp = operation.getText().toString().substring(0, operation.getText().toString().length() - 1);
                    operation.setText(temp+"*");
                }else if (operation.getText().length()==0){
                    operation.setText("0*");
                }else{
                    operation.setText(operation.getText().toString()+"*");
                    terminaOperador =true;
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador && operation.getText().length()!=0){
                    String temp = operation.getText().toString().substring(0, operation.getText().toString().length() - 1);
                    operation.setText(temp+"/");
                }else if (operation.getText().length()==0){
                    operation.setText("0/");
                }else{
                    operation.setText(operation.getText().toString()+"/");
                    terminaOperador =true;
                }
            }
        });

        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("");
            }
        });

        btnCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = operation.getText().toString().length()==0?"":operation.getText().toString().substring(0,operation.getText().toString().length()-1);
                operation.setText(temp);
            }
        });

        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminaOperador){
                    Toast.makeText(getApplicationContext(), "Su operacion debe terminar en un numero", Toast.LENGTH_SHORT).show();
                    return;
                }
                String temp = operation.getText().toString();
                lastOperation.setText(temp+"=");
                temp = operar(temp);
                operation.setText(temp);
            }
        });
    }
    //TODO hacerlo con stringbluider
    public String operar(String operacion){

        String[] caracter=operacion.split("");
        ArrayList<String> expresion= new ArrayList<String>();
        String num="";
        for (int i=1; i<caracter.length; i++){
            if (caracter[i].equals("+") || caracter[i].equals("*") || caracter[i].equals("/") || caracter[i].equals("-")) {
                expresion.add(num);
                expresion.add(caracter[i]);
                num="";
            }else{
                num+=caracter[i];
            }
        }
        expresion.add(num);

        Arbol arbol = new Arbol();
        for (String string : expresion) {
            arbol.agregar(string);
        }

        arbol.operar();

        String respuesta = arbol.darValorRaiz();
        operacion+="="+respuesta;

        lastOperation.setText(operacion);
        operation.setText("");

        return "";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_primera_calculator, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
