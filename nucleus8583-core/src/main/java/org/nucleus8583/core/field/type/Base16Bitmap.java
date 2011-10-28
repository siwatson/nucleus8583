package org.nucleus8583.core.field.type;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.nucleus8583.core.util.Base16Padder;
import org.nucleus8583.core.xml.FieldAlignments;
import org.nucleus8583.core.xml.FieldDefinition;

public class Base16Bitmap extends FieldType {
	private static final long serialVersionUID = -5615324004502124085L;

	private Base16Padder padder;

	public Base16Bitmap(FieldDefinition def, FieldAlignments defaultAlign,
			String defaultPadWith, String defaultEmptyValue) {
		super(def, defaultAlign, defaultPadWith, defaultEmptyValue);

		padder = new Base16Padder();
	}

	@Override
	public boolean isBinary() {
		return true;
	}

	@Override
	public void read(InputStream in, byte[] value, int off, int len)
			throws IOException {
		padder.read(in, value, off, len);
	}

	@Override
	public void write(OutputStream out, byte[] value) throws IOException {
		padder.write(out, value, 0, value.length);
	}

	@Override
	public void write(OutputStream out, byte[] value, int off, int len)
			throws IOException {
		padder.write(out, value, off, len);
	}
}