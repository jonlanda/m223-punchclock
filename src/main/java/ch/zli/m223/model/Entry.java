package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime checkIn;

  @Column(nullable = false)
  private LocalDateTime checkOut;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  public Set<Tags> getTag() {
    return tag;
  }

  public void setTag(Set<Tags> tag) {
    this.tag = tag;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }

  @ManyToOne
  @JoinColumn(name = "category_id", nullable = true)
  private Category category;

  public void setCategory(Category category) {
    this.category = category;
  }

  public Category getCategory() {
    return category;
  }

  @ManyToMany
  @JoinTable(name = "entry_tags", joinColumns = @JoinColumn(name = "entry_id"), inverseJoinColumns = @JoinColumn(name = "tags_id"))
  private Set<Tags> tag;
}