package uk.me.uohiro.protobuf.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex14.Test;

public class Ex14 {
	public static void main(String[] args) throws Exception {
		Test.Builder builder = Test.newBuilder();
		Test test = builder.setValue("test").build();
		
		System.out.println("Length: " + test.toByteArray().length);
		System.out.print("===Byte:");
		for (byte b : test.toByteArray()) {
			System.out.print(String.format("%02X", b));
		}
		System.out.println("===");
	}
}
