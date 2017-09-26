package tests;

import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HastuneMiku on 2017/8/23.
 */
public class ImageTest {
    private int width;
    private int height;
    BufferedImage screenshot;
    public BufferedImage getScreenshot() throws AWTException, IOException {
        final Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) dimension.getWidth();
        height = (int) dimension.getHeight();
        screenshot = robot.createScreenCapture(new Rectangle(0, 0, width, height));
        screenshot=resizeFix(960, 540);
        //File outputfile = new File("saved.png");
       // ImageIO.write(screenshot, "png", outputfile);
        //WritableImage w
        return screenshot;
    }
    public static  void main(String args[]){
        try {
            BufferedImage image=ImageIO.read(new File("src/views/default.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照宽度还是高度进行压缩
     *
     * @param w int 最大宽度
     * @param h int 最大高度
     */
    private BufferedImage resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            return resizeByWidth(w);
        } else {
            return resizeByHeight(h);
        }
    }

    /**
     * 以宽度为基准，等比例放缩图片
     *
     * @param w int 新宽度
     */
    private BufferedImage resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        return resize(w, h);
    }

    /**
     * 以高度为基准，等比例缩放图片
     *
     * @param h int 新高度
     */
    private BufferedImage resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        return resize(w, h);
    }

    /**
     * 强制压缩/放大图片到固定的大小
     *
     * @param w int 新宽度
     * @param h int 新高度
     */
    private BufferedImage resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        image.getGraphics().drawImage(screenshot, 0, 0, w, h, null); // 绘制缩小后的图
        return image;
    }
}
