package com.filatov.rooms;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MeetingRoomsCounter {

    private static final Integer START_MEETING_POSITION = 0;
    private static final Integer END_MEETING_POSITION = 1;
    private static final Integer EARLIEST_END_MEETING_POSITION = 0;

    public int countMinMeetingRooms(List<List<Integer>> meetingIntervals) {
        //sort intervals by meeting`s start time
        meetingIntervals = new ArrayList<>(meetingIntervals);
        Collections.sort(
                meetingIntervals,
                Comparator.comparing((List<Integer> interval) -> interval.get(START_MEETING_POSITION)));

        List<Integer> roomsMeetingEndTime = new ArrayList<>();
        for (List<Integer> interval : meetingIntervals) {
            //sorting the end time of meetings in all involved rooms
            Collections.sort(roomsMeetingEndTime);
            if (roomsMeetingEndTime.isEmpty() ||
                    interval.get(START_MEETING_POSITION).intValue() <
                            roomsMeetingEndTime.get(EARLIEST_END_MEETING_POSITION).intValue()) {
                //We need more rooms
                roomsMeetingEndTime.add(interval.get(END_MEETING_POSITION));
            } else {
                //We don't need more rooms
                roomsMeetingEndTime.set(EARLIEST_END_MEETING_POSITION, interval.get(END_MEETING_POSITION));
            }
        }
        return roomsMeetingEndTime.size();
    }

}
