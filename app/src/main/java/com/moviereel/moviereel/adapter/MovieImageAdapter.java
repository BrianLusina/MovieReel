package com.moviereel.moviereel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.ImagesModel;

import java.util.List;

/**
 * MovieReel
 * com.moviereel.moviereel.adapter
 * Created by lusinabrian on 10/10/16.
 * Description: RecyclerAdapter for the Images of the movie or TVShow
 */

public class MovieImageAdapter extends RecyclerView.Adapter<MovieImageAdapter.ViewHolder>{
    private Context mContext;
    private List<ImagesModel> imagesModelsList;
    public int itemLayout;

    // constructor
    public MovieImageAdapter(Context mContext, List<ImagesModel> imagesModelList, int itemLayout){
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.imagesModelsList = imagesModelList;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ImagesModel imagesModel = imagesModelsList.get(position);
        holder.itemView.setTag(imagesModel);

        //load images using Glider library
        Glide.with(mContext)
                .load(imagesModel.getFilePath())
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
                .into(holder.moviePoster);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView  moviePoster;
        public ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress_movieimage_progress);
            moviePoster = (ImageView) itemView.findViewById(R.id.movieimage_item_img);
        }

    }

    public void add(ImagesModel itemModel, int position){
        imagesModelsList.add(position,itemModel);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return imagesModelsList.size();
    }

}

