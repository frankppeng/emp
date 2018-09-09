package com.exp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exp.modle.Order;
import com.exp.util.PaymentUtil;



/**
 * �ױ�֧��
 * @author Lanqiao08
 *
 */
@WebServlet("/order/yeepay.jhtml")
public class YeePayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		Order order = (Order) hs.getAttribute("order");
		String orderId = order.getId();
		String expprice = order.getExpprice();
		System.out.println("获得订单号:"+orderId);
		
		
//		String a = (String) ServletActionContext.getRequest().getSession().getAttribute("gourl");
//		System.out.println(a);
//		UUID id = UUID.randomUUID();
//		String uuid =  id.toString().replace("-", "");
		String p0_Cmd = "Buy"; 
		String p1_MerId = "10001126856";
		String p2_Order =orderId;//= request.getParameter("orderid");
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		String p8_Url = "http://192.168.50.164:8080/exp/order/paystatus.jhtml?order_id="+p2_Order; 
		String p9_SAF = "";
		String pa_MP = ""; 
		String pd_FrpId = "";
		String pr_NeedResponse = "1";
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// ���ױ���������:
		System.out.println("拼地址并且转发");
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		System.out.println(sb);
		response.sendRedirect(sb.toString());
	}
}
