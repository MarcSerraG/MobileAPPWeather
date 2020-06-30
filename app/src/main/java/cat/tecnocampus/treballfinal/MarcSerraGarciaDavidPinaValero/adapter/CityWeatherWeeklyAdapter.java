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
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReportDaily;

public class CityWeatherWeeklyAdapter extends RecyclerView.Adapter<CityWeatherWeeklyAdapter.ViewHolder> {

    ArrayList<WeatherReportDaily> reportList;

    public CityWeatherWeeklyAdapter(ArrayList<WeatherReportDaily> reportList) {
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public CityWeatherWeeklyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city_weather_daily_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CityWeatherWeeklyAdapter.ViewHolder holder, int position) {

        WeatherReportDaily report = reportList.get(position);

        Date date = new Date(report.getTimestamp()*1000);
        SimpleDateFormat formater = new SimpleDateFormat("EEEE MMM d");
        String day = formater.format(date);

        holder.tv_daily_weather_description.setText(report.getDescription().toUpperCase());
        holder.tv_max_temperature.setText(""+(int)report.getTemperatureMax()+" ºC");
        holder.tv_min_temperature.setText(""+(int)report.getTemperatureMin()+" ºC");
        holder.tv_humidity.setText(""+report.getHumidity()+" %");
        holder.tv_date.setText(""+day);

        Glide.with(holder.itemView.getContext())
                .load(report.getIconURL())
                .into(holder.im_weather_image);

    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView im_weather_image;
        public TextView tv_daily_weather_description;
        public TextView tv_max_temperature;
        public TextView tv_min_temperature;
        public TextView tv_humidity;
        public TextView tv_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            im_weather_image = itemView.findViewById(R.id.im_daily_weather);
            tv_daily_weather_description = itemView.findViewById(R.id.tv_daily_weather_description);
            tv_max_temperature = itemView.findViewById(R.id.tv_max_daily_temperature);
            tv_min_temperature = itemView.findViewById(R.id.tv_min_daily_temperature);
            tv_humidity = itemView.findViewById(R.id.tv_daily_humidity);
            tv_date = itemView.findViewById(R.id.tv_daily_date);

        }
    }
}
