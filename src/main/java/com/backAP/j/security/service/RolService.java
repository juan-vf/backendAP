package com.backAP.j.security.service;

import com.backAP.j.security.entity.Rol;
import com.backAP.j.security.enums.RolName;
import com.backAP.j.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
