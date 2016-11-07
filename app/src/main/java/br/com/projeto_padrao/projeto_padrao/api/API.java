package br.com.projeto_padrao.projeto_padrao.api;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Italo Alan on 06/11/2016.
 */

public class API<T> {
    private static final String URL = "http://10.0.0.104:81/api/";
    private static Retrofit retrofit = null;

    public static Retrofit factoryRetrofit() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
