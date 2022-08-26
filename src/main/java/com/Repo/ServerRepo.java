 package com.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Server;

public interface ServerRepo extends JpaRepository<Server, Long> 
{
	Server findByIpAddress(String ipAddress);

}
