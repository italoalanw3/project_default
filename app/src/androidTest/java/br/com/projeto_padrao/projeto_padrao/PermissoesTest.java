package br.com.projeto_padrao.projeto_padrao;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import br.com.projeto_padrao.projeto_padrao.api.url.BolaoService;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Italo Alan on 06/11/2016.
 */

@RunWith(AndroidJUnit4.class)
public class PermissoesTest {

    @Test
    public void testarPermissaoRequest() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:81/api/").addConverterFactory(GsonConverterFactory.create()).build();

        BolaoService bolaoService = retrofit.create(BolaoService.class);

        assertNotNull(bolaoService);

        try {
            bolaoService.listBoloesAtivos().execute();
        } catch (IOException e) {
            if (e.getMessage().toLowerCase().contains("permission denied")) {
                fail("Permissão negada, faltando a permissão: android.permission.INTERNET");
            }
        }
    }
}
