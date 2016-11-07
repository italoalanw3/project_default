package br.com.projeto_padrao.projeto_padrao.api.url;

import java.util.List;

import br.com.projeto_padrao.projeto_padrao.modelo.Bolao;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Italo Alan on 06/11/2016.
 */

public interface BolaoService {

    @GET("bolao-ativos")
    Call<List<Bolao>> listBoloesAtivos();
}
