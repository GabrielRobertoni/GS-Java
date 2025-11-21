package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class SeguroTO {

    private Long cdApolice;

    @NotBlank(message = "A descrição do plano é obrigatória.")
    private String dsPlano;

    @NotNull(message = "O valor da cobertura é obrigatório.")
    private Double vlCobertura;

    @NotBlank(message = "A descrição da cobertura é obrigatória.")
    private String dsCobertura;

    @NotBlank(message = "A situação é obrigatória.")
    private String dsSituacao;

    @NotNull(message = "O código do serviço é obrigatório.")
    private Long cdServico;

    public SeguroTO() {}

    public SeguroTO(Long cdApolice, String dsPlano, Double vlCobertura, String dsCobertura, String dsSituacao, Long cdServico) {
        this.cdApolice = cdApolice;
        this.dsPlano = dsPlano;
        this.vlCobertura = vlCobertura;
        this.dsCobertura = dsCobertura;
        this.dsSituacao = dsSituacao;
        this.cdServico = cdServico;
    }

    public Long getCdApolice() { return cdApolice; }
    public void setCdApolice(Long cdApolice) { this.cdApolice = cdApolice; }

    public String getDsPlano() { return dsPlano; }
    public void setDsPlano(String dsPlano) { this.dsPlano = dsPlano; }

    public Double getVlCobertura() { return vlCobertura; }
    public void setVlCobertura(Double vlCobertura) { this.vlCobertura = vlCobertura; }

    public String getDsCobertura() { return dsCobertura; }
    public void setDsCobertura(String dsCobertura) { this.dsCobertura = dsCobertura; }

    public String getDsSituacao() { return dsSituacao; }
    public void setDsSituacao(String dsSituacao) { this.dsSituacao = dsSituacao; }

    public Long getCdServico() { return cdServico; }
    public void setCdServico(Long cdServico) { this.cdServico = cdServico; }
}
