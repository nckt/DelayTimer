package info.sugargoodman.delaytimer;

import java.math.BigDecimal;

/**
 * 音符の修飾子を分数にしたものの定数クラス
 */
public class NoteConstants {
    /**
     * インスタンスの生成は禁止。
     */
    public NoteConstants(){
    }

    public static final BigDecimal DOTTED;
    public static final BigDecimal TRIPLET;

    static {
        DOTTED  = BigDecimal.valueOf(3).divide( BigDecimal.valueOf(2), 10, BigDecimal.ROUND_HALF_UP );
        TRIPLET = BigDecimal.valueOf(2).divide( BigDecimal.valueOf(3), 10, BigDecimal.ROUND_HALF_UP );
    }
}
