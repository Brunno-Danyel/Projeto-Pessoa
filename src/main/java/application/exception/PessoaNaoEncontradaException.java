package application.exception;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException() {
        super("Pessoa não encontrada na base de dados!");
    }
}
