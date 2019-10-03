package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TableOwnerinfo;
import model.billInfo;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerinfoHelper oih = new OwnerinfoHelper();
		String bill = request.getParameter("bill");
		
		
		String[] selectedItems = request.getParameterValues("allInfoToAdd");
		List<TableOwnerinfo> selectedItemsInList = new ArrayList<TableOwnerinfo>();
		if(selectedItems != null && selectedItems.length >0)
		{
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				TableOwnerinfo c = oih.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		TableOwnerinfo oi = new TableOwnerinfo();
		billInfo bi = new billInfo(Integer.parseInt(bill), oi);
		
		BillinfoHelper bih = new BillinfoHelper();
		bih.insertBill(bi);
		System.out.println(bi.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
