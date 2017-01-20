package io.khasang.helpdesk.entity;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Boolean in_work = false;
    private Boolean opened = false;
    private Boolean finished = false;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", nullable = false)
    private Users users;

    public Status() {
    }

    public Boolean getIn_work() {
        return in_work;
    }

    public void setIn_work(Boolean in_work) {
        this.in_work = in_work;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
