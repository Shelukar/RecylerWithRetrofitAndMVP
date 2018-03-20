package com.example.onevoice.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.onevoice.myapplication.Contract.Contract;
import com.example.onevoice.myapplication.Presenter.MainActivityPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by onevoice on 1/3/18.
 */

public class MainActivity extends AppCompatActivity implements Contract.View {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "2";
    MainActivityPresenter mPresenter;
    adapter adapter;
    Button bt;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    //TODO - insert your themoviedb.org API KEY here
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPresenter = new MainActivityPresenter(this);
        mPresenter.getDataFromUrl(getApplicationContext());

    }

    //===================== MVP =================================

    @Override
    public void onGetDataSuccess(String message, List<Datum> list) {
        adapter = new adapter(list, R.layout.list_item, getApplicationContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onGetDataFailure(String message) {

    }
    // ===================== MVP =================================



}
