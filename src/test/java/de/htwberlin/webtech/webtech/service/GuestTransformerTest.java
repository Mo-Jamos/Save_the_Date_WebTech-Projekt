package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.GuestEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.doReturn;

public class GuestTransformerTest implements WithAssertions {

    private final GuestTransformer underTest = new GuestTransformer();

    @Test
    @DisplayName("should transform GuestEntity to Guest")
    void should_transform_guest_entity_to_guest() {
        // given
        var guestEntity = Mockito.mock(GuestEntity.class);
        doReturn(111L).when(guestEntity).getId();
        doReturn("John").when(guestEntity).getFirstName();
        doReturn("Doe").when(guestEntity).getLastName();
        doReturn("Johndoe@gmail.com").when(guestEntity).getEmail();
        doReturn(true).when(guestEntity).getInvited();
        doReturn(true).when(guestEntity).getPlusOne();
        doReturn("NOTED").when(guestEntity).getNote();
        doReturn(guestEntity.getRelationship().brideFamily).when(guestEntity).getRelationship();

        // when
        var result = underTest.transformEntity(guestEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getFirstName()).isEqualTo("John");
        assertThat(result.getLastName()).isEqualTo("Doe");
        assertThat(result.getEmail()).isEqualTo("Johndoe@gmail.com");
        assertThat(result.isInvited()).isEqualTo(true);
        assertThat(result.isPlusOne()).isEqualTo(true);
        assertThat(result.getNote()).isEqualTo("NOTED");
        assertThat(result.getRelationship()).isEqualTo("brideFamily");
    }
}
