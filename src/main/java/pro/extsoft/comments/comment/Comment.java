package pro.extsoft.comments.comment;

public interface Comment {

    Comment pageComment();

    void fillData();

    void save();

    String info();

    void select();
}
