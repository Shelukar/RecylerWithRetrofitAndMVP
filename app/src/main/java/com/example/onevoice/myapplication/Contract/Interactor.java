package com.example.onevoice.myapplication.Contract;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.onevoice.myapplication.ApiClient;
import com.example.onevoice.myapplication.ApiInterface;
import com.example.onevoice.myapplication.Datum;
import com.example.onevoice.myapplication.Example;
import com.example.onevoice.myapplication.MainActivity;
import com.example.onevoice.myapplication.R;
import com.example.onevoice.myapplication.adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by onevoice on 17/3/18.
 */

public class Interactor implements Contract.Interactor {
    private Contract.onGetDataListener mOnGetDatalistener;
    private static final String TAG = MainActivity.class.getSimpleName();

    List<String> allData = new ArrayList<>();
    List<Datum> data;

    public static String API_KEY = "2";

    public Interactor(Contract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall(Context context) {


        if (API_KEY.isEmpty()) {
            //Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
           // return;
        }
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiService.getTopRatedMovies(API_KEY);
        Log.d("====","api"+API_KEY);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                int statusCode = response.code();
                 data = response.body().getData();
                for(int i=0;i<data.size();i++){
                    allData.add(String.valueOf(data));
                }
                mOnGetDatalistener.onSuccess("List Size: " + allData.size(),data);

                //recyclerView.setAdapter(new adapter(data, R.layout.list_item, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // Log error hhow to generate release key hash for facebook in linuxere since request failed
                Log.e(TAG, t.toString());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });


    }
}
