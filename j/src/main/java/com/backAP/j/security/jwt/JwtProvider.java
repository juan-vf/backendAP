package com.backAP.j.security.jwt;

import com.backAP.j.security.entity.MainUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication auth){
        MainUser mainUser = (MainUser) auth.getPrincipal();
        int expirationInSeconds = expiration;
        return Jwts.builder().
                setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public String getUserNameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException err) {
            logger.error("malform token" + err.getMessage());
        } catch (UnsupportedJwtException err) {
            logger.error("unsupported token" + err.getMessage());
        } catch (IllegalArgumentException err) {
            logger.error("empty token" + err.getMessage());
        } catch (SignatureException err) {
            logger.error("signature fail" + err.getMessage());
        }catch (ExpiredJwtException err) {
            logger.error("expired token" + err.getMessage());
        }
        return false;

    }
}
