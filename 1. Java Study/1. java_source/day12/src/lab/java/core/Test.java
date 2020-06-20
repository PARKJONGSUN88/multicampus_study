package lab.java.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("C:/workspace/day12/src/dbinfo.properties"));
		System.out.println(props.getProperty("driver"));
		System.out.println(props.getProperty("url"));
		System.out.println(props.getProperty("user"));
		System.out.println(props.getProperty("pwd"));
	}

}
