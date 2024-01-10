package org.cs.jwt.dto;

import java.util.List;
import java.util.Map;

public class MenuDTO {
	private int level=0;
	private Integer parentid=0;
	private String moduleName="";
	private String path;
	private String pathName;
	private String parentName="";
	private String menuname="";
	private Integer menuid;
	private String menuurl="";
	private String menuicon="";
	private int isleafnode=0;
	private String iconassociated;
	private Integer parentmenuId=0;
	private String parentmenuname;
	private String remarks;
	private String rolename;
	private List<MenuDTO> childs=null;
	private Map<String,MenuDTO> childsmap=null;
	public  Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentId) {
		this.parentid = parentId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	public void setParentid(int parentId) {
		this.parentid = parentId;
	}
	public int getIsleafnode() {
		return isleafnode;
	}
	public void setIsleafnode(int isleafnode) {
		this.isleafnode = isleafnode;
	}
	public String getParentmenuname() {
		return parentmenuname;
	}
	public void setParentmenuname(String parentmenuname) {
		this.parentmenuname = parentmenuname;
	}
	public Integer getParentmenuId() {
		return parentmenuId;
	}
	public void setParentmenuId(Integer parentmenuId) {
		this.parentmenuId = parentmenuId;
	}
	public String getIconassociated() {
		return iconassociated;
	}
	public void setIconassociated(String iconassociated) {
		this.iconassociated = iconassociated;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
