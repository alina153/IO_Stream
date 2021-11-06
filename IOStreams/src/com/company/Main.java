package com.company;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int selection;

        Scanner scFirstSelection = new Scanner(System.in);
        Scanner scUserText = new Scanner(System.in);
        System.out.println("Выберите, что нужно сделать: " +
                "\n " + "1.Записать текст в файл\n " + "2.Вывести текст из документа в консоль");
        selection = scFirstSelection.nextInt();

        switch (selection) {
            case 1: {

                String userText;
                System.out.println("Введите текст:");
                userText = scUserText.nextLine();

                try(FileOutputStream fileOutputStream = new FileOutputStream("D://MDK_PW_UsualIO.txt")) {

                    byte[] buffer = userText.getBytes();

                    //Change after success startup
                    fileOutputStream.write(buffer, 0, buffer.length);
                    System.out.println("Текстовый файл был сохранен!");

                }catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }break;
            case 2: {

                try(FileInputStream fileInputStream = new FileInputStream("D://MDK_PW_UsualIO.txt")) {

                    System.out.printf("Размер этого файла: %d байтов \n", fileInputStream.available());

                    int i = -1;

                    while ((i = fileInputStream.read()) != -1) {
                        System.out.print((char)i);
                    }
                }catch (IOException exception){

                    System.out.println(exception.getMessage());
                }
                break;
            } default:{
                System.out.println("Введите 1 или 2.");
            }
        }
    }
}