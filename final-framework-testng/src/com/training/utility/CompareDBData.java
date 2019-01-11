package com.training.utility;

import java.util.List;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;

public class CompareDBData {

	private ELearningDAO edao = new ELearningDAO();
	//edao = new ELearningDAO();

	public boolean dbMatch(String name, String first, String last, String email) {
	List<LoginBean> listOfElements = edao.getLogins();
	String unamedb="";
	  String fnamedb="";
	  String lnamedb="";
	  String maildb="";
	  for(LoginBean element : listOfElements) {
		  unamedb = element.getUserName().trim();
		  fnamedb = element.getfname().trim();
		  lnamedb = element.getlname().trim();
		  maildb = element.getmail().trim();
		}
	  System.out.println(unamedb + " " + name);
	  System.out.println(fnamedb + " " + first);
	  System.out.println(lnamedb + " " + last);
	  System.out.println(maildb + " " + email);

	  boolean flag = false;
	  if(unamedb.equals(name) && fnamedb.equals(first) && lnamedb.equals(last) && maildb.equals(email)) {
		  flag=true;
	  }
	  return flag;

}
}