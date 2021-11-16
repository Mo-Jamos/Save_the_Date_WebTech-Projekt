package de.htwberlin.webtech.webtech.web;

import de.htwberlin.webtech.webtech.service.GuestService;
import de.htwberlin.webtech.webtech.web.api.Guest;
import de.htwberlin.webtech.webtech.web.api.GuestManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class GuestRestController {



    private final GuestService guestService;

    public GuestRestController(GuestService guestService) {
        this.guestService = guestService;
    }


    @GetMapping(path = "/api/v1/guests")
    public ResponseEntity<List<Guest>> fetchGuests() {
        return ResponseEntity.ok(guestService.findAll());
    }

    @PostMapping(path = "/api/v1/guests")
    public ResponseEntity<Void> createGuest(@RequestBody GuestManipulationRequest request) throws URISyntaxException {
        var guest = guestService.create(request);
        URI uri = new URI("/api/v1/guests/" + guest.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Guest> fetchGuestById(@PathVariable Long id) {
        var guest = guestService.findById(id);
        return guest != null? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }
    @PutMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody GuestManipulationRequest request) {
        var guest = guestService.update(id, request);
        return guest != null? ResponseEntity.ok(guest) : ResponseEntity.notFound().build();
    }
    @DeleteMapping(path = "/api/v1/guests/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        boolean successful = guestService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
