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

import com.hotel.demo.interfacesService.IempleadoService;
import com.hotel.demo.modelo.Empleado;
@Controller
@RequestMapping
public class ControladorEmpleado {
	@Autowired
	private IempleadoService service;
	@GetMapping("/listarEmpleado")
	public String listar(Model model) {
		List<Empleado>empleados = service.listarEmpleado();
		model.addAttribute("empleados",empleados);
		return "Empleado";
	}
	@GetMapping("/newEmpleado")
	public String agregar(Model model) {
		model.addAttribute("empleado",new Empleado());
		return "NuevoEmpleado";
	}
	@PostMapping("/saveEmpleado")
	public String guardar(@Validated Empleado e, Model model) {
		service.Guardar(e);
		return "redirect:/listarEmpleado";
	}
	@GetMapping("/editarEmpleado/{Id_empleado}")
	public String editar(@PathVariable Integer Id_empleado, Model model) {
		Optional<Empleado>empleado=service.listarId(Id_empleado);
		model.addAttribute("empleado", empleado);
		return "NuevoEmpleado";
	}
	@GetMapping("/eliminarEmpleado/{Id_empleado}")
	public String delete(Model model, @PathVariable Integer Id_empleado) {
		service.Borrar(Id_empleado);
		return "redirect:/listarEmpleado";
	}

}
