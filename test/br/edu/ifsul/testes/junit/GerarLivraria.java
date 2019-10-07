/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanuel
 */
public class GerarLivraria {
    
    public GerarLivraria() {}
        
    @Test
    public void teste(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    Livraria l = new Livraria();
    
    l.setNome("Nobel");
    l.setSite("www.nobel.com.br");
    

    em.getTransaction().begin();
    em.persist(l);
    em.getTransaction().commit();
    
    }
    
    
}
