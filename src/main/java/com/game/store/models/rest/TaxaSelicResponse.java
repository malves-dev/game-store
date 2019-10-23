package com.game.store.models.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author malves
 * 
 *         TaxaSelicResponse
 */
public class TaxaSelicResponse {

    @ApiModelProperty(name = "taxas")
    @JsonProperty("taxas")
    private List<TaxaSelic> taxas;

    @ApiModelProperty(name = "httpStatus")
    @JsonProperty("httpStatus")
    private HttpStatus httpStatus;

    public TaxaSelicResponse() {

    }

    /**
     * 
     * @param taxas
     * @param httpStatus
     */
    public TaxaSelicResponse(List<TaxaSelic> taxas, HttpStatus httpStatus) {
        this.taxas = taxas;
        this.httpStatus = httpStatus;
    }

    /**
     * @return List<TaxaSelic> return the taxas
     */
    public List<TaxaSelic> getTaxas() {
        return taxas;
    }

    /**
     * @param taxas the taxas to set
     */
    public void setTaxas(List<TaxaSelic> taxas) {
        this.taxas = taxas;
    }

    /**
     * @return HttpStatus return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus the httpStatus to set
     */
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}