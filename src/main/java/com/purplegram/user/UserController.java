package com.purplegram.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	
		/**
		 * ȸ������
		 * @param model
		 * @return
		 */
		@RequestMapping("/sign_up_view")
		public String signUpView(Model model) {
			model.addAttribute("viewName", "user/sign_up");
			return "template/layout";
		}
		
		/**
		 * �α���
		 * @param model
		 * @return
		 */
		@RequestMapping("/sign_in_view")
		public String signInView(Model model) {
			model.addAttribute("viewName", "user/sign_in");
			return "template/layout";
		}

		/**
		 * �α׾ƿ�
		 * @param request
		 * @return
		 */
		@RequestMapping("/sign_out")
		public String signOut(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.removeAttribute("userLoginId");
			session.removeAttribute("userName");
			session.removeAttribute("userId");
			return "redirect:/timeline/timeline_view";
		}
	}
}