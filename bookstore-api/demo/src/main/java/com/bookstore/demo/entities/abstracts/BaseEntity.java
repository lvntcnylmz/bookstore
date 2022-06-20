package com.bookstore.demo.entities.abstracts;

import java.time.LocalDateTime;

import javax.persistence.Column;

public abstract class BaseEntity {

    @Column(name = "date_created")
    private LocalDateTime createOn;

    @Column(name = "last_updated")
    private LocalDateTime updatedOn;

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

}
