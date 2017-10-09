package com.example.blackbird.myapplication.api.retrofit;

import com.example.blackbird.myapplication.api.response.BaseResponse;
import com.example.blackbird.myapplication.model.ApiError;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by blackbird on 7/10/17.
 */


public abstract class RetrofitCallback<T extends BaseResponse> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onComplete();
        T apiResponse = null;
        boolean isSuccessful = false;
        if(response!=null && response.isSuccessful())//If the response is successful check for error details in the body
        {
            apiResponse = response.body();
            if(apiResponse.getError()==null)
            {
                isSuccessful = true;
            }
        }
        if(isSuccessful)//If the response is a true success (with no api sent error message)
        {
            onSuccess(apiResponse);
        }
        else//Somethings gone wrong
        {
            //We're checking if the API has returned with an custom error for us.
            BaseResponse errorResponse = null;
            if(response!=null && response.errorBody()!=null)//try getting the api error details.
            {
                try {
                    Gson gson = new Gson();
                    errorResponse = gson.fromJson(response.errorBody().string(), BaseResponse.class);
                }
                catch (IOException e)
                {
                    onError(e);
                }
                catch (NullPointerException e)
                {
                    onError(e);
                }
                catch (JsonParseException e)
                {
                    onError(e);
                }
            }
            if(errorResponse!=null && errorResponse.getError() !=null)//Custom error is there.
            {
                onError(errorResponse.getError());
            }
            else
            {
                onError(ApiError.unknownError("Something went wrong!"));
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(t);
    }

    public void onError(Throwable t)
    {
        ApiError error = new ApiError(t);
        onError(error);
    }

    public abstract void onSuccess(T response);
    public abstract void onError(ApiError error);
    public abstract void onComplete();
}
