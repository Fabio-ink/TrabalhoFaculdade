public class MetodoPagamento {
    private String metodoPag;
    private Integer numeroParcela;
    private double descontoMetodo;
    private double valorFinal;
    private double valorParcela;

    public MetodoPagamento(String metodoPag, Integer numeroParcela, double descontoMetodo) {
        this.metodoPag = metodoPag;
        this.numeroParcela = numeroParcela;
        this.descontoMetodo = descontoMetodo;
    }

    public void calcularPagamento(double valorInicial) {
        valorFinal = valorInicial - (valorInicial * descontoMetodo / 100);

        if (numeroParcela != null && numeroParcela > 0) {
            valorParcela = valorFinal / numeroParcela;
        } else {
            valorParcela = valorFinal;
        }
    }

    public String getMetodoPag() {
        return metodoPag;
    }

    public void setMetodoPag(String metodoPag) {
        this.metodoPag = metodoPag;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public double getDescontoMetodo() {
        return descontoMetodo;
    }

    public void setDescontoMetodo(double descontoMetodo) {
        this.descontoMetodo = descontoMetodo;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
}