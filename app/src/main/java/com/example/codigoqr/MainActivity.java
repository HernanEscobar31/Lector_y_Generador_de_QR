package com.example.codigoqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    ImageView codigoQR;
    EditText datos;
    Button crear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigoQR= findViewById(R.id.codigoQR);
        datos= findViewById(R.id.datos);
        crear= findViewById(R.id.crear);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    //Segun el video tambien podemos pedir estos datos solo hya que concatenar con el datos
                    //Telefono es: tel:
                    //SMS es: numero:mensaje
                    //Correo: mailto
                    BarcodeEncoder  barcodeEncoder= new BarcodeEncoder();
                    Bitmap bitmap= barcodeEncoder.encodeBitmap(
                            //"tel:"+datos.getText().toString(),
                            //"4271448433:Hola esto es una prueba"+datos.getText().toString(),
                           "mailto:"+datos.getText().toString(),
                            //datos.getText().toString(),
                            BarcodeFormat.QR_CODE,
                            750,
                            750
                    );
                    codigoQR.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
   public void ventana2(View view){
        Intent v1 = new Intent(MainActivity.this, Scanner.class);
        startActivity(v1);
   }
}