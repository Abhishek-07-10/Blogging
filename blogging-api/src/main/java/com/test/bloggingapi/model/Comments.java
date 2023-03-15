package com.test.bloggingapi.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @NotBlank(message = "Message should not be")
    private String msg;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @ManyToOne
    private Users userId;
    @ManyToOne
    private Post postId;

}
