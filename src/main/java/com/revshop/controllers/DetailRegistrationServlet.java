package com.revshop.controllers;

import java.io.IOException;

import com.revshop.Entity.LoginEntity;
import com.revshop.Entity.UserEntity;
import com.revshop.service.LoginService;
import com.revshop.service.UserService;
import com.revshop.service.impl.LoginServiceIMPL;
import com.revshop.service.impl.UserServiceIMPL;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DetailRegistrationServlet
 */
public class DetailRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginService loginservice = LoginServiceIMPL.getInstance();
		LoginEntity user = (LoginEntity) session.getAttribute("user");

		if (user != null) {
			String userId = request.getParameter("userId");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String mobile = request.getParameter("mobile");
			String pincode = request.getParameter("pincode");
			String billingAddress = request.getParameter("billingAddress");
			String companyName = request.getParameter("companyName");
			String gstNumber = request.getParameter("gstNumber");
			String websiteUrl = request.getParameter("websiteUrl");
			String panNumber = request.getParameter("panNumber");
			String bankAccountNo = request.getParameter("bankAccountNo");
			String ifsc = request.getParameter("ifsc");

			UserEntity userEntity = new UserEntity();
			userEntity.setUserId(Integer.parseInt(userId));
			userEntity.setFirstName(firstName);
			userEntity.setLastName(lastName);
			userEntity.setGender(gender);
			userEntity.setMobile(mobile);
			userEntity.setPincode(pincode);
			userEntity.setBillingAddress(billingAddress);
			userEntity.setCompanyName(companyName);
			userEntity.setGstNumber(gstNumber);
			userEntity.setWebsiteUrl(websiteUrl);
			userEntity.setPanNumber(panNumber);
			userEntity.setBankAccountNo(bankAccountNo);
			userEntity.setIfsc(ifsc);
			UserService userService = new UserServiceIMPL();
			boolean isUpdated = userService.updateUserDetails(userEntity);

			if (isUpdated) {
				// Update the isFirstLogin flag to false in tbl_login
				user.setFirstLogin(false);
				loginservice.updateFirstLoginFlag(user.getEmail());

				// Update session with new details
				session.setAttribute("user", user);
				response.sendRedirect("HomeServlet");
			} else {
				request.setAttribute("RegistererrorMessage", "Update failed. Please try again.");
				request.getRequestDispatcher("LoginAndRegistration/detail-registration.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("LoginAndRegistration/user-login.jsp");
		}
	}
}
