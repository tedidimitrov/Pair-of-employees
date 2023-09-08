package com.company.model;

import java.time.LocalDate;

public class Record {

    private Integer employeeId;
    private int projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Record(int employeeId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }
}
