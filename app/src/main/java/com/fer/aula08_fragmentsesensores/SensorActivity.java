package com.fer.aula08_fragmentsesensores;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
   ImageView btnVoltar;
   TextView titulo, texto;
   long timeUpdate;
   SensorManager sensorManager;
   boolean trocaCor = false;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sensor);
      btnVoltar = findViewById(R.id.btn_voltar);
      titulo = findViewById(R.id.titulo);
      texto = findViewById(R.id.txt_sensor);
      sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
      timeUpdate = System.currentTimeMillis();

      btnVoltar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent ooo = new Intent(SensorActivity.this, MainActivity.class);
            startActivity(ooo);
            finish();
         }
      });
   }

   private void getAcelerometro(SensorEvent event, TextView txt){
      float[] valores = event.values;
      float x = valores[0];
      float y = valores[1];
      float z = valores[2];

      float equacao = (float) ( (Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2)) / Math.pow(SensorManager.GRAVITY_EARTH,2));
      long horaAtual = event.timestamp;

      if(equacao >=2){
         if((horaAtual = timeUpdate) < 200){
            return;
         }
         timeUpdate = horaAtual;
         if(trocaCor){
            texto.setTextColor(Color.MAGENTA);
         }
         else {
            texto.setTextColor(Color.CYAN);
         }
         trocaCor = !trocaCor;
      }
   }

   @Override
   protected void onResume() {
      super.onResume();
      sensorManager.registerListener(
              (SensorEventListener) this,
              sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
              SensorManager.SENSOR_DELAY_NORMAL);
   }

   @Override
   protected void onPause() {
      super.onPause();
      sensorManager.unregisterListener((SensorEventListener) this);
   }


   @Override
   public void onSensorChanged(SensorEvent sensorzinho) {
      if(sensorzinho.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
         getAcelerometro(sensorzinho, texto);
      }
   }

   @Override
   public void onAccuracyChanged(Sensor sensor, int i) {

   }
}
