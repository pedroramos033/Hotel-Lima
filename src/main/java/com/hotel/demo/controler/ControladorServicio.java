package com.hotel.demo.controler;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.demo.interfacesService.IservicioService;
import com.hotel.demo.modelo.Servicio;
@Controller
@RequestMapping
public class ControladorServicio {
	@Autowired
	private IservicioService service;
	@GetMapping("/listarServicio")
	public String listar(Model model) {
		List<Servicio>servicios = service.listarServicio();
		model.addAttribute("servicios", servicios);
		return "Servicio";
	}
	@GetMapping("/newServicio")
	public String agregar(Model model) {
		model.addAttribute("servicio", new Servicio());
		return "NuevoServicio";
	}
	@PostMapping("/saveServicio")
	public String guardar(@Validated Servicio s, Model model) {
		service.Guardar(s);
		return "redirect:/listarServicio";
	}
	@GetMapping("/editarServicio/{Id_servicio}")
	public String editar(@PathVariable int Id_servicio, Model model) {
		Optional<Servicio>servicio=service.listarId(Id_servicio);
		model.addAttribute("servicio", servicio);
		return "NuevoServicio";
	}
	@GetMapping("/eliminarServicio/{Id_servicio}")
	public String delete(Model model, @PathVariable int Id_servicio) {
		service.Borrar(Id_servicio);
		return "redirect:/listarServicio";

	}
}
