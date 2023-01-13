package api.pixie.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.pixie.crud.data.ClienteDTO;
import api.pixie.crud.models.Cliente;
import api.pixie.crud.repositories.ClienteRepository;

@RestController
public class RestClientes {

    @Autowired
    private ClienteRepository clienteRepository;

    // FUNÇÕES APENAS PARA ENCURTAR CÓDIGO (NÃO NECESSÁRIAS)

    public boolean ehUmNumero(String idCru) {
        if (idCru.matches("[0-9]+")) return true;
        return false;
    }

    public boolean clienteExiste(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) return true;
        return false;
    }

    // CRUD SYSTEM
    
    @GetMapping("/clientes")
    public List<Cliente> todosOsClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente clienteEspecifico(@PathVariable(name = "id") String idCru) {
        if (!ehUmNumero(idCru)) return null;
        Long id = Long.parseLong(idCru);

        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (!clienteExiste(id)) return null;
        Cliente cliente = clienteOptional.get();
        return cliente;
    }

    @DeleteMapping("/excluir/{id}")
    public String deletarCliente(@PathVariable(name = "id") String idCru) {
        if (!ehUmNumero(idCru)) return "Id inválido";
        Long id = Long.parseLong(idCru);
        
        if (!clienteExiste(id)) return "Cliente não encontrado";

        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        Cliente cliente = clienteOptional.get();

        clienteRepository.delete(cliente);
        return "Cliente deletado";
    }

    @PostMapping("/novoCliente")
    public String novoCliente(@RequestBody ClienteDTO dados) {
        Cliente novoCliente = dados.novoCliente(dados);
        clienteRepository.save(novoCliente);
        return "Novo cliente!";
    }

    @PutMapping("/editar/{id}")
    public Cliente atualizarCliente(@RequestBody ClienteDTO dados, @PathVariable(name = "id") String idCru) {
        if (!ehUmNumero(idCru)) return null;
        Long id = Long.parseLong(idCru);

        if(!clienteExiste(id)) return null;

        Cliente clienteEditado = dados.atualizarCliente(dados, id);
        clienteRepository.save(clienteEditado);
        return clienteEditado;
    }
}
