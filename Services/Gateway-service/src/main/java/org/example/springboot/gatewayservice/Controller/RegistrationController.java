package org.example.springboot.gatewayservice.Controller;

import jakarta.ws.rs.core.Response;
import org.example.springboot.gatewayservice.DTO.UserRegistrationDTO;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8002/api/v1/users/user/register";

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

    public RegistrationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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
            System.out.println("Токен: " + keycloak.tokenManager().getAccessTokenString());
            UserRepresentation user = new UserRepresentation();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setEnabled(true);
            user.setEmailVerified(false);

            CredentialRepresentation credential = new CredentialRepresentation();
            credential.setType(CredentialRepresentation.PASSWORD);
            credential.setValue(userDTO.getPassword());
            credential.setTemporary(false);
            user.setCredentials(Collections.singletonList(credential));

            Response response = keycloak.realm(realm).users().create(user);
            System.out.println("Ответ Keycloak: " + response.getStatus());
            if (response.getStatus() == 201) {
                String userId = CreatedResponseUtil.getCreatedId(response);
                createUser(userDTO.getEmail(), userId);
                return ResponseEntity.status(201).body("Пользователь успешно зарегистрирован");
            } else {
                String responseBody = response.readEntity(String.class);
                System.out.println("Тело ответа: " + responseBody);
                return ResponseEntity.status(response.getStatus()).body("Ошибка при регистрации: " + responseBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Ошибка сервера: " + e.getMessage());
        }
    }


    private void createUser(String email, String id){
        try {

            Map<String, String> data = new HashMap<>();
            data.put("email", email);
            data.put("id", id);

            restTemplate.postForObject(baseUrl, data, String.class);

        } catch (Exception e) {
            System.err.println("Ошибка при отправке данных: " + e.getMessage());
        }
    }
}