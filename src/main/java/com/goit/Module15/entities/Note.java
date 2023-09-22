package com.goit.Module15.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note() {

    }
}
