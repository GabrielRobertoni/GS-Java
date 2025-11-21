package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class ClienteTO {

    private Long cdCliente;

    @NotBlank(message = "O CPF é obrigatório.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos numéricos.")
    private String nmCpf;

    @NotBlank(message = "O nome é obrigatório.")
    private String dsNome;

    @NotBlank(message = "O endereço é obrigatório.")
    private String dsEndereco;

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos.")
    private String nmCep;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 dígitos numéricos.")
    private String nmTelefone;

    public ClienteTO() {}

    public ClienteTO(Long cdCliente, String nmCpf, String dsNome, String dsEndereco, String nmCep, String nmTelefone) {
        this.cdCliente = cdCliente;
        this.nmCpf = nmCpf;
        this.dsNome = dsNome;
        this.dsEndereco = dsEndereco;
        this.nmCep = nmCep;
        this.nmTelefone = nmTelefone;
    }

    public Long getCdCliente() {
        return cdCliente;
    }
    public void setCdCliente(Long cdCliente) {
        this.cdCliente = cdCliente;
    }

    public String getNmCpf() {
        return nmCpf;
    }
    public void setNmCpf(String nmCpf) {
        this.nmCpf = nmCpf;
    }

    public String getDsNome() {
        return dsNome;
    }
    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }
    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNmCep() {
        return nmCep;
    }
    public void setNmCep(String nmCep) {
        this.nmCep = nmCep;
    }

    public String getNmTelefone() {
        return nmTelefone;
    }
    public void setNmTelefone(String nmTelefone) {
        this.nmTelefone = nmTelefone;
    }
}
