
package controller;

import abstratas.dao;
import java.util.List;
import model.Cliente;
import model.Funcionario;

public class DaoFuncionario extends dao<Funcionario>{
    public List<Funcionario> read(){
        return super.read("select f from Funcionario f order by f.nome");
    }
    public List<Funcionario> read(String filtro){
        return super.read("select f from Funcionario f where f.nome like ?1 order by f.nome",
                "%"+filtro.toUpperCase()+"%");        
    }  
}
