package api.Users.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Obtener el claim "realm_access"
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        // Inicializar una lista de roles vacía
        List<String> roles = new ArrayList<>();

        // Verificar que realmAccess no sea null y contenga el claim "roles" con una lista de strings
        if (realmAccess != null && realmAccess.get("roles") instanceof List<?>) {
            roles = ((List<?>) realmAccess.get("roles")).stream()
                    .filter(role -> role instanceof String) // Asegurarse de que cada elemento es un String
                    .map(role -> (String) role)
                    .toList();
        }

        // Log para verificar roles extraídos
        roles.forEach(role -> System.out.println("Role found: " + role));

        // Convertir roles a GrantedAuthority y retornarlos
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}
