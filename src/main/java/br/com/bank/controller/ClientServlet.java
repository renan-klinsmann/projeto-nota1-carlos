package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public ClientServlet() {
		this.service = new ClientServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Client> client = null;
		client = service.getAll();
		
		request.setAttribute("client", client);
		request.getRequestDispatcher("add_client.jsp").forward(request, response);	
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PEGA OS DADOS DO REQUEST
		String name  = request.getParameter("name"); 
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//MONTEI O MEU OBJETO CLIENT
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);
		
		//SALVAR O MEU CLIENT
		if(this.service.save(client) == true) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.sendRedirect("CadastroRealizado.jsp");
		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.sendRedirect("EmailOuPhoneErrado.jsp");
		}
	}

}
