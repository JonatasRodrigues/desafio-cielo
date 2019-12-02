package br.com.gft.desafio_cielo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.gft.desafio_cielo.config.MensagemConfig;
import br.com.gft.desafio_cielo.constants.ApplicationConstants;

@SpringBootTest(classes = App.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class LancamentoTest extends AbstractTestNGSpringContextTests{

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@BeforeClass
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        new MockLancamentoService();
    }

	@Test
    public void testFindByIdLancamentoNotFound()throws Exception {
        mockMvc.perform(get("/api/v1/lancamentos/2"))
        .andExpect(status().isNotFound())
        .andExpect(content().json("{\"status\":404,\"detail\":\"Lancamento não encontrado na base de dados: 2\",\"developerMessage\":\"br.com.gft.desafio_cielo.exception.LancamentoNotFoundException\"}"));
    }
	
	@Test
    public void testFindByIdComSucesso()throws Exception {
        mockMvc.perform(get("/api/v1/lancamentos/1"))
        .andExpect(status().isOk())
        .andExpect(content().json(" {\r\n" + 
        		"        \"dtLancamento\": \"30/11/2019\",\r\n" + 
        		"        \"descricao\": \"Regular\",\r\n" + 
        		"        \"numero\": 1234,\r\n" + 
        		"        \"situacao\": \"Pago\",\r\n" + 
        		"        \"dtConfirmacao\": \"30/11/2019\",\r\n" + 
        		"        \"dadosBancarios\": \"ABC Ag 123 CC 44444\",\r\n" + 
        		"        \"vlrFinal\": 2222.00\r\n" + 
        		"    }"));
    }
	
	@Test
    public void testDeleteLancamentoSuccess()throws Exception {
        mockMvc.perform(delete("/api/v1/lancamentos/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(MensagemConfig.getMensagem(ApplicationConstants.MSG_REMOVIDO_SUCESSO)));
    }

    @Test
    public void testDeleteLancamentoNotFound()throws Exception {
        mockMvc.perform(delete("/api/v1/lancamentos/2"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"status\":404,\"detail\":\"Lancamento não encontrado na base de dados: 2\",\"developerMessage\":\"br.com.gft.desafio_cielo.exception.LancamentoNotFoundException\"}"));
    }
    
    @Test
    public void testFindAll()throws Exception {
        mockMvc.perform(get("/api/v1/lancamentos"))
        .andExpect(status().isOk())
        .andExpect(content().json("[ {\r\n" + 
        		"        \"dtLancamento\": \"30/11/2019\",\r\n" + 
        		"        \"descricao\": \"Regular\",\r\n" + 
        		"        \"numero\": 1234,\r\n" + 
        		"        \"situacao\": \"Pago\",\r\n" + 
        		"        \"dtConfirmacao\": \"30/11/2019\",\r\n" + 
        		"        \"dadosBancarios\": \"ABC Ag 123 CC 44444\",\r\n" + 
        		"        \"vlrFinal\": 2222.00\r\n" + 
        		"    }]"));
    }

    @Test
    public void testCalcularTotais()throws Exception {
        mockMvc.perform(get("/api/v1/lancamentos/totais"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\r\n" + 
        		"        \"qtdTotalLancamento\": 3,\r\n" + 
        		"        \"qtdTotalRemessa\": 30,\r\n" + 
        		"        \"vlrTotalLancamento\": 13459.10\r\n" + 
        		"    }"));
    }
}
