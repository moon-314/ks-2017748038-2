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
public class Basic implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String label;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime updateDate;

    @Builder
    public Basic(String name, String label, String email, String phone, LocalDateTime createDate, LocalDateTime updateDate) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void update(Basic basic) {
        this.name = basic.getName();
        this.label = basic.getLabel();
        this.email = basic.getEmail();
        this.phone = basic.getPhone();
    }
}
