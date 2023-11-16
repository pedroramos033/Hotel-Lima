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

import com.hotel.demo.interfacesService.IhabitacionService;
import com.hotel.demo.modelo.Habitacion;


@Controller
@RequestMapping
public class ControladorHabitacion {
	@Autowired
	private IhabitacionService service;
	@GetMapping("/listarHabitacion")
	public String listar(Model model) {
		List<Habitacion>habitaciones = service.listar();
		model.addAttribute("habitaciones",habitaciones);
		return "Habitacion";
	}
	@GetMapping("/newHabitacion")
	public String agregar(Model model) {
		model.addAttribute("habitacion",new Habitacion());
		return "NuevaHabitacion";
	}
	@PostMapping("/saveHabitacion")
	public String guardar(@Validated Habitacion h, Model model) {
		service.Guardar(h);
		return "redirect:/listarHabitacion";
	}
	@GetMapping("/editarHabitacion/{Nro_habi}")
	public String editar(@PathVariable int Nro_habi, Model model) {
		Optional<Habitacion>habitacion=service.listarNro(Nro_habi);
		model.addAttribute("habitacion", habitacion);
		return "NuevaHabitacion";
	}
	@GetMapping("/eliminarHabitacion/{Nro_habi}")
	public String delete(Model model, @PathVariable int Nro_habi) {
		service.Borrar(Nro_habi);
		return "redirect:/listarHabitacion";
	}
}
