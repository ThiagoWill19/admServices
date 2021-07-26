package com.thiagowill.admServices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thiagowill.admServices.entities.Client;
import com.thiagowill.admServices.entities.Product;
import com.thiagowill.admServices.services.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clientes")
	public ModelAndView clientPage() {
		ModelAndView mv = new ModelAndView("clientPage");
		mv.addObject("clientes",clientService.findAll());
		return mv;
	}
	
	@PostMapping("/clientes")
	public String saveClient(Client client) {
		clientService.save(client);
		return "redirect:/clientes";
	}
	
	@GetMapping("/remover{id}")
	public String delete(@PathVariable("id") int id) {
		clientService.deleteById(id);
		return "redirect:/clientes";
	}
	
	@GetMapping("/clientes/{id}")
	public ModelAndView clientDetailPage(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("clientDetailPage");
		mv.addObject("client",clientService.findById(id));
		return mv;
	}
	
	@PostMapping("/clientes/{id}")
	public String updateClient( @PathVariable("id") int id, Product product) {
		Client client  = clientService.findById(id);
		client.getProductList().add(product);
		clientService.save(client);
		return "redirect:/clientes/"+ client.getId();
	}

}
