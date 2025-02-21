import java.util.ArrayList;
import java.util.List;

public class Avaliacao {
    private Integer totalAvaliacao;
    private List<String> comentarios;
    private List<Double> notas;
    private double mediaAvaliacao;
    
    public Avaliacao(Integer totalAvaliacao, String comentario, double nota) {
        this.totalAvaliacao = 0;
        this.comentarios = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.mediaAvaliacao = 0.0;
    }

    public void atualizarMedia(double novaNota) {
        mediaAvaliacao = ((mediaAvaliacao * totalAvaliacao) + novaNota) / (totalAvaliacao + 1);
        totalAvaliacao++;
    }

    public void criarAvaliacao(String comentario, double nota) {
        this.comentarios.add(comentario);
        this.notas.add(nota);
        atualizarMedia(nota);
    }

    public Integer getTotalAvaliacao() {
        return totalAvaliacao;
    }

    public String getComentario() {
        return comentarios.isEmpty() ? "" : comentarios.get(comentarios.size() - 1);
    }

    public List<String> getTodosComentarios() {
        return comentarios;
    }

    public double getNota() {
        return notas.isEmpty() ? 0.0 : notas.get(notas.size() - 1);
    }

    public double getMediaAvaliacao() {
    return mediaAvaliacao;
    }
}
