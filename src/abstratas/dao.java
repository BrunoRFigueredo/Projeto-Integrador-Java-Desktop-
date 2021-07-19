
package abstratas;

import banco.Dados;
import java.util.List;
import javax.persistence.Query;

abstract public class dao<T> {
    public void create(T objeto){
        Dados.getEntity().getTransaction().begin();
        Dados.getEntity().persist(objeto);
        Dados.getEntity().getTransaction().commit();
    }
    public void update(T objeto){
        Dados.getEntity().getTransaction().begin();
        Dados.getEntity().merge(objeto);
        Dados.getEntity().getTransaction().commit();
    }
    public void delete(T objeto){
        Dados.getEntity().getTransaction().begin();
        Dados.getEntity().remove(objeto);
        Dados.getEntity().getTransaction().commit();
    }
    public T read(Class<T> classType,int id){
        return (Dados.getEntity().find(classType, id));
    }
    //    
    public List<T> read(String JPQL){         
        Query query = Dados.getEntity().createQuery(JPQL);
        return query.getResultList();        
    }
    
    public List<T> read(String JPQL,Object... args){         
        Query query = Dados.getEntity().createQuery(JPQL);
        for (int i=0; i < args.length; i++){
            query.setParameter((i+1), args[i]);
        }
        return query.getResultList();        
    }    
}
