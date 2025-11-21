package br.com.fiap.to;

public class ContratadoTO {

    private Long cdContratado;
    private String nmCnpj;
    private String dsNome;
    private String nmTelefone;
    private String dsRegiao;
    private String dsCidade;
    private String dsEspecialidade;
    private Double dsEstrelas; // <-- tipo DOUBLE

    // Getters e Setters
    public Long getCdContratado() { return cdContratado; }
    public void setCdContratado(Long cdContratado) { this.cdContratado = cdContratado; }

    public String getNmCnpj() { return nmCnpj; }
    public void setNmCnpj(String nmCnpj) { this.nmCnpj = nmCnpj; }

    public String getDsNome() { return dsNome; }
    public void setDsNome(String dsNome) { this.dsNome = dsNome; }

    public String getNmTelefone() { return nmTelefone; }
    public void setNmTelefone(String nmTelefone) { this.nmTelefone = nmTelefone; }

    public String getDsRegiao() { return dsRegiao; }
    public void setDsRegiao(String dsRegiao) { this.dsRegiao = dsRegiao; }

    public String getDsCidade() { return dsCidade; }
    public void setDsCidade(String dsCidade) { this.dsCidade = dsCidade; }

    public String getDsEspecialidade() { return dsEspecialidade; }
    public void setDsEspecialidade(String dsEspecialidade) { this.dsEspecialidade = dsEspecialidade; }

    public Double getDsEstrelas() { return dsEstrelas; }
    public void setDsEstrelas(Double dsEstrelas) { this.dsEstrelas = dsEstrelas; }
}
