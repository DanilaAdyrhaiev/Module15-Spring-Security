package com.goit.Module15.Repos;

import com.goit.Module15.entities.Note;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

}
