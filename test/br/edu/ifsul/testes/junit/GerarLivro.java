/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.modelo.LivroBasico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emanuel
 */
public class GerarLivro {
    
    public GerarLivro() {}
        
    @Test
    public void teste(){
    EntityManager em = EntityManagerUtil.getEntityManager();
    
    Livro lb = new Livro();
    
    lb.setISBN("123456789");
    lb.setTitulo("Inimigo de Deus");
    lb.setResumo(" A Britânia está pronta expulsar de uma vez os invasores saxões.");
    lb.setEditora("DarkHose");
    lb.setDataPublicacao(Calendar.getInstance());
    lb.setCodigoBarras("12345678912345");
    lb.setNumeroPaginas(100);
    lb.setAtivo(Boolean.TRUE);
    lb.setDataCadastro(Calendar.getInstance());
    
    Idioma i =  em.find(Idioma.class,1);
    lb.setIdioma(i);
    
    Formato f = em.find(Formato.class,1);
    lb.setFormato(f);
    
    Catalogo c = em.find(Catalogo.class,1);
    lb.setCatalogo(c);
    
    
    
   
        
    em.getTransaction().begin();
    em.persist(lb);
    em.getTransaction().commit();
    
    }
    
    
}
