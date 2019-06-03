package com.woniu.yzm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image.do")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个图片对象
		BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 200, 100);
		char[] cs = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		Random rand = new Random();
		for(int i=1;i<=100;i++){
			g.setColor(Color.green);
			g.drawLine(rand.nextInt(200), rand.nextInt(100), rand.nextInt(200), rand.nextInt(200));
		}
		StringBuffer strB = new StringBuffer();
		for(int i=0;i<4;i++){
			char c = cs[rand.nextInt(cs.length)];
			strB.append(c);
		}
		g.setFont(new Font("隶书",Font.BOLD,30));
		g.setColor(Color.BLACK);
		int jd = rand.nextInt()%30;
		g.rotate(jd * Math.PI / 180,50,50);
		g.drawString(strB.toString(), 50, 50);
		
		request.getSession().setAttribute("yzm", strB.toString());
		ImageIO.write(image, "JPG", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
