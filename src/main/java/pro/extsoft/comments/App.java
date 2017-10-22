package pro.extsoft.comments;

import io.github.tatools.sunshine.core.*;
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
                                new RegexCondition(
                                        new AttributeWithPrintableValue(
                                                "The following pattern will be used for classes filtering:",
                                                new AttributeFromSequence(
                                                        new AttributeOfTestPatternFromCli(),
                                                        new Attribute() {
                                                            @Override
                                                            public String value() {
                                                                return "^pro.extsoft.comments.tests(.+)?";
                                                            }

                                                            @Override
                                                            public boolean present() {
                                                                return true;
                                                            }
                                                        }
                                                )
                                        )
                                )
                        )
                )

        ).shine();
    }
}
