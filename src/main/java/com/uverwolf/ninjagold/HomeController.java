package com.uverwolf.ninjagold;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController  {
	
	@RequestMapping("/")
	public String index(HttpSession session,HttpServletRequest request) {
		if(session.isNew()) {
			List<String> actividades = new ArrayList<String>();
			session.setAttribute("oro", 0);
			session.setAttribute("actividades", actividades);
		}	
		return "index.jsp";
	}
	
	@RequestMapping(value = "/granja", method = RequestMethod.POST)
	public String granja( HttpSession session,HttpServletRequest request) {
		//se llama al valor de oro de la sesion
		int oro = (Integer) session.getAttribute("oro");
		LocalDateTime fecha = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE','dd' de 'MMMM','yyyy, hh:mm:ss a");
		
		//numero Aleatoria a generar
		Aleatorio random = new Aleatorio();
		int numAleatorio = random.aleatorio(20, 10);
		
		//se le agrega el valor aleatorio al oro
		 oro+=numAleatorio;
		 
		//se actualiza el oro de la sesion
		session.setAttribute("oro", oro);
		
		//se llama al array de la sesion para guardar el string
		List<String> act = (List<String>) session.getAttribute("actividades");
		
		//se agrega el nuevo valor a la session
		session.setAttribute("logActividades", act.add("Fuiste a la granja y ganaste: "+numAleatorio+" de oro "+fecha.format(formatoFecha)));
		return "redirect:/";
	}
	
	@RequestMapping(value ="/cueva" , method = RequestMethod.POST)
	public String cueva(HttpSession session,HttpServletRequest request) {
		int oro = (Integer) session.getAttribute("oro");
		LocalDateTime fecha = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE','dd' de 'MMMM','yyyy, hh:mm:ss a");
		
		Aleatorio random = new Aleatorio();
		int numAleatorio = random.aleatorio(10, 5);
		
		oro+=numAleatorio;
		session.setAttribute("oro", oro);
		
		List<String> act = (List<String>)session.getAttribute("actividades");
		
		session.setAttribute("logActividades", act.add("Entraste a la cueva y ganaste: "+numAleatorio+" de oro "+fecha.format(formatoFecha)));
		return "redirect:/";
	}
	
	@RequestMapping(value = "/casa" , method = RequestMethod.POST)
	public String casa(HttpSession session, HttpServletRequest request) {
		int oro = (Integer) session.getAttribute("oro");
		LocalDateTime fecha = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE','dd' de 'MMMM','yyyy, hh:mm:ss a");
		
		Aleatorio random = new Aleatorio();
		int numAleatorio = random.aleatorio(5, 2);
		
		oro+=numAleatorio;
		session.setAttribute("oro", oro);
		
		List<String> act = (List<String>)session.getAttribute("actividades");
		
		session.setAttribute("logActividades", act.add("Entraste a una casa y ganaste: "+numAleatorio+" de oro "+fecha.format(formatoFecha)));
		return "redirect:/";
	}
	@RequestMapping(value = "/casino", method =RequestMethod.POST)
	public String casino(HttpSession session, HttpServletRequest request) {
		int oro = (Integer) session.getAttribute("oro");
		LocalDateTime fecha = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE','dd' de 'MMMM','yyyy, hh:mm:ss a");
		
		List<String> act = (List<String>)session.getAttribute("actividades");
		Aleatorio random = new Aleatorio();
		
		int numAleatorio = random.aleatorio(50, -50);
		session.setAttribute("random", numAleatorio);
		oro+=numAleatorio;
		session.setAttribute("oro", oro);
		
		if(numAleatorio<=0) {
			session.setAttribute("logActividades", act.add("Fuiste al casino y perdiste: "+numAleatorio+" de oro "+fecha.format(formatoFecha)));
		}else {
			session.setAttribute("logActividades", act.add("Fuiste al casino y ganaste : "+numAleatorio+" de oro "+fecha.format(formatoFecha)));
		}
		
		
		return "redirect:/";
	}
}
