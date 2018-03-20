package com.example.onevoice.myapplication.Contract;

import android.content.Context;

import com.example.onevoice.myapplication.Datum;
import com.example.onevoice.myapplication.Example;

import java.util.List;

/**
 * Created by onevoice on 15/3/18.
 */

public interface Contract {

    interface View{

        void onGetDataSuccess(String message, List<Datum> list);
        void onGetDataFailure(String message);
    }

    interface Presenter{
        void getDataFromUrl(Context context);
    }

    interface Interactor{
        void initRetrofitCall(Context context);

    }
    interface onGetDataListener{
        void onSuccess(String message, List<Datum> data);
        void onFailure(String message);
    }
}
