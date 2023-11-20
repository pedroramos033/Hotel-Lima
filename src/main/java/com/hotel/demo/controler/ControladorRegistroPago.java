package com.hotel.demo.controler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.demo.interfacesService.IregistroPagoService;
import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.interfacesService.IservicioService;
import com.hotel.demo.modelo.Registro_Pago;
import com.hotel.demo.modelo.Reserva;
import com.hotel.demo.modelo.Servicio;

@Controller
@RequestMapping
public class ControladorRegistroPago {
	@Autowired
	private IregistroPagoService service;
	@Autowired	
	private IreservaService serviceR;
	@Autowired
	private IservicioService serviceS;
	@GetMapping("/listarRegistroPago")
	public String listar(Model model) {
		List<Registro_Pago>registros = service.listarRegPago();
		model.addAttribute("registros",registros);
		return "RegistroPago";
	}
	@GetMapping("/newRegistro_Pago")
	public String mostrarFormulario(Model model, @RequestParam(required = false) Integer nroReserva) {
	    List<Reserva> reservas = serviceR.listarReserva();
	    List<Servicio>servicios = serviceS.listarServicio();
	    model.addAttribute("reservas", reservas);
	    model.addAttribute("servicios", servicios);
	    model.addAttribute("registro", new Registro_Pago());
	    return "NuevoRegistroPago";
	}
	
	
	@PostMapping("/saveRegistroPago")
	public String guardar(@Validated Registro_Pago rp, Model model) {
	    

	        // Guarda el Registro_Pago
	        service.GuardarRegistro(rp);

	        return "redirect:/listarRegistroPago";
	    
	}
	@GetMapping("/editarRegistroPago/{Id_pago}")
	public String editar(@PathVariable int Id_pago, Model model) {
		Optional<Registro_Pago>registro=service.listarId(Id_pago);
		model.addAttribute("registro", registro);
		return "NuevoRegistroPago";
	}
	@GetMapping("/eliminarRegistroPago/{Id_pago}")
	public String delete(Model model, @PathVariable int Id_pago) {
		service.Borrar(Id_pago);
		return "redirect:/listarRegistroPago";
	}
	

	@GetMapping("/getPrecioServicio")
	@ResponseBody
	public double getPrecioServicio(@RequestParam int nro_reserva) {
	    try {
	        // Agrega la lógica para obtener el precio de servicio directamente de la base de datos
	        double precioServicio = serviceR.obtenerPrecioServicioPorId(nro_reserva);

	        // Si todo está bien, devuelve el precio del servicio
	        return precioServicio;
	    } catch (Exception e) {
	        // Manejo de errores, puedes personalizar esto según tus necesidades
	        e.printStackTrace();
	        return 0.0; // O un valor predeterminado en caso de error
	    }
	}
	
	
}
