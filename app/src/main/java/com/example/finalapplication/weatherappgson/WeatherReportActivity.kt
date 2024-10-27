package com.example.finalapplication.weatherappgson

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivityWeatherReportBinding
import com.google.gson.Gson

class WeatherReportActivity : AppCompatActivity() {
    lateinit var binding: ActivityWeatherReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWeatherReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gson = Gson()

        val json = getJSONFromAsset()

//        Log.d("Weather Report", "${json}")

        val weatherReport = gson.fromJson(json, WeatherReport::class.java);

        if (weatherReport != null){
            Log.d("Weather Report", "Coordinates ${weatherReport.coord.lat} - ${weatherReport.coord.lon}")
            for (weather in weatherReport.weather){
                Log.d("Weather Report", "Weather: ${weather.id} - ${weather.main} - ${weather.description} - ${weather.icon}")
            }
            Log.d("Weather Report", "Base: ${weatherReport.base}")
            Log.d("Weather Report", "Main: ${weatherReport.main.temp} - ${weatherReport.main.feels_like} - ${weatherReport.main.temp_min} - ${weatherReport.main.temp_max} - ${weatherReport.main.pressure} - ${weatherReport.main.humidity}")
            Log.d("Weather Report", "Visibility: ${weatherReport.visibility}")
            Log.d("Weather Report","Wind: Speed ${weatherReport.wind.speed} - deg ${weatherReport.wind.deg}")
            Log.d("Weather Report", "Cloud: ${weatherReport.clouds.all}")
            Log.d("Weather Report", "DT: ${weatherReport.dt}")
            Log.d("Weather Report", "Sys: Id ${weatherReport.sys.id} - COuntry ${weatherReport.sys.country} - Sunrise ${weatherReport.sys.sunrise} - SunSet ${weatherReport.sys.sunset}")
            Log.d("Weather Report", "TimeZone: ${weatherReport.timezone}")
            Log.d("Weather Report", "Id: ${weatherReport.id}")
            Log.d("Weather Report", "Name: ${weatherReport.name}")
            Log.d("Weather Report", "Cod: ${weatherReport.cod}")
        }


    }

    private fun getJSONFromAsset(): String? {
        var json: String? = null
        var charset = Charsets.UTF_8
        try{

            val weatherJSONFile = assets.open("weather.json");
            val size = weatherJSONFile.available()
            val buffer = ByteArray(size)

            weatherJSONFile.read(buffer)
            weatherJSONFile.close()

            json = String(buffer, charset)


        }catch (e:Exception){
            e.printStackTrace()
        }

        return json;
    }
}