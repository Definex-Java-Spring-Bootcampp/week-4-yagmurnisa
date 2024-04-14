package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.kredinbizdeservice.enums.SectorType;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaigns")
public class Campaign {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
    private String title;
    
    private String content;
    
    private LocalDate dueDate;
    
    private LocalDate createDate;
    
    private LocalDate updateDate;
    
   /* @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "card_id")
    private CreditCard card;*/
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sector_type")
    private SectorType sector;

}
