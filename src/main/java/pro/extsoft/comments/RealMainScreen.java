package pro.extsoft.comments;

import pro.extsoft.comments.comment.Comment;
import pro.extsoft.comments.comments.Comments;
import pro.extsoft.comments.comments.SelfLoadedComments;
import pro.extsoft.comments.elements.DefaultField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class RealMainScreen implements MainScreen {

    private final WebDriver webDriver;

    public RealMainScreen(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void open() {
        webDriver.get("http://commentssprintone.azurewebsites.net");
    }

    @Override
    public Iterator<String> commentsPageNames() {
        String data = new DefaultField(webDriver, By.className("webgrid-footer")).data();
        return Arrays.stream(data.split(" ")).collect(Collectors.toList()).iterator();
    }

    @Override
    public Comments comments(String pageName) {
        return new SelfLoadedComments(webDriver, pageName);
    }

    @Override
    public Comments lastComments() {
        Iterator<String> pageNames = commentsPageNames();
        String page = "";
        while (pageNames.hasNext()) {
            String next = pageNames.next();
            if (next.matches("\\d+?")) {
                page = next;
            }
        }
        return comments(page);
    }

    @Override
    public boolean contains(Comment comment) {
        Iterator<String> names = commentsPageNames();
        while (names.hasNext()) {
            Comments current = comments(names.next());
            if (current.contains(comment)) {
                return true;
            }
        }
        return false;
    }
}
