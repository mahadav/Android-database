package learn.zone.androiddatabase;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.HashMap;

@Table(name = "Book")
public class Book extends Model {
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        HashMap<String,String> map=new HashMap<>();
        map.put("title", title);
        map.put("author", author);
        return map.toString();
    }
}
