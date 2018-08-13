package com.example.mostafaeisam.findstation3.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mostafaeisam.findstation3.R;
import com.example.mostafaeisam.findstation3.activites.DetailsActivity;
import com.example.mostafaeisam.findstation3.activites.MainActivity;
import com.example.mostafaeisam.findstation3.classes.Station;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class stationsRecyclerViewAapter extends RecyclerView.Adapter<stationsRecyclerViewAapter.ViewHolder> {

    private Context Context;
    private List<Station> stations;

    public stationsRecyclerViewAapter(Context context, List<Station> stations) {
        this.Context = context;
        this.stations = stations;
    }

    @NonNull
    @Override
    public stationsRecyclerViewAapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_stations, parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Station station = stations.get(position);
        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.mIvNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailsIntent = new Intent(v.getContext(), DetailsActivity.class);
                detailsIntent.putExtra("intentCode",2);
                detailsIntent.putExtra("stationTitle",station.getTitle());
                detailsIntent.putExtra("stationAddress",station.getAddress());
                detailsIntent.putExtra("stationLatPosition",station.getPosition().getLat());
                detailsIntent.putExtra("stationLngPosition",station.getPosition().getLng());
                detailsIntent.putExtra("stationImageUrl",station.getCompany().get_image().getUrl());
                Context.startActivity(detailsIntent);
            }
        });

        viewHolder.mTvAddress.setText(station.getAddress());
        viewHolder.mTvTitle.setText(station.getTitle());
        viewHolder.mTvGas91Price.setText(String.valueOf(station.getGas91Price()));
        viewHolder.mTvGas95Price.setText(String.valueOf(station.getGas95Price()));
        viewHolder.mTvDslPrice.setText(String.valueOf(station.getDieselPrice()));
        viewHolder.mTvGas91Currency.setText(station.getCurrency().getEnCurrency());
        viewHolder.mTvGas95Currency.setText(station.getCurrency().getEnCurrency());
        viewHolder.mTvDslCurrency.setText(station.getCurrency().getEnCurrency());
        viewHolder.mRatingBar.setRating(station.getRating());
        //set RatingBar Stars Colors
        LayerDrawable stars = (LayerDrawable) viewHolder.mRatingBar.getProgressDrawable();
        stars.setColorFilter(Color.parseColor("#47B0DB"), PorterDuff.Mode.SRC_ATOP);

        Picasso.get()
                .load(station.getCompany().get_image().getUrl())
                .placeholder(R.drawable.avatar_icon)
                .fit()
                .into(viewHolder.mIvStationImage);

        stationIsHasRestaurantImageView(station, viewHolder);
        stationIsHasMasjidImageView(station, viewHolder);
        stationIsHasCafeImageView(station, viewHolder);
        stationIsHasLadiesWCImageView(station, viewHolder);
        stationIsHasMensWCImageView(station, viewHolder);
        stationIsHasHotelImageView(station, viewHolder);
        stationIsHasATMImageView(station, viewHolder);

    }

    private void stationIsHasATMImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasATM()==false){
            viewHolder.mIvHasATM.setVisibility(View.GONE);
        }else {
            viewHolder.mIvHasATM.setImageResource(R.drawable.atm);
        }
    }

    private void stationIsHasHotelImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasHotel()==false){
            viewHolder.mIvHasHotel.setVisibility(View.GONE);
        }else {
            viewHolder.mIvHasHotel.setImageResource(R.drawable.hotel_ico);
        }
    }

    private void stationIsHasMensWCImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasMensWC()==false){
            viewHolder.mIvHasMensWC.setVisibility(View.GONE);
        }else {
            viewHolder.mIvHasMensWC.setImageResource(R.drawable.toilet_male);
        }
    }

    private void stationIsHasLadiesWCImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasLadiesWC()==false){
            viewHolder.mIvHasLadiesWC.setVisibility(View.GONE);
        }else {
            viewHolder.mIvHasLadiesWC.setImageResource(R.drawable.toilet_female);
        }
    }

    private void stationIsHasCafeImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasCafe()==false){
            viewHolder.mIvHasCafe.setVisibility(View.GONE);
        }else {
            viewHolder.mIvHasCafe.setImageResource(R.drawable.coffee_ico);
        }
    }

    private void stationIsHasMasjidImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasMasjid()==false){
            viewHolder.mIvHasMasjid.setVisibility(View.GONE);
        }else {
            viewHolder.mIvHasMasjid.setImageResource(R.drawable.mosque_ico);
        }
    }

    private void stationIsHasRestaurantImageView(Station station, ViewHolder viewHolder) {
        if (station.isHasRestaurant()==false){
            viewHolder.mIvHasRestaurant.setVisibility(View.GONE);
        }else{
            viewHolder.mIvHasRestaurant.setImageResource(R.drawable.resturant_ico);
        }
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_address)
        TextView mTvAddress;
        @BindView(R.id.tv_gas91Price)
        TextView mTvGas91Price;
        @BindView(R.id.tv_gas95Price)
        TextView mTvGas95Price;
        @BindView(R.id.tv_dslPrice)
        TextView mTvDslPrice;
        @BindView(R.id.tv_gas91Currency)
        TextView mTvGas91Currency;
        @BindView(R.id.tv_gas95Currency)
        TextView mTvGas95Currency;
        @BindView(R.id.tv_dslCurrency)
        TextView mTvDslCurrency;
        @BindView(R.id.iv_stationImage)
        ImageView mIvStationImage;
        @BindView(R.id.iv_hasRestaurant)
        ImageView mIvHasRestaurant;
        @BindView(R.id.iv_hasMasjid)
        ImageView mIvHasMasjid;
        @BindView(R.id.iv_hasCafe)
        ImageView mIvHasCafe;
        @BindView(R.id.iv_hasLadiesWC)
        ImageView mIvHasLadiesWC;
        @BindView(R.id.iv_hasMensWC)
        ImageView mIvHasMensWC;
        @BindView(R.id.iv_hasHotel)
        ImageView mIvHasHotel;
        @BindView(R.id.iv_hasATM)
        ImageView mIvHasATM;
        @BindView(R.id.RATINGinitialvalueratingID)
        RatingBar mRatingBar;
        @BindView(R.id.iv_navigationButton)
        ImageView mIvNavigationButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

    }
}
