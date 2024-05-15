package com.tfg.openAPICliente;

import java.io.IOException;
import java.util.List;

import com.tfg.modelo.SitioTuristico;
import com.tfg.modelo.Alojamiento;
import com.tfg.openAPI.modelo.ApiResponseST;
import com.tfg.openAPI.modelo.ApiResponseAlo;
import com.tfg.openAPI.modelo.RequestBody;
import com.tfg.openAPIServicio.OpenAIApiService;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class OpenAIClient {
    private OpenAIApiService apiService;

    public OpenAIClient() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openai.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(OpenAIApiService.class);
    }

    public List<SitioTuristico> fetchTouristSites(String prompt, int maxTokens, int temperature) throws IOException {
        RequestBody body = new RequestBody();
        body.prompt = prompt;
        body.max_tokens = maxTokens;
        body.temperature = temperature;
        body.model = "gpt-3.5-turbo-16k-0613";

        // Sincronizar la llamada para devolver directamente la lista de sitios
        Response<ApiResponseST> response = apiService.fetchTouristSites(body).execute();

        if (response.isSuccessful() && response.body() != null) {
            return response.body().results; // Devuelve la lista de resultados directamente
        } else {
            throw new IOException("Error en la API: " + response.errorBody().string());
        }
    }
    
    public List<Alojamiento> fetchAccommodation(String prompt, int maxTokens, int temperature) throws IOException {
        RequestBody body = new RequestBody();
        body.prompt = prompt;
        body.max_tokens = maxTokens;
        body.temperature = temperature;
        body.model = "gpt-3.5-turbo-16k-0613";

        // Sincronizar la llamada para devolver directamente la lista de alojamientos
        Response<ApiResponseAlo> response = apiService.fetchAccommodation(body).execute();

        if (response.isSuccessful() && response.body() != null) {
            return response.body().results; // Devuelve la lista de resultados directamente
        } else {
            throw new IOException("Error en la API: " + response.errorBody().string());
        }
    }
}

