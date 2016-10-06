package com.moviereel.moviereel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.MovieModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * MovieReel
 * com.moviereel.moviereel.adapter
 * Created by lusinabrian on 06/10/16.
 * Description:
 */

public class MovieCastAdapter extends RecyclerView.Adapter<MovieCastAdapter.ViewHolder>{
    private Context mContext;
    private List<MovieModel> MovieModelList;
    public int itemLayout;

    // constructor
    public MovieCastAdapter(Context mContext, List<MovieModel> MovieModelList, int itemLayout){
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.MovieModelList = MovieModelList;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new MovieCastAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MovieModel MovieModel = MovieModelList.get(position);
        holder.itemView.setTag(MovieModel);
        holder.bind(MovieModel);

        //load images using Glider library
        Glide.with(mContext)
                .load(MovieModel.getMovie_poster_url())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .centerCrop()
                .fitCenter()
                .crossFade()
                .into(holder.actorImage);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView actorImage;
        public TextView actorName;
        public ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress_movie_img);
            actorImage = (CircleImageView) itemView.findViewById(R.id.moviecast_item_img);
            actorName = (TextView) itemView.findViewById(R.id.moviecast_item_name);
        }
        public void bind(MovieModel movieModel){
            actorName.setText(movieModel.getMovie_title());
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
