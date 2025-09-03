package com.JobFindingPlatform.service;


import com.JobFindingPlatform.dto.AuthResponseDTO;
import com.JobFindingPlatform.dto.LoginRequestDTO;
import com.JobFindingPlatform.dto.UserDTO;
import com.JobFindingPlatform.entity.User;
import com.JobFindingPlatform.repository.UserRespository;
import com.JobFindingPlatform.security.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRespository userRespository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;


    public String register(UserDTO dto){

        if(userRespository.findByEmail(dto.getEmail()).isPresent()){
            throw  new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        userRespository.save(user);

        return "User successfully registered";

    }

    public AuthResponseDTO login(LoginRequestDTO dto){
        User user = userRespository.findByEmail(dto.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email: " + dto.getEmail())
        );

        if(!passwordEncoder.matches(dto.getPassword(),user.getPassword())){

            throw  new RuntimeException("Password doesn't match");
        }
        String token = jwtUtils.generateToken(user);
        return new AuthResponseDTO("Login Successfully",token);
    }


}
