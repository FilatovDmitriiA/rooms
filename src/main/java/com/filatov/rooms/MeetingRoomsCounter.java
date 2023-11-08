package com.filatov.rooms;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MeetingRoomsCounter {

    public int countMinMeetingRooms(List<List<Integer>> meetingIntervals) {
        //sort intervals by meeting`s start time
        meetingIntervals = new ArrayList<>(meetingIntervals);
        Collections.sort(
                meetingIntervals,
                Comparator.comparing((List<Integer> interval) -> interval.get(0)));

        List<Integer> roomsMeetingEndTime = new ArrayList<>();
        for (List<Integer> interval : meetingIntervals) {
            //sorting the end time of meetings in all involved rooms
            Collections.sort(roomsMeetingEndTime);
            if (roomsMeetingEndTime.isEmpty() || interval.get(0).intValue() < roomsMeetingEndTime.get(0).intValue()) {
                //We need more rooms
                roomsMeetingEndTime.add(interval.get(1));
            } else {
                //We don't need more rooms
                roomsMeetingEndTime.set(0, interval.get(1));
            }
        }
        return roomsMeetingEndTime.size();
    }

}
