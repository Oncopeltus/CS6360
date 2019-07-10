package edu.utdallas.database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;


public class testByteFile {
	public static void main(String[] args) throws FileNotFoundException {
		/*String text = "42";
		String fileName = "E:\\DatabaseDesign_6360\\proj1\\test.txt";
		OutputStream oStream = new FileOutputStream(fileName);
		byte value = Byte.parseByte(text);
		// scanner.
		// get the input from the command line;
		// parse the input into : table name, projected attribute names, conditions;
		// operation{}
		// insert -> writeBytes
		// select -> readBytes
		// delete -> set the indicators opposite

		int offset = 0;
		try {
			RandomAccessFile raf = new RandomAccessFile("E:\\DatabaseDesign_6360\\proj1\\ByteFile.txt", "rw");
			long size = raf.length();
			raf.seek(offset);
			/*FileChannel inChannel = raf.getChannel();
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			for(int i = 0; i < buffer.limit(); i++) {
				if (i % 16 == 0) {
					System.out.println();
				}
				byte b = buffer.get();
				System.out.print(String.format("%02X ",b));
			}*/
			
			// get the table leaf page (first byte)
			byte[] leafPage = new byte[2];
			raf.readFully(leafPage);
			System.out.println("table leaf page:-" + new String(leafPage)+"-");
			
			// set the pointer to the next byte (skip the space in the file);
			
			byte[] recordByte = new byte[5];
			raf.seek(raf.getFilePointer()+1);
			// get the number of records 
			raf.readFully(recordByte);
			
			System.out.println("number of the records:-" + new String(recordByte) + "--> ");
			
			// get the first record offset
			byte[] firstOffset = new byte[5];
			raf.seek(raf.getFilePointer()+1);
			raf.readFully(firstOffset);
			System.out.println("first record offset: " + new String(firstOffset));
			// get the rightmost leaf page
			byte[] rightLeaf = new byte[11];
			raf.seek(raf.getFilePointer()+1);
			raf.readFully(rightLeaf);
			System.out.println("rightmost leaf page : " + new String(rightLeaf));
			// get the rowid and the offset of a certain record (how ?)
//			for(int i = 0; ) {
//				
//			}
				// go to the record
				// get the payload size
				// get the rowId
				// get the record header: number of the columns --> data type for each column
					// get each column, and convert the Hex to the char;
			// command: select * from table;
			// if(command[0].equals("select"))
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
