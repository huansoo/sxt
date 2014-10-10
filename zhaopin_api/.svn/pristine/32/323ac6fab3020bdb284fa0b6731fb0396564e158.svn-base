package test;

import net.sf.json.*;



public class JsonTester {
	
	public void main(String args[]) {
		B_Class b = new B_Class();
		b.Name = "sada";
		b.Age = 11;
		
		JSONObject obj = JSONObject.fromObject(b);
		System.out.println(b.toString());
	}
	
	public class A_Class{
		private String Name;
		private Integer Age;
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Integer getAge() {
			return Age;
		}
		public void setAge(Integer age) {
			Age = age;
		}
		
	}
	public class B_Class{
		private String Name;
		private Integer Age;
		private A_Class obj;
		public A_Class getObj() {
			return obj;
		}
		
		public B_Class(){
			obj = new A_Class();
			obj.Name = "ddd";
			obj.Age = 11;
		}
		
		public void setObj(A_Class obj) {
			this.obj = obj;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Integer getAge() {
			return Age;
		}
		public void setAge(Integer age) {
			Age = age;
		}
		
	}	
}
