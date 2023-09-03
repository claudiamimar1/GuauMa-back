package com.uniquindio.guauma.aplicacion.dto.pipeline.comando;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase comando para obtener la respuesta de la petición
 */
@Data
@NoArgsConstructor
public class RespuestaComando {

    private Boolean exitoso;
    private List<String> mensajes;
    private Object data;
    private int codigoHttp;
    private HttpStatus estadoHttp;


    public RespuestaComando(Boolean exitoso, String mensaje, Object data, HttpStatus estado){
        this.exitoso = exitoso;
        this.data = data;
        this.codigoHttp = estado.value();
        this.estadoHttp = estado;
        if(mensaje != null && !mensaje.isEmpty()){
            this.mensajes = new ArrayList<>(Arrays.asList(mensaje));
        } else {
            this.mensajes = new ArrayList<>();
        }
    }

    public void agregarMensaje(String mensaje){
        if (mensaje != null && !mensaje.isEmpty() && !this.mensajes.contains(mensaje)) {
            this.mensajes.add(mensaje);
        }
    }

    public void limpiarMensajes(){
        this.mensajes.clear();
    }
}
