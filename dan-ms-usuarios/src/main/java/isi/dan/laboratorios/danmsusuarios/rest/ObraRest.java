package isi.dan.laboratorios.danmsusuarios.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import isi.dan.laboratorios.danmsusuarios.dtos.requests.ObraRequestDTO;
import isi.dan.laboratorios.danmsusuarios.services.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import isi.dan.laboratorios.danmsusuarios.domain.Empleado;
import isi.dan.laboratorios.danmsusuarios.domain.Obra;

@RestController
@RequestMapping(ObraRest.API_OBRA)
@CrossOrigin
@Api(value = "ObraRest", description = "Permite gestionar las obras de la empresa")
public class ObraRest {
    static final String API_OBRA = "/api/obra";
    
    private static final List<Obra> listaObras = new ArrayList<Obra>();
    private static Integer ID_GEN = 1;

    @Autowired
    ObraService obraService;

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un obra por id")
    public ResponseEntity<Obra> obraPorId(@PathVariable Integer id){

        Optional<Obra> o =  listaObras
                .stream()
                .filter(unaObra -> unaObra.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(o);
    }

    @GetMapping
    @ApiOperation(value = "Retorna las obras")
    public ResponseEntity<List<Obra>> todas(){
        return ResponseEntity.ok(listaObras);
    }


    @GetMapping(path = "/obras/{idCliente}")
    @ResponseBody
    public ResponseEntity<List<String>> obraPorCliente(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(obraService.getObraPorCliente(idCliente));
    }

    @PostMapping
    @ApiOperation(value = "Da de alta una obra")
    @CrossOrigin
    public void crear(@RequestBody ObraRequestDTO nuevo){
        obraService.crear(nuevo);
        System.out.println("Obra creada exitosamente");
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza una obra")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualizado correctamente"),
        @ApiResponse(code = 401, message = "No autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<Obra> actualizar(@RequestBody Obra nuevo,  @PathVariable Integer id) {
        OptionalInt indexOpt = IntStream.range(0, listaObras.size())
        .filter(i -> listaObras.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            nuevo.setId(id);
            listaObras.set(indexOpt.getAsInt(), nuevo);
            return ResponseEntity.ok(nuevo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Elimina una obra")
    public ResponseEntity<Empleado> borrar(@PathVariable Integer id){
        OptionalInt indexOpt = IntStream.range(0, listaObras.size())
        .filter(i -> listaObras.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaObras.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}