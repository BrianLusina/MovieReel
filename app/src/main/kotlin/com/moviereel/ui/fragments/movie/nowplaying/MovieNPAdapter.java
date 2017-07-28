package com.moviereel.ui.fragments.movie.nowplaying;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.gson.Gson;
import com.moviereel.BuildConfig;
import com.moviereel.R;

import com.moviereel.data.api.model.movie.response.MovieResultsResponse;
import com.moviereel.di.ActivityContext;
import com.moviereel.di.ApplicationContext;
import com.moviereel.ui.activities.itemdetails.movie.MovieDetailsActivity;
import com.moviereel.ui.base.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lusinabrian on 01/06/17.
 * @Notes
 */

public class MovieNPAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = MovieNPAdapter.class.getSimpleName();

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mCallback;

    private List<MovieResultsResponse> movieResultsResponseList;
    private Context mContext;

    @Inject
    public MovieNPAdapter(List<MovieResultsResponse> movieResultsResponseList, @ActivityContext Context mContext){
        this.movieResultsResponseList = movieResultsResponseList;
        this.mContext = mContext;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_layout, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemViewType(int position) {
        if (movieResultsResponseList != null && movieResultsResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }

    }

    @Override
    public int getItemCount() {
        if(movieResultsResponseList != null && movieResultsResponseList.size() > 0){
            return movieResultsResponseList.size();
        }else {
            return 1;
        }
    }

    /**
     * Add Movie now playing responses to list
     * */
    public void addItems(List<MovieResultsResponse> movieResultsResponses){
        movieResultsResponseList.addAll(movieResultsResponses);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder{
        @BindView(R.id.item_movie_progressbar)
        ProgressBar progressBar;

        @BindView(R.id.item_movie_imgView)
        ImageView movieImageView;

        @BindView(R.id.item_movie_title_txtView)
        TextView movieTitle;

        @BindView(R.id.item_movie_voteAvg_txtView)
        TextView movieVoteAvg;

        @BindView(R.id.item_movieCategories_txtView)
        TextView movieCategories;

        @BindView(R.id.item_movieRuntime_txtView)
        TextView movieRuntime;

        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        public void onBind(final int position){
            final MovieResultsResponse movieResultsResponse = movieResultsResponseList.get(position);
            movieTitle.setText(movieResultsResponse.getTitle());
            movieVoteAvg.setText(String.valueOf(movieResultsResponse.getVoteAverage()));

            // glide images to image views
            Glide.with(mContext)
                    .load(BuildConfig.POSTER_PATH + movieResultsResponse.getPosterPath())
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .fitCenter()
                    .crossFade()
                    .into(movieImageView);
            // movieRuntime.setText(movieResultsResponse.get);
            // nowPlayingResponse.getResults()
            // movieRuntime.setText(nowPlayingResponse.get);

            // open movie details activity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent openMovieIntent = new Intent(mContext, MovieDetailsActivity.class);

                    openMovieIntent.putExtra("MovieObj", movieResultsResponse);
                    itemView.getContext().startActivity(openMovieIntent);
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder{

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onViewEmptyViewRetryClick();
        }
    }

    public interface Callback {
        void onViewEmptyViewRetryClick();
    }

}
