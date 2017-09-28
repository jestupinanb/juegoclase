/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private int posicionX = 10;
    int posicionY = 390;
    int posicionXRectangulo = 410;
    int posicionYRectangulo = 410;
    int xGato=0;
    int numImagenGato;
    private int delay = 25;
    private Timer timer;
    
    public Board(){
        timer = new Timer(this.delay,this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, this);
        
        g.drawString("Puntaje", 100, 100);
        int x[] = {20+posicionX,30+posicionX,50+posicionX,60+posicionX};
        int y[] = {20+posicionY,0+posicionY,0+posicionY,20+posicionY};
        
        //Tigre
        Image gato = loadImage("cats.gif");
        g.drawImage(gato,xGato, 100, xGato+132, (100+80),
                numImagenGato*132,0, (numImagenGato*132)+132, 80, this);   
        //Carro
        g.fillPolygon(x,y,4);
        g.fillRect(0+posicionX, 20+posicionY, 80, 20);
        g.setColor(Color.BLACK);
        g.fillOval(20+posicionX, 40+posicionY, 10, 10);
        g.fillOval(50+posicionX, 40+posicionY, 10, 10);
        
        g.drawRect(0+posicionX, 0+posicionY, 80, 50);
        Rectangle carro = new Rectangle(0+posicionX,0+posicionY,80,50);
        //Circulo
        g.drawRect(50+posicionXRectangulo, 0+posicionYRectangulo, 30, 30);
        Rectangle oval = new Rectangle(50+posicionXRectangulo,0+posicionYRectangulo,30,30);
        g.fillOval(50+posicionXRectangulo, posicionYRectangulo, 30, 30);
        
        if(carro.intersects(oval)){
//            this.timer.stop();
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.posicionX +=1;
        this.xGato +=1;
        if(this.numImagenGato==6){
            this.numImagenGato=0;
        }else{
            this.numImagenGato++;
        };
        this.posicionY +=1;
        this.posicionXRectangulo -=1;
        repaint();
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image  = ii.getImage();
        return image;
    }
}