import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class AviaSoulsTest {

    // test for compare method
    @Test
    public void testingCompareToMethod(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 15);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        int expected = -1;
        int actual = ticket2.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);
    }

    // tests for sort method
    @Test
    public void testingSortMethodSeveralTickets(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 15);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6, ticket1, ticket2, ticket5, ticket7};
        Ticket[] actual = manager.search("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingSortMethodZeroTickets(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 15);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "NYC");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingSortMethodOneTicket(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 15);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 15);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("SPB", "OVB");
        Assertions.assertArrayEquals(expected, actual);
    }




    // tests for Comparator
    @Test
    public void testingSortMethodSeveralTicketsWithComparator(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 15);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6, ticket1, ticket2, ticket7, ticket5};
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingSortMethodZeroTicketsWithComparator(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 15);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK", "NYC", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingSortMethodOneTicketWithComparator(){
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3_000, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 12, 15);
        Ticket ticket3 = new Ticket("SPB", "OVB", 7_000, 11, 16);
        Ticket ticket4 = new Ticket("OVB", "SPB", 9_000, 16, 20);
        Ticket ticket5 = new Ticket("MSK", "SPB", 6_000, 13, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 2_000, 13, 14);
        Ticket ticket7 = new Ticket("MSK", "SPB", 10_000, 9, 13);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("OVB", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }




}
