package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex15.Test1;
import uk.me.uohiro.protobuf.model.ch3.ex15.Test2;

public class Ex15 {
	public static void main(String[] args) throws Exception {
		Test2.Builder builder = Test2.newBuilder();
		Test2 test = builder.setValue(Test1.newBuilder().setValue(227)).build();
		
		System.out.println("Length: " + test.toByteArray().length);
		System.out.print("===Byte:");
		for (byte b : test.toByteArray()) {
			System.out.print(String.format("%02X", b));
		}
		System.out.println("===");
	}
}
