package br.com.conversor_monetario;

public class Main {

	public static void main(String[] args) {

		Convertible<String> convertible = new ConvertibleImpl();

//		String valueA = convertible.getValueFormatted("1.789.025.008,11");
//		System.out.println(valueA);
//		String valueA = convertible.getValueFormatted("1,789,025,008.11");
//		System.out.println(valueA);
		
//		String valueB = convertible.getValueFormatted("1.789.025,08");
//		System.out.println(valueB);
//		String valueB = convertible.getValueFormatted("1,789,025.08");
//		System.out.println(valueB);

//		String valueC = convertible.getValueFormatted("1.789,25");
//		System.out.println(valueC);
//		String valueC = convertible.getValueFormatted("1,789.25");
//		System.out.println(valueC);

//		String valueD = convertible.getValueFormatted(" . ");
//		System.out.println(valueD);

//		String valueE = convertible.getValueFormatted("  ");
//		System.out.println(valueE);

		String valueF = convertible.getValueFormatted(" ");
		System.out.println(valueF);
	}
}