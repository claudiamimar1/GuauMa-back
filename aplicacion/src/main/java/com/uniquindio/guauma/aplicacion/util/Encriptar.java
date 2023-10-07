package com.uniquindio.guauma.aplicacion.util;

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
 * Clase para encriptar las contraseñas
 */
public class Encriptar {

    private static final String KEY = "GuauMa-CuidadoAnimal";

    public static String encriptarContrasenia(String contrasenia) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

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
