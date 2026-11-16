package Test_NG;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReateBarCode {
    @Test
    public void ReadBARCod() throws Exception {
        // Kiểm tra file ảnh barcode trong thư mục dự án hoặc F:\barcode_newa.png
        File barcodeFile = new File("barcode_newa.png");
        if (!barcodeFile.exists()) {
            barcodeFile = new File("F:\\barcode_newa.png");
        }
        
        BufferedImage bufferedImage = ImageIO.read(barcodeFile);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = new MultiFormatReader().decode(bitmap);
        
        System.out.println("NỘI DUNG GIẢI MÃ ĐƯỢC LÀ: " + result.getText());
        AssertJUnit.assertEquals("PLT SOLUTIONS - AUTOMATION", result.getText());
    }
}
