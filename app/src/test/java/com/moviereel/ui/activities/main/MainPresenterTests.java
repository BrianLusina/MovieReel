package com.moviereel.ui.activities.main;

import com.moviereel.data.DataManager;
import com.moviereel.ui.main.MainPresenterImpl;
import com.moviereel.ui.main.MainView;

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
 * Tests for {@link MainPresenterImpl}. Checks if the methods set out are actually being called
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTests {
    @Mock
    MainView mMockMainView;

    @Mock
    DataManager mMockDataManager;

    private MainPresenterImpl<MainView> mainPresenterImpl;

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
        mainPresenterImpl = new MainPresenterImpl<>(mMockDataManager, compositeDisposable);
        mainPresenterImpl.onAttach(mMockMainView);
    }

    @After
    public void tearDown() throws Exception{
        RxAndroidPlugins.reset();
        mainPresenterImpl.onDetach();
    }

    @Test
    public void testShouldDisplayNowPlayingMoviesFragment(){
        mMockMainView.showNowPlayingMoviesFragment();

        verify(mMockMainView).showNowPlayingMoviesFragment();
    }
    
    /**
     * Fragment Show the shows that are most popular
     * */
    @Test
    public void testShouldShowPopularMoviesFragment(){
        mMockMainView.showPopularMoviesFragment();
        
        verify(mMockMainView).showPopularMoviesFragment();
    }

    @Test
    public void testShouldShowTopRatedMoviesFragment(){
        mMockMainView.showTopRatedMoviesFragment();
        
        verify(mMockMainView).showTopRatedMoviesFragment();
    }

    @Test
    public void testShouldShowUpcomingMoviesFragment(){
        mMockMainView.showUpcomingMoviesFragment();

        verify(mMockMainView).showUpcomingMoviesFragment();

    }

    @Test
    public void testShouldShowLatestSeriesFragment(){
        mMockMainView.showLatestSeriesFragment();

        verify(mMockMainView).showLatestSeriesFragment();
    }

    @Test
    public void testShouldShowOnTheAirSeriesFragment(){
        mMockMainView.showOnTheAirSeriesFragment();

        verify(mMockMainView).showOnTheAirSeriesFragment();
    }

    @Test
    public void testShouldShowAiringTodaySeriesFragment(){
        mMockMainView.showAiringTodaySeriesFragment();

        verify(mMockMainView).showAiringTodaySeriesFragment();
    }

    @Test
    public void testShouldShowTopRatedSeriesFragment(){
        mMockMainView.showTopRatedSeriesFragment();

        verify(mMockMainView).showTopRatedSeriesFragment();
    }

    @Test
    public void testShouldShowPopularSeriesFragment(){
        mMockMainView.showPopularSeriesFragment();

        verify(mMockMainView).showPopularSeriesFragment();
    }

    @Test
    public void testShouldShowHelpSection(){
        mMockMainView.showHelpSection();

        verify(mMockMainView).showHelpSection();
    }

    @Test
    public void testShouldShowSettingsScreen(){
        mMockMainView.showSettingsScreen();

        verify(mMockMainView).showSettingsScreen();
    }

    @Test
    public void testShouldShowAboutFragment(){
        mMockMainView.showAboutFragment();

        verify(mMockMainView).showAboutFragment();
    }
}
