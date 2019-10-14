package com.ja.mlproject.vo;

public class TrialImageVO {
	private String t_idx;
	private String t_imgorifilename;
	private String t_imgfilelink;
	
	public TrialImageVO() {
		
	}

	public TrialImageVO(String t_idx, String t_imgorifilename, String t_imgfilelink) {
		super();
		this.t_idx = t_idx;
		this.t_imgorifilename = t_imgorifilename;
		this.t_imgfilelink = t_imgfilelink;
	}

	public String getT_idx() {
		return t_idx;
	}

	public void setT_idx(String t_idx) {
		this.t_idx = t_idx;
	}

	public String getT_imgorifilename() {
		return t_imgorifilename;
	}

	public void setT_imgorifilename(String t_imgorifilename) {
		this.t_imgorifilename = t_imgorifilename;
	}

	public String getT_imgfilelink() {
		return t_imgfilelink;
	}

	public void setT_imgfilelink(String t_imgfilelink) {
		this.t_imgfilelink = t_imgfilelink;
	}
	
}
