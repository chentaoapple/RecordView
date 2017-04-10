package com.sf.canvas;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * @项目名: Canvas
 * @包名: com.sf.canvas
 * @创建者: 陈涛
 * @创建时间: 2017/4/7  13:55
 * @描述: 自定义View
 * @svn版本: Rev:
 * @更新人: Author: 01112178
 * @更新时间: Date:  2017/4/7  13:55
 * @更新描述: 自定义View
 */
public class RadarView extends View {
    private static final int DEFAULT_WIDTH  = 300;
    private static final int DEFAULT_HEIGHT = 300;
    private              int startColor     = R.color.colorAccent;
    private              int endColor       = R.color.colorAccent;
    private              int bgColor        = android.R.color.black;
    private              int lineColor      = android.R.color.white;
    private              int circleCount    = 4;

    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (null != attrs) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RadarView);
            startColor = ta.getColor(R.styleable.RadarView_startColor, context.getColor(startColor));
            endColor = ta.getColor(R.styleable.RadarView_endColor, context.getColor(endColor));
            bgColor = ta.getColor(R.styleable.RadarView_bgColor, context.getColor(bgColor));
            lineColor = ta.getColor(R.styleable.RadarView_lineColor, context.getColor(lineColor));
            circleCount = ta.getInteger(R.styleable.RadarView_circleCount, circleCount);
            ta.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureSize(1, DEFAULT_WIDTH, widthMeasureSpec);
        int height = measureSize(0, DEFAULT_HEIGHT, heightMeasureSpec);
        int size = Math.max(width, height);
        setMeasuredDimension(size, size);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int measureSize(int specType, int contentSize, int measureSpec) {
        int result;
        int specSize = MeasureSpec.getSize(measureSpec);
        int specMode = MeasureSpec.getMode(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = Math.max(contentSize, specSize);
        } else {
            result = contentSize;
            if (specType == 1) {
                result += (getPaddingLeft() + getPaddingRight());
            } else {
                result += (getPaddingTop() + getPaddingBottom());
            }
        }
        return result;
    }


}
