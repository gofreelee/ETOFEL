package loginmodule.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

/**
 * @ClassName TokenProcessor
 * @Author 11214
 * @Date 2020/6/16
 * @Description TODO
 */
public class TokenProcessor {
    private static TokenProcessor tokenProcessor;

    private TokenProcessor() {
    }

    public static synchronized TokenProcessor getInstance() {
        if (tokenProcessor == null) {
            synchronized (TokenProcessor.class) {
                tokenProcessor = new TokenProcessor();
            }
        }
        return tokenProcessor;
    }

    public String makeToken(String username) {
        String token = System.currentTimeMillis() + username;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            return Base64.getEncoder().encodeToString(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
