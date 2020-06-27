package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> implements Filterable {

    List<City> citiesList;
    List<City> citiesListAll;

    public CityListAdapter(List<City> citiesList){
        this.citiesList = citiesList;
        this.citiesListAll = new ArrayList<>(citiesList);
    }

    @NonNull
    @Override
    public CityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CityListAdapter.ViewHolder holder, int position) {
        City aCity = citiesList.get(position);
        String urlImage = "https://www.countryflags.io/"+aCity.getCountry()+"/shiny/64.png";
        holder.tv_city_name.setText(aCity.getName());
        Glide.with(holder.itemView.getContext())
                .load(urlImage)
                .into(holder.cityImage);
    }

    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<City> filtered = new ArrayList<>();

            if (constraint.toString().isEmpty()){
                filtered.addAll(citiesListAll);
            }else{
                for (City city : citiesListAll){
                    if (city.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filtered.add(city);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filtered;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            citiesList.clear();
            citiesList.addAll((Collection<? extends City>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView cityImage;
        public TextView tv_city_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cityImage = itemView.findViewById(R.id.img_city_flag);
            tv_city_name = itemView.findViewById(R.id.tv_city_name);
        }

        @Override
        public void onClick(View v) {
            //TODO
        }
    }
}
