package upeu.edu.pe.resources;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import upeu.edu.pe.dtos.AlumnoCreateDTO;
import upeu.edu.pe.dtos.AlumnoDTO;
import upeu.edu.pe.service.AlumnoService;

import java.util.List;

@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoResource {

    @Inject
    AlumnoService alumnoService;

    @GET
    public List<AlumnoDTO> listar() {
        return alumnoService.listar();
    }

    @GET
    @Path("/{id}")
    public AlumnoDTO buscarPorId(@PathParam("id") Long id) {
        return alumnoService.buscarPorId(id);
    }

    @POST
    public Response crear(@Valid AlumnoCreateDTO dto) {
        AlumnoDTO alumnoCreado = alumnoService.crear(dto);
        return Response.status(Response.Status.CREATED).entity(alumnoCreado).build();
    }

    @PUT
    @Path("/{id}")
    public AlumnoDTO actualizar(@PathParam("id") Long id, @Valid AlumnoCreateDTO dto) {
        return alumnoService.actualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        alumnoService.eliminar(id);
        return Response.noContent().build();
    }
}