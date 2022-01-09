package de.htwberlin.webtech.webtech.web;


import de.htwberlin.webtech.webtech.service.GuestService;
import de.htwberlin.webtech.webtech.web.api.Guest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GuestRestController.class)
public class GuestRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    @Test
    @DisplayName("should return found guests from guest service")
    void should_return_found_guests_from_guest_service() throws Exception {
        // given
        var guests = List.of(
                new Guest(1, "John", "Doe", "Johndoe@gmail.com", true, true,"NOTED", "brideFamily"),
                new Guest(2, "Maria", "Thompson", "Mariathompson@gmail.com", false, false, "NOTNOTED" , "notRelated" )
        );
        doReturn(guests).when(guestService).findAll();

        // when
        mockMvc.perform(get("/api/v1/guests"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].email").value("Johndoe@gmail.com"))
                .andExpect(jsonPath("$[0].invited").value(true))
                .andExpect(jsonPath("$[0].plusOne").value(true))
                .andExpect(jsonPath("$[0].note").value("NOTED"))
                .andExpect(jsonPath("$[0].relationship").value("brideFamily"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Maria"))
                .andExpect(jsonPath("$[1].lastName").value("Thompson"))
                .andExpect(jsonPath("$[1].email").value("Mariathompson@gmail.com"))
                .andExpect(jsonPath("$[1].invited").value(false))
                .andExpect(jsonPath("$[1].plusOne").value(false))
                .andExpect(jsonPath("$[1].note").value("NOTNOTED"))
                .andExpect(jsonPath("$[1].relationship").value("notRelated"));
    }


    @Test
    @DisplayName("should return 404 if guest is not found")
    void should_return_404_if_guest_is_not_found() throws Exception {
        // given
        doReturn(null).when(guestService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/guests/123"))
                // then
                .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("should return 201 http status and Location header when creating a guest")
    void should_return_201_http_status_and_location_header_when_creating_a_guest() throws Exception {
        // given
        String guestToCreateAsJson = "{\"firstName\": \"John\", \"lastName\":\"Doe\", \"email\":\"johndoe@gmail.com\", \"invited\": true, \"plusOne\": true, \"note\":\"NOTED\", \"relationship\":\"brideFamily\"}";
        var guest = new Guest(123, null, null, null, false, false, null, null);
        doReturn(guest).when(guestService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/guests")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(guestToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/guests/" + guest.getId()))));

    }
    @Test
    @DisplayName("should validate create guest request")
    void should_validate_create_guest_request() throws Exception {
        // given
        //Email not valid
        String guestToCreateAsJson = "{\"firstName\": \"John\", \"lastName\":\"Doe\", \"email\":\"johndoegmail.com\", \"invited\": true, \"plusOne\": true, \"note\":\"NOTED\", \"relationship\":\"brideFamily\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/guests")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(guestToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }

}
