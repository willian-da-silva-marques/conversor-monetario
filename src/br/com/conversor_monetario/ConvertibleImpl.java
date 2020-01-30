package br.com.conversor_monetario;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class ConvertibleImpl implements Convertible<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvertibleImpl.class);
	
	private static final String EMPTY = "";

	@Override
	public String getValueFormatted(String string) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		String value = null;
		String regex = null;
		if (string != null && !string.trim().equals(EMPTY)) {
			value = string.replaceAll("\\,", "\\.").trim();
			value = value.trim();
			try {
				byte[] bytes = value.getBytes(StandardCharsets.UTF_8.name());
				if (bytes.length == 0 && bytes[0] == 46) {
					return value;
				} else {
					StringBuilder sb = new StringBuilder();
					List<Integer> indexes = new ArrayList<>();
					for (int i = 0; i < bytes.length; i++) {
						if (bytes[i] == 46) {
							indexes.add(i);
							char letter = (char) bytes[i];
							sb.append(letter);
						} else {
							char letter = (char) bytes[i];
							sb.append(letter);
						}
					}
					value = sb.toString();
					for (int i = 0; i < value.length(); i++) {
						for (int j = 0; j < indexes.size() - 1; j++) {
							Integer index = indexes.get(j);
							if (Integer.valueOf(i).equals(index)) {
								char oldChar = value.charAt(index);
								char newChar = '\u0020';
								Character oldValueOf = Character.valueOf(oldChar);
								Character newValueOf = Character.valueOf(newChar);
								regex = newValueOf.toString();
								String scape = "\\";
								String concat = scape.concat(oldValueOf.toString());
								value = value.replaceFirst(concat, newValueOf.toString());
							}
						}
					}
					if (regex != null) {
						String[] splited = value.split(regex);
						StringBuilder builder = new StringBuilder();
						for (int i = 0; i < splited.length; i++) {
							builder.append(splited[i]);
						}
						value = builder.toString();
						BigDecimal bigDecimal = new BigDecimal(value);
						value = nf.format(bigDecimal);
					}
				}
			} catch (IllegalArgumentException | UnsupportedEncodingException e) {
				LOGGER.error(e.getMessage());
			}
			return value;
		}
		return value;
	}
}