package pro.extsoft.comments;

import io.github.tatools.sunshine.core.*;
import io.github.tatools.sunshine.testng.CachedTestNGSuite;
import io.github.tatools.sunshine.testng.LoadableTestNGSuite;
import io.github.tatools.sunshine.testng.TestNGEngine;

import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class App {
    public static void main(String[] args) throws IOException, EngineException {
        new TestNGEngine(
                new CachedTestNGSuite(
                        new LoadableTestNGSuite(
                                new FileSystemOfClasspathClasses(),
                                new DirectoryWithAutomaticCreation(
                                        new DirectoryWithAutomaticDeletion(
                                                new DirectorySafe(Files.createTempDirectory("comments-at"))
                                        )
                                ),
                                new RegexCondition("^com.extsoft.comments.tests(.+)?")
                        )
                )
        ).run();
    }
}
