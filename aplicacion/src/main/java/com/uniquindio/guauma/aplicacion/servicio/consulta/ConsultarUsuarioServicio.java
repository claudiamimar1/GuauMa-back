package com.uniquindio.guauma.aplicacion.servicio.consulta;

import com.uniquindio.guauma.aplicacion.dto.UsuarioDTO;
import com.uniquindio.guauma.aplicacion.util.Encriptar;
import com.uniquindio.guauma.aplicacion.util.ObjectMapperUtils;
import com.uniquindio.guauma.dominio.modelo.Usuario;
import com.uniquindio.guauma.infraestructura.persistencia.RolRepositorio;
import com.uniquindio.guauma.infraestructura.persistencia.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que obtiene la información del usuario
 */
@Service
public class ConsultarUsuarioServicio {

    @Autowired
    private UsuarioRepositorio repositorio;
    @Autowired
    private RolRepositorio rolRepositorio;

    /**
     * Metodo que obtiene el usuario
     * @return  Usuario
     */
    public UsuarioDTO consultarUsuario(String correo){
        Usuario usuario = repositorio.findByCorreo(correo);
        UsuarioDTO usuarioDTO = ObjectMapperUtils.map(repositorio.findByCorreo(correo), UsuarioDTO.class);
        usuarioDTO.getDireccion().setCodigoMunicipio(usuario.getDireccion().getMunicipio().getIdMunicipio());
        usuarioDTO.setContrasenia(null);
        return usuarioDTO;
    }

    public List<UsuarioDTO> obtenerProveedores(String nombre_rol) {
        Long idRol = rolRepositorio.findByNombre(nombre_rol).getIdRol();
        return ObjectMapperUtils.mapAll(repositorio.findByRol_IdRol(idRol) , UsuarioDTO.class);
    }

    public UsuarioDTO consultarUsuarioInicioSesion(String correo, String contrasenai) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        UsuarioDTO usuarioDto = ObjectMapperUtils.map(repositorio.findByCorreo(correo), UsuarioDTO.class);
        String contraseniaEncriptada = Encriptar.encriptarContrasenia(contrasenai);
        if(contraseniaEncriptada.equals(usuarioDto.getContrasenia()) && correo.equals(usuarioDto.getCorreo())) {
            usuarioDto.setContrasenia(null);
            return usuarioDto;
        } else {
            return null;
        }
    }
}