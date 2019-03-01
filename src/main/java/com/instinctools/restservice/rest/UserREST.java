package com.instinctools.restservice.rest;

import com.instinctools.restservice.entity.User;
import com.instinctools.restservice.registrator.UserRegistrator;
import com.instinctools.restservice.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/user")
@RequestScoped
public class UserREST {

    @Inject
    private Logger logger;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserRegistrator userRegistrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers(){
        logger.info("Get all messages");
        return userRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id){
        logger.info("Get mapping by id:" + id);
        return userRepository.getById(id);
    }

    }
