package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.GeustRepository;
import de.htwberlin.webtech.webtech.persistence.GuestEntity;
import de.htwberlin.webtech.webtech.web.api.Guest;
import de.htwberlin.webtech.webtech.web.api.GuestManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GeustRepository geustRepository;

    public GuestService(GeustRepository geustRepository) {
        this.geustRepository = geustRepository;
    }
    public List<Guest> findAll() {
        List<GuestEntity> guests = geustRepository.findAll();
        return guests.stream()
                .map(guestEntity -> new Guest(
                        guestEntity.getId(),
                        guestEntity.getFirstName(),
                        guestEntity.getLastName(),
                        guestEntity.getWDay(),
                        guestEntity.getInvited()
                ))
                .collect(Collectors.toList());

    }

    public Guest create(GuestManipulationRequest request) {
        var guestEntity = new GuestEntity(request.getFirstName(), request.getLastName(), request.getWDay(), request.isInvited());
        guestEntity = geustRepository.save(guestEntity);
        return transformEntity(guestEntity);
    }

    private Guest transformEntity(GuestEntity guestEntity) {
        return new Guest(
                guestEntity.getId(),
                guestEntity.getFirstName(),
                guestEntity.getLastName(),
                guestEntity.getWDay(),
                guestEntity.getInvited()
        );
    }
    public Guest findById(Long id) {
        var guestEntity = geustRepository.findById(id);
        return guestEntity.map(this::transformEntity).orElse(null);
    }
    public Guest update(Long id, GuestManipulationRequest request) {
        var guestEntityOptional = geustRepository.findById(id);
        if (guestEntityOptional.isEmpty()) {
            return null;
        }
        var guestEntity = guestEntityOptional.get();
        guestEntity.setFirstName(request.getFirstName());
        guestEntity.setLastName(request.getLastName());
        guestEntity.setWDay(request.getWDay());
        guestEntity.setInvited(request.isInvited());
        guestEntity = geustRepository.save(guestEntity);

        return transformEntity(guestEntity);
    }
    public boolean deleteById(Long id) {
        if (!geustRepository.existsById(id)) {
            return false;
        }

        geustRepository.deleteById(id);
        return true;
    }
}
