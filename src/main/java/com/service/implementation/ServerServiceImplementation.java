package com.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Repo.ServerRepo;
import com.enumeration.Status;
import com.model.Server;
import com.service.ServerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService{

	@Autowired
	private ServerRepo serverRepo;
	
	
	@Override
	public Server create(Server server)
	{
		
		log.info("Saving new server() : {}",server.getName());

		server.setImageUrl(setServerImageUrl());
		
		return serverRepo.save(server);
	}


	@Override
	public Server ping(String ipAddress) 
	{
		log.info("Pinging server IP() : {}",ipAddress);
	
		Server server = serverRepo.findByIpAddress(ipAddress);
		InetAddress address;
		try {
			address = InetAddress.getByName(ipAddress);
			server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
			serverRepo.save(server);
			return server;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
			
		
		
		
	
	}	

	@Override
	public Collection<Server> list(int limit) {
		log.info("Fetching all servers...");
		
		return serverRepo.findAll(PageRequest.of(0,limit)).toList(); //For pagination
		
	}

	@Override
	public Server get(Long id) {
		
		log.info("Fetching server by id: {}"+id);
		return serverRepo.findById(id).get(); //get returns the actual server
	}

	@Override
	public Server update(Server server) {
		log.info("Updating server : {}",server.getName());
		
		return serverRepo.save(server);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Deleting server with id : {}"+id);
		serverRepo.deleteById(id);
		return true;
	}

	
	
private String setServerImageUrl() {
		
		return null;
	}
}
