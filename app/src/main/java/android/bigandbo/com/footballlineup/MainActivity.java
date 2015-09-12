package android.bigandbo.com.footballlineup;

import android.bigandbo.com.footballlineup.Adapters.AdapterAssociation;
import android.bigandbo.com.footballlineup.Listeners.HidingScrollListener;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView mListAssociation;
    private Toolbar mToolbar;
    private AdapterAssociation mAdapter;
    private List<String> mData;

    // Listener
    private HidingScrollListener mHidingScrollListener = new HidingScrollListener() {
        @Override
        public void onHide() {
            hideViews();
        }

        @Override
        public void onShow() {
            showViews();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mListAssociation = (RecyclerView) findViewById(R.id.rvAssociation);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            mData.add("" +i);
        }

        mAdapter = new AdapterAssociation(mContext, mData);
        mListAssociation.setAdapter(mAdapter);
        mListAssociation.setLayoutManager(new LinearLayoutManager(mContext));
        mListAssociation.setOnScrollListener(mHidingScrollListener);
    }

    private void hideViews(){
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }

    private void showViews(){
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }
}
