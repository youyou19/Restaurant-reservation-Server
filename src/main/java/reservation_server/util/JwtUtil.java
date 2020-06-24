package reservation_server.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import reservation_server.domain.Role;
import reservation_server.domain.User;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private Key key;
    public final String NOT_GRANTED_MESSAGE = "YOU CANT ACCESS THIS SERVICE";
    private final String MD5_KEY="887848bec483d79131c2e6b75ad3042a";
    private SecretKey secretKey;

    public JwtUtil(){

        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    }

    public Key getKey(){
        return key;
    }

    public boolean isGranted(String token) {
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        try {

            List<Object> list = Jwts.parser().setSigningKey(this.getKey())
                    .parseClaimsJws(token).getBody().entrySet().stream()
                    .filter( entry -> entry.getKey().equals("key"))
                    .map(value -> value.getValue()).collect(Collectors.toList());

             boolean tokenFound = MD5_KEY.equals(list.get(0).toString().toLowerCase()) ;

            if(!tokenFound){
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String generateToken(User user, String role,boolean exist) {
        String uId="2";
        if(role.toLowerCase().equals("admin")){
            uId="1";
        }

        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        if(exist){
            return uId+Jwts.builder()
                    .setSubject(user.getUsername())
                    .claim("key",MD5_KEY)
                    .claim("id",user.getId())
                    .signWith(this.key)
                    .compact();
        }else{
            return "";
        }
    }
    public Long generateID() {
        Random r = new Random();
        int low = 456;
        int high = 989856;
        long result = r.nextInt(high - low) + low;
        return result;
    }


}
