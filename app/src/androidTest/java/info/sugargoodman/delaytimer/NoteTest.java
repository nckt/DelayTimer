package info.sugargoodman.delaytimer;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.*;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.math.BigDecimal;

/**
 * Created by y.sato on 2014/11/24.
 *
 * How To Test:
 * cd [DelayTimer Project Root]
 * ./gradlew clean check
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class NoteTest{
    private Note note;

    /**
     * modifierに何も指定しないと1/denominator音符
     */
    @Test
    public void testIfModifierIsNotSetThenNormalNote(){
        note = new Note(4);
        assertThat( note.calcPhoneticVal(), is( new BigDecimal(0.25) ) );
    }

    /**
     * modifierが'DOTTED'だと音価が1.5倍
     */
    @Test
    public void testIfModifierIsDottedThenDottedNote(){
        note = new Note( 4, "DOTTED" );
        assertThat( note.calcPhoneticVal(), is( new BigDecimal(0.25).multiply(NoteConstants.DOTTED) ) );
    }

    /**
     * modifierが'TRIPLET'だと音価が2/3倍
     */
    @Test
    public void testIfModifierIsTripletThenTripletNote(){
        note = new Note( 4, "TRIPLET" );
        assertThat( note.calcPhoneticVal(), is( new BigDecimal(0.25).multiply(NoteConstants.TRIPLET) ) );
    }
}
