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


import com.hotel.demo.interfacesService.IdetalleReservaService;
import com.hotel.demo.interfacesService.IhabitacionService;
import com.hotel.demo.interfacesService.IreservaService;
import com.hotel.demo.modelo.Detalle_Reserva;

import com.hotel.demo.modelo.Habitacion;
import com.hotel.demo.modelo.Reserva;

import jakarta.transaction.Transactional;


@Controller
@RequestMapping
public class ControladorDetalleReserva {
	@Autowired
	private IdetalleReservaService serviceDR;
	@Autowired
	private IreservaService serviceR;
	@Autowired
	private IhabitacionService ServiceH;
	@GetMapping("/listarDetalleReserva")
	public String listar(Model model) {
		List<Detalle_Reserva>detreservas = serviceDR.listarDetReserva();
		model.addAttribute("detreservas",detreservas);
		return "DetalleReserva";
	}
	
	@GetMapping("/newDetalleReserva")
	public String agregar(Model model) {
		
		List<Habitacion>habitaciones = ServiceH.listar();		
		List<Reserva>reservas = serviceR.listarReserva();
		model.addAttribute("habitaciones",habitaciones);
		model.addAttribute("reservas", reservas);	
		model.addAttribute("detreserva", new Detalle_Reserva());
		
		return "NuevoDetalleReserva";
	}
	
	@PostMapping("/saveDetalleReserva")
	@Transactional
	public String guardarDR(@Validated Detalle_Reserva dr, Model model) {
		
        serviceDR.crearReservaConDetalle(dr);

        return "redirect:/listarDetalleReserva";
	}


	
	@GetMapping("/editarDetalleReserva/{Id_detreserva}")
	public String editar(@PathVariable int Id_detreserva, Model model) {
		Optional<Detalle_Reserva>detreserva=serviceDR.listarId(Id_detreserva);	
		List<Habitacion>habitaciones = ServiceH.listar();
		List<Reserva>reservas = serviceR.listarReserva();			
		model.addAttribute("habitaciones",habitaciones);
		model.addAttribute("reservas", reservas);
		model.addAttribute("detreserva", detreserva);
		return "NuevoDetalleReserva";
	}
	@GetMapping("/eliminarDetalleReserva/{Id_detreserva}")
	public String delete(Model model, @PathVariable int Id_detreserva) {
		// Obtener el detalle de la reserva a eliminar
        Optional<Detalle_Reserva> detreserva = serviceDR.listarId(Id_detreserva);
        if (detreserva.isPresent()) {
            // Obtener la reserva asociada al detalle
            Reserva reserva = detreserva.get().getObjReserva();

            // Verificar si la reserva y la habitación asociada existen
            if (reserva != null && reserva.getObjHabitacion() != null) {
                // Obtener la habitación y actualizar su estado
                Habitacion habitacion = reserva.getObjHabitacion();
                habitacion.disponibilizar(); // Utiliza el método que actualiza el estado
                ServiceH.Guardar(habitacion); // Guardar la habitación
            }

            // Eliminar el detalle de la reserva
            serviceDR.Borrar(Id_detreserva);
        }
        return "redirect:/listarDetalleReserva";
	}
	
}
