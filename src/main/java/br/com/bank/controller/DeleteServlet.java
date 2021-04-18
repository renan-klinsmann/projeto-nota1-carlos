package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.service.ClientServiceImpl;

@WebServlet("/clientDeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public DeleteServlet() {
		this.service = new ClientServiceImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try {
			service.deleteById(Long.parseLong(id));
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.toString();
		}
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
