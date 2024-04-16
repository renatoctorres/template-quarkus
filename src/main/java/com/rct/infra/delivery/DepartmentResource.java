package com.rct.infra.delivery;

import com.rct.core.service.DepartmentService;
import com.rct.core.service.model.Department;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;
import java.util.UUID;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.noContent;
import static jakarta.ws.rs.core.Response.ok;
import static jakarta.ws.rs.core.Response.status;
import static jakarta.ws.rs.core.Response.Status.CREATED;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/departments")
@RequiredArgsConstructor
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class DepartmentResource {
    private final DepartmentService service;

    @GET
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Successful operation", content =
            @Content(mediaType = APPLICATION_JSON))})
    public List<Department> findAll() {
        return service.findAll();

    }

    @GET
    @Path("/name/{name}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Successful operation", content =
            @Content(mediaType = APPLICATION_JSON))})
    public List<Department> findByName(@PathParam("name") String name) {
        return service.findByName(name);

    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        var item = service.findById(id);
        if (item != null) {
            return ok().entity(item).build();
        } else {
            return status(NOT_FOUND) .build();
        }

    }

    @POST
    public Response create(Department department) {
        service.create(department);
        return status(CREATED)
                .entity(department)
                .build();
    }

    @PUT
    public Response update( Department department) {
        service.update(department);
        return ok().entity(department).build();

    }

    @DELETE
    @Produces(APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteById(@PathParam("id") UUID id) {
        service.deleteById(id);
        return noContent().build();
    }
}
