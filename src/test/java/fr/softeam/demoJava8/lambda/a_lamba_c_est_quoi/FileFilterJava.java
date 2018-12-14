package fr.softeam.demoJava8.lambda.a_lamba_c_est_quoi;

import java.io.File;
import java.io.FileFilter;

public class FileFilterJava implements FileFilter{
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(".java");
	}
}
