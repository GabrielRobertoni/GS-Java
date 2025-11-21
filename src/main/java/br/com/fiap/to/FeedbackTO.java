package br.com.fiap.to;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class FeedbackTO {

    private Long cdFeedback;

    @NotBlank(message = "A descrição do feedback é obrigatória.")
    private String dsFeedback;

    @NotBlank(message = "O comentário é obrigatório.")
    private String dsComentario;

    @NotNull(message = "A data de envio é obrigatória.")
    private LocalDate dtEnvio;

    @NotNull(message = "O código do serviço é obrigatório.")
    private Long cdServico;

    public FeedbackTO() {}

    public FeedbackTO(Long cdFeedback, String dsFeedback, String dsComentario, LocalDate dtEnvio, Long cdServico) {
        this.cdFeedback = cdFeedback;
        this.dsFeedback = dsFeedback;
        this.dsComentario = dsComentario;
        this.dtEnvio = dtEnvio;
        this.cdServico = cdServico;
    }

    public Long getCdFeedback() { return cdFeedback; }
    public void setCdFeedback(Long cdFeedback) { this.cdFeedback = cdFeedback; }

    public String getDsFeedback() { return dsFeedback; }
    public void setDsFeedback(String dsFeedback) { this.dsFeedback = dsFeedback; }

    public String getDsComentario() { return dsComentario; }
    public void setDsComentario(String dsComentario) { this.dsComentario = dsComentario; }

    public LocalDate getDtEnvio() { return dtEnvio; }
    public void setDtEnvio(LocalDate dtEnvio) { this.dtEnvio = dtEnvio; }

    public Long getCdServico() { return cdServico; }
    public void setCdServico(Long cdServico) { this.cdServico = cdServico; }
}
