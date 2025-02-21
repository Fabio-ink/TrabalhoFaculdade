public class Preco {
    private double valorProduto;
    private double descontoGeral;

    public Preco(double valorProduto, double descontoGeral) {
        this.valorProduto = valorProduto;
        this.descontoGeral = descontoGeral;
    }

    public double getValorFinal() {
        return valorProduto - descontoGeral;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public double getDescontoGeral() {
        return descontoGeral;
    }

    public void setDescontoGeral(double descontoGeral) {
        this.descontoGeral = descontoGeral;
    }

    public double calcularValorComDesconto() {
        return valorProduto - (valorProduto * descontoGeral / 100);
    }
}