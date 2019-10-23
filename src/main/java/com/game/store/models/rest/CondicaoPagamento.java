package com.game.store.models.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author malves
 * 
 */
public class CondicaoPagamento {

    @ApiModelProperty(name = "valorEntrada")
    @JsonProperty("valorEntrada")
    @NotNull
    private Double valorEntrada;

    @ApiModelProperty(name = "qtdeParcelas")
    @JsonProperty("qtdeParcelas")
    @NotNull
    @Positive
    private Integer qtdeParcelas;

    /**
     * @return Float return the valorEntrada
     */
    public Double getValorEntrada() {
        return valorEntrada;
    }

    /**
     * @param valorEntrada the valorEntrada to set
     */
    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    /**
     * @return Integer return the qtdeParcelas
     */
    public Integer getQtdeParcelas() {
        return qtdeParcelas;
    }

    /**
     * @param qtdeParcelas the qtdeParcelas to set
     */
    public void setQtdeParcelas(Integer qtdeParcelas) {
        this.qtdeParcelas = qtdeParcelas;
    }

}