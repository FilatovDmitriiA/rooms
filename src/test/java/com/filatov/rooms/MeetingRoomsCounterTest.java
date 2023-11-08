package com.filatov.rooms;

import com.filatov.rooms.fixtures.MeetingIntervals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
class MeetingRoomsCounterTest {

    @Autowired
    private MeetingRoomsCounter meetingRoomsCounter;
    private MeetingIntervals meetingIntervals = new MeetingIntervals();

    @Test
    public void countMinMeetingRoomsFor5UnsortedMeetings() {
        int minMeetingRooms = meetingRoomsCounter.countMinMeetingRooms(meetingIntervals.get5MeetingIntervals());
        assertEquals("wrong number of meeting rooms", 2, minMeetingRooms);
    }

    @Test
    public void countMinMeetingRoomsFor10UnsortedMeetings() {
        int minMeetingRooms = meetingRoomsCounter.countMinMeetingRooms(meetingIntervals.get10MeetingIntervals());
        assertEquals("wrong number of meeting rooms", 4, minMeetingRooms);
    }

}