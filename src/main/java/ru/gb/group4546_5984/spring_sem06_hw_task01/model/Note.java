package ru.gb.group4546_5984.spring_sem06_hw_task01.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


/**
 * Заметка с полями:
 * - ID (автоинкрементное)(тип - Long)
 * - Заголовок (не может быть пустым)(тип - String)
 * - Содержимое (не может быть пустым)(тип - String)
 * - Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
 */
@Entity
@Table(name = "notes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "context", nullable = false)
    private String context;
    @Column(name = "local_date_time")
    private LocalDateTime localDateTime;

}
