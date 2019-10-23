package com.game.store.models.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author malves
 * 
 *         CompraProdutoRequest
 */
public class CompraProdutoRequest {

    @ApiModelProperty(name = "produto")
    @JsonProperty("produto")
    @NotNull
    @Valid
    private Produto produto;

    @ApiModelProperty(name = "condicaoPagamento")
    @JsonProperty("condicaoPagamento")
    @NotNull
    @Valid
    private CondicaoPagamento condicaoPagamento;

    /**
     * @return Produto return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return CondicaoPagamento return the condicaoPagamento
     */
    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    /**
     * @param condicaoPagamento the condicaoPagamento to set
     */
    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }

}