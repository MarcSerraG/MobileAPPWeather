package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReport;

public class CityWeatherHourlyAdapter extends RecyclerView.Adapter<CityWeatherHourlyAdapter.ViewHolder> {

    ArrayList<WeatherReport> weatherHourly;

    public CityWeatherHourlyAdapter(ArrayList<WeatherReport> weatherHourly){
        this.weatherHourly = new ArrayList<WeatherReport>(weatherHourly.subList(0, 25));
    }

    @NonNull
    @Override
    public CityWeatherHourlyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city_weather_hour_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherReport weatherReport = weatherHourly.get(position);

        Date date = new Date(weatherReport.getTimestamp()*1000);
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
        String hour = formater.format(date);


        holder.humidity.setText(""+weatherReport.getHumidity()+" %");
        holder.temperature.setText(""+(int)weatherReport.getTemperature()+" ºC");
        holder.time.setText(hour);

        Glide.with(holder.itemView.getContext())
                .load(weatherReport.getIconURL())
                .into(holder.weatherImage);

    }

    @Override
    public int getItemCount() {
        return weatherHourly.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView time, humidity, temperature;
        private ImageView weatherImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.tv_time_hourly);
            humidity = itemView.findViewById(R.id.tv_humidity_hourly);
            temperature = itemView.findViewById(R.id.tv_temperature_hourly);
            weatherImage = itemView.findViewById(R.id.im_weather_humidity_hourly);
        }
    }
}
