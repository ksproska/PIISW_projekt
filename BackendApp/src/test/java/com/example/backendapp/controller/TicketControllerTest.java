package com.example.backendapp.controller;

import com.example.backendapp.controller.api.TicketController;
import com.example.backendapp.controller.request.CreateTicketRequest;
import com.example.backendapp.service.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TicketControllerTest {

    private TicketController ticketController;

    @Mock
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ticketController = new TicketController(ticketService);
    }

    @Test
    public void testActivateTicket() {
        long ticketId = 123;
        String tramId = "456";

        ticketController.activateTicket(ticketId, tramId);

        verify(ticketService, times(1)).activateTicket(ticketId, tramId);
    }

    @Test
    public void testActivateTicketAsUser() {
        long ticketId = 123;
        String tramId = "456";

        ticketController.activateTicketAsUser(ticketId, tramId);

        verify(ticketService, times(1)).activateTicket(ticketId, tramId);
    }

//    @Test
//    public void testGetTicketInfoForUserId() {
//        long userId = 123;
//        List<TicketInfo> expectedTicketInfoList = new ArrayList<>();
//        expectedTicketInfoList.add(new TicketInfo());
//        expectedTicketInfoList.add(new TicketInfo());
//
//        when(ticketService.getTicketInfo(userId)).thenReturn(expectedTicketInfoList);
//
//        List<TicketInfo> result = ticketController.getTicketInfoForUserId(userId);
//
//        assertEquals(expectedTicketInfoList, result);
//    }

    @Test
    public void testPutSingleTicketFromOfferForUserId() {
        CreateTicketRequest request = new CreateTicketRequest(1L, 1L);

        ticketController.putSingleTicketFromOfferForUserId(request);

        verify(ticketService, times(1)).saveSingleTicket(request);
    }

    @Test
    public void testPutSeasonTicketFromOfferForUserId() {
        CreateTicketRequest request = new CreateTicketRequest(1L, 1L);

        ticketController.putSeasonTicketFromOfferForUserId(request);

        verify(ticketService, times(1)).saveSeasonTicket(request);
    }

    @Test
    public void testPutCommuterPassFromOfferForUserId() {
        CreateTicketRequest request = new CreateTicketRequest(1L, 1L);

        ticketController.putCommuterPassFromOfferForUserId(request);

        verify(ticketService, times(1)).saveCommuterPass(request);
    }
}
