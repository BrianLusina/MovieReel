package com.moviereel.ui.activities.intro;

import com.moviereel.data.DataManager;
import com.moviereel.ui.intro.splash.SplashPresenterImpl;
import com.moviereel.ui.intro.splash.SplashView;
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
 * @author lusinabrian
 */
@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    @Mock
    SplashView mMockSplashView;

    @Mock
    DataManager mMockDataManager;

    private SplashPresenterImpl<SplashView> mSplashPresenterImpl;

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
    public  void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mSplashPresenterImpl = new SplashPresenterImpl<>(mMockDataManager, compositeDisposable);
        mSplashPresenterImpl.onAttach(mMockSplashView);
    }

    @After
    public void tearDown() throws Exception{
        RxAndroidPlugins.reset();
        mSplashPresenterImpl.onDetach();
    }

    @Test
    public void testSplashScreenShouldOpenIntroActivityOnFirstStart(){
        verify(mMockSplashView).openMainActivity();
    }

    @Test
    public void testSplashScreenShouldOpenMainActivityOnSecondStart(){
        mMockSplashView.openAppIntroductionActivity();

        verify(mMockSplashView).openMainActivity();
    }

    @Test
    public void testSplashScreenStartsSyncService(){
        verify(mMockSplashView).startSyncService();
    }
}