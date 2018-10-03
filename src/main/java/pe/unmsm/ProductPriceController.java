package pe.unmsm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPriceController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ProductPriceRepository repository;

	@GetMapping("/catalogo/name/{name}")
	public ProductPrice retrieveProductPrice(@PathVariable String name) {
	
		ProductPrice productPrice = repository.findOneByName(name);
		productPrice.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return productPrice;
	
	}

}
