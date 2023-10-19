package com.languagesApp.Entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "english")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "englishwords")
    private String englishWord;

    @Column(name = "turkishwords")
    private String turkishWord;

    @Lob
    @Column(name = "englishwordImage")
    private byte[] image;

}
