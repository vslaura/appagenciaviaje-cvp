package com.cvpsa.appagenciaviajes.business.servlet;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;
import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;
import com.cvpsa.appagenciaviajes.business.services.BusService;
import com.cvpsa.appagenciaviajes.business.services.CategoriaService;
import com.cvpsa.appagenciaviajes.business.services.ClienteService;
import com.cvpsa.appagenciaviajes.business.services.DepartamentoService;
import com.cvpsa.appagenciaviajes.business.services.EmpleadoService;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 

		BusService busService = new BusService();		
		List<BusDTO> listadoBuses = busService.listarBuses("");
		
		HttpSession session = arg0.getSession();		
		session.setAttribute("listadoBuses", listadoBuses);
    
		ClienteService clienteService = new ClienteService();		
		List<ClienteDTO> listaClientes = clienteService.listarClientes();
		
		session.setAttribute("listaClientes", listaClientes);
		
		DepartamentoService departamentoService = new DepartamentoService();		
		List<DepartamentoDTO> listaDepartamentos = departamentoService.listarDepartamentos();
		
		session.setAttribute("listaDepartamentos", listaDepartamentos);
		
		CategoriaService categoriaService = new CategoriaService();
		List<CategoriaDTO> listaCategorias = categoriaService.listarCategorias();
		
		session.setAttribute("listaCategorias", listaCategorias);
		
		
		EmpleadoService empleadoService = new EmpleadoService();
		List<EmpleadoDTO> listaEmpleados = empleadoService.listarEmpleados();
		
		session.setAttribute("listaEmpleados", listaEmpleados);
		
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
