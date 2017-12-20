package com.bean;

import java.util.HashSet;
import java.util.Set;
public class Booktype {
		private int booktypeId;
		private String booktypeName;
		private Set<Book> bookSet = new HashSet<Book>();
		public Set<Book> getBookSet() {
			return bookSet;
		}
		public void setBookSet(Set<Book> bookSet) {
			this.bookSet = bookSet;
		}
		public int getBooktypeId() {
			return booktypeId;
		}
		public void setBooktypeId(int booktypeId) {
			this.booktypeId = booktypeId;
		}
		public String getBooktypeName() {
			return booktypeName;
		}
		public void setBooktypeName(String booktypeName) {
			this.booktypeName = booktypeName;
		}
}
