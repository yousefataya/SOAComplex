package generatebarcodetransaction;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;



public class GenerateBarcodeClass {
	
	public static byte[] getBarcodeByType(String strBarcodeType,String strCode)
	{
		byte[] pngImageData = null;
		
		switch (strBarcodeType) {
		case "code39":
			pngImageData = Generate39(strCode);
			break;
			
		case "CODE128":
			pngImageData = Generate_EAN_UCC_13(strCode);
			break;

		default:
			break;
		}
		
		return pngImageData;
		
	}
	
	private static byte[] Generate39(String strCode)
	{
		byte[] pngImageData = null;
	  	Barcode39 code39ext = new Barcode39();
    	code39ext.setCode(strCode);
    	code39ext.setStartStopText(false);
    	code39ext.setExtended(true);
    	java.awt.Image rawImage = code39ext.createAwtImage(Color.BLACK, Color.WHITE);

    	pngImageData = generateIamgeByBarcodeImage(rawImage);
    	
    	return pngImageData;
	}

	private static byte[] Generate_EAN_UCC_13(String strCode)
	{
		//http://blog.icodejava.com/1273/bar-code-generation-in-java/
		byte[] pngImageData = null;
		
		  Barcode128 code128 = new Barcode128();
		  code128.setBaseline(-1);
		  code128.setSize(12);
		  code128.setCode(strCode);
		  code128.setCodeType(Barcode128.CODE128);
		  code128.setFont(null);

        try {
        	java.awt.Image rawImage = code128.createAwtImage(Color.BLACK, Color.WHITE);

        	pngImageData = makeBlackAndWhitePng(rawImage);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			
		}
    	return pngImageData;
	}
	
	private static byte[] generateIamgeByBarcodeImage(java.awt.Image rawImage)
	{
		//http://stackoverflow.com/questions/5749860/get-bytes-from-itexts-barcode39-image
		byte[] pngImageData = null;
    	BufferedImage outImage = new BufferedImage(rawImage.getWidth(null), rawImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
    	outImage.getGraphics().drawImage(rawImage,0, 0, null);
    	ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
		try {
			ImageIO.write(outImage, "jpg", bytesOut);
	    	bytesOut.flush();
	    	pngImageData = bytesOut.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bytesOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return pngImageData;
	}
	
	private static byte[] makeBlackAndWhitePng(java.awt.Image image) throws IOException, DocumentException {
       
        BufferedImage newBi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_USHORT_GRAY);
        newBi.getGraphics().drawImage(image, 0, 0, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(newBi, "png", baos);
        return baos.toByteArray();
    }
	   
}