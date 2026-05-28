package excecao;

public class ErroDeConversaoBusca extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoBusca(String message) {
        super(message);
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
