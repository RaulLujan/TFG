package com.tfg.openAPIServicio;

import com.tfg.openAPI.modelo.ApiResponseAlo;
import com.tfg.openAPI.modelo.ApiResponseST;
import com.tfg.openAPI.modelo.RequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
public interface OpenAIApiService {

    @Headers({
        "Content-Type: application/json",
        "Authorization: Bearer sk-proj-VyTmrxyY0zBtLbdpFdyMT3BlbkFJG04K269kCbMOXU0XWssF"
    })
    @POST("v1/chat/completions")
    Call<ApiResponseST> fetchTouristSites(@Body RequestBody body);
    
    @Headers({
        "Content-Type: application/json",
        "Authorization: Bearer sk-proj-VyTmrxyY0zBtLbdpFdyMT3BlbkFJG04K269kCbMOXU0XWssF"
    })
    @POST("v1/chat/completions")
    Call<ApiResponseAlo> fetchAccommodation(@Body RequestBody body);
}