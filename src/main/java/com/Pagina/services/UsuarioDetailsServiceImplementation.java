package com.Pagina.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Pagina.models.Role;
import com.Pagina.models.Usuario;
import com.Pagina.repositories.UsuarioRepository;

@Service
public class UsuarioDetailsServiceImplementation implements UserDetailsService{

        @Autowired
        UsuarioRepository UsuarioRepository;
    
    
        @Override
        public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
            Usuario Usuario = UsuarioRepository.findByNombre(nombre);
            
            if(Usuario == null) {
                throw new UsernameNotFoundException("Usuario not found");
            }
            
            return new org.springframework.security.core.userdetails.User(Usuario.getNombre(), Usuario.getPassword(), getAuthorities(Usuario));
        }
        
    
    
    private List<GrantedAuthority> getAuthorities(Usuario usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                for(Role role : usuario.getRoles()) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getNombre());
                    authorities.add(grantedAuthority);
                }
                return authorities;
        }
}