package ru.gb.group4546_5984.spring_sem06_hw_task01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.group4546_5984.spring_sem06_hw_task01.model.Note;

/**
 * JPA Репозиторий заметки
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
