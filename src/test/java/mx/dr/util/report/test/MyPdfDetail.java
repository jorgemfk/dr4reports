package mx.dr.util.report.test;

import java.util.Date;

import mx.dr.util.report.tag.DRPdfLabel;

public class MyPdfDetail {
	@DRPdfLabel(wspacesBefore=0, y=1)
	private String code;
	@DRPdfLabel(wspacesBefore=0, y=1)
    private String name;
	@DRPdfLabel(wspacesBefore=0, y=1)
    private Date date;
	@DRPdfLabel(wspacesBefore=0, y=1)
    private Double amount;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
    
}
