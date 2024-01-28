package com.vitosonline.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    public static final String SECRET = "d789880a8ddee419626859e85d28fa1c4f338e3b6324424da424a4a3c1ee6c41461ac350b2c5a3b0b9b3582b4a5db2aa584245a4282b6dfff22e8511e7760599cecf685f23e7645ccf648bad2949eaee59fb3ec3ff43f98d15677e532ae5e7b570b345413e6d7b472da516df67299274e3cfb147e3b05f4715f7ac5a6a6237d9a6af11bc6ea40f0d3d6dd36ad293166a5fa3f8fc2906024f560116283215022337de8dd8e3fbbd3733ca54be2cdd8084cfaf0f6820aa1f85bbf4703dc5139bfc43fe06ca1a44e7c1529d63176446ad64850f8ed59e1ba47ce6bb941f48aebd10bf75d6b46ef74db3516a748e9d2195df6a052ffd2b31f957fc03905e738edc5a";

    public JwtUtil() {
    }

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap();
        return this.createToken(claims, email);
    }

    private String createToken(Map<String, Object> claims, String email) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode("d789880a8ddee419626859e85d28fa1c4f338e3b6324424da424a4a3c1ee6c41461ac350b2c5a3b0b9b3582b4a5db2aa584245a4282b6dfff22e8511e7760599cecf685f23e7645ccf648bad2949eaee59fb3ec3ff43f98d15677e532ae5e7b570b345413e6d7b472da516df67299274e3cfb147e3b05f4715f7ac5a6a6237d9a6af11bc6ea40f0d3d6dd36ad293166a5fa3f8fc2906024f560116283215022337de8dd8e3fbbd3733ca54be2cdd8084cfaf0f6820aa1f85bbf4703dc5139bfc43fe06ca1a44e7c1529d63176446ad64850f8ed59e1ba47ce6bb941f48aebd10bf75d6b46ef74db3516a748e9d2195df6a052ffd2b31f957fc03905e738edc5a");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

