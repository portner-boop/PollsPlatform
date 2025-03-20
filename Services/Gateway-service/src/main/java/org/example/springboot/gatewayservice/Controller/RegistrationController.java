package org.example.springboot.gatewayservice.Controller;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.example.springboot.gatewayservice.DTO.UserRegistrationDTO;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Value("${keycloak.server.url}")
    private String serverUrl;

    @Value("${keycloak.master.realm}")
    private String masterRealm;

    @Value("${keycloak.admin.username}")
    private String adminUsername;

    @Value("${keycloak.admin.password}")
    private String adminPassword;

    private String clientId = "admin-cli";

    @Value("${keycloak.realm}")
    private String realm;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        try {
            Keycloak keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(masterRealm)
                    .username(adminUsername)
                    .password(adminPassword)
                    .clientId(clientId)
                    .build();

            UserRepresentation user = new UserRepresentation();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setEnabled(true);

            CredentialRepresentation credential = new CredentialRepresentation();
            credential.setType(CredentialRepresentation.PASSWORD);
            credential.setValue(userDTO.getPassword());
            credential.setTemporary(false);
            user.setCredentials(Collections.singletonList(credential));

            Response response = keycloak.realm(realm).users().create(user);

            if (response.getStatus() == 201) {
                return ResponseEntity.status(201).body("Пользователь успешно зарегистрирован");
            } else {
                return ResponseEntity.status(response.getStatus()).body("Ошибка при регистрации: " + response.getStatusInfo());
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Ошибка сервера: " + e.getMessage());
        }
    }
}