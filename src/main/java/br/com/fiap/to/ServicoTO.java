package br.com.fiap.to;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ServicoTO {

    private Long cdServico;

    @NotBlank(message = "A descrição do serviço é obrigatória.")
    private String dsServico;

    private String dsComentario;

    @NotBlank(message = "O grau de dificuldade é obrigatório.")
    private String dsGrauDificuldade;

    @NotBlank(message = "O segmento é obrigatório.")
    private String dsSegmento;

    @NotNull(message = "O código do cliente é obrigatório.")
    private Long cdCliente;

    @NotNull(message = "O código do contratado é obrigatório.")
    private Long cdContratado;

    @NotNull(message = "O código do pagamento é obrigatório.")
    private Long cdPagamento;

    @NotNull(message = "O código do feedback é obrigatório.")
    private Long cdFeedback;

    private LocalDate dtPrevisao;
    private LocalDate dtConclusao;

    public ServicoTO() {}

    public ServicoTO(Long cdServico, String dsServico, String dsComentario, String dsGrauDificuldade,
                     String dsSegmento, Long cdCliente, Long cdContratado, Long cdPagamento,
                     Long cdFeedback, LocalDate dtPrevisao, LocalDate dtConclusao) {
        this.cdServico = cdServico;
        this.dsServico = dsServico;
        this.dsComentario = dsComentario;
        this.dsGrauDificuldade = dsGrauDificuldade;
        this.dsSegmento = dsSegmento;
        this.cdCliente = cdCliente;
        this.cdContratado = cdContratado;
        this.cdPagamento = cdPagamento;
        this.cdFeedback = cdFeedback;
        this.dtPrevisao = dtPrevisao;
        this.dtConclusao = dtConclusao;
    }

    public Long getCdServico() { return cdServico; }
    public void setCdServico(Long cdServico) { this.cdServico = cdServico; }
    public String getDsServico() { return dsServico; }
    public void setDsServico(String dsServico) { this.dsServico = dsServico; }
    public String getDsComentario() { return dsComentario; }
    public void setDsComentario(String dsComentario) { this.dsComentario = dsComentario; }
    public String getDsGrauDificuldade() { return dsGrauDificuldade; }
    public void setDsGrauDificuldade(String dsGrauDificuldade) { this.dsGrauDificuldade = dsGrauDificuldade; }
    public String getDsSegmento() { return dsSegmento; }
    public void setDsSegmento(String dsSegmento) { this.dsSegmento = dsSegmento; }
    public Long getCdCliente() { return cdCliente; }
    public void setCdCliente(Long cdCliente) { this.cdCliente = cdCliente; }
    public Long getCdContratado() { return cdContratado; }
    public void setCdContratado(Long cdContratado) { this.cdContratado = cdContratado; }
    public Long getCdPagamento() { return cdPagamento; }
    public void setCdPagamento(Long cdPagamento) { this.cdPagamento = cdPagamento; }
    public Long getCdFeedback() { return cdFeedback; }
    public void setCdFeedback(Long cdFeedback) { this.cdFeedback = cdFeedback; }
    public LocalDate getDtPrevisao() { return dtPrevisao; }
    public void setDtPrevisao(LocalDate dtPrevisao) { this.dtPrevisao = dtPrevisao; }
    public LocalDate getDtConclusao() { return dtConclusao; }
    public void setDtConclusao(LocalDate dtConclusao) { this.dtConclusao = dtConclusao; }
}
