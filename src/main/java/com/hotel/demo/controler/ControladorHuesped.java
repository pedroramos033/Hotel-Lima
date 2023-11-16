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


import com.hotel.demo.interfacesService.IhuespedService;
import com.hotel.demo.modelo.Huesped;

@Controller
@RequestMapping
public class ControladorHuesped {
	@Autowired
	private IhuespedService service;
	@GetMapping("/listarHuesped")
	public String listar(Model model) {
		List<Huesped>huespeds = service.listarHuesped();
		model.addAttribute("huespeds",huespeds);
		return "Huesped";
	}
	@GetMapping("/newHuesped")
	public String agregar(Model model) {
		model.addAttribute("huesped",new Huesped());
		return "NuevoHuesped";
	}
	@PostMapping("/saveHuesped")
	public String guardar(@Validated Huesped h, Model model) {
		service.Guardar(h);
		return "redirect:/listarHuesped";
	}
	@GetMapping("/editarHuesped/{Id_huesped}")
	public String editar(@PathVariable int Id_huesped, Model model) {
		Optional<Huesped>huesped=service.listarId(Id_huesped);
		model.addAttribute("huesped", huesped);
		return "NuevoHuesped";
	}
	@GetMapping("/eliminarHuesped/{Id_huesped}")
	public String delete(Model model, @PathVariable int Id_huesped) {
		service.Borrar(Id_huesped);
		return "redirect:/listarHuesped";
	}
}
