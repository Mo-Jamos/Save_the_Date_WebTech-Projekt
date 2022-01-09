package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.GuestEntity;
import de.htwberlin.webtech.webtech.persistence.relationship;
import de.htwberlin.webtech.webtech.web.api.Guest;
import org.springframework.stereotype.Service;

@Service
public class GuestTransformer {
    public Guest transformEntity(GuestEntity guestEntity) {
        var relationShip = guestEntity.getRelationship() != null ? guestEntity.getRelationship().name() : relationship.notRelated.name();
        return new Guest(
                guestEntity.getId(),
                guestEntity.getFirstName(),
                guestEntity.getLastName(),
                guestEntity.getEmail(),
                guestEntity.getInvited(),
                guestEntity.getPlusOne(),
                guestEntity.getNote(),
                relationShip
                );
    }

}
