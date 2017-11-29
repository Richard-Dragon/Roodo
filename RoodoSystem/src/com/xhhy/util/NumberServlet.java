/**
 * 生成验证码的工具类
 */
package com.xhhy.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NumberServlet extends HttpServlet {
	private int width = 120;// 图片验证码的宽度
	private int height = 40;// 高度
	private int count = 4;// 验证码的数量

	// 验证码的出处
	char[] cs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2',
			'3', '4', '5', '6', '7', '8', '9' };// 32个字符

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建一个画布
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 创建一个画笔
		Graphics2D g = bi.createGraphics();
		// 设置背景颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);// 填充一个宽为width 高为height的矩形
		// 设置字体
		Font f = new Font("Fixedsys", Font.PLAIN | Font.BOLD, height - 2);//最古老的字体
		g.setFont(f);
		// 画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 2, height - 2);
		// 创建一个随机工具
		Random rd = new Random();
		// 给图片添加字符串 显示的验证码是什么 创建一个字符串 4个字符 随机取4个字符
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			// cs[i];
			// cs[rd.nextInt(cs.length)];
			String s = String.valueOf(cs[rd.nextInt(cs.length)]); // 如何把字符变成字符串
			sb.append(s);
			// 随机生成颜色   验证码字体的颜色  白色的16进制是多少？  #FF FF  FF   白色  #000000 黑色
			int red = rd.nextInt(255);  //生成0到254之间的数字  不包括255     FF  16*15+15  255
			int green = rd.nextInt(255);
			int blue = rd.nextInt(255);
			// 设置画笔颜色
			g.setColor(new Color(red, green, blue));
			g.drawString(s, (i + 1) * (width / 6), height - 5);
		}
		// 添加干扰线
		for (int i = 0; i < 15; i++) {
			int x = rd.nextInt(width);
			int y = rd.nextInt(height);
			int x1 = rd.nextInt(12);
			int y1 = rd.nextInt(12);
			g.setColor(Color.BLACK);
			g.drawLine(x, y, x + x1, y + y1);
		}
		// 先把生成的验证码保存到session中  后台验证验证码是否正确
		request.getSession().setAttribute("number", sb.toString());
		// 把图片发送到客户端
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpeg", out);
		out.flush();
		out.close();
	}

}
