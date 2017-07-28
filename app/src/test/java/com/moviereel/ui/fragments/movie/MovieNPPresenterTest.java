package com.moviereel.ui.fragments.movie;

import android.support.design.widget.Snackbar;

import com.moviereel.R;
import com.moviereel.data.DataManager;
import com.moviereel.ui.fragments.movie.nowplaying.MovieNPPresenterImpl;
import com.moviereel.ui.fragments.movie.nowplaying.MovieNPView;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.verify;

/**
 * @author lusinabrian on 19/04/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieNPPresenterTest {

    @Mock
    MovieNPView mMockMovieNPView;

    @Mock
    DataManager mMockDataManager;

    private MovieNPPresenterImpl<MovieNPView> movieNPPresenterImpl;

    @BeforeClass
    public static void onlyOnce() throws Exception{
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(@NonNull Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        movieNPPresenterImpl = new MovieNPPresenterImpl<>(mMockDataManager, compositeDisposable);
        movieNPPresenterImpl.onAttach(mMockMovieNPView);
    }

    @After
    public void tearDown() throws Exception{
        RxAndroidPlugins.reset();
        movieNPPresenterImpl.onDetach();
    }

    /**
     * Test that the API error snackbar is called upon, should there be an error
     * */
    @Test
    public void testShouldDisplayApiErrorSnackBar(){

        mMockMovieNPView.showApiErrorSnackbar(R.string.snackbar_api_error,
                R.string.snackbar_api_error_retry,
                Snackbar.LENGTH_SHORT);

        verify(mMockMovieNPView).showApiErrorSnackbar(R.string.snackbar_api_error,
                R.string.snackbar_api_error_retry,
                Snackbar.LENGTH_SHORT);
    }
}
