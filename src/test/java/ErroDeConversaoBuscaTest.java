import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroDeConversaoBuscaTest {

    public ErroDeConversaoBuscaTest(String mensagem) {
    }

    @Test
    void DeveTerMensagem(){
        String mensagem = "Não consegui capturar este Pokemon na busca (Nome ou ID.Dex inválido).";
        ErroDeConversaoBuscaTest erro = new ErroDeConversaoBuscaTest(mensagem);

        //Verifica se a mensagem está certa
        assertEquals(mensagem, erro.getMessage());

    }

    private String getMessage() {
        return getMessage();
    }
}
