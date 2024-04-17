package ru.gb.group4546_5984.spring_sem06_hw_task01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.group4546_5984.spring_sem06_hw_task01.model.Note;
import ru.gb.group4546_5984.spring_sem06_hw_task01.repository.NoteRepository;

import java.util.List;

/**
 * Сервис заметки
 */
@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    /**
     * Добавление заметки
     * @param note - Заметка
     * @return - Заметка
     */
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Получение всех заметок
     * @return - список заметок
     */
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Поиск заметки по id
     * @param id - id заметки
     * @return - Заметка
     */
    public Note findNoteById(Long id) {
        return noteRepository.findById(id).orElseThrow(null);
    }

    /**
     * Редактирование заметки
     * @param note - Обновленная заметка
     * @return - Заметка
     */
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Удаление заметки по id
     * @param id -id заметки
     */
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
