package isi.dan.laboratorios.danmsusuarios.rest;

import java.util.List;
import java.util.Optional;

import isi.dan.laboratorios.danmsusuarios.dtos.requests.ClienteRequestDTO;
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
import isi.dan.laboratorios.danmsusuarios.dtos.ClienteDTO;
import isi.dan.laboratorios.danmsusuarios.services.ClienteService;

import javax.validation.Valid;

@RestController
@RequestMapping(ClienteRest.API_CLIENTE)
@Api(value = "ClienteRest", description = "Permite gestionar los clientes de la empresa")
public class ClienteRest {
    static final String API_CLIENTE = "/api/cliente";

    @Autowired
    ClienteService clienteService; 

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un cliente por id")
    public ResponseEntity<ClienteDTO> clientePorId(@PathVariable Integer id){
        return ResponseEntity.of(Optional.of(clienteService.buscarCliente(id)));
    }

    @GetMapping
    @ApiOperation(value = "Retorna una lista de todos los clientes")
    public ResponseEntity<List<ClienteDTO>> todos(){
        return ResponseEntity.ok(clienteService.buscarClientes());
    }


    @GetMapping(path = "/cuit/{cuit}")
    @ApiOperation(value = "Busca un cliente por cuit")
    public ResponseEntity<ClienteDTO> clientePorCuit(@PathVariable String cuit) {
        return ResponseEntity.of(Optional.of(clienteService.buscarCliente(cuit)));
    }

    //Example: "api/cliente/razonsocial?razonSocial=example"
    @GetMapping(path = "/razonsocial")
    @ApiOperation(value = "Retorna una lista de clientes que contengan la razon social especificada, no es un parametro obligatorio")
    @ResponseBody
    public ResponseEntity<List<ClienteDTO>> clientePorRazonSocial(
        @RequestParam(required = false) String razonSocial) {
        return ResponseEntity.ok(clienteService.buscarClientes(razonSocial));
    }

    @PostMapping
    @ApiOperation(value = "Da de alta un cliente")
    public ResponseEntity<String> crear(@Valid @RequestBody ClienteRequestDTO cliente){
        clienteService.guardarCliente(cliente);
        return ResponseEntity.ok().body("Cliente creado con exito");
    }

    @PutMapping
    @ApiOperation(value = "Actualiza un cliente")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualizado correctamente"),
        @ApiResponse(code = 401, message = "No autorizado"),
        @ApiResponse(code = 403, message = "Prohibido"),
        @ApiResponse(code = 404, message = "El ID no existe")
    })
    public ResponseEntity<ClienteDTO> actualizar(@RequestBody ClienteDTO nuevo) {
        return ResponseEntity.of(Optional.of(clienteService.actualizarCliente(nuevo)));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Borra un cliente")
    public ResponseEntity<Cliente> borrar(@PathVariable Integer id) {
        clienteService.borrarCliente(id);
        return ResponseEntity.ok().build();
    }

}
