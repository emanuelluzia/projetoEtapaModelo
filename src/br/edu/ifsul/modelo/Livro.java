/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name="Livro")
@Inheritance(strategy = InheritanceType.JOINED)

public class Livro extends LivroBasico implements Serializable{
    
    
    @NotBlank(message="O Codigo de Barras deve ser informado")
    @Column(name = "codigoBarras", nullable = false, length = 50)
    @Length(max= 15, message = "O Codigo de Barras não pode ter mais que {max} caracteres")
    private String codigoBarras;
    
    @NotNull(message = "O numero de Paginas de parcelas deve ser informada")
    @Min(value = 1, message = "O numeroPaginas mínima de parcelas é {value}")
    @Column(name = "numeroPaginas", nullable = false)
    private Integer numeroPaginas;
    
    
    @NotNull(message = "Informe se o livro está ativo ou não")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotNull(message = "A data do cadastro deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro", nullable = false)
    private Calendar dataCadastro ;
    
    @NotNull(message = "O valor  deve ser informado")
    @Column(name = "valor", nullable = false,columnDefinition = "numeric(10,2)")
    private double valor;
    
    @NotNull(message = "O catalogo deve ser informada")
    @ManyToOne
    @JoinColumn(name = "catalogo_id",referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;
    
    @NotNull(message = "O formato deve ser informada")
    @ManyToOne
    @JoinColumn(name = "formato_id",referencedColumnName = "id", nullable = false)
    private Formato formato;
    
    @NotNull(message = "O Idioma deve ser informada")
    @ManyToOne
    @JoinColumn(name = "idioma_id",referencedColumnName = "id", nullable = false)
    private Idioma idioma;

    public Livro() {
    }

    
    
    
    
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
         
    
    
    
    
    
    
    
    
    
}
