/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */

package org.dicom4j.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/**
 * <p>
 * Extends {@link java.io.FilterOutputStream FilterOutputStream} by adding the
 * concept of little and big endian binary value encoding. Supplies functions
 * for writing various sized integer and floating point words.
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class BinaryOutputStream extends FilterOutputStream {

	/**
	 * the buffer for bytes swapping
	 */
	private byte fBuffer[];

	/**
	 * the {@link ByteOrder}
	 */
	private ByteOrder fByteOrder;

	public BinaryOutputStream(OutputStream aStream) {
		this(aStream, ByteOrder.LITTLE_ENDIAN);
	}

	/**
	 * Create a new BinaryOutputStream
	 * 
	 * @param aStream
	 *          The underlying output stream
	 * @param aByteOrder
	 *          The byteOrder to use
	 */
	public BinaryOutputStream(OutputStream aStream, ByteOrder aByteOrder) {
		super(aStream);
		this.fByteOrder = aByteOrder;
		this.fBuffer = new byte[8];
	}

	public ByteOrder getByteOrder() {
		return this.fByteOrder;
	}

	/**
	 * @param v
	 */
	final void insertSigned16(int v) {
		this.insertUnsigned16(v);
	}

	/**
	 * @param v
	 */
	final void insertSigned32(long v) {
		this.insertUnsigned32(v);
	}

	/**
	 * @param v
	 */
	final void insertUnsigned16(int v) {
		if (this.fByteOrder == ByteOrder.BIG_ENDIAN) {
			this.fBuffer[0] = (byte) (v >> 8);
			this.fBuffer[1] = (byte) v;
		} else {
			this.fBuffer[1] = (byte) (v >> 8);
			this.fBuffer[0] = (byte) v;
		}
	}

	/**
	 * @param v
	 */
	final void insertUnsigned32(long v) {
		if (this.fByteOrder == ByteOrder.BIG_ENDIAN) {
			this.fBuffer[0] = (byte) (v >> 24);
			this.fBuffer[1] = (byte) (v >> 16);
			this.fBuffer[2] = (byte) (v >> 8);
			this.fBuffer[3] = (byte) v;
		} else {
			this.fBuffer[3] = (byte) (v >> 24);
			this.fBuffer[2] = (byte) (v >> 16);
			this.fBuffer[1] = (byte) (v >> 8);
			this.fBuffer[0] = (byte) v;
		}
	}

	/**
	 * @param v
	 */
	final void insertUnsigned64(long v) {
		if (this.fByteOrder == ByteOrder.BIG_ENDIAN) {
			this.fBuffer[0] = (byte) (v >> 56);
			this.fBuffer[1] = (byte) (v >> 48);
			this.fBuffer[2] = (byte) (v >> 40);
			this.fBuffer[3] = (byte) (v >> 32);
			this.fBuffer[4] = (byte) (v >> 24);
			this.fBuffer[5] = (byte) (v >> 16);
			this.fBuffer[6] = (byte) (v >> 8);
			this.fBuffer[7] = (byte) v;
		} else {
			this.fBuffer[7] = (byte) (v >> 56);
			this.fBuffer[6] = (byte) (v >> 48);
			this.fBuffer[5] = (byte) (v >> 40);
			this.fBuffer[4] = (byte) (v >> 32);
			this.fBuffer[3] = (byte) (v >> 24);
			this.fBuffer[2] = (byte) (v >> 16);
			this.fBuffer[1] = (byte) (v >> 8);
			this.fBuffer[0] = (byte) v;
		}
	}

	/**
	 * @param v
	 */
	final void insertUnsigned8(int v) {
		this.fBuffer[0] = (byte) v;
	}

	public void setByteOrder(ByteOrder aValue) {
		this.fByteOrder = aValue;
	}

	public void writeASCII(String aValue) throws IOException {
		this.write(aValue.getBytes("ASCII"));
	}

	public void writeBoolean(boolean aValue) throws IOException {
		this.write(aValue ? 1 : 0);
	}

	/**
	 * <p>
	 * Write one floating point 64 bit value.
	 * </p>
	 * 
	 * @param value
	 *          a double value
	 * @exception IOException
	 */
	public final void writeDouble(double value) throws IOException {
		long binary = Double.doubleToRawLongBits(value);
		this.insertUnsigned64(binary);
		this.write(this.fBuffer, 0, 8);
	}

	/**
	 * <p>
	 * Write an array of floating point 64 bit values.
	 * </p>
	 * 
	 * @param f
	 *          an array of floats to write
	 * @param len
	 *          the number of values to write
	 * @exception IOException
	 */
	public final void writeDouble(double[] f, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			this.writeDouble(f[i]);
		}
	}

	/**
	 * <p>
	 * Write one floating point 32 bit value.
	 * </p>
	 * 
	 * @param value
	 *          a float value
	 * @exception IOException
	 */
	public final void writeFloat(float value) throws IOException {
		int binary = Float.floatToRawIntBits(value);
		this.insertUnsigned32(binary);
		this.write(this.fBuffer, 0, 4);
	}

	/**
	 * <p>
	 * Write an array of floating point 32 bit values.
	 * </p>
	 * 
	 * @param f
	 *          an array of floats to write
	 * @param len
	 *          the number of values to write
	 * @exception IOException
	 */
	public final void writeFloat(float[] f, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			this.writeFloat(f[i]);
		}
	}

	/**
	 * <p>
	 * Write one signed integer 16 bit value.
	 * </p>
	 * 
	 * @param v
	 *          an int containing an signed value
	 * @exception IOException
	 */
	public final void writeSigned16(int v) throws IOException {
		this.insertSigned16(v);
		this.write(this.fBuffer, 0, 2);
	}

	/**
	 * <p>
	 * Write one signed integer 32 bit value.
	 * </p>
	 * 
	 * @param v
	 *          a long containing an signed value
	 * @exception IOException
	 */
	public final void writeSigned32(long v) throws IOException {
		this.insertSigned32(v);
		this.write(this.fBuffer, 0, 4);
	}

	/**
	 * <p>
	 * Write an unsigned integer 16 bits long value.
	 * </p>
	 * 
	 * @param unsigned16
	 *          An int containing an unsigned value (0 <= aUnsigned16 < 2^16)
	 * @exception IOException
	 */
	public final void writeUnsigned16(int unsigned16) throws IOException {
		if (unsigned16 < 0) {
			throw new IllegalArgumentException(unsigned16	+ " is not a valid Unsigned16");
		}
		if (unsigned16 > 65536) {
			throw new IllegalArgumentException(unsigned16 + " is not a valid Unsigned16");
		}
		this.insertUnsigned16(unsigned16);
		this.write(this.fBuffer, 0, 2);
	}

	/**
	 * <p>
	 * Write an array of unsigned integer 16 bit values.
	 * </p>
	 * 
	 * @param w
	 *          an array of integers to write
	 * @param len
	 *          the number of 16 bit values to write
	 * @exception IOException
	 */
	public final void writeUnsigned16(short[] w, int len) throws IOException {
		byte b[] = new byte[len * 2];
		int bcount = 0;
		int wcount = 0;
		// long starttime=new Date().getTime();
		// System.err.println("writeUnsigned16: write to convert at: 0");
		if (this.fByteOrder == ByteOrder.BIG_ENDIAN) {
			while (wcount < len) {
				short value = w[wcount++];
				b[bcount++] = (byte) (value >> 8);
				b[bcount++] = (byte) value;
			}
		} else {
			while (wcount < len) {
				short value = w[wcount++];
				b[bcount++] = (byte) value;
				b[bcount++] = (byte) (value >> 8);
			}
		}
		// System.err.println("writeUnsigned16: exit at: "+(new
		// Date().getTime()-starttime));
		this.write(b, 0, (len * 2));
	}

	/**
	 * <p>
	 * Write one unsigned integer 32 bit value.
	 * </p>
	 * 
	 * @param v
	 *          a long containing an unsigned value
	 * @exception IOException
	 */
	public final void writeUnsigned32(long v) throws IOException {
		this.insertUnsigned32(v);
		this.write(this.fBuffer, 0, 4);
	}

	/**
	 * <p>
	 * Write an unsigned integer 8 bits long value.
	 * </p>
	 * 
	 * @param aUnsigned8
	 *          An int containing an unsigned value (0 <= aUnsigned16 < 2^16)
	 * @exception IOException
	 */
	public final void writeUnsigned8(int aUnsigned8) throws IOException {
		this.insertUnsigned8(aUnsigned8);
		this.write(this.fBuffer, 0, 1);
	}

}
