package com.uniquindio.guauma.aplicacion.servicio.comando;

import com.uniquindio.guauma.aplicacion.dto.pipeline.comando.CrearUsuarioComando;
import com.uniquindio.guauma.dominio.modelo.Direccion;
import com.uniquindio.guauma.dominio.modelo.Usuario;
import com.uniquindio.guauma.infraestructura.persistencia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author Carolina Marin Hincapie Uniquindio cmarinh@uniquindio.edu.co
 * @author Claudia Milena Marin Hincapie Uniquindio cmmarinh@uniquindio.edu.co
 * Clase Servicio que crea un usuario
 */
@Service
public class CrearUsuarioServicio {

    private static final String KEY = "GuauMa-CuidadoAnimal";

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private MunicipioRepositorio municipioRepositorio;

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    /**
     * Metodo que crea un usuario
     */
    public void registrarUsuario(CrearUsuarioComando comando) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Usuario usuario = new Usuario();
        usuario.setTipoIdentificacion(tipoIdentificacionRepositorio.findByNombre(comando.getTipoIdentificacion()));
        usuario.setNumeroIdentificacion(comando.getNumeroIdentificacion());
        usuario.setNombreRazonSocial(comando.getNombreRazonSocial());
        usuario.setCorreo(comando.getCorreo());
        usuario.setContrasenia(encriptarContrasenia(comando.getContrasenia()));
        usuario.setCelular(comando.getCelular());
        Direccion direccion = new Direccion();
        direccion.setDescripcion(comando.getDireccion().getDescripcion());
        direccion.setMunicipio(municipioRepositorio.findByCodigo(comando.getDireccion().getCodigoMunicipio()));
        direccion.setIdDireccion(direccionRepositorio.saveAndFlush(direccion).getIdDireccion());
        usuario.setDireccion(direccion);
        usuario.setRol(rolRepositorio.findByNombre(comando.getRol()));
        usuarioRepositorio.save(usuario);
    }

    public String encriptarContrasenia(String contrasenia) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        Key key = new SecretKeySpec(KEY.getBytes(),  0, 16, "AES");

        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] encriptado = aes.doFinal(contrasenia.getBytes());
        String contraseniaEncriptada = "";
        for (byte b : encriptado) {
            contraseniaEncriptada += (Integer.toHexString(0xFF & b));
        }

        return contraseniaEncriptada;
    }
}