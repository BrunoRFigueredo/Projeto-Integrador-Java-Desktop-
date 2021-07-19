
package controller;

import abstratas.dao;
import java.util.List;
import model.Cliente;
import model.Produto;

public class DaoProduto extends dao<Produto>{
    public List<Produto> read(){
        return super.read("select p from Produto p order by p.nome");
    }
    public List<Produto> read(String filtro){
        return super.read("select p from Produto p where p.nome like ?1 order by p.nome",
                "%"+filtro.toUpperCase()+"%");        
    }  
}
