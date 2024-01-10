package org.cs.jwt.dto;

import java.util.List;
import java.util.Map;

public class MenuModuleDTO {
	private String rolename="";
	private String moduleName="";
	private String menuname="";
	private String moduleImg="";
	private int parentid=0;
	private int isleafnode=0; 
	private String menuurl="";
	private String menuicon="";
	private String modulecardcolor="";
	private String modulecardfontcolor="";
	private List<MenuDTO> childs=null;
	private Map<String,MenuDTO> childsmap=null;
	
	
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public String getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public List<MenuDTO> getChilds() {
		return childs;
	}
	public void setChilds(List<MenuDTO> childs) {
		this.childs = childs;
	}
	public Map<String, MenuDTO> getChildsmap() {
		return childsmap;
	}
	public void setChildsmap(Map<String, MenuDTO> childsmap) {
		this.childsmap = childsmap;
	}
	public String getModuleImg() {
		return moduleImg;
	}
	public void setModuleImg(String moduleImg) {
		this.moduleImg = moduleImg;
	}
	public String getModulecardcolor() {
		return modulecardcolor;
	}
	public void setModulecardcolor(String modulecardcolor) {
		this.modulecardcolor = modulecardcolor;
	}
	public String getModulecardfontcolor() {
		return modulecardfontcolor;
	}
	public void setModulecardfontcolor(String modulecardfontcolor) {
		this.modulecardfontcolor = modulecardfontcolor;
	}
	public int getIsleafnode() {
		return isleafnode;
	}
	public void setIsleafnode(int isleafnode) {
		this.isleafnode = isleafnode;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	
}
