/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanuel
 */
public class GerarAutor {
    
    public GerarAutor() {}
        
    @Test
    public void teste(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    Autor a = new Autor();
    
    a.setNome("Bernard Cornwell");
    a.setBibliografia("Bernard Cornwell OBE (Londres, 23 de fevereiro de 1944) é um dos mais importantes escritores britânicos da atualidade. Já publicou mais de 40 livros e teve obras traduzidas para mais de 16 idiomas.");

    em.getTransaction().begin();
    em.persist(a);
    em.getTransaction().commit();
    
    }
    
    
}
