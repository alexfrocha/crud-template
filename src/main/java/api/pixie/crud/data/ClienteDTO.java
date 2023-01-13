package api.pixie.crud.data;

import api.pixie.crud.models.Cliente;

public class ClienteDTO {
    
    private Long id;
    private String nome;
    private Integer idade;
    private String cpf;
    private Double saldo;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    
    public Cliente novoCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setIdade(clienteDTO.getIdade());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setSaldo(clienteDTO.getSaldo());
        return cliente;
    }

    public Cliente atualizarCliente(ClienteDTO clienteDTO, Long id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(clienteDTO.getNome());
        cliente.setIdade(clienteDTO.getIdade());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setSaldo(clienteDTO.getSaldo());
        return cliente;
    }

}
