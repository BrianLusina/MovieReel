package com.moviereel.moviereel.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.moviereel.moviereel.R;

import java.util.List;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:54
 * <p/>
 * Description:Render the RecyclerView, we need an adapter class which inflates the movieitem_layout.xml by keeping appropriate information.
 *
 * The mContext shall render the views in the appropriate view in which it is called
 * foodModelList will hold the Food items in a list.
 *
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
        Glide.with(mContext).load(MovieModel.getMovie_backdrop_url()).into(holder.MoviePoster);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView MoviePoster;
        public TextView MovieTitle, MovieOverview, MovieReleaseDate, MovieVoteCount, MoviePopularityCount;

        public ViewHolder(View itemView) {
            super(itemView);
            MoviePoster = (ImageView) itemView.findViewById(R.id.movie_image_card);
            MovieTitle = (TextView) itemView.findViewById(R.id.movie_title_card);
            MovieOverview = (TextView) itemView.findViewById(R.id.movie_desc_card);
            MovieReleaseDate = (TextView) itemView.findViewById(R.id.movie_release_date);
            MovieVoteCount = (TextView) itemView.findViewById(R.id.movie_chef_card);
            MoviePopularityCount = (TextView)itemView.findViewById(R.id.movie_popularity_count_id);
        }
        public void bind(MovieModel MovieModel){
            MovieTitle.setText(MovieModel.getMovie_title());
            MovieOverview.setText(MovieModel.getMovie_overview());
            MovieReleaseDate.setText(MovieModel.getRelease_date());
            MovieVoteCount.setText(MovieModel.getMovie_poster_url());
            MoviePopularityCount.setText(MovieModel.getMovie_popularity());
        }
    }

    public void add(MovieModel itemModel, int postion){
        MovieModelList.add(postion,itemModel);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return MovieModelList.size();
    }
}
