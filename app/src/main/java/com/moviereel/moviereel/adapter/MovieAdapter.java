package com.moviereel.moviereel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.view.IconicsImageView;
import com.mikepenz.iconics.view.IconicsTextView;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:54
 * Description:Render the RecyclerView, we need an adapter class which inflates the movieitem_layout.xml by keeping appropriate information.
 * The mContext shall render the views in the appropriate view in which it is called
 * foodModelList will hold the Food items in a list.
 * the MovieViewHolder will find the view items with their ids
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private Context mContext;
    private List<MovieModel> MovieModelList;
    public int itemLayout;


    // constructor
    public MovieAdapter(Context mContext, List<MovieModel> MovieModelList, int itemLayout){
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.MovieModelList = MovieModelList;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MovieModel MovieModel = MovieModelList.get(position);
        holder.itemView.setTag(MovieModel);
        holder.bind(MovieModel);

        //load images using Glider library
        Glide.with(mContext)
                .load(MovieModel.getMovie_poster_url())
                .centerCrop()
                .fitCenter()
                .crossFade()
                .into(holder.MoviePoster);
        //Glide.with(mContext).load(MovieModel.getMovie_poster_url()).into(holder.MoviePoster).
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView MoviePoster;
        public IconicsTextView MovieVoteCount, MoviePopularityCount;
        public IconicsImageView movieShareItem;
        public TextView MovieTitle, MovieOverview;

        public ViewHolder(View itemView) {
            super(itemView);
            MoviePoster = (ImageView) itemView.findViewById(R.id.movie_poster_image_id);
            MovieTitle = (TextView) itemView.findViewById(R.id.movie_title_card);
            MovieOverview = (TextView) itemView.findViewById(R.id.movie_overview_card);
            MovieVoteCount = (IconicsTextView) itemView.findViewById(R.id.movie_vote_count_id);
            MoviePopularityCount = (IconicsTextView)itemView.findViewById(R.id.movie_popularity_count_id);
            movieShareItem = (IconicsImageView)itemView.findViewById(R.id.movie_share_icon_id);
        }
        public void bind(MovieModel MovieModel){
            MovieTitle.setText(MovieModel.getMovie_title());
            MovieOverview.setText(MovieModel.getMovie_overview());
            MovieVoteCount.setText(String.valueOf(MovieModel.getMovie_vote_count()));
            MoviePopularityCount.setText(String.valueOf(MovieModel.getMovie_popularity()));
        }
    }

    public void add(MovieModel itemModel, int position){
        MovieModelList.add(position,itemModel);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return MovieModelList.size();
    }
}
