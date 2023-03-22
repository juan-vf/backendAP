package com.backAP.j.security.controller;

import com.backAP.j.security.dto.JwtDto;
import com.backAP.j.security.dto.LoginUser;
import com.backAP.j.security.dto.NewUser;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.security.entity.Rol;
import com.backAP.j.security.entity.User;
import com.backAP.j.security.enums.RolName;
import com.backAP.j.security.jwt.JwtProvider;
import com.backAP.j.security.service.RolService;
import com.backAP.j.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin//(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        System.out.println(newUser.getPassword());

        if(bindingResult.hasErrors()){
            return  new ResponseEntity(new Mensaje("WRONGLY PLACED FIELDS OR INVALID MAIL"), HttpStatus.BAD_REQUEST);
        }
        if(userService.existByUserName(newUser.getUserName())){
            return new ResponseEntity(new Mensaje("that name already exists"), HttpStatus.BAD_REQUEST);
        }
        if(userService.existByEmail(newUser.getEmail())){
            return new ResponseEntity(new Mensaje("that email already exists"), HttpStatus.BAD_REQUEST);
        }
        //if(){}
        User user = new User(newUser.getName(),
                newUser.getUserName(),
                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword())
        );
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin")){
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Mensaje("saved user"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  new ResponseEntity(new Mensaje("WRONGLY PLACED FIELDS"), HttpStatus.BAD_REQUEST);
        }
        //System.out.println(loginUser.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
