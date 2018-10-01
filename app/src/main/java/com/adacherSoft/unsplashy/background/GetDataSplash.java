package com.adacherSoft.unsplashy.background;

import android.os.AsyncTask;

import com.adacherSoft.unsplashy.models.Unsplash;
import com.adacherSoft.unsplashy.network.GetSplash;
import com.adacherSoft.unsplashy.network.UnsplashInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * xc
 * Created by adacher on 10-07-17.
 */

public class GetDataSplash extends AsyncTask<Void, Void, List<Unsplash>> {


    @Override
    protected List<Unsplash> doInBackground(Void... params) {


        GetSplash request = new UnsplashInterceptor().get();
        Call<List<Unsplash>> call = request.getRandom(10);
        List<Unsplash> unsplashes = new ArrayList<>();

        try {

            Response<List<Unsplash>> response = call.execute();
            if (response.code() == 200 && response.isSuccessful()) {
                List<Unsplash> getSplash = response.body();
                if (getSplash != null && getSplash.size() > 0) {
                    //return getSplash;
                    unsplashes.addAll(getSplash);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return unsplashes;


    }
}




