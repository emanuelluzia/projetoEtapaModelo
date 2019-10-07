/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name="Autor")
public class Autor implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O nome deve ser informado")
    @Column(name = "nome", nullable = false, length = 50)
    @Length(max= 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    
    @NotBlank(message="A bibliografia deve ser informada")
    @Column(name = "bibliografia", nullable = false)
    private String bibliografia;
    
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name="AutorLivro", joinColumns = @JoinColumn(name="autor",referencedColumnName = "id", nullable = false),
   inverseJoinColumns = @JoinColumn(name="LivroBasico", referencedColumnName = "ISBN", nullable = false))
    private Set<LivroBasico> LivroAutor = new HashSet<>();

    public Set<LivroBasico> getLivroAutor() {
        return LivroAutor;
    }

    public void setLivroAutor(Set<LivroBasico> LivroAutor) {
        this.LivroAutor = LivroAutor;
    }

    public Autor() {
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
