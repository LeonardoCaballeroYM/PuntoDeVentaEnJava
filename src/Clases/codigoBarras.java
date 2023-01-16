/** ** @author Richard */
package Clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class codigoBarras {

    public void barras(){

        Conectar cc = new Conectar();
        Connection con = cc.conexion();

        PreparedStatement ps;
        ResultSet rs;
        Image img;

        try {

            ps = con.prepareStatement("SELECT * FROM productos");
            rs = ps.executeQuery();

            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigos.pdf"));
            doc.open();

            Barcode39 Code = new Barcode39();

            while (rs.next()) {

                Code.setCode(rs.getString("cod_producto"));
                img = Code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
                doc.add(img);

                doc.add(new Paragraph(" "));
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(codigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(codigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(codigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Códigos de Barras generados correctamente");
    }
}
