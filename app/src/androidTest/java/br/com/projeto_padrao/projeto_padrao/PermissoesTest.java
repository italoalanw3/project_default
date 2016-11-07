package br.com.projeto_padrao.projeto_padrao;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import br.com.projeto_padrao.projeto_padrao.api.API;
import br.com.projeto_padrao.projeto_padrao.api.url.BolaoService;

import static junit.framework.Assert.fail;

/**
 * Created by Italo Alan on 06/11/2016.
 */

@RunWith(AndroidJUnit4.class)
public class PermissoesTest {

    @Test
    public void testarPermissaoRequest() {

        BolaoService bolaoService = API.factoryRetrofit().create(BolaoService.class);

        try {
            bolaoService.listBoloesAtivos().execute();
        } catch (IOException e) {
            if (e.getMessage().toLowerCase().contains("permission denied")) {
                fail("Permissão negada, faltando a permissão: android.permission.INTERNET");
            }
        }
    }
}
