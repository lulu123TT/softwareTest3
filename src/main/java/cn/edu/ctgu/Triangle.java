package cn.edu.ctgu;

public class Triangle {
    public String classify(final int a, final int b, final int c) {
        final int num = 100;
        if (a < 1 || a > num || b < 1 || b > num || c < 1 || c > num) {
            return "输入错误";
        }
        if (!((a + b > c) && (a + c > b) && (b + c > a))) {
            return "非三角形";
        } else if (a == b && a == c && b == c) {
            return "等边三角形";
        } else if (a != b && a != c && b != c) {
            return "不等边三角形";
        } else {
            return "等腰三角形";
        }
    }
}
