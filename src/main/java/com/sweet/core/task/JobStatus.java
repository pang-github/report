package com.sweet.core.task;

public enum JobStatus {
    /**
     *     STATE_BLOCKED("4"),
     */
    RUN("1"),
    PAUSED("2"),
    STOP("3"),
    ;
    private String status;
    private JobStatus(String status){
        this.status=status;
    }

    public String getStatus() {
        return status;
    }
}
