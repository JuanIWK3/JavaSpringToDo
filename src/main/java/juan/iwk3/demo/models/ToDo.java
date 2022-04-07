package juan.iwk3.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {

  // MODEL ID FIELD
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  // Model Specific Properties
  public String name;
  public String description;
  public Date date;
  public Date time;

  // constructor
  public ToDo() {

  }

  public ToDo(String name, String description, Date date, Date time) {
    this.name = name;
    this.description = description;
    this.date = date;
    this.time = time;
  }

  // getters

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }

  public Date getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public Date getTime() {
    return time;
  }

  // setters

  public void setId(Long id) {
    this.id = id;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTime(Date time) {
    this.time = time;
  }

}
