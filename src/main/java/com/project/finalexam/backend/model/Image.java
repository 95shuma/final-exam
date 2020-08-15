package com.project.finalexam.backend.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String type;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Image(){
    }

    public Image(String name, String type, byte[] data, Place place) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.place = place;
    }

}
