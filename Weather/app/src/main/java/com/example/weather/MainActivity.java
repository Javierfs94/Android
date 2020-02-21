package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    class WeatherInfo extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);

                int data = reader.read();
                String apiDetails = "";
                char current;

                while (data != -1){
                    current = (char) data;
                    apiDetails += current;
                    data = reader.read();
                }
                return apiDetails;

            }catch (Exception e){
                    e.printStackTrace();
            }


            return null;
        }
    }


    public void getWeatherInfo(View view){
        WeatherInfo weatherInfo = new WeatherInfo();

        EditText cityName = (EditText) findViewById(R.id.cityEditText);
        TextView weatherTextView = (TextView) findViewById(R.id.weatherTextView);

        try {

            if (cityName.getText().toString().isEmpty()){
                Toast.makeText(this,"Please Enter City Name!", Toast.LENGTH_SHORT).show();
                weatherTextView.setText("");
            }else {

                String weatherApiDetails = weatherInfo.execute("https://openweathermap.org/data/2.5/weather?q=" + cityName.getText().toString() + "&appid=b6907d289e10d714a6e88b30761fae22").get();

                JSONObject jsonObject = new JSONObject(weatherApiDetails);

                String weather = jsonObject.getString("weather");

                JSONArray arrayWeather = new JSONArray(weather);

                String weather_main = "";
                String weather_description = "";


                for (int z = 0; z < arrayWeather.length(); z++) {
                    JSONObject arrayObjectWeather = arrayWeather.getJSONObject(z);

                    weather_main = arrayObjectWeather.getString("main");
                    weather_description = arrayObjectWeather.getString("description");
                }

                weatherTextView.setText("Main: " + weather_main + "\n" +
                        "Desc : " + weather_description
                );

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
