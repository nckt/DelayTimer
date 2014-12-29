package info.sugargoodman.delaytimer;

import java.math.BigDecimal;

import static info.sugargoodman.delaytimer.NoteConstants.*;

/**
 * 音符クラス。音符の長さ(音価)を管理します。
 * @author Y.Sato <galikuson@gmail.com>
 */
public class Note {
    private int denominator;
    private BigDecimal modifier;

    /**
     * 修飾子なしのコンストラクタ。
     * @param denominator 音価の分母。4分音符なら、4。
     */
    public Note(int denominator){
        this.denominator = denominator;
        this.modifier = new BigDecimal(1);
    }

    /**
     * 修飾子ありのコンストラクタ。
     * @param denominator 音価の分母。4分音符なら、4。
     * @param modifier    音符の修飾子。'DOTTED' or 'TRIPLET'。それ以外は音価に影響を与えない。
     */
    public Note(int denominator, String modifier){
        this.denominator = denominator;

        String upperCaseModifier = modifier.toUpperCase();
        if( upperCaseModifier.equals("DOTTED") ){
            this.modifier = DOTTED;
        }else if( upperCaseModifier.equals("TRIPLET") ){
            this.modifier = TRIPLET;
        }else{
            this.modifier = new BigDecimal(1);
        }
    }

    /**
     * 音価を計算します。
     */
    public BigDecimal calcPhoneticVal(){
        // 1 / denominator * modifier
        return new BigDecimal(1).divide( new BigDecimal(denominator) ).multiply(modifier);
    }
}
