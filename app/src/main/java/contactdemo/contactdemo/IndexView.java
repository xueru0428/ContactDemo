package contactdemo.contactdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ChenJiangFeng on 2017/1/5.
 */

public class IndexView extends View {
    private IndexView iv_main_words;
    private int viewWidth;
    private int viewHeight;

    private int itemWidth;
    private int itemHeight;

    private Paint paint;
    //下标
    private int currentindex = -1;
    private String [] words ={"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};

    public IndexView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        //设置字体
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize(30);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            viewWidth = getMeasuredWidth();
            viewHeight = getMeasuredHeight();

            itemHeight = viewHeight/words.length;
            itemWidth = viewWidth;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0;i<words.length;i++){
            if( i == currentindex) {
                paint.setColor(Color.GRAY);
            }else{
                paint.setColor(Color.WHITE);
            }
            String word = words[i];

            Rect rect = new Rect();
            paint.getTextBounds(word, 0, 1, rect);
            //得到了字母的宽跟高
            int wordwidth = rect.width();
            int wordheight =rect.height();
            //字母的坐标
            float wordsX = itemWidth/2-wordwidth/2;
            float wordsY = itemHeight/2 +wordheight/2+i*itemHeight;
            //绘制字母
            canvas.drawText(word,wordsX,wordsY,paint);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                int index = (int) (y/itemHeight);
                if(currentindex != index) {
                    currentindex = index;
                    if(listerent != null && words!= null &&  currentindex <words.length){
                        //MyOnIndexChangeListener
                        if(currentindex > -1)
                        listerent.onIndeChange(words[currentindex]);//这快有bug
                    }
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
                currentindex = -1;
                invalidate();
                break;
        }
        return true;
    }

    /**
     * 设置接口
     */
    public interface onIndexChangeListerent{

        public void onIndeChange(String word);
    }

    private onIndexChangeListerent listerent;

    /**
     * 设置页面变化的监听
     * @param l
     */
    public void setOnIndexChangeListerent(onIndexChangeListerent l){
        this.listerent = l;
    }
}
