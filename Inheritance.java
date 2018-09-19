public class Inheritance {
	static class A {
	int x = 5;
	public void m1() {System.out.println("Am1-> " + x);}
	public void m2() {System.out.println("Am2-> " + this.x);}
	public void update() {x = 99;}
	} 

	static class B extends A {
	int x = 10;
	int z = 6;
	public void m2() {System.out.println("Bm2-> " + x);}
	public void m3() {System.out.println("Bm3-> " + super.x);}
	public void m4() {System.out.print("Bm4-> "); super.m2();}
	} 

	static class C extends B {
	int y = x + 1;
	public void m2() {System.out.println("Cm2-> " + super.x);}
	/* public void m3() {System.out.println("Cm3-> " + super.super.x);} // THIS CODE IS INVALID*/ 
	//public void m3() {System.out.println("hello");}
	public void m4() {System.out.println("Cm4-> " + y);}
	/* public void m5() {System.out.println("Cm5-> " + super.y);} // THIS CODE IS INVALID */
	}

	public static void main(String[] args) {
		A b0 = new B();
		System.out.println(b0.x);
		System.out.println( ((B) b0).x );
		//b0.m3();
		//System.out.println( b0.z ); // compile time error

		b0.m1();
		b0.m2();

		B b1 = new B();
		b1.m3();
		b1.m4();

		A c0 = new C();
		c0.m1();

		A a1 = (A) c0;
		C c2 = (C) a1;
		c2.m4();
		((C) c0).m3(); // try it with line 21 uncommented

		b0.update();
		b0.m1();
	}
}