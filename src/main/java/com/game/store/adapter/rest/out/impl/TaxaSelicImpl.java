package com.game.store.adapter.rest.out.impl;

import java.util.List;

import com.game.store.adapter.rest.out.ITaxaSelic;
import com.game.store.exception.GameStoreException;
import com.game.store.models.rest.TaxaSelic;
import com.game.store.models.rest.TaxaSelicResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author malves
 */
@Service
@PropertySource("classpath:url.properties")
public class TaxaSelicImpl implements ITaxaSelic {

	@Autowired
	RestTemplate restTemplate;

	@Value("${url.selic}")
	private String url;

	public TaxaSelicImpl() {

	}

	/**
	 * @author malves
	 */
	public TaxaSelicResponse getTaxaSelic() {

		HttpStatus httpStatus = null;
		List<TaxaSelic> taxas = null;

		try {
			ResponseEntity<List<TaxaSelic>> response = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TaxaSelic>>() {
					});

			taxas = response.getBody();
			httpStatus = response.getStatusCode();
		} catch (Exception e) {
			throw new GameStoreException(e);
		}

		return new TaxaSelicResponse(taxas, httpStatus);

	}

}
