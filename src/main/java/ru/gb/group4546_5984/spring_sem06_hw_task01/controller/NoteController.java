package ru.gb.group4546_5984.spring_sem06_hw_task01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.group4546_5984.spring_sem06_hw_task01.model.Note;
import ru.gb.group4546_5984.spring_sem06_hw_task01.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Контроллер Заметок
 */
//Проверка свагером http://localhost:8080/swagger-ui/index.html
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    /**
     * Добавление заметки.
     * @param note - Заметка
     * @return - Универсальный тип http ответа,
     * содержащий тело заметки и статус ответа
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        note.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    /**
     * Просмотр всех заметок
     * @return - универсальный тип http ответа,
     *  содержащий список заметок и статус ответа
     */
    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    /**
     * Получение заметки по id.
     * @param id - id заметки
     * @return - универсальный тип http ответа,
     *  содержащий тело заметки и статус ответа
     */
    @GetMapping("{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable("id") Long id) {
        Note note;
        try {
            note = noteService.findNoteById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    /**
     * Редактирование заметки
     * @param note - Заметка
     * @return - универсальный тип http ответа,
     *  содержащий тело заметки и статус ответа
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        note.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    /**
     * Удаление заметки
     * @param id - id заметки
     * @return - универсальный тип http ответа,
     *  содержащий статус ответа
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }


}
