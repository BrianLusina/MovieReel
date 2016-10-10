package com.moviereel.moviereel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.ActorModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * MovieReel
 * com.moviereel.moviereel.adapter
 * Created by lusinabrian on 10/10/16.
 * Description:
 */

public class MovieImageAdapter extends RecyclerView.Adapter<MovieCastAdapter.ViewHolder>{
    private Context mContext;
    private List<ActorModel> actorModelList;
    public int itemLayout;

    // constructor
    public MovieImageAdapter(Context mContext, List<ActorModel> actorModelList, int itemLayout){
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.actorModelList = actorModelList;
        this.notifyDataSetChanged();
    }

    @Override
    public MovieCastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new MovieCastAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MovieCastAdapter.ViewHolder holder, int position) {
        ActorModel actorModel = actorModelList.get(position);
        holder.itemView.setTag(actorModel);
        holder.bind(actorModel);

        //load images using Glider library
        Glide.with(mContext)
                .load(actorModel.getProfilePath())
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
        public TextView actorName, characterName;
        public ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progress_moviecast_progress);
            actorImage = (CircleImageView) itemView.findViewById(R.id.moviecast_item_img);
            actorName = (TextView) itemView.findViewById(R.id.moviecast_item_name);
            characterName = (TextView) itemView.findViewById(R.id.moviecast_item_charname);
        }
        public void bind(ActorModel actorModel){
            actorName.setText(actorModel.getName());
            characterName.setText(actorModel.getCharacter());
        }
    }

    public void add(ActorModel itemModel, int position){
        actorModelList.add(position,itemModel);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return actorModelList.size();
    }


}

