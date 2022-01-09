package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.relationship;
import de.htwberlin.webtech.webtech.persistence.GuestRepository;
import de.htwberlin.webtech.webtech.persistence.GuestEntity;
import de.htwberlin.webtech.webtech.web.api.Guest;
import de.htwberlin.webtech.webtech.web.api.GuestManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final GuestTransformer guestTransformer;

    public GuestService(GuestRepository guestRepository, GuestTransformer guestTransformer) {
        this.guestRepository = guestRepository;
        this.guestTransformer = guestTransformer;
    }

    public List<Guest> findAll() {
        List<GuestEntity> guests = guestRepository.findAll();
        return guests.stream()
                .map(guestTransformer::transformEntity)
                .collect(Collectors.toList());

    }
    public Guest findById(Long id) {
        var guestEntity = guestRepository.findById(id);
        return guestEntity.map(guestTransformer::transformEntity).orElse(null);
    }

    public Guest create(GuestManipulationRequest request) {
        var relationship = de.htwberlin.webtech.webtech.persistence.relationship.valueOf(request.getRelationship());
        var guestEntity = new GuestEntity(request.getFirstName(), request.getLastName(), request.getEmail(), request.isInvited(), request.isPlusOne(), request.geNote(), relationship);
        guestEntity = guestRepository.save(guestEntity);
        return guestTransformer.transformEntity(guestEntity);
    }


    public Guest update(Long id, GuestManipulationRequest request) {
        var guestEntityOptional = guestRepository.findById(id);
        if (guestEntityOptional.isEmpty()) {
            return null;
        }
        var guestEntity = guestEntityOptional.get();
        guestEntity.setFirstName(request.getFirstName());
        guestEntity.setLastName(request.getLastName());
        guestEntity.setEmail(request.getEmail());
        guestEntity.setInvited(request.isInvited());
        guestEntity.setPlusOne(request.isPlusOne());
        guestEntity.setNote(request.geNote());
        guestEntity.setRelationship(relationship.valueOf(request.getRelationship()));
        guestEntity = guestRepository.save(guestEntity);

        return guestTransformer.transformEntity(guestEntity);
    }
    public boolean deleteById(Long id) {
        if (!guestRepository.existsById(id)) {
            return false;
        }

        guestRepository.deleteById(id);
        return true;
    }
}
