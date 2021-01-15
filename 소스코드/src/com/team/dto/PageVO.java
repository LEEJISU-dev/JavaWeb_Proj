package com.team.dto;

import java.sql.Timestamp;

public class PageVO {
   // admin
   private String AId;
   private String APw;
   // users
   private String UserId;
   private String UName;
   private String UPw;
   private String UPhone;
   private String UEmail;
   private String UAddr;
   // product
   private int PNo;
   private String PName;
   private String PPrice;
   private String PClass1;
   private String PClass2;
   private String PDetail;
   private int PSelled;
   private String PPhoto;
   public String getPPhoto() {
	return PPhoto;
}
public void setPPhoto(String pPhoto) {
	PPhoto = pPhoto;
}
private String PSId;
   private Timestamp PSDate;
   // buy
   private Timestamp DealDate;
   
   public String getAId() {
      return AId;
   }
   public void setAId(String aId) {
      AId = aId;
   }
   public String getAPw() {
      return APw;
   }
   public void setAPw(String aPw) {
      APw = aPw;
   }
   public String getUserId() {
      return UserId;
   }
   public void setUserId(String userId) {
      UserId = userId;
   }
   public String getUName() {
      return UName;
   }
   public void setUName(String uName) {
      UName = uName;
   }
   public String getUPw() {
      return UPw;
   }
   public void setUPw(String uPw) {
      UPw = uPw;
   }
   public String getUPhone() {
      return UPhone;
   }
   public void setUPhone(String uPhone) {
      UPhone = uPhone;
   }
   public String getUEmail() {
      return UEmail;
   }
   public void setUEmail(String uEmail) {
      UEmail = uEmail;
   }
   public String getUAddr() {
      return UAddr;
   }
   public void setUAddr(String uAddr) {
      UAddr = uAddr;
   }
   public int getPNo() {
      return PNo;
   }
   public void setPNo(int pNo) {
      PNo = pNo;
   }
   public String getPName() {
      return PName;
   }
   public void setPName(String pName) {
      PName = pName;
   }
   public String getPPrice() {
      return PPrice;
   }
   public void setPPrice(String pPrice) {
      PPrice = pPrice;
   }
   public String getPClass1() {
      return PClass1;
   }
   public void setPClass1(String pClass1) {
      PClass1 = pClass1;
   }
   public String getPClass2() {
      return PClass2;
   }
   public void setPClass2(String pClass2) {
      PClass2 = pClass2;
   }
   public String getPDetail() {
      return PDetail;
   }
   public void setPDetail(String pDetail) {
      PDetail = pDetail;
   }
   public int getPSelled() {
      return PSelled;
   }
   public void setPSelled(int pSelled) {
      PSelled = pSelled;
   }
   public String getPSId() {
      return PSId;
   }
   public void setPSId(String pSId) {
      PSId = pSId;
   }
   public Timestamp getPSDate() {
      return PSDate;
   }
   public void setPSDate(Timestamp pSDate) {
      PSDate = pSDate;
   }
   public Timestamp getDealDate() {
      return DealDate;
   }
   public void setDealDate(Timestamp dealDate) {
      DealDate = dealDate;
   }

}