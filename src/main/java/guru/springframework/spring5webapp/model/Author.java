package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private FLName flName;


    @ManyToMany(mappedBy = "authors")
    private Set<Book>books = new HashSet<>();

    public Author(){ }

    public Author(FLName flName) {
        this.flName = flName;

    }

    public Author(FLName flName, Set<Book> books) {
        this.flName = flName;
        this.books = books;
    }


    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) { this.books = books; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public FLName getFlName() { return flName; }

    public void setFlName(FLName flName) { this.flName = flName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", flName=" + flName +
                ", books=" + books +
                '}';
    }
}
