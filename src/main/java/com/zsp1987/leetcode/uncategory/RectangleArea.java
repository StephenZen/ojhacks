package com.zsp1987.leetcode.uncategory;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Rectangle Area Assume that the total area is never beyond the maximum
 * possible value of int.
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int area1 = Math.abs(C - A) * Math.abs(D - B);
		int area2 = Math.abs(G - E) * Math.abs(H - F);
		int width = 0, height = 0;
		// calculate the collapse area;
		// calculate the width
		if (E >= A && E <= C) {
			if (G >= C)
				width = Math.abs(C - E);
			else
				width = Math.abs(G - E);
		} else if (A >= E & A <= G) {
			if (C >= G)
				width = Math.abs(G - A);
			else
				width = Math.abs(C - A);
		}
		// calculate the height
		if (B >= F && B <= H) {
			if (D >= H)
				height = Math.abs(H - B);
			else
				height = Math.abs(D - B);
		} else if (F >= B && F <= D) {
			if (H >= D)
				height = Math.abs(D - F);
			else
				height = Math.abs(H - F);
		}
		return area1 + area2 - height * width;

	}
}

// æ³¨æ„?é‡?å? ä¸ŽåŒ…å?«çš„å…³ç³», éƒ¨åˆ†é‡?å? å’Œå…¨åŒ…æ¶µ