/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ClientDaoImpl;
import br.com.bank.model.Client;

/**
 * @author cbgomes
 *
 */
public class ClientServiceImpl implements ClientService {
	
	private ClientDaoImpl dao;
	
	public ClientServiceImpl() {
		this.dao = new ClientDaoImpl();
	}

	@Override
	public Client getClient(String name) {
		return this.dao.getClient(name);
	}

	@Override
	public List<Client> getAll() {
		return this.dao.getAll();
	}

	@Override
	public Boolean save(Client client) {
		if(this.dao.save(client)) {
			return true;
		}else { 
			return false;
		}
	}
		
	

	@Override
	public Boolean deleteById(Long idClient) {
		 if(this.dao.deleteById(idClient)) {
			 return true;
		 }else {
			 return false;
		 }
	}

	
}
