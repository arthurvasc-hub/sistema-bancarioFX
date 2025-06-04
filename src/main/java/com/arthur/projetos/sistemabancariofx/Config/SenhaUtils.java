package com.arthur.projetos.sistemabancariofx.Config;

import org.mindrot.jbcrypt.BCrypt;

public class SenhaUtils {


    public static String hashSenha(String senhaPura) {
        return BCrypt.hashpw(senhaPura, BCrypt.gensalt());
    }

    public static boolean verificarSenha(String senhaPura, String senhaHash) {
        return BCrypt.checkpw(senhaPura, senhaHash);
    }
}
