package com.emil.portfolio.contact;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@RestController
@RequestMapping("/api/contact")

/**
 * 5173 tries to call 8080, different origins and is blocked.
 * CORS lets calls from 5173 go through.
 */
@CrossOrigin(origins = { "http://localhost:5173" })
public class ContactController {

    private ContactService contactService;

    // Look at your own notes in Notepad
    @PostMapping
    public ResponseEntity<Map<String, String>> createContact(@Valid @RequestBody ContactForm contactForm) {
        UUID uuid = contactService.contactFormHaveBeenFilledAndSent(contactForm);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(uuid)
                .toUri();

        return ResponseEntity
                .created(location)
                .body(Map.of("id", uuid.toString()));
    }
}
