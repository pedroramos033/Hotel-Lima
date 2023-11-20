package com.hotel.demo.controler;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.demo.interfacesService.IdetalleServicioService;
import com.hotel.demo.interfacesService.IempleadoService;
import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.interfacesService.IservicioService;
import com.hotel.demo.modelo.Detalle_Servicio;
import com.hotel.demo.modelo.Empleado;
import com.hotel.demo.modelo.Reserva;
import com.hotel.demo.modelo.Servicio;


@Controller
@RequestMapping
public class ControladorDetalleServicio {
	@Autowired
	private IdetalleServicioService serviceDS;
	@Autowired
	@Lazy
	private IreservaService serviceR;
	@Autowired
	private IempleadoService serviceE;
	@Autowired
	private IservicioService serviceS;
	
	@GetMapping("/listarDetalleServicio")
	public String listar(Model model) {
		List<Detalle_Servicio>detservicios = serviceDS.listarDetServicio();
		model.addAttribute("detservicios",detservicios);
		return "DetalleServicio";
	}
	
	@GetMapping("/newDetalleServicio")
	public String agregar(Model model) {
		
		List<Empleado>empleados = serviceE.listarEmpleado();		
		List<Reserva>reservas = serviceR.listarReserva();	
		List<Servicio>servicios = serviceS.listarServicio();
		model.addAttribute("empleados",empleados);	
		model.addAttribute("reservas", reservas);
		model.addAttribute("servicios", servicios);
		model.addAttribute("detservicio", new Detalle_Servicio());
		
		return "NuevoDetalleServicio";
	}
	@PostMapping("/saveDetalleServicio")
	public String guardarDS(@Validated Detalle_Servicio ds, Model model) {
		serviceDS.Guardar(ds);
		return "redirect:/listarDetalleServicio";
	}
	@GetMapping("/editarDetalleServicio/{Id_detservicio}")
	public String editar(@PathVariable int Id_detservicio, Model model) {
		Optional<Detalle_Servicio>detservicio=serviceDS.listarId(Id_detservicio);
		List<Empleado>empleados = serviceE.listarEmpleado();		
		List<Reserva>reservas = serviceR.listarReserva();
		model.addAttribute("empleados",empleados);	
		model.addAttribute("reservas", reservas);
		model.addAttribute("detservicio", detservicio);
		return "NuevoDetalleServicio";
	}
	@GetMapping("/eliminarDetalleServicio/{Id_detservicio}")
	public String delete(Model model, @PathVariable int Id_detservicio) {
		serviceDS.Borrar(Id_detservicio);
		return "redirect:/listarDetalleServicio";
	}
}
