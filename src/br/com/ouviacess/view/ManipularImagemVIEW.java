package br.com.ouviacess.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Essa classe faz a formatação da imagem, Projeto Portaria IFSP
 *
 * @author Andre Luis Gobbi Primo
 * @version 1.0
 */
public class ManipularImagemVIEW {

    public static BufferedImage setImagemDimensao(Icon icon, Integer imgLargura, Integer imgAltura) {
        Double novaImgLargura = null;
        Double novaImgAltura = null;
        Double imgProporcao = null;
        Graphics2D g2d = null;
        BufferedImage imagem = null, novaImagem = null;

//        try {
//            //--- Obtém a imagem a ser redimensionada ---
//            imagem = ImageIO.read(new File(caminhoImg));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//            Logger.getLogger(ManipularImagemVIEW.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Converte o ícone para uma imagem
        if (icon instanceof ImageIcon) {
            imagem = (BufferedImage) ((ImageIcon) icon).getImage();
        } else {
            // Se o ícone não for uma instância de ImageIcon, você pode criar uma imagem em branco
            novaImagem = new BufferedImage(imgLargura, imgAltura, BufferedImage.TYPE_INT_RGB);
            g2d = novaImagem.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, imgLargura, imgAltura);
            return novaImagem;
        }

        //--- Obtém a largura da imagem ---  
        novaImgLargura = (double) imagem.getWidth();

        //--- Obtám a altura da imagem ---  
        novaImgAltura = (double) imagem.getHeight();

        //--- Verifica se a altura ou largura da imagem recebida é maior do que os ---  
        //--- parâmetros de altura e largura recebidos para o redimensionamento   ---  
        if (novaImgLargura >= imgLargura) {
            imgProporcao = (novaImgAltura / novaImgLargura);//calcula a proporção  
            novaImgLargura = (double) imgLargura;

            //--- altura deve <= ao parâmetro imgAltura e proporcional a largura ---  
            novaImgAltura = (novaImgLargura * imgProporcao);

            //--- se altura for maior do que o parâmetro imgAltura, diminui-se a largura de ---  
            //--- forma que a altura seja igual ao parâmetro imgAltura e proporcional a largura ---  
            while (novaImgAltura > imgAltura) {
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * imgProporcao);
            }
        } else if (novaImgAltura >= imgAltura) {
            imgProporcao = (novaImgLargura / novaImgAltura);//calcula a proporção  
            novaImgAltura = (double) imgAltura;

            //--- se largura for maior do que o parâmetro imgLargura, diminui-se a altura de ---  
            //--- forma que a largura seja igual ao parâmetro imglargura e proporcional a altura ---  
            while (novaImgLargura > imgLargura) {
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * imgProporcao);
            }
        }

        novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0, novaImgLargura.intValue(), novaImgAltura.intValue(), null);

        return novaImagem;
    }

    public static byte[] getImgBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPEG", baos);
        } catch (IOException ex) {
            //handle it here.... not implemented yet...
        }

        InputStream is = new ByteArrayInputStream(baos.toByteArray());

        return baos.toByteArray();
    }

    //Novo método para exibir imagem na tela
    //Recebe o label que queremos exibir E a imagem como array de bytes do banco
    public static void exibiImagemLabel(byte[] minhaimagem, javax.swing.JLabel label) {
        //primeiro verifica se tem a imagem
        //se tem convert para inputstream que é o formato reconhecido pelo ImageIO

        if (minhaimagem != null) {
            InputStream input = new ByteArrayInputStream(minhaimagem);
            try {
                BufferedImage imagem = ImageIO.read(input);
                label.setIcon(new ImageIcon(imagem));
            } catch (IOException ex) {
            }

        } else {
            label.setIcon(null);

        }

    }
}
