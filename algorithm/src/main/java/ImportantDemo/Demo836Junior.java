package ImportantDemo;

import org.junit.Test;

//矩阵重叠
public class Demo836Junior {
    @Test
    public void test01(){

    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);
    }
}
