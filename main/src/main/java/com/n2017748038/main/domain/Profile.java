package com.n2017748038.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updateDate;

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    @Builder
    public Profile(String network, String username, String url, LocalDateTime createdAt, LocalDateTime updateDate) {
        this.network = network;
        this.username = username;
        this.url = url;
        this.createdAt = createdAt;
        this.updateDate = updateDate;
    }

    public void update(Profile profile) {
        this.network = profile.getNetwork();
        this.username = profile.getUsername();
        this.url = profile.getUrl();
        this.createdAt = profile.getCreatedAt();
    }
}
