package com.zsp1987.leetcode.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(value = RetentionPolicy.CLASS)
public @interface LeetCode {
  int value();
}
