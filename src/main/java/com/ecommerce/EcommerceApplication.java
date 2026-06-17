package com.ecommerce;

import com.ecommerce.entity.Role;
import com.ecommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    /**
     * Seeds the roles table on first startup.
     * Safe to run multiple times — only inserts if the role doesn't exist.
     */
    @Bean
    CommandLineRunner seedRoles(RoleRepository roleRepository) {
        return args -> {
            for (Role.RoleName roleName : Role.RoleName.values()) {
                if (roleRepository.findByName(roleName).isEmpty()) {
                    roleRepository.save(new Role(roleName));
                    System.out.println("Seeded role: " + roleName);
                }
            }
        };
    }
}
