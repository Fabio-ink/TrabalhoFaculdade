public class Produto {

    private String nome;
    private String descricao;
    private String imagem;
    private String modelo;
    private Preco preco;

    public Produto(String Nome, String Descricao) {
        this.nome = Nome;
        this.descricao = Descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorFinal() {
        return preco.getValorFinal();
    }

}