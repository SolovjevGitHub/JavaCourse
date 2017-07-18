

public class Book {
    private int id;
    private String title;
    private int pages;
    private String published;
    private String rating;
    private int writerId;
    private String writer;
    private BookWriter bookWriter;

    public Book(int id, String title, int pages, String published, String rating, int writerId) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.published = published;
        this.rating = rating;
        this.writerId = writerId;
    }

    public Book(String title, int pages, String published, String rating, int writerId) {
        this.title = title;
        this.pages = pages;
        this.published = published;
        this.rating = rating;
        this.writerId = writerId;
    }

    public Book(String title, int pages, String published, String rating) {
        this.title = title;
        this.pages = pages;
        this.published = published;
        this.rating = rating;
    }

    public Book(String writer, String title, int pages, String published, String rating) {
        this.writer = writer;
        this.title = title;
        this.pages = pages;
        this.published = published;
        this.rating = rating;


    }

    public Book(BookWriter bookWriter,String title, int pages, String published, String rating, int writerId, String writer) {
        this.bookWriter = bookWriter;
        this.title = title;
        this.pages = pages;
        this.published = published;
        this.rating = rating;
        this.writerId = writerId;
        this.writer = writer;

    }

    public Book() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getWriterId() {
        return writerId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }
}

