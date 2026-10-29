/*
 * SPDX-FileCopyrightText: 2006 The Android Open Source Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.prauga.calculator;

import android.content.Context;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;

import com.google.android.material.button.MaterialButton;

/**
 * A basic Button that vibrates on finger down.
 */
public class HapticButton extends MaterialButton {
    public HapticButton(Context context) {
        super(context);
        initVibration();
    }

    public HapticButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initVibration();
    }

    public HapticButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initVibration();
    }

    private void initVibration() {
        setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            }

            // Passthrough
            return false;
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateTextSize(w, h);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore,
            int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        updateTextSize(getWidth(), getHeight());
    }

    private void updateTextSize(int w, int h) {
        if (w == 0 || h == 0 || getIcon() != null) {
            return;
        }

        float textSize = h * 0.4f;
        CharSequence text = getText();
        final TransformationMethod method = getTransformationMethod();
        if (method != null) {
            text = method.getTransformation(text, this);
        }
        final TextPaint paint = new TextPaint(getPaint());
        paint.setTextSize(textSize);
        final float textWidth = paint.measureText(text, 0, text.length());
        final float available = 0.9f * (w - getCompoundPaddingLeft() - getCompoundPaddingRight());
        if (textWidth > available) {
            textSize *= available / textWidth;
        }
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }
}
