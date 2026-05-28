package co.pokeapi;

import co.pokeapi.excecao.ErroDeConversaoBusca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErroDeConversaoBuscaTest {
    @Test
    void DeveTerMensagem(){
        String mensagem = "Não consegui capturar este Pokemon na busca (Nome ou ID.Dex inválido).";
        ErroDeConversaoBusca erro = new ErroDeConversaoBusca(mensagem);

        //Verifica se a mensagem está certa
        assertEquals(mensagem, erro.getMessage());

    }
}
