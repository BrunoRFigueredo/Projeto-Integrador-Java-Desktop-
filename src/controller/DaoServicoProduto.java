
package controller;

import abstratas.dao;
import java.util.List;
import model.Cliente;
import model.Produto;
import model.Servico;
import model.ServicoProduto;

public class DaoServicoProduto extends dao<ServicoProduto>{
 public List<ServicoProduto> read(Produto produto) {
        return super.read("select sp from ServicoProduto sp where sp.produto = ?1",
                produto);
    }
 
 public List<ServicoProduto> read(Servico servico) {
        return super.read("select sp from ServicoProduto sp where sp.servico = ?1",
                servico);
    }
 
}
