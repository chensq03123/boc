package com.boc.bocop.sdk.util;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BPUtil {
	private static final char[] CHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };

	private static BPUtil bpUtil;

	public static BPUtil getInstance() {
		if (bpUtil == null) {
			bpUtil = new BPUtil();
		}
		return bpUtil;
	}

	private static final int DEFAULT_CODE_LENGTH = 4;
	private static final int DEFAULT_FONT_SIZE = 20;
	private static final int DEFAULT_LINE_NUMBER = 3;
	private static final int BASE_PADDING_LEFT = 5, RANGE_PADDING_LEFT = 10,
			BASE_PADDING_TOP = 15, RANGE_PADDING_TOP = 10;
	private static final int DEFAULT_WIDTH = 60, DEFAULT_HEIGHT = 30;

	// settings decided by the layout xml
	// canvas width and height
	private int width = DEFAULT_WIDTH, height = DEFAULT_HEIGHT;

	// random word space and pading_top
	private int basePaddingLeft = BASE_PADDING_LEFT,
			rangePaddingLeft = RANGE_PADDING_LEFT,
			basePaddingTop = BASE_PADDING_TOP,
			rangePaddingTop = RANGE_PADDING_TOP;

	// number of chars, lines; font size
	private int codeLength = DEFAULT_CODE_LENGTH,
			line_number = DEFAULT_LINE_NUMBER, font_size = DEFAULT_FONT_SIZE;

	// variables
	private String code;
	private int paddingLeft, paddingTop;
	private Random random = new Random();

	public Bitmap createBitmap() {
		paddingLeft = 0;

		Bitmap bp = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas c = new Canvas(bp);

		code = createCode();

		c.drawColor(Color.WHITE);
		Paint paint = new Paint();
		paint.setTextSize(font_size);

		for (int i = 0; i < line_number; i++) {
			drawLine(c, paint);
		}

		c.save(Canvas.ALL_SAVE_FLAG);
		// 保存
		c.restore();//
		return bp;
	}

	public String getCode() {
		return code;
	}

	private String createCode() {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < codeLength; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}

	private void drawLine(Canvas canvas, Paint paint) {
		int color = randomColor();
		int startX = random.nextInt(width);
		int startY = random.nextInt(height);
		int stopX = random.nextInt(width);
		int stopY = random.nextInt(height);
		paint.setStrokeWidth(1);
		paint.setColor(color);
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}

	private int randomColor() {
		return randomColor(1);
	}

	private int randomColor(int rate) {
		int red = random.nextInt(256) / rate;
		int green = random.nextInt(256) / rate;
		int blue = random.nextInt(256) / rate;
		return Color.rgb(red, green, blue);
	}

	private void randomPadding() {
		paddingLeft += basePaddingLeft + random.nextInt(rangePaddingLeft);
		paddingTop = basePaddingTop + random.nextInt(rangePaddingTop);
	}

}
