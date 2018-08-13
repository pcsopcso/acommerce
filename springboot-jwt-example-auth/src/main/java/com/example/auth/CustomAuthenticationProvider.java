package com.example.auth;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.auth.user.model.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired 
    private PasswordEncoder passwordEncoder;    
 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String user_id = (String)authentication.getPrincipal();   
        String user_pw = (String)authentication.getCredentials();
          
        System.out.printf("사용자 로그인정보: %s \n", user_id + "/" + user_pw);
         
        User user = (User) userService.loadUserByUsername(user_id);
        System.out.printf("사용자 DB 정보: %s \n", user.getUsername() + "/" + user.getPassword());
 
        // 화면에서 입력한 이용자의 비밀번호(평문)와 DB에서 가져온 이용자의 암호화된 비밀번호를 비교한다
        if(! passwordEncoder.matches(user_pw, user.getPassword())){
            throw new BadCredentialsException("Bad credentials");
        }
         
        return new UsernamePasswordAuthenticationToken(user_id, user_pw, (Collection<? extends GrantedAuthority>) user.getRoles());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
