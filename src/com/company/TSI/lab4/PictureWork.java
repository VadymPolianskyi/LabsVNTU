package com.company.TSI.lab4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class PictureWork {

    final static int begImg = 54;
    final static int k = 5;

    public static int countOf1(int number)
    {
        int answer = 0;
        while(number > 0)
        {
            answer += number % 2;
            number /= 2;
        }
        return answer;
    }

    public static byte[] readPicture(String pathName)
    {
        byte[] imageBytes = {};

        try{

            BufferedImage originalImage = ImageIO.read(new File(pathName));

            // convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "bmp", baos);
            baos.flush();
            imageBytes = baos.toByteArray();
            baos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageBytes;
    }


    public static void stenography(String fileWithPicture, String fileWithMessage, int start, String end)
    {
        try {

            byte[] imageBytes = readPicture(fileWithPicture);

            byte[] bBytes = new byte[(imageBytes.length - begImg ) / 3];
            byte[] gBytes = new byte[(imageBytes.length - begImg ) / 3];
            byte[] rBytes = new byte[(imageBytes.length - begImg ) / 3];

            for (int j = begImg ; j < imageBytes.length; j++) {
                int i = j - begImg ;
                switch(i % 3) {
                    case 0:
                        rBytes[i / 3] = imageBytes[j];
                        break;
                    case 1:
                        gBytes[i / 3] = imageBytes[j];
                        break;
                    default:
                        bBytes[i / 3] = imageBytes[j];
                        break;
                }
            }

            int current = start;

            String message = "";

            List<String> lines = Files.readAllLines(Paths.get(fileWithMessage), StandardCharsets.UTF_8);

            for(String line: lines) {
                message += line;
            }

            message += end;

            for(char letter : message.toCharArray()) {
                byte []mas = new byte[8];
                byte numb = (byte)letter;
                //System.out.println(numb);
                for(int i = 7; i >= 0; i--) {
                    mas[i] = (byte)(numb % 2);
                    numb /= 2;
                }
                for (int i = 0; i < 8; i++) {

                    bBytes[current] >>= 1;
                    bBytes[current] <<= 1;
                    bBytes[current] += mas[i];

                    current= (current + countOf1(current) * k) % bBytes.length;
                }
            }

            byte[] afterStenographyImageBytes = new byte[imageBytes.length];

            for (int i = 0; i < begImg; i++)
                afterStenographyImageBytes[i] = imageBytes[i];
            for (int i = 0; i < bBytes.length; i++) {
                afterStenographyImageBytes[i * 3 + begImg]     = rBytes[i];
                afterStenographyImageBytes[i * 3 + begImg + 1] = gBytes[i];
                afterStenographyImageBytes[i * 3 + begImg + 2] = bBytes[i];
            }

            imageBytes = afterStenographyImageBytes;

            InputStream in = new ByteArrayInputStream(imageBytes);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            ImageIO.write(bImageFromConvert, "bmp", new File("resultImage.bmp"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverseStenography(String fileWithPicture, int start, String end)
    {

        byte[] imageBytes = readPicture(fileWithPicture);

        byte[] bBytes = new byte[(imageBytes.length - begImg ) / 3];
        byte[] gBytes = new byte[(imageBytes.length - begImg ) / 3];
        byte[] rBytes = new byte[(imageBytes.length - begImg ) / 3];

        for (int j = begImg ; j < imageBytes.length; j++) {
            int i = j - begImg ;
            switch(i % 3) {
                case 0:
                    rBytes[i / 3] = imageBytes[j];
                    break;
                case 1:
                    gBytes[i / 3] = imageBytes[j];
                    break;
                default:
                    bBytes[i / 3] = imageBytes[j];
                    break;
            }
        }

        int current = start;

        String message = "";

        while (!message.contains(end)) {
            int numb = 0;
            for (int i = 0; i < 8; i++) {
                numb = (numb * 2 + Math.abs(bBytes[current]) % 2);
                current = (current + countOf1(current) * k) % bBytes.length;
            }
            message += (char)(numb);
        }
        message = message.replace(end, "");
        System.out.println(message);
    }

    public static void main(String[] args) {

        Random rand = new Random();
        int start = 54;
        String end = "fas@FGd@";

        stenography( "picture.bmp","message.txt", start, end);

        reverseStenography("resultImage.bmp", start, end);
    }
}