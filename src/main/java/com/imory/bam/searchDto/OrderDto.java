package com.imory.bam.searchDto;

public class OrderDto {
   private  Integer start;
   private  Integer length;
   private  Integer draw;
   private  Integer orderStatus;
   private  Integer searchTag;
   private  String searchTxt;
   private  String startTime;
   private  String endTime;
   
   
		public String getSearchTxt() {
			return searchTxt;
		}
		public void setSearchTxt(String searchTxt) {
			this.searchTxt = searchTxt;
		}
		public Integer getStart() {
			return start;
		}
		public void setStart(Integer start) {
			this.start = start;
		}
		public Integer getLength() {
			return length;
		}
		public void setLength(Integer length) {
			this.length = length;
		}
		public Integer getDraw() {
			return draw;
		}
		public void setDraw(Integer draw) {
			this.draw = draw;
		}
		public Integer getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(Integer orderStatus) {
			this.orderStatus = orderStatus;
		}
		public Integer getSearchTag() {
			return searchTag;
		}
		public void setSearchTag(Integer searchTag) {
			this.searchTag = searchTag;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
   
	
   
}
