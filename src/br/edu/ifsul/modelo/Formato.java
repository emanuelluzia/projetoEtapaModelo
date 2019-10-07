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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name = "formato")
public class Formato implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_formato", sequenceName = "seq_formato_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_formato", strategy = GenerationType.SEQUENCE)
    private Integer id;
    

    
   @NotBlank(message="O nome deve ser informado")
    @Column(name = "nome", nullable = false, length = 50)
    @Length(max= 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;

    public Formato() {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Formato other = (Formato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
   
   
    
}
