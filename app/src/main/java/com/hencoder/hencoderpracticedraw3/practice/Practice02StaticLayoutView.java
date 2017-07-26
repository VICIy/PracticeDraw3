package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 绘制换行字体
 */
public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字，当文字中含有换行\n的时候，绘制出的文字不会换行，\n的位置转换为空格
        //只能绘制单行文字，不会再边缘折行
        canvas.drawText(text, 50, 100, textPaint);
        //文字、画笔、换行的区间设置，对齐方式，行间距，行间距额外增加的值，是否需要在文字的上下添加额外控件
        StaticLayout staticLayout = new StaticLayout(text,textPaint,400, Layout.Alignment.ALIGN_NORMAL,1,0,true);
        canvas.save();
        canvas.translate(0,100);
        staticLayout.draw(canvas);
        canvas.restore();

    }
}
