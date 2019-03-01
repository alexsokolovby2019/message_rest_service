package com.instinctools.restservice.rest;

import com.instinctools.restservice.entity.Message;
import com.instinctools.restservice.registrator.MessageRegistrator;
import com.instinctools.restservice.repository.MessageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/message")
public class MessageREST {

    @Inject
    private Logger logger;

    @Inject
    private MessageRepository messageRepository;

    @Inject
    private MessageRegistrator messageRegistrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getListAll(){
        logger.info("Get all messages");
        return messageRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getById(@PathParam("id") long id){
        logger.info("Get mapping by id:" + id);
        return messageRepository.getById(id);
    }

}
