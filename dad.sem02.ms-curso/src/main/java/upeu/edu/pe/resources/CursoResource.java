package upeu.edu.pe.resources;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import upeu.edu.pe.dtos.CursoCreateDTO;
import upeu.edu.pe.dtos.CursoDTO;
import upeu.edu.pe.service.CursoService;

import java.util.List;

@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CursoResource {

    @Inject
    CursoService cursoService;

    @GET
    public List<CursoDTO> listar() {
        return cursoService.listar();
    }

    @GET
    @Path("/{id}")
    public CursoDTO buscarPorId(@PathParam("id") Long id) {
        return cursoService.buscarPorId(id);
    }

    @POST
    public Response crear(@Valid CursoCreateDTO dto) {
        CursoDTO cursoCreado = cursoService.crear(dto);
        return Response.status(Response.Status.CREATED).entity(cursoCreado).build();
    }

    @PUT
    @Path("/{id}")
    public CursoDTO actualizar(@PathParam("id") Long id, @Valid CursoCreateDTO dto) {
        return cursoService.actualizar(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        cursoService.eliminar(id);
        return Response.noContent().build();
    }
}