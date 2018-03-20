package com.example.onevoice.myapplication.Presenter;

import android.content.Context;

import com.example.onevoice.myapplication.Contract.Contract;
import com.example.onevoice.myapplication.Contract.Interactor;
import com.example.onevoice.myapplication.Datum;
import com.example.onevoice.myapplication.Example;

import java.util.List;

/**
 * Created by onevoice on 15/3/18.
 */

public class MainActivityPresenter implements Contract.Presenter,Contract.onGetDataListener {


    private Contract.View mGetDataView;
    private Interactor mIntractor;

    public MainActivityPresenter(Contract.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Interactor(this);
    }

    @Override
    public void getDataFromUrl(Context context) {
        mIntractor.initRetrofitCall(context);
    }

    @Override
    public void onSuccess(String message, List<Datum> data) {
        mGetDataView.onGetDataSuccess(message, data);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }
}
