/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Formato;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanuel
 */
public class GerarFormato {
    
    public GerarFormato() {}
        
    @Test
    public void teste(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    Formato f = new Formato();
    
    f.setNome("Capa dura");

    em.getTransaction().begin();
    em.persist(f);
    em.getTransaction().commit();
    
    }
    
    
}
