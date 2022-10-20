package com.example.MicSecurityService.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTAuthorizarionFilter extends OncePerRequestFilter {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "lo que sea";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            if (checkJWTToken(request,response)){
                Claims claims = validateToken(request);
                if (claims.get("authorities") != null){
                    setUpSpringAuthentication(claims);
                }else{
                    SecurityContextHolder.clearContext();
                }
            }else{
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request,response);
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse response) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX)){
            return false;
        }
        return true;
    }

    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                claims.getSubject(),
                authorities.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX,"");
        return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
    }


}
