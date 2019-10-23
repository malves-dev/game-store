package com.game.store.core.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.game.store.adapter.rest.out.ITaxaSelic;
import com.game.store.core.IProdutoPort;
import com.game.store.exception.GameStoreException;
import com.game.store.models.rest.CompraProdutoRequest;
import com.game.store.models.rest.Parcela;
import com.game.store.models.rest.TaxaSelicResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author malves
 * 
 */
@Service
@PropertySource("classpath:prazo.properties")
public class ProdutoPortImpl implements IProdutoPort {

    @Autowired
    private ITaxaSelic taxaSelic;

    /**
     * A taxa foi parametrizada, com default = 0
     */
    @Value("${taxa.ao.mes}")
    private double taxa;

    /**
     * A quantidade de parcelas foi parametrizada, com default = 6
     */
    @Value("${quantidade.de.parcelas}")
    private int parcelas;

    @Override
    public List<Parcela> comprar(CompraProdutoRequest request) throws GameStoreException {

        return calculaParcelas(request);
    }

    /**
     * @param compra (dados)
     * @return calcula parcelas
     */
    public List<Parcela> calculaParcelas(CompraProdutoRequest request) {

        double i = this.taxa;
        double pv = request.getProduto().getValor();
        double entrada = request.getCondicaoPagamento().getValorEntrada();
        int n = request.getCondicaoPagamento().getQtdeParcelas();

        // Busca taxa selic
        if (request.getCondicaoPagamento().getQtdeParcelas() >= parcelas) {
            try {
                TaxaSelicResponse resp = taxaSelic.getTaxaSelic();
                double sel = resp.getTaxas().stream().mapToDouble(taxa -> Double.valueOf(taxa.getValor())).sum();
                i = sel;
            } catch (Exception e) {
                throw new GameStoreException(e);
            }
        }

        double pmt = 0.0;
        List<Parcela> list = new ArrayList<Parcela>();

        try {
            if (i == 0.0) {
                pmt = (pv - entrada) / n;
            } else {
                // PMT=PV/(1+i)ⁿ-1/(1+i)ⁿ.i <- Equação financeira utilizada para parcelamentos
                pmt = (pv - entrada) / ((Math.pow(1 + (i / 100), n) - 1) / ((Math.pow(1 + (i / 100), n) * i))) / 100;
            }

            BigDecimal pmt_format = new BigDecimal(pmt).setScale(2, RoundingMode.HALF_EVEN);
            BigDecimal i_format = new BigDecimal(i).setScale(2, RoundingMode.HALF_EVEN);

            for (int p = 1; p <= n; p++) {
                list.add(new Parcela(p, pmt_format.doubleValue(), i_format.doubleValue()));
            }

        } catch (Exception e) {
            throw new GameStoreException(e);
        }

        return list;
    }

}