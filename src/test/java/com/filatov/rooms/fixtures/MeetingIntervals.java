package com.filatov.rooms.fixtures;

import java.util.List;

public class MeetingIntervals {

    public List<List<Integer>> get5MeetingIntervals() {
        return List.of(
                List.of(1, 3),
                List.of(3, 10),
                List.of(5, 6),
                List.of(7, 10),
                List.of(2, 5)
        );
    }

    public List<List<Integer>> get10MeetingIntervals() {
        return List.of(
                List.of(1, 3),
                List.of(1, 10),
                List.of(7, 8),
                List.of(8, 10),
                List.of(2, 5),
                List.of(10, 13),
                List.of(9, 21),
                List.of(5, 7),
                List.of(8, 10),
                List.of(1, 8)
        );
    }

}