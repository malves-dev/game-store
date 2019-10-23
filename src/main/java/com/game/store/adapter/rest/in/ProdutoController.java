
package com.game.store.adapter.rest.in;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.game.store.core.IProdutoPort;
import com.game.store.error.ErrorDetails;
import com.game.store.exception.GameStoreException;
import com.game.store.models.rest.CompraProdutoRequest;
import com.game.store.models.rest.Parcela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author malves
 */
@RestController
@Validated
@RequestMapping("/v1/produto")
@Api(value = "Produto", tags = { "Compra, Prestações, Taxa de juros" })
public class ProdutoController {

	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Echo => %s!";

	@Autowired
	IProdutoPort produtoPort;

	@RequestMapping(value = "/echo", method = RequestMethod.GET)
	public Echo echo(@RequestParam(value = "echo", defaultValue = "API de serviços da Game Store") String name) {
		return new Echo(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/comprar")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Realiza transação de compra de produto", response = Parcela.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad request format", response = ErrorDetails.class) })
	public ResponseEntity<List<Parcela>> comprar(@Valid @RequestBody CompraProdutoRequest compra,
			HttpServletResponse response) throws IOException {

		List<Parcela> parcelas = null;

		try {
			parcelas = produtoPort.comprar(compra);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (GameStoreException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
		}

		return ResponseEntity.status(response.getStatus()).body(parcelas);
	}
}
