package com.moviereel.moviereel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moviereel.moviereel.R;
import com.moviereel.moviereel.models.ReviewsModel;

import java.util.List;

/**
 * MovieReel
 * com.moviereel.moviereel.adapter
 * Created by lusinabrian on 11/10/16.
 * Description: Adapter for the review fragment
 */

public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewAdapter.ViewHolder>{
    private Context mContext;
    private List<ReviewsModel> reviewsModelList;
    public int itemLayout;

    // constructor
    public MovieReviewAdapter(Context mContext, List<ReviewsModel> reviewsModelList, int itemLayout){
        this.mContext = mContext;
        this.itemLayout = itemLayout;
        this.reviewsModelList = reviewsModelList;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ReviewsModel reviewsModel = reviewsModelList.get(position);
        holder.itemView.setTag(reviewsModel);
        holder.bind(reviewsModel);
        //load images using Glider library
        /*Glide.with(mContext)
                .load(reviewsModel.getFilePath())
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
                .into(holder.moviePoster);*/

        /*set on click listener for the review items*/
        holder.reviewViewmore.setOnClickListener(v -> {
            //start next activity to read more on the review

        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView reviewAuthorImg;
        public TextView reviewAuthorName, reviewContent;
        public ProgressBar progressBar;
        public Button reviewViewmore;

        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.movirereview_progress);
            reviewAuthorImg = (ImageView) itemView.findViewById(R.id.moviereview_author_img);
            reviewAuthorName = (TextView) itemView.findViewById(R.id.moviereview_author_name);
            reviewContent = (TextView)itemView.findViewById(R.id.moviereview_content_id);
            reviewViewmore = (Button)itemView.findViewById(R.id.moviewreview_viewmore_button);

        }

        public void bind(ReviewsModel itemModel){
            reviewAuthorName.setText(itemModel.getReviewAuthor());

            /*truncate the string*/
            String content = itemModel.getReviewContent().substring(0, 99);
            reviewContent.setText(content  + "...");
        }

    }

    public void add(ReviewsModel itemModel, int position){
        reviewsModelList.add(position,itemModel);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return reviewsModelList.size();
    }

}