package com.hotel.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.demo.interfacesService.IhabitacionService;
import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.interfacesService.IservicioService;
import com.hotel.demo.modelo.Habitacion;
import com.hotel.demo.modelo.Reserva;
import com.hotel.demo.modelo.Servicio;

public class ReporteControler {
	@Controller
	public class ReservaPagoController {
		@Autowired
		private IreservaService serviceR;
		@Autowired
		private IservicioService serviceS;
		@Autowired
		private IhabitacionService serviceHa;

	    @GetMapping("/reserva_pago")
	    public String mostrarReservaPago(Model model) {
	        // Supongamos que tienes servicios para obtener las listas de entidades
	        List<Reserva> reservas = serviceR.listarReserva();
	        List<Habitacion> habitaciones = serviceHa.listar();
	        List<Servicio> servicios = serviceS.listarServicio();

	        // Agrega las listas al modelo para que puedan ser utilizadas en la vista
	        model.addAttribute("reservas", reservas);
	        model.addAttribute("habitaciones", habitaciones);
	        model.addAttribute("servicios", servicios);

	        return "Reporte";
	    }
	}
}
