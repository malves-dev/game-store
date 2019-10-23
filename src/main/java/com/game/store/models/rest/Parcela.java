package com.game.store.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author malves
 * 
 *         {@link Parcela}
 */
public class Parcela {

    public Parcela() {
    }

    /**
     * 
     * @param numeroParcela
     * @param valor
     * @param taxaJurosAoMes
     */
    public Parcela(Integer numeroParcela, Double valor, Double taxaJurosAoMes) {
        this.numeroParcela = numeroParcela;
        this.valor = valor;
        this.taxaJurosAoMes = taxaJurosAoMes;
    }

    @ApiModelProperty(name = "numeroParcela")
    @JsonProperty("numeroParcela")
    private Integer numeroParcela;

    @ApiModelProperty(name = "valor")
    @JsonProperty("valor")
    private Double valor;

    @ApiModelProperty(name = "taxaJurosAoMes")
    @JsonProperty("taxaJurosAoMes")
    private Double taxaJurosAoMes;

    /**
     * @return Integer return the numeroParcela
     */
    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    /**
     * @param numeroParcela the numeroParcela to set
     */
    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    /**
     * @return Double return the valor
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
     * @return Double return the taxaJurosAoMes
     */
    public Double getTaxaJurosAoMes() {
        return taxaJurosAoMes;
    }

    /**
     * @param taxaJurosAoMes the taxaJurosAoMes to set
     */
    public void setTaxaJurosAoMes(Double taxaJurosAoMes) {
        this.taxaJurosAoMes = taxaJurosAoMes;
    }

}