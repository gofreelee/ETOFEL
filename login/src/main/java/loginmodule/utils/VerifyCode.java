package loginmodule.utils;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class VerifyCode {
    private int width;
    private int height;
    private final Random random = new Random();
    // {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
    private final String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    // 验证码上的文本
    private String text;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // 生成随机的颜色
    private Color randomColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    // 生成随机的字体
    private Font randomFont() {
        int index = random.nextInt(fontNames.length);
        String fontName = fontNames[index];//生成随机的字体名称
        int style = random.nextInt(4);//生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
        int size = random.nextInt(5) + 24; //生成随机字号, 24 ~ 28
        return new Font(fontName, style, size);
    }

    // 画干扰线
    private void drawLine(BufferedImage image) {
        int num = 3;//一共画3条
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {//生成两个点的坐标，即4个值
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE); //干扰线是蓝色
            g2.drawLine(x1, y1, x2, y2);//画线
        }
    }

    // 随机生成一个字符
    private char randomChar() {
        // 可选字符
        String codes = "0123456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    // 创建BufferedImage
    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(new Color(255, 255, 255));
        g2.fillRect(0, 0, width, height);
        return image;
    }

    // 调用这个方法得到验证码
    public BufferedImage getImage() {
        BufferedImage image = createImage();//创建图片缓冲区 
        Graphics2D g2 = (Graphics2D) image.getGraphics();//得到绘制环境
        StringBuilder sb = new StringBuilder();//用来装载生成的验证码文本
        // 向图片中画4个字符
        for (int i = 0; i < 4; i++) {//循环四次，每次生成一个字符
            String s = randomChar() + "";//随机生成一个字母 
            sb.append(s); //把字母添加到sb中
            float x = i * 1.0F * width / 4; //设置当前字符的x轴坐标
            g2.setFont(randomFont()); //设置随机字体
            g2.setColor(randomColor()); //设置随机颜色
            g2.drawString(s, x, height - 5); //画图
        }
        this.text = sb.toString(); //把生成的字符串赋给了this.text
        drawLine(image); //添加干扰线
        return image;
    }

    /**
     * 获得base64格式的验证码
     * @return base64验证码
     */
    public String getBase64() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(getImage(), "JPEG", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }

    // 返回验证码图片上的文本
    public String getText() {
        return text;
    }
}

