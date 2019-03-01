package com.instinctools.restservice.rest;

import com.instinctools.restservice.entity.MessageMapping;
import com.instinctools.restservice.registrator.MessageMappingRegistrator;
import com.instinctools.restservice.repository.MessageMappingRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/message_mapping")
public class MessageMappingREST {
    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator registrator;

    @Inject
    private MessageMappingRepository repository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll(){
        logger.info("Get full message mapping");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(long id){
        logger.info("Get mapping by id:" + id);
        return repository.getById(id);
    }
}
