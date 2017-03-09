package cn.mesie.seedfilling;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.Stack;

/**
 * 种子填充算法
 * @author meise
 * 2016年4月14日 下午10:06:07
 */
public class SeedFiling {

	//栈
	private Stack<Point> mStack = new Stack<Point>();
	
	private int mBorderColor = -1;

    private boolean hasBorderColor = false;
	/**
	 * 
	 * @param pixels 像素数组
	 * @param w 宽
	 * @param h 高
	 * @param pixel 当填充颜色
	 * @param newColor 填充颜色
	 * @param i 横坐标
	 * @param j 纵坐标
	 */
	public void fillColor(int[] pixels, int w, int h, int pixel, int newColor, int i, int j){
		//1.将粽子点(x,y)入栈
		mStack.push(new Point(i,j));
		
		//2.判断栈是否为空
		// 如果栈为空则结束算法，否则取出栈顶元素作为当前扫描线的种子点(x, y)，
        // y是当前的扫描线；
		while(!mStack.isEmpty()){
			
		    //步骤3：从种子点(x, y)出发，沿当前扫描线向左、右两个方向填充，
			//直到边界。分别标记区段的左、右端点坐标为xLeft和xRight；
			Point seed = (Point) mStack.pop();
			int count = fillLineLeft(pixels, pixel, w, h, newColor, i, j);
			int left = seed.x - count + 1;
			count = fillLineRight(pixels, pixel, w, h, newColor, i, j) ;
			int right = seed.x + count;
			
			/**
             * 步骤4：
             * 分别检查与当前扫描线相邻的y - 1和y + 1两条扫描线在区间[xLeft, xRight]中的像素，
             * 从xRight开始向xLeft方向搜索，假设扫描的区间为AAABAAC（A为种子点颜色），
             * 那么将B和C前面的A作为种子点压入栈中，然后返回第（2）步；
             */
            //从y-1找种子
            if (seed.y - 1 >= 0)
                findSeedInNewLine(pixels, pixel, w, h, seed.y - 1, left, right);
            //从y+1找种子
            if (seed.y + 1 < h)
                findSeedInNewLine(pixels, pixel, w, h, seed.y + 1, left, right);
		}
	}
	
	/**
     * 在新行找种子节点
     *
     * @param pixels
     * @param pixel
     * @param w
     * @param h
     * @param i
     * @param left
     * @param right
     */
    private void findSeedInNewLine(int[] pixels, int pixel, int w, int h, int i, int left, int right)
    {
        /**
         * 获得该行的开始索引
         */
        int begin = i * w + left;
        /**
         * 获得该行的结束索引
         */
        int end = i * w + right;

        boolean hasSeed = false;

        int rx = -1, ry = -1;

        ry = i;

        /**
         * 从end到begin，找到种子节点入栈（AAABAAAB，则B前的A为种子节点）
         */
        while (end >= begin)
        {
            if (pixels[end] == pixel)
            {
                if (!hasSeed)
                {
                    rx = end % w;
                    mStack.push(new Point(rx, ry));
                    hasSeed = true;
                }
            } else
            {
                hasSeed = false;
            }
            end--;
        }
    }

    /**
     * 往右填色，返回填充的个数
     *
     * @return
     */
    private int fillLineRight(int[] pixels, int pixel, int w, int h, int newColor, int x, int y)
    {
        int count = 0;

        while (x < w)
        {
            //拿到索引
            int index = y * w + x;
            if (needFillPixel(pixels, pixel, index))
            {
                pixels[index] = newColor;
                count++;
                x++;
            } else
            {
                break;
            }

        }

        return count;
    }


    /**
     * 往左填色，返回填色的数量值
     *
     * @return
     */
    private int fillLineLeft(int[] pixels, int pixel, int w, int h, int newColor, int x, int y)
    {
        int count = 0;
        while (x >= 0)
        {
            //计算出索引
            int index = y * w + x;

            if (needFillPixel(pixels, pixel, index))
            {
                pixels[index] = newColor;
                count++;
                x--;
            } else
            {
                break;
            }

        }
        return count;
    }

    private boolean needFillPixel(int[] pixels, int pixel, int index)
    {
        if (hasBorderColor)
        {
            return pixels[index] != mBorderColor;
        } else
        {
            return pixels[index] == pixel;
        }
    }

    /**
     * 返回一个随机颜色
     *
     * @return
     */
    private int randomColor()
    {
        Random random = new Random();
//        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return 1;
    }
    
    public static void jisuan(){
    	System.out.println("123");
    }
}
