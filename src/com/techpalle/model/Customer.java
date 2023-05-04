package com.techpalle.model;
public class Customer
{
	private int cid;
	private String cname;
	private String cemail;
	private long cmobile;
	public int getCid() { return cid; }
	public void setCid(int cid) { this.cid = cid; }
	public String getCname() { return cname; }
	public void setCname(String cname) { this.cname = cname; }
	public String getCemail() { return cemail; }
	public void setCemail(String cemail) { this.cemail = cemail; }
	public long getCmobile() { return cmobile; }
	public void setCmobile(long cmobile) { this.cmobile = cmobile; }
	public Customer(String cname, String cemail, long cmobile)
	{
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.cmobile = cmobile;
	}
	public Customer(int cid, String cname, String cemail, long cmobile)
	{
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cmobile = cmobile;
	}
}
