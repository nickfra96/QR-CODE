package qrcode;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class BarCodeGenerator extends JPanel {

    private static final long serialVersionUID = -4147740402524630710L;




	private static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 600, 600);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);


    }
  

    
    
    public void paint(Graphics g) {
    	String nome = "Francesco Nicoletti";
        Image img = null;
		try {
			img = generateQRCodeImage(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        g.drawImage(img, 50,50,this);
     }
    
 

    
    public static void main(String[] args) throws Exception {
		
    	
    	JFrame frame = new JFrame();
    	 frame.getContentPane().add(new BarCodeGenerator());
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(200, 200);
         frame.setVisible(true);
    
	}
    
 
}
