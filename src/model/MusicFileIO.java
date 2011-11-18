package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MusicFileIO {

	private static MusicFileIO musicFileIO = new MusicFileIO();

	public static MusicFileIO getMusicFileIO() {
		return musicFileIO;
	}

	public ID3Tag parseFileToID3(File file) throws IOException {

		InputStream in = new FileInputStream(file);

		long fileSize = file.length();
		if(fileSize > Integer.MAX_VALUE) {
			return null;
		}
		byte[] bytes = new byte[(int)fileSize];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "+file.getName());
		}
		in.close();

		return scanArray(bytes);
	}

	private ID3Tag scanArray(byte[] bytes) {

		byte[] headerIdent = {'I','D','3'};
		byte[] headerVersion = {0x03, 0x00};
		byte[] headerFlags = {0x00};
		int headerPos = findPos(bytes,headerIdent);
		System.out.println("headerPos: "+headerPos);
		byte[] headerArr = getSubByteArray(bytes,headerPos, headerPos + 10);

		if(findPos(headerArr,concatAll(headerIdent, headerVersion, headerFlags)) != 0) {
			System.err.println("Wrong version or set of flags...");
			return null;
		}
		int headerSize = headerArr[6] + headerArr[7] + headerArr[8] + headerArr[9];
		System.out.println("headerSize: "+headerSize);
		return processHeader(getSubByteArray(bytes, headerPos, headerPos+headerSize));
	}

	private ID3Tag processHeader(byte[] subByteArray) {
		// TODO Auto-generated method stub
		return null;
	}

	public static byte[] concat(byte[] first, byte[] second) {
		byte[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	public static byte[] concatAll(byte[] first, byte[]... rest) {
		int totalLength = first.length;
		for (byte[] array : rest) {
			totalLength += array.length;
		}
		byte[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (byte[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	private byte[] getSubByteArray(byte[] bytes, int i, int j) {
		if(i > j)
			return null;

		byte[] returnArr = new byte[j - i + 1];

		for(int k = 0; k < returnArr.length; k++) {
			returnArr[k] = bytes[i+k];
		}

		return returnArr;
	}

	private int findPos(byte[] findIn, byte[] toFind) {

		int lookingAt = 0;
		int foundAt = -1;
		boolean notFound = true;
		while(notFound){
			int i = 0;
			while(i < toFind.length && findIn[lookingAt+i] == toFind[i]) {
				if(i == toFind.length-1) {
					foundAt = lookingAt;
					notFound = false;
				}
				i++;
			}
			lookingAt++;
		}
		return foundAt;
	}



}