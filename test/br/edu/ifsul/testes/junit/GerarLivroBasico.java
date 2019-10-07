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
import br.edu.ifsul.modelo.LivroBasico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanuel
 */
public class GerarLivroBasico {
    
    public GerarLivroBasico() {}
        
    @Test
    public void teste(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    LivroBasico lb = new LivroBasico();
    
    lb.setISBN("159657");
    lb.setTitulo("Rei do Inverno");
    lb.setResumo("The Warlord Chronicles é uma trilogia de livros sobre a lenda do Rei Artur.");
    lb.setEditora("DarkHose");
    lb.setDataPublicacao(Calendar.getInstance());

    lb.setAutorLivro(em.find(Autor.class,1));
    
   
        
    em.getTransaction().begin();
    em.persist(lb);
    em.getTransaction().commit();
    
    }
    
    
}
