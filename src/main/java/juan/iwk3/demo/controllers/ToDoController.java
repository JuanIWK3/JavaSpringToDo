package juan.iwk3.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import juan.iwk3.demo.models.ToDo;
import juan.iwk3.demo.repositories.TodoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/")
public class ToDoController {

  private TodoRepository toDoRepository;

  public ToDoController(TodoRepository toDo) {
    this.toDoRepository = toDo;
  }

  @GetMapping
  public List<ToDo> getAll() {
    return toDoRepository.findAll();
  }

  @PostMapping
  public List<ToDo> createToDo(@RequestBody ToDo newToDo) {
    toDoRepository.save(newToDo);
    return toDoRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<ToDo>> getById(@PathVariable Long id) {
    Optional<ToDo> toDo;
    try {
      toDo = toDoRepository.findById(id);
      return new ResponseEntity<Optional<ToDo>>(toDo, HttpStatus.OK);
    } catch (NoSuchElementException nsee) {
      return new ResponseEntity<Optional<ToDo>>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(value = "/{id}")
  public List<ToDo> updatePerson(@PathVariable Long id, @RequestBody ToDo updatedToDo) {
    toDoRepository.findById(id).map(toDo -> {
      toDo.setName(updatedToDo.getName());
      toDo.setDescription(updatedToDo.getDescription());
      toDo.setDate(updatedToDo.getDate());
      toDo.setTime(updatedToDo.getTime());

      return toDoRepository.save(toDo);
    });

    return toDoRepository.findAll();
  }

  @DeleteMapping(path = "/{id}")
  public List<ToDo> deleteToDo(@PathVariable Long id) {
    toDoRepository.deleteById(id);
    return toDoRepository.findAll();
  }
}
