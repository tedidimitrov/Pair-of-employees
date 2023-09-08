package com.company.model;

import java.util.Objects;

public class Pair {

    private int firstEmployeeId ;
    private int secondEmployeeId;
    private long totalDuration = 0;

    public Pair(int firstEmployeeId, int secondEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
        this.secondEmployeeId = secondEmployeeId;
    }

    public void updateTotalDuration(long totalDuration) {
        this.totalDuration += totalDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return firstEmployeeId == pair.firstEmployeeId && secondEmployeeId == pair.secondEmployeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstEmployeeId, secondEmployeeId);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstEmployeeId=" + firstEmployeeId +
                ", secondEmployeeId=" + secondEmployeeId +
                ", totalDuration=" + totalDuration +
                '}';
    }
}

