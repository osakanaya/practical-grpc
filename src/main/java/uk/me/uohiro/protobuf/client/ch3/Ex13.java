package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex13.Test1;
import uk.me.uohiro.protobuf.model.ch3.ex13.Test2;

public class Ex13 {
	public static void main(String[] args) throws Exception {
		Test1.Builder builder1 = Test1.newBuilder();
		Test1 test1 = builder1.setValue(-227).build();
		printByteValue(test1.toByteArray());
		
		Test1.Builder builder2 = Test1.newBuilder();
		Test1 test2 = builder2.setValue(227).build();
		printByteValue(test2.toByteArray());
		
		Test2.Builder builder3 = Test2.newBuilder();
		Test2 test3 = builder3.setValue(-227).build();
		printByteValue(test3.toByteArray());

		Test2.Builder builder4 = Test2.newBuilder();
		Test2 test4 = builder4.setValue(-227).build();
		printByteValue(test4.toByteArray());
	}
	
	private static void printByteValue(byte[] arr) {
		System.out.println("Length: " + arr.length);
		System.out.print("===Byte:");
		for (byte b : arr) {
			System.out.print(String.format("%02X", b));
		}
		System.out.println("===");
		
	}
}
