/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="LivroBasico")
public class LivroBasico implements Serializable{
    
    @Id
    @NotBlank(message="O ISBN deve ser informado")
    @Column(name = "ISBN", nullable = false, length = 50)
    @Length(max= 50, message = "O ISBN não pode ter mais que {max} caracteres")
    private String ISBN;
    
    @NotBlank(message="O titulo deve ser informado")
    @Column(name = "titulo", nullable = false, length = 50)
    @Length(max= 50, message = "O titulo não pode ter mais que {max} caracteres")
    private String titulo;
    
    @NotBlank(message="O resumo deve ser informado")
    @Column(name = "resumo", nullable = false, length = 50)
    @Length(max= 100, message = "O resumo não pode ter mais que {max} caracteres")
    private String resumo;
    
    @NotBlank(message="A editora deve ser informado")
    @Column(name = "editora", nullable = false, length = 50)
    @Length(max= 100, message = "A editora não pode ter mais que {max} caracteres")
    private String editora;
    
    @NotNull(message = "A data dd publicação deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPublicacao", nullable = false)
    private Calendar dataPublicacao;
    
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name="AutorLivro", joinColumns = @JoinColumn(name="LivroBasico",referencedColumnName = "ISBN", nullable = false),
   inverseJoinColumns = @JoinColumn(name="autor", referencedColumnName = "id", nullable = false))
    private Set<Autor> AutorLivro = new HashSet<>();

    public LivroBasico() {
    }
    

    public Set<Autor> getAutorLivro() {
        return AutorLivro;
    }

    public void setAutorLivro(Set<Autor> AutorLivro) {
        this.AutorLivro = AutorLivro;
    }

   

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ISBN);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }

    public void setAutorLivro(Autor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
