package cn.mesie.seedfilling;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.Stack;

/**
 * ��������㷨
 * @author meise
 * 2016��4��14�� ����10:06:07
 */
public class SeedFiling {

	//ջ
	private Stack<Point> mStack = new Stack<Point>();
	
	private int mBorderColor = -1;

    private boolean hasBorderColor = false;
	/**
	 * 
	 * @param pixels ��������
	 * @param w ��
	 * @param h ��
	 * @param pixel �������ɫ
	 * @param newColor �����ɫ
	 * @param i ������
	 * @param j ������
	 */
	public void fillColor(int[] pixels, int w, int h, int pixel, int newColor, int i, int j){
		//1.�����ӵ�(x,y)��ջ
		mStack.push(new Point(i,j));
		
		//2.�ж�ջ�Ƿ�Ϊ��
		// ���ջΪ��������㷨������ȡ��ջ��Ԫ����Ϊ��ǰɨ���ߵ����ӵ�(x, y)��
        // y�ǵ�ǰ��ɨ���ߣ�
		while(!mStack.isEmpty()){
			
		    //����3�������ӵ�(x, y)�������ص�ǰɨ��������������������䣬
			//ֱ���߽硣�ֱ������ε����Ҷ˵�����ΪxLeft��xRight��
			Point seed = (Point) mStack.pop();
			int count = fillLineLeft(pixels, pixel, w, h, newColor, i, j);
			int left = seed.x - count + 1;
			count = fillLineRight(pixels, pixel, w, h, newColor, i, j) ;
			int right = seed.x + count;
			
			/**
             * ����4��
             * �ֱ����뵱ǰɨ�������ڵ�y - 1��y + 1����ɨ����������[xLeft, xRight]�е����أ�
             * ��xRight��ʼ��xLeft��������������ɨ�������ΪAAABAAC��AΪ���ӵ���ɫ����
             * ��ô��B��Cǰ���A��Ϊ���ӵ�ѹ��ջ�У�Ȼ�󷵻صڣ�2������
             */
            //��y-1������
            if (seed.y - 1 >= 0)
                findSeedInNewLine(pixels, pixel, w, h, seed.y - 1, left, right);
            //��y+1������
            if (seed.y + 1 < h)
                findSeedInNewLine(pixels, pixel, w, h, seed.y + 1, left, right);
		}
	}
	
	/**
     * �����������ӽڵ�
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
         * ��ø��еĿ�ʼ����
         */
        int begin = i * w + left;
        /**
         * ��ø��еĽ�������
         */
        int end = i * w + right;

        boolean hasSeed = false;

        int rx = -1, ry = -1;

        ry = i;

        /**
         * ��end��begin���ҵ����ӽڵ���ջ��AAABAAAB����Bǰ��AΪ���ӽڵ㣩
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
     * ������ɫ���������ĸ���
     *
     * @return
     */
    private int fillLineRight(int[] pixels, int pixel, int w, int h, int newColor, int x, int y)
    {
        int count = 0;

        while (x < w)
        {
            //�õ�����
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
     * ������ɫ��������ɫ������ֵ
     *
     * @return
     */
    private int fillLineLeft(int[] pixels, int pixel, int w, int h, int newColor, int x, int y)
    {
        int count = 0;
        while (x >= 0)
        {
            //���������
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
     * ����һ�������ɫ
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
