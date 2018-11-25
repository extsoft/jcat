package pro.extsoft.comments;

import io.github.tatools.sunshine.core.RegexCondition;
import io.github.tatools.sunshine.core.Sun;
import io.github.tatools.sunshine.core.VerboseRegex;
import io.github.tatools.sunshine.testng.LoadableTestNGSuite;
import io.github.tatools.sunshine.testng.TestNGKernel;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class App {
    public static void main(String[] args) {
        new Sun(
                new TestNGKernel(
                        new LoadableTestNGSuite(
                                new VerboseRegex(
                                        new RegexCondition(
                                                args.length == 1 ? args[0] : "^pro.extsoft.comments.tests(.+)?"
                                        )
                                )
                        )
                )
        ).shine();
    }
}
