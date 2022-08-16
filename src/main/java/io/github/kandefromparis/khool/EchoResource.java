package io.github.kandefromparis.khool;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/echo")
public class EchoResource {

    @PUT
    public String putHello() {
        return this.hello();
    }
    @POST
    public String postHello() {
        return this.hello();
    }
    @HEAD
    public String headHello() {
        return this.hello();
    }
    @DELETE
    public String deleteHello() {
        return this.hello();
    }
    @OPTIONS
    public String optionsHello() {
        return this.hello();
    }
    @GET
    public String getHello() {
        return this.hello();
    }

    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}