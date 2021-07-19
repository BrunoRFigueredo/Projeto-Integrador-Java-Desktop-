
package controller;

import abstratas.dao;
import java.util.List;
import model.Cliente;
import model.Servico;

public class DaoServico extends dao<Servico>{
    public List<Servico> read(){
        return super.read("select s from Servico s order by s.nome");
    }
    public List<Servico> read(String filtro){
        return super.read("select s from Servico s where s.nome like ?1 order by s.nome",
                "%"+filtro.toUpperCase()+"%");        
    }  
}
