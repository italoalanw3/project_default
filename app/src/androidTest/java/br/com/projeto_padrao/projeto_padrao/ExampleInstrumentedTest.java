package br.com.projeto_padrao.projeto_padrao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

import br.com.projeto_padrao.projeto_padrao.api.API;
import br.com.projeto_padrao.projeto_padrao.api.url.BolaoService;
import br.com.projeto_padrao.projeto_padrao.modelo.Bolao;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("br.com.projeto_padrao.projeto_padrao", appContext.getPackageName());
    }

    @Test
    public void testar_request_get() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API.URL).addConverterFactory(GsonConverterFactory.create()).build();

        BolaoService bolaoService = retrofit.create(BolaoService.class);

        assertNotNull(bolaoService);

        Call<List<Bolao>> fila = bolaoService.listBoloesAtivos();

        try {
            Response<List<Bolao>> execute = fila.execute();
            assertEquals(execute.code(), 200);
            assertNotNull(execute.body());
        } catch (ConnectException e) {
            if (e.getMessage().contains("connect to localhost")) {
                fail("Conexão com API não deve usar LOCALHOST");
            } else {
                fail("Conexão com API falhou: " + e.getMessage());
            }
        } catch (IOException e) {
            if (e.getMessage().toLowerCase().contains("failed to connect"))
                fail("Falha ao conectar na API: " + e.getMessage());
            else
                fail("Erro não tratado para o teste: " + e.getMessage());
        }
    }
}
