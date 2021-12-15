package com.nit.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class Customer {
	@NonNull
	private int cno;
	//@NonNull
	private String cname;
	//@NonNull
	private String cadd;
	private double billAmt;

	/*
	 * public Customer() {
	 * 
	 * }
	 */

	/*
	 * @Override public String toString() { return "Customer [cno=" + cno +
	 * ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]"; }
	 */
}
