/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuel
 */

@Entity
@Table(name="catalogo")
public class Catalogo implements Serializable{
    
    @Id
    
    @SequenceGenerator(name = "seq_catalogo", sequenceName = "seq_catalogo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    

    
   @NotBlank(message="O nome deve ser informado")
    @Column(name = "nome", nullable = false, length = 50)
    @Length(max= 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
   
    @NotBlank(message="A descriçao deve ser informado")
    @Column(name = "descricao", nullable = false, length = 50)
    @Length(max= 100, message = "A descriçao não pode ter mais que {max} caracteres")
    private String descricao;
    
    @NotNull(message = "A livraria deve ser informada")
    @ManyToOne
    @JoinColumn(name = "livraria_id",referencedColumnName = "id", nullable = false)
    private Livraria livraria;

    
    
    public Catalogo() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Catalogo other = (Catalogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

    
}
