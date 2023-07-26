//package com.webcrudapi.config;
//
//import io.jsonwebtoken.Claims;
//import org.springframework.stereotype.Component;
//
//import static com.auth0.jwt.impl.JsonNodeClaim.extractClaim;
//
//@Component
//public class JwtUtil {
//    private String jwtSigningKey = "secret";
//
//    public String extractUsername(String token){
//        return extractClaim(token, Claims :: getSubject);
//    }
//}
