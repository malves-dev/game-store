package com.game.store.core;

import java.util.List;

import com.game.store.models.rest.CompraProdutoRequest;
import com.game.store.models.rest.Parcela;

/**
 * @author malves
 */
public interface IProdutoPort {

    /**
     * 
     * @param Dados de produto e condições de pagamentos
     * @return lista de parcelas
     */
    List<Parcela> comprar(CompraProdutoRequest produto);
}