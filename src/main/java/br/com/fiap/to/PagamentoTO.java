package br.com.fiap.to;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PagamentoTO {

    private Long cdPagamento;

    @NotBlank(message = "A forma de pagamento é obrigatória.")
    private String dsFormaPag;

    @NotNull(message = "O valor do serviço é obrigatório.")
    private Double vlServico1;

    @NotNull(message = "A data do pagamento é obrigatória.")
    private LocalDate dtPagamento;

    @NotBlank(message = "O status do pagamento é obrigatório.")
    private String dsStatusPag;

    public PagamentoTO() {}

    public PagamentoTO(Long cdPagamento, String dsFormaPag, Double vlServico1, LocalDate dtPagamento, String dsStatusPag) {
        this.cdPagamento = cdPagamento;
        this.dsFormaPag = dsFormaPag;
        this.vlServico1 = vlServico1;
        this.dtPagamento = dtPagamento;
        this.dsStatusPag = dsStatusPag;
    }

    public Long getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(Long cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

    public String getDsFormaPag() {
        return dsFormaPag;
    }

    public void setDsFormaPag(String dsFormaPag) {
        this.dsFormaPag = dsFormaPag;
    }

    public Double getVlServico1() {
        return vlServico1;
    }

    public void setVlServico1(Double vlServico1) {
        this.vlServico1 = vlServico1;
    }

    public LocalDate getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(LocalDate dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public String getDsStatusPag() {
        return dsStatusPag;
    }

    public void setDsStatusPag(String dsStatusPag) {
        this.dsStatusPag = dsStatusPag;
    }
}
