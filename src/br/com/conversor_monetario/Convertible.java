package br.com.conversor_monetario;

@FunctionalInterface
public interface Convertible<T> {

	public String getValueFormatted(String string);

	public default int getNumero0() {
		return 0;
	}

	public default int getNumero1() {
		return 1;
	}

	public default int getNumero2() {
		return 2;
	}

	public static String getString() {
		return "";
	}
}
