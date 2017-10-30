package pro.extsoft.comments.elements;


import org.testng.annotations.Test;


/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SmartCheckBoxTest {
    @Test
    public void testChecked() throws Exception {
        assert new SmartCheckBox(new CheckBox() {
            @Override
            public void check() {

            }

            @Override
            public void uncheck() {

            }

            @Override
            public boolean checked() {
                return true;
            }
        }).checked();
    }
}