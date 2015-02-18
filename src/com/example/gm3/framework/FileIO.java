package com.example.gm3.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ������ � �������
 * 
 * @author jb
 *
 */
public interface FileIO {

	public InputStream readAsset(String name) throws IOException;

	public InputStream readFile(String name) throws IOException;

	public OutputStream writeFile(String name) throws IOException;
}
