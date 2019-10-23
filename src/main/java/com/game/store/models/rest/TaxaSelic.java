package com.game.store.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author malves
 * 
 *         TaxaSelic
 *         {@link https://dadosabertos.bcb.gov.br/dataset/11-taxa-de-juros---selic}
 */
public class TaxaSelic {

    @ApiModelProperty(name = "data")
    @JsonProperty("data")
    private String data;

    @ApiModelProperty(name = "valor")
    @JsonProperty("valor")
    private String valor;

    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

}