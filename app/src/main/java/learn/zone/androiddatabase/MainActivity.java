package learn.zone.androiddatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Book book = new Book();
        book.setTitle("Zero to one");
        book.setAuthor("Peter Thiel");
        book.save();

        Book book2 = new Book();
        book2.setTitle("Antifragile");
        book2.setAuthor("Nassim Taleb");
        book2.save();

        //Retrieve all books that are saved in database
        List<Book> books = getAll();
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("All books_____________\n"+String.valueOf(books));

        //Retrieve all books by Peter Thiel
        textView.append("\n\nBooks by Peter Thiel_______________\n");
        List<Book> peterTheilBooks = getAll("Peter Thiel");
        textView.append(String.valueOf(peterTheilBooks));

        textView.append("\n\nDeleting the book by Nassim Taleb___");
        deleteBook("Nassim Taleb");

        List<Book> newBookList=getAll();
        textView.append("\n\nAll books_____________\n" + String.valueOf(newBookList));
    }

    public List<Book> getAll() {
        return new Select()
                .from(Book.class)
                .execute();
    }

    public  List<Book> getAll(String author) {
        return new Select()
                .from(Book.class)
                .where("author = ?", author)
                .execute();
    }


    public void deleteBook(String author) {
        new Delete()
                .from(Book.class)
                .where("author = ?", author)
                .execute();
    }
}
