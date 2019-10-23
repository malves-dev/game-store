package com.game.store.models.rest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author malves
 * 
 *         {@link Produto}
 */
public class Produto {

    @ApiModelProperty(name = "codigo")
    @JsonProperty("codigo")
    @NotNull
    @Positive
    private Long codigo;

    @ApiModelProperty(name = "nome")
    @JsonProperty("nome")
    @NotEmpty
    private String nome;

    @ApiModelProperty(name = "valor")
    @JsonProperty("valor")
    @NotNull
    @Positive
    // @DecimalMin("10.00") valor mínimo
    private Double valor;

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Float return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return Long return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

}
