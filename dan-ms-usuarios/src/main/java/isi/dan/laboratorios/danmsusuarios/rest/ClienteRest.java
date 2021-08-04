package isi.dan.laboratorios.danmsusuarios.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
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
import isi.dan.laboratorios.danmsusuarios.domain.Cliente;
import isi.dan.laboratorios.danmsusuarios.services.ClienteService;

@RestController
@RequestMapping(ClienteRest.API_CLIENTE)
@Api(value = "ClienteRest", description = "Permite gestionar los clientes de la empresa")
public class ClienteRest {
    static final String API_CLIENTE = "/api/cliente";

    @Autowired
    ClienteService clienteService; 
    
    private static final List<Cliente> listaClientes = new ArrayList<>();
    private static Integer ID_GEN = 1;

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un cliente por id")
    public ResponseEntity<Cliente> clientePorId(@PathVariable Integer id){

        /*Optional<Cliente> c =  listaClientes
                .stream()
                .filter(unCli -> unCli.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(c);*/
        return ResponseEntity.of(clienteService.buscarCliente(id));
    }

    @GetMapping
    @ApiOperation(value = "Retorna una lista de todos los clientes")
    public ResponseEntity<Iterable<Cliente>> todos(){
        /*return ResponseEntity.ok(listaClientes);*/
        return ResponseEntity.ok(clienteService.buscarClientes());
    }

    // GET por cuit -> Retorna un único cliente
    @GetMapping(path = "/cuit/{cuit}")
    @ApiOperation(value = "Busca un cliente por cuit")
    public ResponseEntity<Cliente> clientePorCuit(@PathVariable String cuit) {
        /*Optional<Cliente> c =  listaClientes
                .stream()
                .filter(unCli -> unCli.getCuit().equals(cuit))
                .findFirst();
        return ResponseEntity.of(c);*/
        return ResponseEntity.of(clienteService.buscarCliente(cuit));
    }

    // GET por razon social (query string OPC) -> Retorna una lista de clientes con la razon social especificada, example: "api/cliente/razonsocial?razonSocial=example"
    @GetMapping(path = "/razonsocial")
    @ApiOperation(value = "Retorna una lista de clientes que contengan la razon social especificada, no es un parametro obligatorio")
    @ResponseBody
    public ResponseEntity<Optional<Iterable<Cliente>>> clientePorRazonSocial(
        @RequestParam(required = false) String razonSocial) {
        /*List<Cliente> c =  listaClientes
                .stream()
                .filter(unCli -> unCli.getRazonSocial().equals(razonSocial))
                .collect(Collectors.toList());

        return ResponseEntity.ok(c);*/
        return ResponseEntity.ok(clienteService.buscarClientes(razonSocial)));
    }

    @PostMapping
    @ApiOperation(value = "Da de alta un cliente")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente nuevo){
        /*nuevo.setId(ID_GEN++);
        listaClientes.add(nuevo);
        return ResponseEntity.ok(nuevo);*/
        return ResponseEntity.ok(clienteService.guardarCliente(nuevo));
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un cliente")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualizado correctamente"),
        @ApiResponse(code = 401, message = "No autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente nuevo,  @PathVariable Integer id) {
        /*OptionalInt indexOpt = IntStream.range(0, listaClientes.size())
        .filter(i -> listaClientes.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            nuevo.setId(id);
            listaClientes.set(indexOpt.getAsInt(), nuevo);
            return ResponseEntity.ok(nuevo);
        } else {
            return ResponseEntity.notFound().build();
        }*/
        return ResponseEntity.of(clienteService.actualizarCliente(nuevo, id));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borra un cliente")
    public ResponseEntity<Cliente> borrar(@PathVariable Integer id) {
        /*OptionalInt indexOpt =   IntStream.range(0, listaClientes.size())
        .filter(i -> listaClientes.get(i).getId().equals(id))
        .findFirst();

        if(indexOpt.isPresent()){
            listaClientes.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }*/
        clienteService.borrarCliente(id);
        return ResponseEntity.ok().build();
    }

}
