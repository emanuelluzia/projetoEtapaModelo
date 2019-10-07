/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanuel
 */
public class GerarCatalogo {
    
    public GerarCatalogo() {}
        
    @Test
    public void teste(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    Catalogo c = new Catalogo();
    
    c.setDescricao("Romance Histórico");
    c.setNome("Ficção Histórica");
    
    Livraria l= em.find(Livraria.class,1);
    c.setLivraria(l);
    
        
    em.getTransaction().begin();
    em.persist(c);
    em.getTransaction().commit();
    
    }
    
    
}
