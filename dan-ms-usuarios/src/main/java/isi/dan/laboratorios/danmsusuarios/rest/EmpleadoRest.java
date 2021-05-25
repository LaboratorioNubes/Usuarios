package isi.dan.laboratorios.danmsusuarios.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import isi.dan.laboratorios.danmsusuarios.domain.Empleado;

@RestController
@RequestMapping(EmpleadoRest.API_EMPLEADO)
@Api(value = "EmpleadoRest", description = "Permite gestionar los empleados de la empresa")
public class EmpleadoRest {
    static final String API_EMPLEADO = "/api/empleado";
    
    private static final List<Empleado> listaEmpleados = new ArrayList<>();
    private static Integer ID_GEN = 1;

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un empleado por id")
    public ResponseEntity<Empleado> empleadoPorId(@PathVariable Integer id){

        Optional<Empleado> e =  listaEmpleados
                .stream()
                .filter(unEmp -> unEmp.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(e);
    }

    @GetMapping
    @ApiOperation(value = "Retorna todos los empleados")
    public ResponseEntity<List<Empleado>> todos(){
        return ResponseEntity.ok(listaEmpleados);
    }

    // GET por nombre (query string OPC) -> Retorna una lista de empleados 
    @GetMapping(path = "/nombre")
    @ApiOperation(value = "Busca un empleado por nombre de usuario")
    @ResponseBody
    public ResponseEntity<Empleado> empleadoPorNombre(
        @RequestParam(required = false) String nombre) {
        Optional<Empleado> e =  listaEmpleados
                .stream()
                .filter(unEmp -> unEmp.getUser().getUser().equals(nombre))
                .findFirst();

        return ResponseEntity.of(e);
    }

    @PostMapping
    @ApiOperation("Da de alta un empleado")
    public ResponseEntity<Empleado> crear(@RequestBody Empleado nuevo){
    	System.out.println("Crear empleado "+ nuevo);
        nuevo.setId(ID_GEN++);
        listaEmpleados.add(nuevo);
        return ResponseEntity.ok(nuevo);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un empleado")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualizado correctamente"),
        @ApiResponse(code = 401, message = "No autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<Empleado> actualizar(@RequestBody Empleado nuevo,  @PathVariable Integer id) {
        OptionalInt indexOpt = IntStream.range(0, listaEmpleados.size())
        .filter(i -> listaEmpleados.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            nuevo.setId(id);
            listaEmpleados.set(indexOpt.getAsInt(), nuevo);
            return ResponseEntity.ok(nuevo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Elimina un empleado")
    public ResponseEntity<Empleado> borrar(@PathVariable Integer id){
        OptionalInt indexOpt =   IntStream.range(0, listaEmpleados.size())
        .filter(i -> listaEmpleados.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaEmpleados.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}