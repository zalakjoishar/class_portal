package com.learn.classPortal.config;

import com.learn.classPortal.entity.Role;
import com.learn.classPortal.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles if they don't exist
        initializeRoles();
    }

    private void initializeRoles() {
        // Check and create ROLE_ADMIN
        if (!roleRepository.findByRoleName("ROLE_ADMIN").isPresent()) {
            Role adminRole = new Role("ROLE_ADMIN");
            roleRepository.save(adminRole);
            System.out.println("Created ROLE_ADMIN");
        }

        // Check and create ROLE_TRAINER
        if (!roleRepository.findByRoleName("ROLE_TRAINER").isPresent()) {
            Role trainerRole = new Role("ROLE_TRAINER");
            roleRepository.save(trainerRole);
            System.out.println("Created ROLE_TRAINER");
        }

        // Check and create ROLE_COORDINATOR
        if (!roleRepository.findByRoleName("ROLE_COORDINATOR").isPresent()) {
            Role coordinatorRole = new Role("ROLE_COORDINATOR");
            roleRepository.save(coordinatorRole);
            System.out.println("Created ROLE_COORDINATOR");
        }

        // Check and create ROLE_STUDENT
        if (!roleRepository.findByRoleName("ROLE_STUDENT").isPresent()) {
            Role studentRole = new Role("ROLE_STUDENT");
            roleRepository.save(studentRole);
            System.out.println("Created ROLE_STUDENT");
        }
    }
}

